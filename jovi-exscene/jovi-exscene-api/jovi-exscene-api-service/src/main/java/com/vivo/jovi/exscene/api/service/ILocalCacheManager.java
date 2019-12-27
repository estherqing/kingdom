package com.vivo.jovi.exscene.api.service;

import com.vivo.jovi.scene.common.dal.entity.*;

public interface ILocalCacheManager {

    String testGet(String key);

    void testSet(String key, String value);

    /**
     * 刷新数据
     */
    void refreshCaches();

    /**
     * 清除现有缓存中的数据
     */
    void cleanCaches();

    /**
     * 获取最新策略
     *
     * @return
     */
    ExPublishEntity getLatestStrategy();

    /**
     * 获取活动卡片最新策略
     *
     * @return
     */
    ExPublishEntity getActivityCardLatestStrategy();

    /**
     * 根据Id获取调研卡片
     *
     * @param questionnaireId
     * @return
     */
    QuestionnaireEntity selectByQuestionnaireId(String questionnaireId);

    /**
     * 获取调研卡片说明
     *
     * @param questionnaireId
     * @param language
     * @return
     */
    QuestionnaireDescEntity selectByIdAndLanguage(String questionnaireId, String language);

    /**
     * 获取问题
     *
     * @param questionId
     * @param language
     * @return
     */
    QuestionEntity selectQuestionByIdAndLanguage(String questionId, String language);

    /**
     * 获取用户实体类
     *
     * @param questionnaireId
     * @param userId
     * @return
     */
    QuestionnaireUserEntity selectByQuestionnaireIdAndUserId(String questionnaireId, String userId);
}