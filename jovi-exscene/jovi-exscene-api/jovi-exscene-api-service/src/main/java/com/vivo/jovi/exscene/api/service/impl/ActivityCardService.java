package com.vivo.jovi.exscene.api.service.impl;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.google.common.collect.Lists;
import com.vivo.jovi.exscene.api.common.constant.BizOp;
import com.vivo.jovi.exscene.api.service.IActivityCardService;
import com.vivo.jovi.exscene.api.service.ICacheManager;
import com.vivo.jovi.exscene.api.service.model.vo.ActivityCardNoticeVO;
import com.vivo.jovi.exscene.api.service.model.vo.ActivityCardVO;
import com.vivo.jovi.exscene.api.service.model.vo.ActivityNameVo;
import com.vivo.jovi.scene.common.constant.LanguageEnum;
import com.vivo.jovi.scene.common.constant.PublishStatus;
import com.vivo.jovi.scene.common.constant.PublishType;
import com.vivo.jovi.scene.common.constant.QuestionnaireStatusEnum;
import com.vivo.jovi.scene.common.constant.activitycard.NoticeTypeEnum;
import com.vivo.jovi.scene.common.dal.dao.IExActivityCardDao;
import com.vivo.jovi.scene.common.dal.dao.IExActivityNoticeDao;
import com.vivo.jovi.scene.common.dal.dao.IExPublishDao;
import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import com.vivo.jovi.scene.common.dal.entity.ExActivityNoticeEntity;
import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import com.vivo.jovi.scene.common.model.ExsceneActivityCardBizQueryParam;
import com.vivo.jovi.scene.common.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @auther zhongjiajun
 * @create 2019-12-07 16:41
 */
@Service
@Slf4j
public class ActivityCardService implements IActivityCardService {
    @Autowired
    private IExActivityCardDao activityCardDao;
    @Autowired
    private IExActivityNoticeDao activityNoticeDao;
    @Autowired
    private IExPublishDao exPublishDao;
    @Autowired
    private ICacheManager cacheManager;

    @Override
    public Map<String, Object> getActivityCardList(ExsceneActivityCardBizQueryParam exsceneBizQueryParam) {
        List<ExPublishEntity> publishEntities = null;
        //1、根据时间戳，判断第一次或增量
        if (StringUtils.isBlank(exsceneBizQueryParam.getLastQueryTime())) {
            publishEntities = exPublishDao.selectActivityCardPublishStrategy();
        } else {
            publishEntities = exPublishDao.selectIncrementActivityCardPublishStrategy(exsceneBizQueryParam.getLastQueryTime());
        }
        if (CollectionUtils.isEmpty(publishEntities)) {
            return null;
        }
        List<ActivityCardVO> activityCardPublishStrategyList = Lists.newArrayList();
        Date maxUpdateTime = null;
        for (ExPublishEntity publishEntity : publishEntities) {
            ActivityCardVO activityCardPublishStrategy = handlerPublishLatestStrategy(publishEntity, exsceneBizQueryParam.getAppVersion(), exsceneBizQueryParam.getRole());
            if (activityCardPublishStrategy != null) {
                activityCardPublishStrategyList.add(activityCardPublishStrategy);
            }
            if (maxUpdateTime == null) {
                maxUpdateTime = publishEntity.getUpdateTime();
            } else if (maxUpdateTime.before(publishEntity.getUpdateTime())) {
                maxUpdateTime = publishEntity.getUpdateTime();
            }
        }
        Map<String, Object> resultMap = new HashMap<>(2);
        resultMap.put("cards", activityCardPublishStrategyList);
        if (maxUpdateTime == null) {
            resultMap.put("lastQueryTime", DateUtil.formatDateTime(new Date()));
        } else {
            resultMap.put("lastQueryTime", DateUtil.formatDateTime(maxUpdateTime));
        }
        return resultMap;
    }

    /**
     * 封装每一个发布策略
     */
    private ActivityCardVO handlerPublishLatestStrategy(ExPublishEntity publishStrategy, Integer appVersion, String role) {
        //校验发布量是否已经达到预期
        Integer actualRelease = cacheManager.getQNRPublishQuatity(publishStrategy.getBizId());
        if (publishStrategy.getExpectedRelease() != -1 && actualRelease > publishStrategy.getExpectedRelease()) {
            log.error("ActualRelease has been higher than expectedRelease");
            return null;
        }
        ActivityCardVO activityCardVO = null;
        if (bizWillPublish(publishStrategy)) {
            if (reachValidVersion(appVersion, publishStrategy.getIntelligSceneEdition())) {
                if (Objects.equals(PublishType.ALL_PUBLISH.getCode(), publishStrategy.getType())) {
                    //组装活动卡片数据
                    activityCardVO = makeUpEntity(publishStrategy.getBizId());
                    activityCardVO.setPublishTime(publishStrategy.getUpdateTime().getTime());
                } else if (Objects.equals(PublishType.GREY_PUBLISH.getCode(), publishStrategy.getType())) {
                    //有效灰度用户
                    if (inGrey(role, publishStrategy)) {
                        //组装活动卡片数据
                        activityCardVO = makeUpEntity(publishStrategy.getBizId());
                        activityCardVO.setPublishTime(publishStrategy.getUpdateTime().getTime());
                    }
                }
                if (activityCardVO != null && StringUtils.isNotBlank(activityCardVO.getActivityId())) {
                    activityCardVO.setStatus(BizOp.MODIFY);
                    cacheManager.addQNRPublishQuantity(publishStrategy.getBizId());
                }
            }
        } else if (bizWillDeleteInClient(role, publishStrategy)) {
            //业务被禁用
            activityCardVO = makeUpEntity(publishStrategy.getBizId());
            activityCardVO.setPublishTime(publishStrategy.getUpdateTime().getTime());
            activityCardVO.setStatus(BizOp.DELETE);

        }
        return activityCardVO;
    }

    /**
     * 判断发布策略是否为全量或者灰度，同时业务为上架状态
     *
     * @param publish
     * @return
     */
    private boolean bizWillPublish(ExPublishEntity publish) {
        return (Objects.equals(publish.getStatus(), PublishStatus.PUBLISH_GRAY_LEVEL.getCode())
                || Objects.equals(publish.getStatus(), PublishStatus.PUBLISH_FULL.getCode()))
                && (publish.getBizStatus().equals(QuestionnaireStatusEnum.ONLINE.getStatus()));
    }

    /**
     * 当发布策略失效或者卡片状态为禁用的时候，客户端相应的调研卡片会被删除
     * 失效时，判断两种情况：
     * 1.如果roleGrey为空，认为是全量发布；
     * 2.如果roleGrey不为空，确认是否包含role值；
     *
     * @param publish
     * @return
     */
    private boolean bizWillDeleteInClient(String role, ExPublishEntity publish) {
        return ((Objects.equals(publish.getStatus(), PublishStatus.PUBLISH_FAILURE.getCode()) &&
                (inGrey(role, publish) || StringUtils.isEmpty(publish.getRoleGrey())))
                || (publish.getBizStatus().equals(QuestionnaireStatusEnum.DISABLED.getStatus())));
    }

    /**
     * 判断客户端的版本号与调研卡片要求的版本号是否一致
     *
     * @param appVersion
     * @param intelligSceneEdition
     * @return
     */
    private boolean reachValidVersion(Integer appVersion, String intelligSceneEdition) {
        if (appVersion == null || intelligSceneEdition == null) {
            log.error("ReachMinVersion with empty version {},{}", appVersion, intelligSceneEdition);
            return false;
        }
        try {
            String[] clientVersionArray = intelligSceneEdition.split(",");
            return Arrays.asList(clientVersionArray).contains(appVersion.toString());
        } catch (Exception e) {
            log.error("ReachMinVersion with error {},{}", appVersion, intelligSceneEdition, e);
            return false;
        }
    }

    /**
     * 判断role是否存在于灰度策略中
     *
     * @param role
     * @param latestStrategy
     * @return
     */
    private boolean inGrey(String role, ExPublishEntity latestStrategy) {
        String roleString = latestStrategy.getRoleGrey();
        String[] roleArray = null;
        if (StringUtils.isNotBlank(roleString)) {
            roleArray = roleString.split(",");
            return Arrays.asList(roleArray).contains(role);
        } else {
            return false;
        }
    }

    /**
     * 组装相应数据
     *
     * @param activityId
     * @return
     */
    private ActivityCardVO makeUpEntity(String activityId) {
        ActivityCardVO activityCardVO = new ActivityCardVO();
        ExActivityCardEntity entity = activityCardDao.selectByActivityId(activityId);
        activityCardVO.setActivityId(activityId);
        activityCardVO.setStartTime(entity.getTriggerStartTime().getTime());
        activityCardVO.setEndTime(entity.getTriggerEndTime().getTime());
        activityCardVO.setBannerUrl(entity.getBannerUrl());
        activityCardVO.setIconUrl(entity.getIconUrl());
        activityCardVO.setCardPosition(entity.getCardPosition());
        activityCardVO.setJumpType(entity.getJumpType());
        activityCardVO.setJumpUrl(entity.getJumpUrl());
        activityCardVO.setWeight(entity.getWeight());
        activityCardVO.setDisapperType(entity.getDisapperType());
        if (StringUtils.isNotBlank(entity.getNoticeTitle())) {
            activityCardVO.setNoticeType(entity.getNoticeType());
            if (entity.getNoticeType() == NoticeTypeEnum.CUSTOM.getType().intValue()) {
                activityCardVO.setNoticeStartTime(DateUtil.parseTime(entity.getNoticeStartTime()).getTime());
                activityCardVO.setNoticeEndtime(DateUtil.parseTime(entity.getNoticeEndTime()).getTime());
            }
        }

        //活动名称多语言
        List<ActivityNameVo> activityNameList = Lists.newArrayList();
        ActivityNameVo chineseActivityName = new ActivityNameVo();
        chineseActivityName.setLanguage(LanguageEnum.CHINESE.getValue());
        chineseActivityName.setActivityName(entity.getName());
        chineseActivityName.setPopup(entity.getPopup());
        activityNameList.add(chineseActivityName);
        //通知多语言
        boolean noticeFlag = StringUtils.isNotBlank(entity.getNoticeContent());
        List<ActivityCardNoticeVO> notilceList = Lists.newArrayList();
        if (noticeFlag) {
            ActivityCardNoticeVO chineseNotice = new ActivityCardNoticeVO();
            chineseNotice.setLanguage(LanguageEnum.CHINESE.getValue());
            chineseNotice.setTitle(entity.getNoticeTitle());
            chineseNotice.setContent(entity.getNoticeContent());
            notilceList.add(chineseNotice);
        }
        if (StringUtils.isNotBlank(entity.getTranslateLanguage())) {
            //缓存翻译文案信息
            List<ExActivityNoticeEntity> noticeEntityList = activityNoticeDao.selectByActivityId(entity.getActivityId());
            for (ExActivityNoticeEntity exActivityNoticeEntity : noticeEntityList) {
                if (noticeFlag) {
                    ActivityCardNoticeVO notice = new ActivityCardNoticeVO();
                    notice.setLanguage(exActivityNoticeEntity.getLanguage());
                    notice.setTitle(exActivityNoticeEntity.getTitle());
                    notice.setContent(exActivityNoticeEntity.getContent());
                    notilceList.add(notice);
                }
                ActivityNameVo activityName = new ActivityNameVo();
                activityName.setLanguage(exActivityNoticeEntity.getLanguage());
                activityName.setActivityName(exActivityNoticeEntity.getActivityName());
                activityName.setPopup(exActivityNoticeEntity.getPopup());
                activityNameList.add(activityName);
            }
        }
        activityCardVO.setActivityTranslation(activityNameList);
        activityCardVO.setNotice(notilceList);
        return activityCardVO;
    }

}
