package com.vivo.jovi.scene.common.model;

/**
 * @author David
 * @version 3.0
 * @describe
 * @date 2019-02-20
 */
public class BizObject {
    /**
     * 版本号
     */
    private Integer      version;
    /**
     * 操作, 1:修改，2：禁用
     */
    private Integer op;


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }
}
