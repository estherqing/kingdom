package com.esther.code.controller;

import com.esther.code.schema.api.IUserService;
import com.esther.code.flow.IBusinessObjectProcessInfoService;
import com.esther.code.flow.adapter.TestFlowProcessActionAdapter;
import com.esther.code.flow.flownode.BusinessType;
import com.esther.code.model.BusinessObjectProcessInfo;
import com.esther.code.model.SubmitParam;
import com.esther.code.model.User;
import com.esther.code.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author esther
 * 2018-05-02 19:09
 * $DESCRIPTION}
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlowController.class);

    @Autowired
    @Qualifier("testFlowProcessActionAdapterImpl")
    private TestFlowProcessActionAdapter testFlowProcessActionAdapter;

    @Autowired
    @Qualifier("defaultBOProcessInfoService")
    private IBusinessObjectProcessInfoService businessObjectProcessInfoService;

    @Autowired
    private IUserService userService;

    /**
     * 提交至下一节点处理人
     *
     * @param boId
     * @param nextNodeUserId   下一节点处理人ID
     * @param nextNodeUserName 下一节点处理人名称
     * @throws Exception
     */
    @RequestMapping(value = "/submit2next")
    public String submit2next(HttpServletResponse response, HttpServletRequest request,
                              @RequestParam(value = "nextNodeUserId") int nextNodeUserId,
                              @RequestParam(value = "nextNodeUserName") String nextNodeUserName,
                              @RequestParam("boId") long boId) throws Exception {
        BusinessObjectProcessInfo info = businessObjectProcessInfoService.getProcessingInfoOfBO(boId, BusinessType.TEST_FLOW);
        User user = userService.selectByPrimaryKey(1);
        SubmitParam submitParam = testFlowProcessActionAdapter.submit2NextNode(user, info, nextNodeUserId, nextNodeUserName);
        if (Objects.isNull(submitParam.getNextFlowNode())) {
            return WebUtil.getFailureJson("流程结束。");
        }
        return WebUtil.getSuccessJson(nextNodeUserName);
    }
}
