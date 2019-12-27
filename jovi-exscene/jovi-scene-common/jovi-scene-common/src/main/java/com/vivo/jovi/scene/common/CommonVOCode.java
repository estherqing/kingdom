package com.vivo.jovi.scene.common;

/**
 * @author lijun
 * @date 2018/11/09
 * @since 1.0
 */
public class CommonVOCode {
    public static final int SUCCESS = 0;

    /**
     * 没有数据
     */
    public static final int NO_DATA = -1;

    /**
     * 不满足灰度要求
     */
    public static final int NO_GREY = 100;

    /**
     * 参数错误
     */
    public static final int BAD_PARAMS = 20000;

    /**
     * 服务器错误
     */
    public static final int SERVER_ERROR = 10000;

    /**
     * 用户没找到
     */
    public static final int USER_NOT_FOUND = 20001;

    /**
     * 用户登录态过期
     */
    public static final int USER_SESSION_EXPIRED = 20002;

    /**
     * 用户提交信息包含敏感词
     */
    public static final int CONTAIN_SENSITIVITY = 20003;

    /**
     * 用户操作被禁止
     */
    public static final int OPERATION_FORBIDDEN = 20004;

    /**
     * 操作失败
     */
    public static final int OPERATION_FAILURE = 20005;

    /**
     * 创建超过上限
     */
    public static final int CREATE_ULTRALIMIT = 20006;

    /**
     * 字段长度超过上限
     */
    public static final int STRING_ULTRALIMIT = 20007;

    /**
     * 已经答过该问卷
     */
    public static final int QUESTION_USED_ANSWER = 20008;

    /**
     * 未答过该问卷
     */
    public static final int QUESTION_NOT_ANSWER = 20009;

    /**
     * 问卷提交失败
     */
    public static final int QUESTION_SUBMIT_FAILURE = 20010;

    /**
     * 抽奖信息提交失败
     */
    public static final int LUCKDRAW_SUBMIT_FAILURE = 20011;

    /**
     * 外销赛事热门赛事大于10
     */
    public static final int SPORT_NUM_FAILURE = 20012;

    /**与teddy对接的错误码 **/

    /**
     * 推送文件与线下邮件文件md5不一致
     */
    public static final int INCONSISTENT_FILE = 25000;
}
