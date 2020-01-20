package com.esther.springboot.service;

import com.esther.springboot.bean.UserSub;
import com.esther.springboot.bean.UserSubByMail;
import com.esther.springboot.bean.UserSubByPhone;
import com.google.common.base.Preconditions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 数据存储在mongodb中
 * 如果在子类上@Document(collection = "user_sub_mail")，那么保存ok，更新、查询不行。
 */
@Service
public class UserSubService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public UserSub addUserSub(UserSub userSub) {
        Preconditions.checkNotNull(userSub);
        Preconditions.checkArgument(!StringUtils.isEmpty(userSub.getSubCode()));
        return mongoTemplate.save(userSub);
    }

    public UpdateResult updateUserSub(UserSub userSub) {
        Preconditions.checkNotNull(userSub);
        Preconditions.checkArgument(!StringUtils.isEmpty(userSub.getSubCode()));
        Query query = null;
        if (userSub instanceof UserSubByPhone) {
            query = Query.query(Criteria.where("subPhone").is(((UserSubByPhone) userSub).getSubPhone()));
        } else if (userSub instanceof UserSubByMail) {
            query = Query.query(Criteria.where("cpCode").is(((UserSubByMail) userSub).getCpCode()).and("mailNo").is(((UserSubByMail) userSub).getMailNo()));
        }
        Document doc = new Document();
        mongoTemplate.getConverter().write(userSub, doc);
        Update update = Update.fromDocument(doc);

        return this.mongoTemplate.updateFirst(query, update, UserSub.class);
    }


    public UserSub findBySubPhone(String subPhone) {
        Preconditions.checkArgument(!StringUtils.isEmpty(subPhone));
        Query query = Query.query(Criteria.where("subPhone").is(subPhone));
        return mongoTemplate.findOne(query, UserSub.class);
    }

    public UserSub findSpecificFields(String subPhone) {
        Document queryObject = new Document();
        queryObject.put("subPhone", subPhone);

        Document fieldsObject = new Document();
        fieldsObject.put("subPhone", true);
        fieldsObject.put("subKey", true);
        fieldsObject.put("subCode", true);
        fieldsObject.put("imei", true);

        Query query = new BasicQuery(queryObject, fieldsObject);
        return mongoTemplate.findOne(query, UserSub.class);
    }

    public List<UserSub> findAll() {
        return mongoTemplate.findAll(UserSub.class);
    }


    public List<UserSub> findBySubPhoneAndCpCodeAndMailNo(String subPhone, String cpCode, String mailNo) {
        Query query = Query.query(Criteria.where("subPhone").is(subPhone).and("cpCode").is(cpCode).and("mailNo").is(mailNo));
        List<UserSub> list = mongoTemplate.find(query, UserSub.class);
        return list;
    }

    public UserSub findBySubCode(String subCode) {
        Preconditions.checkArgument(!StringUtils.isEmpty(subCode));
        Query query = Query.query(Criteria.where("subCode").is(subCode));
        return mongoTemplate.findOne(query, UserSub.class);
    }

/*    public long count() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC, "age").and(new Sort(Sort.Direction.DESC, "date")));
        long count = mongoTemplate.count(query, UserSub.class);
        return count;
    }

    public List<UserSub> findByPage(Integer page, Integer pageSize) {
        Pageable pageable = new PageRequest(page, pageSize);
        Query query = new Query();
        query.with(pageable);
        query.with(new Sort(Sort.Direction.ASC, "age"));
        return mongoTemplate.find(query, UserSub.class);
    }*/
}
