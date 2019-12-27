package com.vivo.jovi.exscene.backend.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.service.IUploadFileService;
import com.vivo.jovi.exscene.backend.service.model.PublishStrategyDetail;
import com.vivo.jovi.exscene.backend.service.model.form.PublishForm;
import com.vivo.jovi.exscene.backend.service.model.form.PublishStrategyForm;
import com.vivo.jovi.exscene.backend.service.model.vo.Approval;
import com.vivo.jovi.exscene.backend.service.model.vo.PublishVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.constant.CommonRetCodeConstants;
import com.vivo.jovi.scene.common.constant.PublishStatus;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.constant.SourceTypeEnum;
import com.vivo.jovi.scene.common.dal.dao.IExActivityCardDao;
import com.vivo.jovi.scene.common.dal.dao.IExPublishDao;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireDao;
import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireEntity;
import com.vivo.jovi.scene.common.publish.Roleuser;
import com.vivo.jovi.scene.common.service.httpClient.IHttpClientService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PublishService implements IPublishService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublishService.class);

    @Autowired
    private IExPublishDao exPublishDao;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IHttpClientService httpClientService;

    @Autowired
    private IUploadFileService uploadFileService;

    @Autowired
    private IExActivityCardDao exActivityCardDao;

    @Override
    public List<PublishVO> findPublish(PublishForm publishForm, Pageable pageable) {
        List<PublishVO> activityList = new ArrayList<>();
        List<ExPublishEntity> pes = exPublishDao.findPublish(publishForm.getName(), publishForm.getStatus(),
                pageable.getOffset(), pageable.getPageSize(), publishForm.getField(), publishForm.getOrder());

        for (ExPublishEntity pe : pes) {
            activityList.add(new PublishVO(pe));
        }

        return activityList;
    }

    @Override
    public long countPublish(PublishForm publishForm) {
        return exPublishDao.countPublish(publishForm.getName(), publishForm.getStatus());
    }

    @Override
    public CommonVO updateStatus(SSOUser ssoUser, PublishForm publishForm) {
        ExPublishEntity publishEntity = exPublishDao.selectByStrategyId(publishForm.getStrategyId(), null);
        if (publishEntity.getStatus().equals(PublishStatus.PUBLISH_FAILURE.getCode())) {
            return CommonVO.error(CommonRetCodeConstants.UPDATE_STATUS_ERROR, "该服务的发布策略已失效，请重新检查内容后上架");
        }

        if (publishForm.getStatus().equals(PublishStatus.PUBLISH_GRAY_LEVEL.getCode()) || publishForm.getStatus().equals(PublishStatus.PUBLISH_FULL.getCode())) {
            if (QuestionnaireStatusEnum.ONLINE.getStatus() != publishEntity.getBizStatus()) {
                if (QuestionnaireStatusEnum.OFFLINE.getStatus() == publishEntity.getBizStatus()) {
                    return CommonVO.error(CommonRetCodeConstants.UPDATE_STATUS_ERROR, "调研卡片处于下架状态、无法启动策略");
                } else if (QuestionnaireStatusEnum.DISABLED.getStatus() == publishEntity.getBizStatus()) {
                    return CommonVO.error(CommonRetCodeConstants.UPDATE_STATUS_ERROR, "调研卡片处于禁用状态、无法启动策略");
                } else {
                    return CommonVO.error(CommonRetCodeConstants.UPDATE_STATUS_ERROR, "启动失败");
                }
            }

            if (publishEntity.getApprovalOperationStatus() == 0 || publishEntity.getApprovalTestStatus() == 0) {
                int row = exPublishDao.updateStatus(publishForm.getStrategyId(), ssoUser.getUserName(), PublishStatus.PUBLISH_TO_AUDIT.getCode(), null);
                if (row <= 0) {
                    return CommonVO.error(CommonRetCodeConstants.UPDATE_STATUS_ERROR, "修改状态失败");
                }

                return CommonVO.success();
            }
        }

        int row = exPublishDao.updateStatus(publishForm.getStrategyId(), ssoUser.getUserName(), publishForm.getStatus(), publishForm.getFailureReason());
        if (row <= 0) {
            return CommonVO.error(CommonRetCodeConstants.UPDATE_STATUS_ERROR, "修改状态失败");
        }

        return CommonVO.success();
    }

    @Override
    public Approval approvalStatus(PublishForm publishForm) {
        ExPublishEntity publishEntity = exPublishDao.approvalStatus(publishForm.getStrategyId());
        return new Approval(publishEntity);
    }

    @Override
    @Transactional
    public CommonVO approval(SSOUser ssoUser, Approval approval) {
        String roleUserUrl = VivoConfigManager.getString("ROLE_SYSTEM_URL", "http://privilege-api.vivo.xyz/roleuser/");
        String response = httpClientService.doGet(roleUserUrl + ssoUser.getUserId());
        JSONArray jsonArray = JSONObject.parseArray(response);

        boolean flag = false;
        String reAuditMsg = null;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Roleuser roleuser = JSONObject.toJavaObject(jsonObject, Roleuser.class);
            ExPublishEntity publishEntity = exPublishDao.selectByStrategyId(approval.getStrategyId(), null);

            // 判断是否为运营人员审核
            if ("exscene_operate".equals(roleuser.getName())) {
                if (publishEntity.getApprovalOperationStatus() != 0) {
                    reAuditMsg = "运营已审核，不能重复审核！";
                    continue;
                }
                flag = true;
                exPublishDao.approvalByOperation(approval.getStrategyId(), ssoUser.getUserId(), ssoUser.getUserName(),
                        approval.getStatus(), approval.getReason());
                //当同时拥有两个角色时，清空
                reAuditMsg = null;
                break;
            }

            // 判断是否为测试人员审核
            if ("exscene_test".equals(roleuser.getName())) {
                if (publishEntity.getApprovalTestStatus() != 0) {
                    reAuditMsg = "测试已审核，不能重复审核！";
                    continue;
                }
                flag = true;
                exPublishDao.approvalByTest(approval.getStrategyId(), ssoUser.getUserId(), ssoUser.getUserName(),
                        approval.getStatus(), approval.getReason());
                //当同时拥有两个角色时，清空
                reAuditMsg = null;
                break;
            }
        }

        if (StringUtils.isNotBlank(reAuditMsg)) {
            return CommonVO.error(CommonRetCodeConstants.NOT_AUDIT_AUTH, reAuditMsg);
        }
        if (!flag) {
            return CommonVO.error(CommonRetCodeConstants.NOT_AUDIT_AUTH, "没有审核权限");
        }

        // 如果两种人员都审核过，判断审核状态来决定发布策略的状态为发布还是驳回
        ExPublishEntity publishEntity = exPublishDao.approvalStatus(approval.getStrategyId());
        if (publishEntity.getApprovalOperationStatus() != 0 && publishEntity.getApprovalTestStatus() != 0) {
            if (publishEntity.getBizStatus() == 9) {
                if (publishEntity.getApprovalOperationStatus() == 1 && publishEntity.getApprovalTestStatus() == 1) {
                    if (publishEntity.getType() != 0) {
                        int row = exPublishDao.updateStatusByApproval(approval.getStrategyId(), PublishStatus.PUBLISH_GRAY_LEVEL.getCode());
                        if (row <= 0) {
                            LOGGER.error("修改状态为灰度发布失败");
                            throw new RuntimeException("审核失败");
                        }
                    } else {
                        int row = exPublishDao.updateStatusByApproval(approval.getStrategyId(), PublishStatus.PUBLISH_FULL.getCode());
                        if (row <= 0) {
                            LOGGER.error("修改状态为全量发布失败");
                            throw new RuntimeException("审核失败");
                        }
                    }
                }
            } else {
                int row = exPublishDao.updateStatusByApproval(approval.getStrategyId(), PublishStatus.PUBLISH_PAUSE.getCode());
                if (row <= 0) {
                    LOGGER.error("修改状态为暂停失败");
                    throw new RuntimeException("审核失败");
                }
            }
        }

        if (publishEntity.getApprovalOperationStatus() == 2 || publishEntity.getApprovalTestStatus() == 2) {
            // 只要有一个角色驳回就驳回
            int row = exPublishDao.updateStatusByApproval(approval.getStrategyId(), PublishStatus.PUBLISH_REJECT.getCode());
            if (row <= 0) {
                LOGGER.error("修改状态为驳回失败");
                throw new RuntimeException("审核失败");
            }
        }

        return CommonVO.success();
    }

    @Override
    public int insertSelective(ExPublishEntity publishEntity) {
        return exPublishDao.insertSelective(publishEntity);
    }

    @Override
    public int updateSelective(ExPublishEntity publishEntity) {
        return exPublishDao.updateSelective(publishEntity);
    }

    @Override
    public int updateStrategy(Long id, String strategyId) {
        return exPublishDao.updateStrategy(id, strategyId);
    }

    @Override
    public List<PublishVO> getPublishExamine() {
        List<ExPublishEntity> publishEntityList = exPublishDao.findPublish(null, 0, null,
                null, "updateTime", "desc");
        List<PublishVO> publishVOList = new ArrayList<>();
        for (ExPublishEntity publishEntity : publishEntityList) {
            PublishVO publishVO = new PublishVO();
            publishVO.setStrategyId(publishEntity.getStrategyId());
            publishVO.setName(publishEntity.getBizName());
            if (publishEntity.getSourceType().equals(SourceTypeEnum.QNR.getType())) {
                QuestionnaireEntity questionnaireEntity = questionnaireDao.selectByQuestionnaireId(publishEntity.getBizId());
                publishVO.setFileUrl(questionnaireEntity.getTranslateFileUrl());
                publishVO.setFileName(questionnaireEntity.getTranslateFileName());
            } else {
                ExActivityCardEntity activityCardEntity = exActivityCardDao.selectByActivityId(publishEntity.getBizId());
                publishVO.setFileUrl(activityCardEntity.getTranslateFileUrl());
                publishVO.setFileName(activityCardEntity.getTranslateFileName());
            }
            publishVOList.add(publishVO);
        }

        return publishVOList;
    }

    @Override
    public Map<String, Object> uploadTranslateFile(MultipartFile file) {
        try {
            String docSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            String fileUrl = uploadFileService.uploadFile(UUID.randomUUID().toString() +
                            file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")),
                    file.getInputStream(), docSuffix);

            Map<String, Object> map = new HashMap<>();
            map.put("fileUrl", fileUrl);
            map.put("fileName", file.getOriginalFilename());

            return map;
        } catch (Exception e) {
            LOGGER.error("异常，参数{}", file);
            return null;
        }
    }

    @Override
    public PublishStrategyDetail getPublishDetail(String strategyId, String bizId) {
        ExPublishEntity publishEntity = exPublishDao.selectByStrategyId(strategyId, bizId);
        if (publishEntity == null) {
            return null;
        }
        if (publishEntity.getSourceType().equals(SourceTypeEnum.QNR.getType())) {
            QuestionnaireEntity questionnaireEntity = questionnaireDao.selectByQuestionnaireId(publishEntity.getBizId());
            publishEntity.setFileUrl(questionnaireEntity.getTranslateFileUrl());
            publishEntity.setFileName(questionnaireEntity.getTranslateFileName());
        } else {
            ExActivityCardEntity activityCardEntity = exActivityCardDao.selectByActivityId(publishEntity.getBizId());
            publishEntity.setFileUrl(activityCardEntity.getTranslateFileUrl());
            publishEntity.setFileName(activityCardEntity.getTranslateFileName());
        }
        return new PublishStrategyDetail(publishEntity);
    }

    @Override
    @Transactional
    public CommonVO publish(SSOUser ssoUser, PublishStrategyForm publishStrategyForm) {
        try {
            if (publishStrategyForm.getType() == 1) {
                if (StringUtils.isBlank(publishStrategyForm.getRoleGrey())) {
                    return CommonVO.badParams("param error");
                }

                String[] strArr = publishStrategyForm.getRoleGrey().split(",");
                for (int i = 0; i < strArr.length; i++) {
                    if (!StringUtils.isNumeric(strArr[i])) {
                        return CommonVO.badParams("role必须为数字");
                    }
                    if (Integer.parseInt(strArr[i]) < 0 || Integer.parseInt(strArr[i]) > 10) {
                        return CommonVO.badParams("role范围为0~10");
                    }
                }
            }

            int row = exPublishDao.updatePublishStrategy(publishStrategyForm.getStrategyId(), publishStrategyForm.getIntelligSceneEdition().replaceAll(" +", ""),
                    publishStrategyForm.getType(), publishStrategyForm.getFileUrl(), publishStrategyForm.getFileName(),
                    publishStrategyForm.getRoleGrey(), PublishStatus.PUBLISH_TO_AUDIT.getCode(), ssoUser.getUserName(),
                    publishStrategyForm.getClientVersion(), publishStrategyForm.getExpectedRelease());
            if (row <= 0) {
                LOGGER.error("创建发布失败");
                return CommonVO.error(CommonRetCodeConstants.ADD_PUBLISHSTRATEGY_ERROR, "创建发布失败");
            }

            return CommonVO.success();
        } catch (Exception e) {
            LOGGER.error("publish error, params : {} !， error msg : {}", publishStrategyForm.toString(), e);
            return CommonVO.error(CommonRetCodeConstants.SYSTEM_ERROR, "系统错误");
        }
    }
}
