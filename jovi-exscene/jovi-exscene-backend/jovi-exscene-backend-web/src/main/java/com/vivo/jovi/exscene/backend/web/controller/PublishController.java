package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.console.data.domain.SimplePage;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.service.model.PublishStrategyDetail;
import com.vivo.jovi.exscene.backend.service.model.form.PublishForm;
import com.vivo.jovi.exscene.backend.service.model.form.PublishStrategyForm;
import com.vivo.jovi.exscene.backend.service.model.vo.Approval;
import com.vivo.jovi.exscene.backend.service.model.vo.PublishVO;
import com.vivo.jovi.exscene.backend.web.filter.ThreadLocalSSOUser;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.constant.CommonRetCodeConstants;
import com.vivo.jovi.scene.common.constant.PublishStatus;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("exscene")
public class PublishController extends BaseController {

    @Autowired
    private IPublishService publishService;

    @RequestMapping("publish/operate")
    public String publishHome() {
        return "scene/publish/index";
    }

    @RequestMapping("publishAudit")
    public String publishAudit() {
        return "scene/publishAudit/index";
    }

    /**
     * 发布列表
     */
    @RequestMapping("publishList")
    @ResponseBody
    public CommonVO publishList(@RequestBody PublishForm publishForm){

        if (publishForm.getPage() == null || publishForm.getSize() == null) {
            return CommonVO.badParams("param error");
        }

        if (StringUtils.isBlank(publishForm.getOrder())) {
            publishForm.setOrder("desc");
        }
        if (StringUtils.isBlank(publishForm.getField())) {
            publishForm.setField("updateTime");
        }

        Pageable pageable = new PageRequest(publishForm.getPage() - 1, publishForm.getSize(), null);
        List<PublishVO> publishList = publishService.findPublish(publishForm, pageable);
        long count = publishService.countPublish(publishForm);
        SimplePage<PublishVO> simplePage = new SimplePage<>(publishList, pageable, count);

        return CommonVO.success(simplePage);
    }

    /**
     * 修改状态
     */
    @RequestMapping("updateStatus")
    @ResponseBody
    public CommonVO updateStatus(@RequestBody PublishForm publishForm){

        if (PublishStatus.PUBLISH_FAILURE.getCode().equals(publishForm.getStatus()) && StringUtils.isBlank(publishForm.getFailureReason())){
            return CommonVO.badParams("失效原因不能为空");
        }

        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        if (ssoUser == null) {
            return CommonVO.error(CommonVOCode.USER_NOT_FOUND, "User does not exists");
        }

        if (StringUtils.isBlank(publishForm.getStrategyId()) || publishForm.getStatus() == null){
            return CommonVO.badParams("param error");
        }

        return publishService.updateStatus(ssoUser, publishForm);
    }

    /**
     * 审核列表
     */
    @RequestMapping("auditList")
    @ResponseBody
    public CommonVO auditList(@RequestBody PublishForm publishForm){

        if (publishForm.getPage() == null || publishForm.getSize() == null) {
            return CommonVO.badParams("param error");
        }

        if (StringUtils.isBlank(publishForm.getOrder())) {
            publishForm.setOrder("desc");
        }
        if (StringUtils.isBlank(publishForm.getField())) {
            publishForm.setField("updateTime");
        }

        publishForm.setStatus(1);

        Pageable pageable = new PageRequest(publishForm.getPage() - 1, publishForm.getSize(), null);
        List<PublishVO> publishList = publishService.findPublish(publishForm, pageable);
        long count = publishService.countPublish(publishForm);
        SimplePage<PublishVO> simplePage = new SimplePage<>(publishList, pageable, count);

        return CommonVO.success(simplePage);
    }

    /**
     * 查看审核状态
     */
    @RequestMapping("approvalStatus")
    @ResponseBody
    public CommonVO approvalStatus(@RequestBody PublishForm publishForm){
        if (StringUtils.isBlank(publishForm.getStrategyId())){
            return CommonVO.badParams("param error");
        }

        Approval approval = publishService.approvalStatus(publishForm);

        return CommonVO.success(approval);
    }

    /**
     * 审核
     */
    @RequestMapping("approval")
    @ResponseBody
    public CommonVO approval(@RequestBody Approval approval){
        if (approval.getStatus() == null){
            return CommonVO.badParams("param error");
        }

        if (approval.getStatus() == 2 && StringUtils.isBlank(approval.getReason())){
            return CommonVO.badParams("原因不能为空");
        }

        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        if (ssoUser == null) {
            return CommonVO.error(CommonVOCode.USER_NOT_FOUND, "User does not exists");
        }

        try {
            return publishService.approval(ssoUser, approval);
        } catch (RuntimeException e){
            return CommonVO.error(CommonRetCodeConstants.APPROVAL_ERROR, "审核失败");
        } catch (Exception e){
            return CommonVO.error(CommonRetCodeConstants.SYSTEM_ERROR, "系统错误");
        }
    }

    /**
     * 待发布卡片名称
     */
    @RequestMapping("getPublishExamine")
    @ResponseBody
    public CommonVO getPublishExamine(){
        List<PublishVO> publishVOList = publishService.getPublishExamine();

        return CommonVO.success(publishVOList);
    }

    /**
     * 获取智慧场景版本
     */
    @RequestMapping("getEdition")
    @ResponseBody
    public CommonVO getEdition(){
        String edition = VivoConfigManager.getString("intellig.scene.edition", "2360,2361,2362,2363");
        List<String> editionList = Arrays.asList(edition.split(","));
        return CommonVO.success(editionList);
    }

    /**
     * 上传翻译文件
     */
    @RequestMapping("uploadTranslateFile")
    @ResponseBody
    public CommonVO uploadTranslateFile(MultipartFile file){
        Map<String, Object> map = publishService.uploadTranslateFile(file);
        return CommonVO.success(map);
    }

    /**
     * 发布/修改
     */
    @RequestMapping("publish")
    @ResponseBody
    public CommonVO publish(@RequestBody PublishStrategyForm publishStrategyForm){

        if (StringUtils.isBlank(publishStrategyForm.getStrategyId()) || StringUtils.isBlank(publishStrategyForm.getIntelligSceneEdition())
                || publishStrategyForm.getClientVersion() == null || publishStrategyForm.getType() == null){
            return CommonVO.badParams("param error");
        }

        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        if (ssoUser == null) {
            return CommonVO.error(CommonVOCode.USER_NOT_FOUND, "User does not exists");
        }

        PublishStrategyDetail publishDetail = publishService.getPublishDetail(publishStrategyForm.getStrategyId(), null);
        if (PublishStatus.PUBLISH_FAILURE.getCode().equals(publishDetail.getStatus())) {
            return CommonVO.error(CommonRetCodeConstants.ADD_PUBLISHSTRATEGY_ERROR, "该服务的发布策略已失效，请重新检查内容后上架");
        }

        if (publishDetail.getBizStatus() != QuestionnaireStatusEnum.ONLINE.getStatus()){
            return CommonVO.error(CommonRetCodeConstants.ADD_PUBLISHSTRATEGY_ERROR, "该服务不在上线状态，请检查内容后上架");
        }

        return publishService.publish(ssoUser, publishStrategyForm);
    }

    /**
     * 发布策略详情
     */
    @RequestMapping("getPublishDetail")
    @ResponseBody
    public CommonVO getPublishDetail(@RequestBody PublishForm publishForm){
        PublishStrategyDetail publishStrategyDetail = publishService.getPublishDetail(publishForm.getStrategyId(), null);
        return CommonVO.success(publishStrategyDetail);
    }
}
