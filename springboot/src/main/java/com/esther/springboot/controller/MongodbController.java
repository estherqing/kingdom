package com.esther.springboot.controller;

import com.esther.springboot.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "mongodb", produces = "mongodb的CRUD测试")
@RestController
@RequestMapping("/mongodb")
public class MongodbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 表名
     */
    private static final String collectionName = "user";

    /**
     * 描述：新增。不用@ApiImplicitParam，否则格式不对
     *
     * @param user
     * @return ResultObject
     * @author maochengyuan
     * @created 2018/9/1 20:17
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "insert", notes = "新增")
   // @ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "User",paramType = "query")
    public ResultObject insert(@RequestBody User user) throws Exception {
        this.mongoTemplate.insert(user);
        return new ResultObject(HttpServletResponse.SC_OK);
    }

    /**
     * 描述：删除.paramType = "query"必填，否则出错
     *
     * @param userId
     * @return ResultObject
     * @author maochengyuan
     * @created 2018/9/1 20:17
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "delete", notes = "删除")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true,dataType = "String",paramType = "query")
    public ResultObject delete(@RequestParam("userId") String userId) throws Exception {
        Query query = Query.query(Criteria.where("userId").is(userId));
        this.mongoTemplate.remove(query, collectionName);
        return new ResultObject(HttpServletResponse.SC_OK);
    }

    /**
     * 描述：修改
     *
     * @param user
     * @return ResultObject
     * @author maochengyuan
     * @created 2018/9/1 20:17
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "update", notes = "修改")
    public ResultObject update(@RequestBody User user) throws Exception {
        Query query = Query.query(Criteria.where("userId").is(user.getUserId()));

        Document doc = new Document(); // org.bson.Document
        mongoTemplate.getConverter().write(user, doc);
        Update update = Update.fromDocument(doc);

        this.mongoTemplate.updateFirst(query, update, collectionName);
        return new ResultObject(HttpServletResponse.SC_OK);
    }

    /**
     * 描述：查询
     *
     * @param
     * @return ResultObject
     * @author maochengyuan
     * @created 2018/9/1 20:17
     */
    @RequestMapping(value = "/query", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "query", notes = "查询")
    public ResultObject query() throws Exception {
        Query query = Query.query(Criteria.where("dataStatus").is(1));
        List<User> users = this.mongoTemplate.find(query, User.class);
        return new ResultObject(HttpServletResponse.SC_OK, users);
    }

}
