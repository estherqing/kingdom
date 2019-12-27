package com.vivo.jovi.exscene.backend.web.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IExActivityCardService;
import com.vivo.jovi.exscene.backend.service.IUploadFileService;
import com.vivo.jovi.exscene.backend.web.filter.ThreadLocalSSOUser;
import com.vivo.jovi.scene.common.ActivityCardBizErrorCode;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.CommonVOCode;
import com.vivo.jovi.scene.common.constant.activitycard.*;
import com.vivo.jovi.scene.common.dal.dao.IExActivityCardDao;
import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import com.vivo.jovi.scene.common.model.ActivityCardSearchDTO;
import com.vivo.jovi.scene.common.model.RoleSystemResult;
import com.vivo.jovi.scene.common.model.bo.ActivityCardAuditBO;
import com.vivo.jovi.scene.common.model.bo.ActivityCardBO;
import com.vivo.jovi.scene.common.model.vo.ActivityCardDetailVO;
import com.vivo.jovi.scene.common.service.httpClient.impl.HttpClientService;
import com.vivo.jovi.scene.common.util.DateUtil;
import com.vivo.jovi.scene.common.util.FileUtil;
import com.vivo.jovi.scene.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author zhongjiajun
 * @date 2019/12/3 15:17
 * @describe 活动卡片管理类
 */
@Controller
@Slf4j
@RequestMapping(value = "/exscene/backend/card")
public class ActivityCardController {
    @Autowired
    private IUploadFileService uploadFileService;
    @Autowired
    private IExActivityCardService iExActivityCardService;
    @Autowired
    private HttpClientService httpClientService;
    @Autowired
    private IExActivityCardDao exActivityCardDao;

    /**
     * 查询操作的权限的地址
     */
    protected static final String ROLE_SYSTEM_URL = VivoConfigManager.getString("ROLE_SYSTEM_URL", "http://privilege-api.vivo.xyz/roleuser/");
    /**
     * 默认初始页
     */
    private static final Integer DEFAULT_INIT_PAGE = 1;
    private static final Integer DEFAULT_PAGE_SIZE = 20;

    @RequestMapping("index")
    public String cardsHome() {
        return "scene/activity/index";
    }

    @RequestMapping("audit")
    public String auditHome() {
        return "scene/activityAudit/index";
    }

    /**
     * 提交活动卡片或者保存草稿
     *
     * @param
     * @return
     */
    @RequestMapping(value = "submit", method = POST)
    @ResponseBody
    public CommonVO submit(@RequestBody ActivityCardBO activityCardAuditBo) {
        String result = checkActivityCard(activityCardAuditBo);
        if (StringUtils.isNotBlank(result)) {
            return CommonVO.badParams(result);
        }
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        if (ssoUser == null) {
            return CommonVO.error(CommonVOCode.USER_NOT_FOUND, "User does not exists");
        }
        iExActivityCardService.add(activityCardAuditBo, ssoUser);
        return CommonVO.success("提交成功");
    }

    /**
     * 修改活动卡片，保存草稿或者提交
     *
     * @return
     */
    @RequestMapping(value = "modify", method = POST)
    @ResponseBody
    public CommonVO modifyActivityCard(@RequestBody ActivityCardBO activityCardAuditBo) {
        String result = checkActivityCard(activityCardAuditBo);
        if (StringUtils.isNotBlank(result)) {
            return CommonVO.badParams(result);
        }
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        CommonVO checkResult = bizCheck(ssoUser, activityCardAuditBo.getId(), OperateTypeEnum.MODIFY);
        if (checkResult != null) {
            return checkResult;
        }
        iExActivityCardService.modify(activityCardAuditBo, ssoUser);
        return CommonVO.success("修改成功");
    }

    /**
     * 活动卡片上架
     *
     * @param id 活动Id
     * @return
     */
    @RequestMapping(value = "upperShelf", method = GET)
    @ResponseBody
    public CommonVO upperShelf(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return CommonVO.badParams("param:{id} is blank");
        }
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        CommonVO checkResult = bizCheck(ssoUser, id, OperateTypeEnum.ONLINE);
        if (checkResult != null) {
            return checkResult;
        }
        iExActivityCardService.updateStatus(id, ActivityCardStatusEnum.ONLINE, null, ssoUser);
        return CommonVO.success("上架成功");
    }

    /**
     * 活动卡片下架
     *
     * @param id     活动卡片Id
     * @param reason 下架原因
     * @return
     */
    @RequestMapping(value = "offShelf", method = GET)
    @ResponseBody
    public CommonVO offShelf(@RequestParam(value = "id") Long id, @RequestParam(value = "reason") String reason) {
        if (id == null) {
            return CommonVO.badParams("param:{id} is blank");
        }
        if (StringUtils.isBlank(reason)) {
            return CommonVO.badParams("param:{reason} is blank");
        }
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        CommonVO checkResult = bizCheck(ssoUser, id, OperateTypeEnum.OFFLINE);
        if (checkResult != null) {
            return checkResult;
        }
        iExActivityCardService.updateStatus(id, ActivityCardStatusEnum.OFFLINE, reason, ssoUser);
        return CommonVO.success("下架成功");
    }

    /**
     * 活动卡片禁用
     *
     * @param id     活动卡片Id
     * @param reason 禁用原因
     * @return
     */
    @RequestMapping(value = "forbid", method = GET)
    @ResponseBody
    public CommonVO forbid(@RequestParam(value = "id") Long id, @RequestParam(value = "reason") String reason) {
        if (id == null) {
            return CommonVO.badParams("param:{id} is blank");
        }
        if (StringUtils.isBlank(reason)) {
            return CommonVO.badParams("param:{reason} is blank");
        }
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        CommonVO checkResult = bizCheck(ssoUser, id, OperateTypeEnum.FORBID);
        if (checkResult != null) {
            return checkResult;
        }
        iExActivityCardService.updateStatus(id, ActivityCardStatusEnum.DISABLED, reason, ssoUser);
        return CommonVO.success("禁用成功");
    }

    /**
     * 活动卡片删除
     *
     * @param id 活动卡片Id
     * @return
     */
    @RequestMapping(value = "delete", method = GET)
    @ResponseBody
    public CommonVO delete(@RequestParam(value = "id") Long id) {
        if (id == null) {
            return CommonVO.badParams("param:{id} is blank");
        }
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();

        CommonVO checkResult = bizCheck(ssoUser, id, OperateTypeEnum.DELETE);
        if (checkResult != null) {
            return checkResult;
        }
        iExActivityCardService.delete(id);
        return CommonVO.success("删除成功");
    }

    /**
     * 活动卡片审核
     *
     * @return
     */
    @RequestMapping(value = "audit", method = POST)
    @ResponseBody
    public CommonVO audit(@RequestBody ActivityCardAuditBO activityCardAuditBo) {
        SSOUser ssoUser = ThreadLocalSSOUser.getSSOuser();
        if (ssoUser == null) {
            return CommonVO.error(CommonVOCode.USER_NOT_FOUND, "User does not exists");
        }
        ActivityCardDetailVO detail = iExActivityCardService.getDetail(activityCardAuditBo.getId());
        if (detail == null) {
            return CommonVO.error(ActivityCardBizErrorCode.ACTIVIYT_CARD_NOT_EXIST, "该活动卡片不存在");
        }
        if (detail.getStatus() != ActivityCardStatusEnum.AWAIT_AUDIT.getStatus()) {
            return CommonVO.error(ActivityCardBizErrorCode.OPERATE_AUTHORITY_LIMIT, "当前状态不可审核");
        }
        AuditStatusEnum auditResult = activityCardAuditBo.isApproval() ? AuditStatusEnum.AUDIT_PASS : AuditStatusEnum.AUDIT_REJECT;
        List<String> roleList = checkAuthority(ssoUser);
        if (CollectionUtils.isEmpty(roleList)) {
            return CommonVO.error(ActivityCardBizErrorCode.OPERATE_AUTHORITY_LIMIT, "当前状态不可审核");
        }
        for (String role : roleList) {
            if (role.equals(ActivityCardConstant.ROLE_OPERATE_NAME)) {
                if (detail.getApprovalOperationStatus() == AuditStatusEnum.AUDITING.getStatus().intValue()) {
                    iExActivityCardService.operationAudit(activityCardAuditBo.getId(), auditResult, activityCardAuditBo.getReason(), ssoUser);
                    break;
                }
            }
            if (role.equals(ActivityCardConstant.ROLE_TEST_NAME)) {
                if (detail.getApprovalTestStatus() == AuditStatusEnum.AUDITING.getStatus().intValue()) {
                    iExActivityCardService.testerAudit(activityCardAuditBo.getId(), auditResult, activityCardAuditBo.getReason(), ssoUser);
                    break;
                }
            }
        }
        return CommonVO.success("审核成功");
    }

    /**
     * 搜索活动卡片
     *
     * @return
     */
    @RequestMapping(value = "search", method = POST)
    @ResponseBody
    public CommonVO search(@RequestBody ActivityCardSearchDTO searchDTO) {
        if (searchDTO.getPage() == null) {
            searchDTO.setPage(DEFAULT_INIT_PAGE);
        }
        if (searchDTO.getSize() == null) {
            searchDTO.setPage(DEFAULT_PAGE_SIZE);
        }
        String orderFiled = null;
        String field = searchDTO.getField();
        if (StringUtils.isNotBlank(field)) {
            StringBuilder orderFieldBuilder = new StringBuilder("order by ");
            orderFieldBuilder.append(field);
            orderFieldBuilder.append(" ");
            orderFieldBuilder.append(searchDTO.getOrder());
            orderFiled = orderFieldBuilder.toString();
        }
        Pageable pageable = new PageRequest(searchDTO.getPage() - 1, searchDTO.getSize(), null);
        return CommonVO.success(iExActivityCardService.getPage(searchDTO.getName(), searchDTO.getStatus(), orderFiled, pageable));
    }

    /**
     * 查询活动卡片详情
     *
     * @return
     */
    @RequestMapping(value = "getDetail", method = GET)
    @ResponseBody
    public CommonVO getDetail(@RequestParam(value = "id") Long id) {
        ActivityCardDetailVO detail = iExActivityCardService.getDetail(id);
        return CommonVO.success(detail);
    }

    /**
     * 上传icon图片
     *
     * @param iconFile icon图片
     * @return
     */
    @RequestMapping(value = "uploadIcon", method = POST)
    @ResponseBody
    public CommonVO uploadIcon(@RequestParam(value = "iconFile") MultipartFile iconFile) throws IOException {
        String checkResult = imageCheck(iconFile, ActivityCardConstant.ICON_TYPE, ActivityCardConstant.ICON_WEIGHT_SIZE, ActivityCardConstant.ICON_HEIGHT_SIZE, ActivityCardConstant.ICON_SIZE);
        if (StringUtils.isNotBlank(checkResult)) {
            return CommonVO.badParams(checkResult);
        }
        HashMap<String, String> result = Maps.newHashMap();
        result.put("imageUrl", uplaodImage(iconFile));
        return CommonVO.success(result);
    }

    /**
     * 上传banner图片
     *
     * @param bannerFile banner图片
     * @return
     */
    @RequestMapping(value = "uploadBanner", method = POST)
    @ResponseBody
    public CommonVO uploadBanner(@RequestParam(value = "bannerFile") MultipartFile bannerFile) throws IOException {
        String checkResult = imageCheck(bannerFile, ActivityCardConstant.BANNER_TYPE, ActivityCardConstant.BANNER_WEIGHT_SIZE, ActivityCardConstant.BANNER_HEIGHT_SIZE, ActivityCardConstant.BANNER_SIZE);
        if (StringUtils.isNotBlank(checkResult)) {
            return CommonVO.badParams(checkResult);
        }
        HashMap<String, String> result = Maps.newHashMap();
        result.put("imageUrl", uplaodImage(bannerFile));
        return CommonVO.success(result);
    }

    /**
     * 图片格式校验
     *
     * @param imageFile 图片文件
     * @param imageType 图片支持类型
     * @param iamgeSize 图片大小限制
     * @return
     */
    private String imageCheck(MultipartFile imageFile, String imageType, int imageWidth, int imageHeight, int iamgeSize) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            log.error("上传的图片异常。");
            return "上传的图片异常";
        }
        //校验上传的图片类型
        String docSuffix = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf(".") + 1);
        if (imageType.indexOf(docSuffix) < NumberUtils.INTEGER_ZERO.intValue()) {
            log.error("上传的图片不是" + imageType);
            return "上传的图片类型不是" + imageType;
        }
        //校验图片大小
        if (!FileUtil.checkFileSize(imageFile.getSize(), iamgeSize, ActivityCardConstant.IMAGE_SIZE_UNIT)) {
            log.error("上传的图片过大");
            return "上传的图片过大";
        }
        // 通过MultipartFile得到InputStream，从而得到BufferedImage。若BufferedImage为空，证明上传的文件不是图片，获取图片流失败，不进行下面的操作
        BufferedImage bufferedImage = ImageIO.read(imageFile.getInputStream());
        if (bufferedImage == null) {
            return "上传的不是图片!";
        }
        Integer width = bufferedImage.getWidth();
        Integer height = bufferedImage.getHeight();
        // 校验图片的宽度和高度
        if ((width != imageWidth) || (height != imageHeight)) {
            return "图片宽度和高度不符合要求";
        }
        return null;
    }

    /**
     * 提交图片
     *
     * @param imageFile 图片文件
     * @return
     */
    private String uplaodImage(MultipartFile imageFile) throws IOException {
        String docSuffix = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf(".") + 1);
        return uploadFileService.uploadFile(UUID.randomUUID().toString() +
                        imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf("."))
                , imageFile.getInputStream(), docSuffix);
    }

    /**
     * 校验活动卡片数据
     *
     * @param activityCardAuditBo
     * @return
     */
    private String checkActivityCard(ActivityCardBO activityCardAuditBo) {
        if (activityCardAuditBo == null) {
            return "缺少必传参数";
        }
        String name = activityCardAuditBo.getName();
        if (StringUtils.isBlank(name) || StringUtils.length(name) > ActivityCardConstant.ACTIVITY_NAME_LENGTH) {
            return "活动名称必传100个字数以内";
        }
        String popup = activityCardAuditBo.getPopup();
        if (StringUtils.isBlank(popup) || StringUtils.length(popup) > ActivityCardConstant.ACTIVITY_NAME_LENGTH) {
            return "活动弹窗必传100个字数以内";
        }
        if (StringUtils.isBlank(activityCardAuditBo.getIcon())) {
            return "活动icon没有上传";
        }
        if (StringUtils.isBlank(activityCardAuditBo.getBanner())) {
            return "活动banner没有上传";
        }
        if (CardPositionEnum.statusOf(activityCardAuditBo.getCardPosition()) == null) {
            return "负一屏是否展示没有上传";
        }
        if (JumpTypeEnum.statusOf(activityCardAuditBo.getJumpType()) == null) {
            return "跳转类型没有上传";
        }
        Integer weight = activityCardAuditBo.getWeight();
        if (weight == null || weight < ActivityCardConstant.WEIGHT_BUTTOM || weight > ActivityCardConstant.WEIGHT_HEIGHT) {
            return "权重设置不合法";
        }
        //校验权重值是否存在
        ExActivityCardEntity entity = new ExActivityCardEntity();
        entity.setWeight(weight);
        List<ExActivityCardEntity> result = exActivityCardDao.selectPage(entity, null, NumberUtils.INTEGER_ZERO.intValue(), DEFAULT_PAGE_SIZE);
        boolean existWeight = false;
        if (activityCardAuditBo.getId() == null) {
            existWeight = CollectionUtils.isNotEmpty(result) && result.size() >= 1;
        } else {
            existWeight = CollectionUtils.isNotEmpty(result) && (result.get(NumberUtils.INTEGER_ZERO.intValue()).getId().longValue() != activityCardAuditBo.getId());
        }
        if (existWeight) {
            return "该权重已存在";
        }
        if (DisapperTypeEnum.statusOf(activityCardAuditBo.getDisapperType()) == null) {
            return "消失规则不合法";
        }
        Date triggerStartTime = activityCardAuditBo.getTriggerStartTime();
        if (triggerStartTime == null || triggerStartTime.compareTo(new Date()) < NumberUtils.INTEGER_ZERO.intValue()) {
            return "活动卡片触发开始时间不合法";
        }
        Date triggerEndTime = activityCardAuditBo.getTriggerEndTime();
        if (triggerEndTime == null || triggerEndTime.compareTo(new Date()) < NumberUtils.INTEGER_ZERO.intValue()) {
            return "活动卡片触发结束时间不合法";
        }
        if (triggerEndTime.compareTo(triggerStartTime) <= NumberUtils.INTEGER_ZERO.intValue()) {
            return "活动卡片触发结束时间不合法不可小于触发开始时间";
        }
        if (activityCardAuditBo.getSaveAction() < NumberUtils.INTEGER_ZERO.intValue() || activityCardAuditBo.getSaveAction() > NumberUtils.INTEGER_ONE.intValue()) {
            return "保存类型不合法";
        }
        String[] translateLanague = activityCardAuditBo.getTranslateLanguage();
        if (translateLanague == null) {
            return "翻译语言不可为空";
        }
        String noticeTitle = activityCardAuditBo.getNoticeTitle();
        if (StringUtils.isBlank(noticeTitle)) {
            return null;
        }
        if (StringUtils.length(noticeTitle) > ActivityCardConstant.NOTICE_TITLE_LENGTH) {
            return "通知标题限制在100个字符";
        }
        String noticeContent = activityCardAuditBo.getNoticeContent();
        if (StringUtils.isBlank(noticeContent) || StringUtils.length(noticeContent) > ActivityCardConstant.NOTICE_CONTENT_LENGTH) {
            return "通知内容限制在100个字符";
        }
        if (NoticeTypeEnum.statusOf(activityCardAuditBo.getNoticeType()) == null) {
            return "通知类型不合法";
        }
        if (activityCardAuditBo.getNoticeType() == NoticeTypeEnum.CUSTOM.getType().intValue()) {
            Date noticeStartTime = activityCardAuditBo.getNoticeStartTime();
            if (noticeStartTime == null || noticeStartTime.compareTo(new Date()) < NumberUtils.INTEGER_ZERO.intValue()) {
                return "通知触发开始时间不合法";
            }
            Date noticeEndTime = activityCardAuditBo.getNoticeEndTime();
            if (noticeEndTime == null || noticeEndTime.compareTo(new Date()) < NumberUtils.INTEGER_ZERO.intValue()) {
                return "通知触发结束时间不合法";
            }
            if (noticeEndTime.compareTo(noticeStartTime) <= NumberUtils.INTEGER_ZERO.intValue()) {
                return "通知触发结束时间不合法不可小于触发开始时间";
            }
        }
        return null;
    }

    /**
     * 权限校验
     *
     * @param currentStatus 活动卡片当前状态
     * @param operateType   操作类型
     * @return
     */
    private boolean checkOperateAuthority(Integer currentStatus, OperateTypeEnum operateType) {
        List<Integer> operateSupportStatus = Lists.newArrayList();
        switch (operateType) {
            case MODIFY: {
                operateSupportStatus.add(ActivityCardStatusEnum.DRAFT.getStatus());
                operateSupportStatus.add(ActivityCardStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus());
                operateSupportStatus.add(ActivityCardStatusEnum.AUDIT_REJECT.getStatus());
                operateSupportStatus.add(ActivityCardStatusEnum.OFFLINE.getStatus());
                operateSupportStatus.add(ActivityCardStatusEnum.DISABLED.getStatus());
            }
            break;
            case DELETE:
                operateSupportStatus.add(ActivityCardStatusEnum.DRAFT.getStatus());
                break;
            case IMPORT:
                operateSupportStatus.add(ActivityCardStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus());
                break;
            case EXPORT:
                operateSupportStatus.add(ActivityCardStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus());
                break;
            case ONLINE:
                operateSupportStatus.add(ActivityCardStatusEnum.AWAIT_ONLINE.getStatus());
                break;
            case OFFLINE:
                operateSupportStatus.add(ActivityCardStatusEnum.ONLINE.getStatus());
                break;
            case FORBID:
                operateSupportStatus.add(ActivityCardStatusEnum.ONLINE.getStatus());
                operateSupportStatus.add(ActivityCardStatusEnum.OFFLINE.getStatus());
                break;
            default:
                break;
        }
        return operateSupportStatus.contains(currentStatus);
    }


    /**
     * 业务逻辑校验
     *
     * @param ssoUser     操作员信息
     * @param id          活动卡片id
     * @param operateType 操作类型
     * @return
     */
    private CommonVO bizCheck(SSOUser ssoUser, Long id, OperateTypeEnum operateType) {
        if (ssoUser == null) {
            return CommonVO.error(CommonVOCode.USER_NOT_FOUND, "User does not exists");
        }
        ActivityCardDetailVO detail = iExActivityCardService.getDetail(id);
        if (detail == null) {
            return CommonVO.error(ActivityCardBizErrorCode.ACTIVIYT_CARD_NOT_EXIST, "该活动卡片不存在");
        }
        boolean queryAuthority = checkOperateAuthority(detail.getStatus(), operateType);
        if (!queryAuthority) {
            return CommonVO.error(ActivityCardBizErrorCode.OPERATE_AUTHORITY_LIMIT, "当前状态不可进行" + operateType.getType() + "操作");
        }
        if (operateType == OperateTypeEnum.ONLINE && DateUtil.parseTime(detail.getTriggerEndTime()).compareTo(new Date()) < NumberUtils.INTEGER_ZERO.intValue()) {
            return CommonVO.error(ActivityCardBizErrorCode.OPERATE_AUTHORITY_LIMIT, "结束时间已过，无法上架");
        }
        return null;
    }

    /**
     * 获取操作员的角色信息
     *
     * @param ssoUser 操作员信息
     * @return
     */
    private List<String> checkAuthority(SSOUser ssoUser) {
        String response = httpClientService.doGet(ROLE_SYSTEM_URL + ssoUser.getUserId());
        List<RoleSystemResult> roleSystemResults = JsonUtils.TO_ARRAY(response, RoleSystemResult.class);
        List<String> roles = Lists.newArrayList();
        try {
            for (RoleSystemResult rs : roleSystemResults) {
                if (!ActivityCardConstant.ROLE_OPERATE_NAME.equals(rs.getName()) && !ActivityCardConstant.ROLE_TEST_NAME.equals(rs.getName())) {
                    continue;
                }
                //测试审核
                if (ActivityCardConstant.ROLE_TEST_NAME.equals(rs.getName())) {
                    roles.add(ActivityCardConstant.ROLE_TEST_NAME);
                }
                //运营审核
                if (ActivityCardConstant.ROLE_OPERATE_NAME.equals(rs.getName())) {
                    roles.add(ActivityCardConstant.ROLE_OPERATE_NAME);
                }
            }
        } catch (Exception e) {
            log.error("query user role failed:{}", e);
        }
        return roles;
    }
}
