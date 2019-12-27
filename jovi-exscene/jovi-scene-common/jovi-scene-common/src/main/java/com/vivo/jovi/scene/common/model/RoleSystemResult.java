package com.vivo.jovi.scene.common.model;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-21 16:39
 */
public class RoleSystemResult {
    private String id;
    private String status;
    private String name;
    private String systemId;
    private String memo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
