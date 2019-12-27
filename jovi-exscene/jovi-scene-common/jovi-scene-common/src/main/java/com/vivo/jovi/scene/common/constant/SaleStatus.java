package com.vivo.jovi.scene.common.constant;

/**
 * 数据内容上下架状态
 * @author Tian Guangxin
 * @date 2018/11/26
 * @since 1.0
 */
public class SaleStatus {

    /**禁用 代表上游禁用和本系统禁用*/
    public static final int NOT_RELEASED = -1;

    /**待上架的*/
    public static final int STAND_BY = 0;

    /**已上架*/
    public static final int RELEASED = 1;

    /**已下架*/
    public static final int CANCELED = 2;

    /**上游下架*/
    public static final int UP_CANCELED = 3;
}
