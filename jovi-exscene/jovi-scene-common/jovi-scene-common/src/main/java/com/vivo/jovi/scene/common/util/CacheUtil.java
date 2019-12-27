package com.vivo.jovi.scene.common.util;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-20
 */
public class CacheUtil {

    private static final String STRATEGY_IMEI_PAIR = "SIP";
    private static final String KEY_SPLIT = ":";
    private static final String PUBLISH_QUANTITY = "PQ";
    private static final String STATISTICAL_INFO_PREFIX = "SI";
    private static final String ANSWER_COUNT_PREFIX = "AC";

    public static String getTipsKey(String bizId,Integer version){
        return "LC"+KEY_SPLIT+bizId+KEY_SPLIT+version;
    }

    public static String getBizsKey(String bizId,Integer version){
        return "LC"+KEY_SPLIT+bizId+KEY_SPLIT+version;
    }

    public static String getBizIdFromKey(String key){
        String[] keyStr = key.split(KEY_SPLIT);
        return keyStr[1];
    }

    public static Integer getBizVersionFromKey(String key){
        String[] keyStr = key.split(KEY_SPLIT);
        return Integer.valueOf(keyStr[2]);
    }

    public static String getStrategyImeiPair(String strategyId, Integer version, String imei) {
        return STRATEGY_IMEI_PAIR +KEY_SPLIT+strategyId+KEY_SPLIT+version+KEY_SPLIT+imei;
    }

    public static String getGroupNameImeiKey(String groupName, String imei) {
        return groupName+imei;
    }

    public static String getPublishQuantityKey(String bizId, Integer versionCode) {
        return PUBLISH_QUANTITY+KEY_SPLIT+bizId+KEY_SPLIT+versionCode;
    }

    public static String getCardKey(String cardId, Integer versionCode) {
        return "LC"+KEY_SPLIT+cardId+KEY_SPLIT+versionCode;
    }

    public static String getQNRPublishQuantityKey(String bizId){
        return PUBLISH_QUANTITY+KEY_SPLIT+bizId;
    }

    public static String getStatisticalInfoKey(String questionnaireId, String questionId) {
        return STATISTICAL_INFO_PREFIX + KEY_SPLIT + questionnaireId + KEY_SPLIT + questionId;
    }

    public static String getAnswerCountKey(String questionnaireId) {
        return ANSWER_COUNT_PREFIX + KEY_SPLIT + questionnaireId;
    }
}
