package com.vivo.jovi.scene.common.constant.activitycard;

/**
 * @Description 操作类型枚举类
 * @auther zhongjiajun
 * @create 2019-12-06 17:38
 */
public enum OperateTypeEnum {
    /**
     * 编辑
     */
    MODIFY("编辑"),
    /**
     * 删除
     */
    DELETE("删除"),
    /**
     * 导入
     */
    IMPORT("导入"),
    /**
     * 导出
     */
    EXPORT("导出"),
    /**
     * 上架
     */
    ONLINE("上架"),
    /**
     * 下架
     */
    OFFLINE("下架"),
    /**
     * 禁用
     */
    FORBID("禁用"),
    ;

    OperateTypeEnum(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public static OperateTypeEnum statusOf(String type) {
        if (type == null) {
            return null;
        }
        for (OperateTypeEnum operateTypeEnum : values()) {
            if (operateTypeEnum.getType().equals(type)) {
                return operateTypeEnum;
            }
        }
        return null;
    }
}
