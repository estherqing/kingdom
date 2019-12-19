package com.esther.springboot.controller;

import com.esther.springboot.bean.UserSub;
import com.esther.springboot.bean.UserSubByMail;
import com.esther.springboot.bean.UserSubByPhone;
import com.esther.springboot.service.UserSubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "usersub", produces = "usersub mongodb的CRUD测试")
@RestController
@RequestMapping("/usersub")
public class UserSubController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserSubService userSubService;

    /**
     * 表名
     */
    private static final String collectionName = "user_sub";

    /**
     * 描述：新增。不用@ApiImplicitParam，否则格式不对
     *
     * @param userSub
     * @return ResultObject
     * @author maochengyuan
     * @created 2018/9/1 20:17
     */
    @RequestMapping(value = "/insertPhone", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "insertPhone", notes = "新增")
    public ResultObject insert(@RequestBody UserSubByPhone userSub) throws Exception {
        this.userSubService.addUserSub(userSub);
        return new ResultObject(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/insertMail", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "insertMail", notes = "新增")
    public ResultObject insert(@RequestBody UserSubByMail userSub) throws Exception {
        this.userSubService.addUserSub(userSub);
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
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "String", paramType = "query")
    public ResultObject delete(@RequestParam("userId") String userId) throws Exception {
        Query query = Query.query(Criteria.where("userId").is(userId));
        this.mongoTemplate.remove(query, collectionName);
        return new ResultObject(HttpServletResponse.SC_OK);
    }

    /**
     * 描述：修改
     *
     * @param
     * @return ResultObject
     * @author maochengyuan
     * @created 2018/9/1 20:17
     */
    @RequestMapping(value = "/updatePhone", method = RequestMethod.POST)
    @ApiOperation(value = "修改phone", notes = "修改phone")
    public ResultObject updatePhone(@RequestBody UserSubByPhone userSubByPhone) throws Exception {
        UserSub userSub = userSubByPhone;
        this.userSubService.updateUserSub(userSub);
        return new ResultObject(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = "/updateMail", method = RequestMethod.POST)
    @ApiOperation(value = "修改mail", notes = "修改mail")
    public ResultObject updateMail(@RequestBody UserSubByMail userSubByMail) throws Exception {
        UserSub userSub = userSubByMail;
        this.userSubService.updateUserSub(userSub);
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
    @RequestMapping(value = "/query", method = {RequestMethod.GET})
    @ApiOperation(value = "query", notes = "查询")
    public ResultObject query() throws Exception {
        List<UserSub> users = this.userSubService.findAll();
        return new ResultObject(HttpServletResponse.SC_OK, users);
    }

    @RequestMapping(value = "/findBySubPhoneAndCpCodeAndMailNo", method = {RequestMethod.GET})
    @ApiOperation(value = "findBySubPhoneAndCpCodeAndMailNo", notes = "查询")
    public ResultObject query(String subPhone, String cpCode, String mailNo) throws Exception {
        List<UserSub> users = this.userSubService.findBySubPhoneAndCpCodeAndMailNo(subPhone,cpCode,mailNo);
        return new ResultObject(HttpServletResponse.SC_OK, users);
    }

}
