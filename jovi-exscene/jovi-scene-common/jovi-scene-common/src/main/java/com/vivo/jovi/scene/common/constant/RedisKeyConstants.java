package com.vivo.jovi.scene.common.constant;

/**
 * @author WangWenqian
 * @version 1.0
 * @describe
 * @date 2018/4/17
 */
public class RedisKeyConstants {

    /**
     * 对订阅号的监控
     */
    public static final String MONITOR_SUBCODE_LASTREQ = "monitor:subcode:lastreq";

    /**
     * 应用版本
     */
    public static final String MONITOR_SUBCODE_APPVER = "monitor:subcode:appver";

    /**
     * 对推送次数的监控
     */
    public static final String MONITOR_PUSHTIMES = "monitor:pushtimes";

    /**
     * 订阅号和token的映射
     */
    public static final String TOKEN_SUBCODE_MAP = "token-subcode:";

    /**
     * 订阅号和token的映射
     */
    public static final String SUBCODE_TOKEN_MAP = "subcode-token:";

    /**
     * 对用户反馈数量的监控
     */
    public static final String MONITOR_FEEDBACK = "monitor:feedback";

    /**
     * 对用用户订阅航班监控
     */
    public static final String MONITOR_SUBBYFLIGHT = "monitor:subbyflight";

    /**
     * 出行 附近推荐
     */
    public static final String NEAR_RECOMMEND = "trip-recommend-near";
	
	/**
     * 丰巢access_token
     */
    public static final String EXPRESS_FENGCHAO_TOKEN = "EXPRESS-FENGCHAO-TOKEN:";


    /**
     * 出行 热门推荐
     */
    public static final String HOT_RECOMMEND = "trip-recommend-hot";


    /**
     * 出行 景区
     */
    public static final String SANMAOYOU_SCENIC = "trip-scenicid";
	/**
     * 监测主动查询三方
     */
    public static final String MONITOR_ACTIVE_QUERY = "monitor:active:query";

    /**
     * 监测快递包裹过期数据清除
     */
    public static final String MONITOR_EXPRESS_EXPIRED_DATA_DEL = "monitor:express:del";

}
