package com.esther.springboot.service;

import com.esther.springboot.bean.UserSub;
import com.esther.springboot.bean.UserSubByMail;
import com.esther.springboot.bean.UserSubByPhone;
import com.google.common.base.Preconditions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserSubService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void addUserSub(UserSub userSub) {
        Preconditions.checkNotNull(userSub);
        Preconditions.checkArgument(!StringUtils.isEmpty(userSub.getSubCode()));
        mongoTemplate.save(userSub);
    }

    public void updateUserSub(UserSub userSub) {
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

        this.mongoTemplate.updateFirst(query, update, UserSub.class);
    }


    public UserSub findBySubPhone(String subPhone) {
        Preconditions.checkArgument(!StringUtils.isEmpty(subPhone));
        Query query = Query.query(Criteria.where("subPhone").is(subPhone));
        return mongoTemplate.findOne(query, UserSub.class);
    }

    public List<UserSub> findAll() {
        return mongoTemplate.findAll(UserSub.class);
    }


    public List<UserSub> findBySubPhoneAndCpCodeAndMailNo(String subPhone, String cpCode, String mailNo) {
        Query query = Query.query(Criteria.where("subPhone").is(subPhone).and("cpCode").is(cpCode).and("mailNo").is(mailNo));
        return mongoTemplate.find(query, UserSub.class);
    }
}
