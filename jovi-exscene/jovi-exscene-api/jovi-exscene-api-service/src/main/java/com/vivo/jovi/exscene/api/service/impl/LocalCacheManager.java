package com.vivo.jovi.exscene.api.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.exscene.api.service.ILocalCacheManager;
import com.vivo.jovi.scene.common.constant.SourceTypeEnum;
import com.vivo.jovi.scene.common.dal.dao.*;
import com.vivo.jovi.scene.common.dal.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @description: LocalCacheManager
 * @author: Lu Guodong
 * @CreateDate: 2019-06-12
 */
@Service
public class LocalCacheManager implements ILocalCacheManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalCacheManager.class);

    private int CONCURRENT_LEVEL = VivoConfigManager.getInteger("CONCURRENT_LEVEL");

    private static final String LASTESTSTRATEGR = "LASTEST_STRATEGR_EXPUBLISH";

    @Autowired
    private IExPublishDao publishDao;

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IQuestionnaireDescDao questionnaireDescDao;

    @Autowired
    private IQuestionDao questionDao;

    @Autowired
    private IQuestionnaireUserDao questionnaireUserDao;
    @Autowired
    private IExActivityCardDao exActivityCardDao;
    @Autowired
    private IExActivityNoticeDao exActivityNoticeDao;

    /**
     * 测试缓存
     */
    private Cache<String, String> testCache = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    /**
     * 最新策略缓存，调研
     */
    private Cache<String, ExPublishEntity> exPublishCache_QNR = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    /**
     * 最新策略缓存，活动卡片
     */
    private Cache<String, ExPublishEntity> exPublishCache_ACT = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    /**
     * 调研卡片缓存
     */
    private Cache<String, QuestionnaireEntity> questionnaireCache = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    /**
     * 调研卡片说明缓存
     */
    private Cache<String, QuestionnaireDescEntity> questionnaireDescCache = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    /**
     * 问题缓存
     */
    private Cache<String, QuestionEntity> questionCache = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    /**
     * 用户缓存
     */
    private Cache<String, QuestionnaireUserEntity> questionnaireUserCache = CacheBuilder.newBuilder().concurrencyLevel(CONCURRENT_LEVEL).build();

    @Override
    public String testGet(String key) {
        return getFromCache(testCache, key);
    }

    @Override
    public void testSet(String key, String value) {
        try {
            testCache.put(key, value);
        } catch (Exception e) {
            LOGGER.error("ERROR_TEST_CACHE", e);
        }
    }

    @Override
    public void refreshCaches() {
        refreshQNRCache();
    }

    /**
     * 刷新调研问卷的最新缓存数据
     */
    private void refreshQNRCache() {
        //客户端获取最新策略
        try {
            ExPublishEntity latestStrategy = publishDao.getLatestStrategy(SourceTypeEnum.QNR.getType());
            if (latestStrategy != null) {
                exPublishCache_QNR.put(LASTESTSTRATEGR, latestStrategy);
            }
        } catch (Exception e) {
            LOGGER.error("EXPUBLISH_REFRESH_ERROR", e);
        }

        //H5获取调研卡片
        try {
            ExPublishEntity latestStrategy = publishDao.getLatestStrategy(SourceTypeEnum.QNR.getType());
            if (latestStrategy != null) {
                String questionnaireId = latestStrategy.getBizId();
                QuestionnaireEntity questionnaireEntity = questionnaireDao.selectByQuestionnaireId(questionnaireId);
                questionnaireCache.put(questionnaireId, questionnaireEntity);
                //TODO 后续如果增加语言信息，需要在此进行添加语言种类
                String[] languages = {"zh_CN", "en_US", "hi_IN"};
                List<String> languageList = Arrays.asList(languages);
                String[] questions = questionnaireEntity.getQuestionIdList().split(",");
                List<String> questionList = Arrays.asList(questions);
                for (String language : languageList) {
                    QuestionnaireDescEntity questionnaireDescEntity = questionnaireDescDao.selectByIdAndLanguage(questionnaireId, language, null);
                    if (questionnaireDescEntity != null) {
                        questionnaireDescCache.put(questionnaireId + language, questionnaireDescEntity);
                    }
                    for (String questionId : questionList) {
                        QuestionEntity questionEntity = questionDao.selectQuestionByIdAndLanguage(questionId, language);
                        if (questionEntity != null) {
                            questionCache.put(questionId + language, questionEntity);
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("getQuestionDetail_REFRESH_ERROR");
        }

        //获取用户信息
        try {
            ExPublishEntity latestStrategy = publishDao.getLatestStrategy(SourceTypeEnum.QNR.getType());
            if (latestStrategy != null) {
                String questionnaireId = latestStrategy.getBizId();
                List<String> userIdList = questionnaireUserDao.selectUserIdsByQuestionnaireId(questionnaireId);
                for (String userId : userIdList) {
                    QuestionnaireUserEntity questionnaireUserEntity = questionnaireUserDao.selectByQuestionnaireIdAndUserId(questionnaireId, userId);
                    questionnaireUserCache.put(questionnaireId + userId, questionnaireUserEntity);
                }
            }
        } catch (Exception e) {
            LOGGER.error("getQustionnaireUser_REFRESH_ERROR");
        }
    }

    @Override
    public void cleanCaches() {
        //调研缓存清空
        exPublishCache_QNR.cleanUp();
        questionCache.cleanUp();
        questionnaireCache.cleanUp();
        questionnaireDescCache.cleanUp();
    }

    @Override
    public ExPublishEntity getLatestStrategy() {
        return getFromCache(exPublishCache_QNR, LASTESTSTRATEGR);
    }

    @Override
    public ExPublishEntity getActivityCardLatestStrategy() {
        return getFromCache(exPublishCache_ACT, LASTESTSTRATEGR);
    }

    @Override
    public QuestionnaireEntity selectByQuestionnaireId(String questionnaireId) {
        return getFromCache(questionnaireCache, questionnaireId);
    }

    @Override
    public QuestionnaireDescEntity selectByIdAndLanguage(String questionnaireId, String language) {
        return getFromCache(questionnaireDescCache, questionnaireId + language);
    }

    @Override
    public QuestionEntity selectQuestionByIdAndLanguage(String questionId, String language) {
        return getFromCache(questionCache, questionId + language);
    }

    @Override
    public QuestionnaireUserEntity selectByQuestionnaireIdAndUserId(String questionnaireId, String userId) {
        return getFromCache(questionnaireUserCache, questionnaireId + userId);
    }

    private <T> T getFromCache(Cache<String, T> cache, String key) {
        try {
            return cache.getIfPresent(key);
        } catch (Exception e) {
            LOGGER.error("缓存读取失败:{}", key, e);
            return null;
        }
    }
}