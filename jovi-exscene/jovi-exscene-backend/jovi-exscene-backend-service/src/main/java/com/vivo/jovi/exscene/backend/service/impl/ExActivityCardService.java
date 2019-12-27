package com.vivo.jovi.exscene.backend.service.impl;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vivo.internet.privilege.client.SSOUser;
import com.vivo.jovi.exscene.backend.service.IExActivityCardService;
import com.vivo.jovi.exscene.backend.service.IPublishService;
import com.vivo.jovi.exscene.backend.service.model.PublishStrategyDetail;
import com.vivo.jovi.scene.common.constant.PublishStatus;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.constant.SourceTypeEnum;
import com.vivo.jovi.scene.common.constant.activitycard.ActivityCardConstant;
import com.vivo.jovi.scene.common.constant.activitycard.ActivityCardStatusEnum;
import com.vivo.jovi.scene.common.constant.activitycard.AuditStatusEnum;
import com.vivo.jovi.scene.common.constant.activitycard.NoticeTypeEnum;
import com.vivo.jovi.scene.common.dal.dao.IExActivityCardDao;
import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import com.vivo.jovi.scene.common.model.bo.ActivityCardBO;
import com.vivo.jovi.scene.common.model.vo.ActivityCardDetailVO;
import com.vivo.jovi.scene.common.model.vo.ActivityCardVO;
import com.vivo.jovi.scene.common.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author zhongjiajun
 * @date 2019/12/4 19:42
 * @describe 活动卡片处理
 */
@Service
public class ExActivityCardService implements IExActivityCardService {
    @Autowired
    private IExActivityCardDao exActivityCardDao;
    @Autowired
    private IPublishService publishService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ActivityCardBO activityCard, SSOUser ssoUser) {
        ExActivityCardEntity entity = convert2Entity(activityCard);
        entity.setCreateUserId(ssoUser.getUserId());
        entity.setCreateUserName(ssoUser.getUserName());
        entity.setModifyUserId(ssoUser.getUserId());
        entity.setModifyUserName(ssoUser.getUserName());
        exActivityCardDao.insertSelective(entity);
        ExActivityCardEntity updateParam = new ExActivityCardEntity();
        updateParam.setId(entity.getId());
        updateParam.setActivityId(ActivityCardConstant.ACTIVITY_ID + entity.getId().longValue());
        exActivityCardDao.updateSelectiveByPrimaryKey(updateParam);
    }

    @Override
    public void modify(ActivityCardBO activityCard, SSOUser ssoUser) {
        ExActivityCardEntity entity = convert2Entity(activityCard);
        entity.setModifyUserId(ssoUser.getUserId());
        entity.setModifyUserName(ssoUser.getUserName());
        entity.setApprovalOperationUserId("");
        entity.setApprovalOperationUserName("");
        entity.setApprovalOperationReason("");
        entity.setApprovalOperationStatus(AuditStatusEnum.AUDITING.getStatus());
        entity.setApprovalTestUserId("");
        entity.setApprovalTestUserName("");
        entity.setApprovalTestReason("");
        entity.setApprovalTestStatus(AuditStatusEnum.AUDITING.getStatus());
        entity.setPulloffReason("");
        entity.setDisableReason("");
        exActivityCardDao.updateSelectiveByPrimaryKey(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStatus(Long id, ActivityCardStatusEnum status, String reason, SSOUser ssoUser) {
        ExActivityCardEntity updateStatus = new ExActivityCardEntity();
        updateStatus.setId(id);
        updateStatus.setStatus(status.getStatus());
        if (status == ActivityCardStatusEnum.OFFLINE) {
            updateStatus.setPulloffReason(reason);
        }
        if (status == ActivityCardStatusEnum.DISABLED) {
            updateStatus.setDisableReason(reason);
        }
        updateStatus.setModifyUserId(ssoUser.getUserId());
        updateStatus.setModifyUserName(ssoUser.getUserName());
        exActivityCardDao.updateSelectiveByPrimaryKey(updateStatus);

        //当状态为上线时，发布管理中不存在发布时，则新增发布管理；若存在，则更新状态为上线
        ExActivityCardEntity exActivityCardEntity = exActivityCardDao.selectByPrimaryKey(id);
        ExPublishEntity exPublishEntity = new ExPublishEntity();
        exPublishEntity.setBizId(exActivityCardEntity.getActivityId());
        if (status.getStatus() == ActivityCardStatusEnum.ONLINE.getStatus()) {
            exPublishEntity.setSourceType(SourceTypeEnum.ACT.getType());
            exPublishEntity.setBizName(exActivityCardEntity.getName());
            exPublishEntity.setBizEndTime(exActivityCardEntity.getTriggerEndTime());
            exPublishEntity.setBizStatus(QuestionnaireStatusEnum.ONLINE.getStatus());
            exPublishEntity.setModifyUserName(ssoUser.getUserName());
            PublishStrategyDetail publishDetail = publishService.getPublishDetail(null, exPublishEntity.getBizId());
            if (publishDetail == null) {
                publishService.insertSelective(exPublishEntity);
                Long primaryKey = exPublishEntity.getId();
                String strategyId = "strategy_" + primaryKey;
                publishService.updateStrategy(primaryKey, strategyId);
            } else {
                exPublishEntity.setId(publishDetail.getId());
                publishService.updateSelective(exPublishEntity);
            }
        }
        //当状态为禁用或下线时，更新发布管理中的内容为禁用或下线
        if (status == ActivityCardStatusEnum.OFFLINE || status == ActivityCardStatusEnum.DISABLED) {
            if (status == ActivityCardStatusEnum.OFFLINE) {
                exPublishEntity.setBizStatus(QuestionnaireStatusEnum.OFFLINE.getStatus());
            }
            if (status == ActivityCardStatusEnum.DISABLED) {
                exPublishEntity.setBizStatus(QuestionnaireStatusEnum.DISABLED.getStatus());
            }
            exPublishEntity.setStatus(PublishStatus.PUBLISH_PAUSE.getCode());
            exPublishEntity.setModifyUserName(ssoUser.getUserName());
            publishService.updateSelective(exPublishEntity);
        }
    }


    @Override
    public void operationAudit(Long id, AuditStatusEnum auditStatus, String rejectReason, SSOUser ssoUser) {
        ExActivityCardEntity updateStatus = new ExActivityCardEntity();
        updateStatus.setId(id);
        updateStatus.setApprovalOperationStatus(auditStatus.getStatus());
        updateStatus.setApprovalOperationReason(auditStatus == AuditStatusEnum.AUDIT_PASS ? null : rejectReason);
        updateStatus.setApprovalOperationUserId(ssoUser.getUserId());
        updateStatus.setApprovalOperationUserName(ssoUser.getUserName());
        updateStatus.setModifyUserId(ssoUser.getUserId());
        updateStatus.setModifyUserName(ssoUser.getUserName());
        //当运营和测试都审核通过时，则设置状态为待上线
        ExActivityCardEntity exActivityCardEntity = exActivityCardDao.selectByPrimaryKey(id);
        boolean auditPass = (auditStatus == AuditStatusEnum.AUDIT_PASS) && (exActivityCardEntity.getApprovalTestStatus().intValue() == AuditStatusEnum.AUDIT_PASS.getStatus());
        if (auditPass) {
            updateStatus.setStatus(ActivityCardStatusEnum.AWAIT_ONLINE.getStatus());
        }
        //当运营或测试有一方审核失败时，设置状态为审核驳回
        boolean auditReject = (auditStatus == AuditStatusEnum.AUDIT_REJECT) && (exActivityCardEntity.getApprovalTestStatus().intValue() != AuditStatusEnum.AUDIT_REJECT.getStatus());
        if (auditReject) {
            updateStatus.setStatus(ActivityCardStatusEnum.AUDIT_REJECT.getStatus());
        }
        exActivityCardDao.updateSelectiveByPrimaryKey(updateStatus);
    }

    @Override
    public void testerAudit(Long id, AuditStatusEnum auditStatus, String rejectReason, SSOUser ssoUser) {
        ExActivityCardEntity updateStatus = new ExActivityCardEntity();
        updateStatus.setId(id);
        updateStatus.setApprovalTestStatus(auditStatus.getStatus());
        updateStatus.setApprovalTestReason(auditStatus == AuditStatusEnum.AUDIT_PASS ? null : rejectReason);
        updateStatus.setApprovalTestUserId(ssoUser.getUserId());
        updateStatus.setApprovalTestUserName(ssoUser.getUserName());
        updateStatus.setModifyUserId(ssoUser.getUserId());
        updateStatus.setModifyUserName(ssoUser.getUserName());
        //当运营和测试都审核通过时，则设置状态为待上线
        ExActivityCardEntity exActivityCardEntity = exActivityCardDao.selectByPrimaryKey(id);
        boolean auditPass = (auditStatus == AuditStatusEnum.AUDIT_PASS) && (exActivityCardEntity.getApprovalOperationStatus().intValue() == AuditStatusEnum.AUDIT_PASS.getStatus());
        if (auditPass) {
            updateStatus.setStatus(ActivityCardStatusEnum.AWAIT_ONLINE.getStatus());
        }
        //当运营或测试有一方审核失败时，设置状态为审核驳回
        boolean auditReject = (auditStatus == AuditStatusEnum.AUDIT_REJECT) && (exActivityCardEntity.getApprovalOperationStatus().intValue() != AuditStatusEnum.AUDIT_REJECT.getStatus());
        if (auditReject) {
            updateStatus.setStatus(ActivityCardStatusEnum.AUDIT_REJECT.getStatus());
        }
        exActivityCardDao.updateSelectiveByPrimaryKey(updateStatus);
    }

    @Override
    public void delete(Long id) {
        exActivityCardDao.deleteByPrimaryKey(id);
    }

    @Override
    public Map getPage(String name, Integer status, String orderField, Pageable pageable) {
        Map<String, Object> result = Maps.newHashMap();
        ExActivityCardEntity queryEntity = new ExActivityCardEntity();
        queryEntity.setName(name);
        queryEntity.setStatus(status);
        Integer count = exActivityCardDao.count(queryEntity);
        result.put("recordCount", count);
        if (count == 0) {
            return result;
        }
        List<ExActivityCardEntity> exActivityCardEntityList = exActivityCardDao.selectPage(queryEntity, orderField, pageable.getOffset(), pageable.getPageSize());
        if (CollectionUtils.isEmpty(exActivityCardEntityList)) {
            return result;
        }
        List<ActivityCardVO> activityCardVoList = Lists.newArrayList();
        for (ExActivityCardEntity activityCardEntity : exActivityCardEntityList) {
            activityCardVoList.add(convert2VO(activityCardEntity));
        }
        result.put("cards", activityCardVoList);
        return result;
    }

    @Override
    public ActivityCardDetailVO getDetail(Long id) {
        return convert2DetailVO(exActivityCardDao.selectByPrimaryKey(id));
    }

    /**
     * 对象转换
     */
    private ExActivityCardEntity convert2Entity(ActivityCardBO activityCard) {
        ExActivityCardEntity entity = new ExActivityCardEntity();
        entity.setId(activityCard.getId());
        entity.setName(activityCard.getName());
        entity.setPopup(activityCard.getPopup());
        entity.setIconUrl(activityCard.getIcon());
        entity.setBannerUrl(activityCard.getBanner());
        entity.setCardPosition(activityCard.getCardPosition());
        entity.setJumpType(activityCard.getJumpType());
        entity.setJumpUrl(activityCard.getJumpUrl());
        entity.setWeight(activityCard.getWeight());
        entity.setTriggerStartTime(activityCard.getTriggerStartTime());
        entity.setTriggerEndTime(activityCard.getTriggerEndTime());
        entity.setDisapperType(activityCard.getDisapperType());
        if (StringUtils.isNotBlank(activityCard.getNoticeTitle())) {
            entity.setNoticeTitle(activityCard.getNoticeTitle());
            entity.setNoticeContent(activityCard.getNoticeContent());
        } else {
            entity.setNoticeTitle("");
            entity.setNoticeContent("");
        }
        if (activityCard.getNoticeType() != null && activityCard.getNoticeType() == NoticeTypeEnum.CUSTOM.getType().intValue()) {
            entity.setNoticeStartTime(DateUtil.formatDateTime(activityCard.getNoticeStartTime()));
            entity.setNoticeEndTime(DateUtil.formatDateTime(activityCard.getNoticeEndTime()));
        } else {
            entity.setNoticeStartTime("");
            entity.setNoticeEndTime("");
        }
        entity.setNoticeType(activityCard.getNoticeType());
        if (activityCard.getTranslateLanguage() != null) {
            entity.setTranslateLanguage(Joiner.on(",").join(Lists.newArrayList(activityCard.getTranslateLanguage())));
        }
        if (activityCard.getSaveAction() == 0) {
            entity.setStatus(ActivityCardStatusEnum.DRAFT.getStatus());
        } else {
            entity.setStatus(ActivityCardStatusEnum.TRANSLATION_TO_BE_EXPORTED.getStatus());
        }
        return entity;
    }

    /**
     * 转换成VO对象
     */
    private ActivityCardVO convert2VO(ExActivityCardEntity entity) {
        if (entity == null) {
            return null;
        }
        ActivityCardVO activityCardVO = ActivityCardVO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .startTime(DateUtil.formatDateTime(entity.getTriggerStartTime()))
                .endTime(DateUtil.formatDateTime(entity.getTriggerEndTime()))
                .operator(entity.getModifyUserName()).build();
        return activityCardVO;
    }

    /**
     * 转换成VO对象
     */
    private ActivityCardDetailVO convert2DetailVO(ExActivityCardEntity entity) {
        if (entity == null) {
            return null;
        }
        ActivityCardDetailVO activityCardVO = ActivityCardDetailVO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .popup(entity.getPopup())
                .icon(entity.getIconUrl())
                .banner(entity.getBannerUrl())
                .cardPosition(entity.getCardPosition())
                .jumpType(entity.getJumpType())
                .jumpUrl(entity.getJumpUrl())
                .weight(entity.getWeight())
                .triggerStartTime(DateUtil.formatDateTime(entity.getTriggerStartTime()))
                .triggerEndTime(DateUtil.formatDateTime(entity.getTriggerEndTime()))
                .disapperType(entity.getDisapperType())
                .noticeTitle(entity.getNoticeTitle())
                .noticeContent(entity.getNoticeContent())
                .noticeType(entity.getNoticeType())
                .noticeStartTime(entity.getNoticeStartTime())
                .noticeEndTime(entity.getNoticeEndTime())
                .translateLanguage(StringUtils.isNotBlank(entity.getTranslateLanguage()) ? entity.getTranslateLanguage().split(",") : null)
                .offShelfReason(entity.getPulloffReason())
                .forbidReason(entity.getDisableReason())
                .status(entity.getStatus())
                .approvalOperationStatus(entity.getApprovalOperationStatus())
                .approvalOperationReason(entity.getApprovalOperationReason())
                .approvalOperationUserName(entity.getApprovalOperationUserName())
                .approvalTestStatus(entity.getApprovalTestStatus())
                .approvalTestReason(entity.getApprovalTestReason())
                .approvalTestUserName(entity.getApprovalTestUserName())
                .build();
        return activityCardVO;
    }

}
