package com.vivo.jovi.exscene.backend.service.model.form;

public class PublishStrategyForm {

    private String strategyId;

    /**
     * 名称
     */
    private String name;

    private String bizVersionCode;

    /**
     * 智慧场景版本
     */
    private String intelligSceneEdition;

    /**
     * 客户端最低版本
     */
    private Integer clientVersion;

    /**
     * 发布类型：0 全量；1 灰度
     */
    private Integer type;

    /**
     * 翻译文件路径
     */
    private String fileUrl;

    /**
     * 翻译文件名
     */
    private String fileName;

    /**
     * 指定role发布，多个用，分隔
     */
    private String roleGrey;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 预计发布量
     */
    private long expectedRelease;

    /**
     * 实际发布量
     */
    private long actualRelease;

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntelligSceneEdition() {
        return intelligSceneEdition;
    }

    public void setIntelligSceneEdition(String intelligSceneEdition) {
        this.intelligSceneEdition = intelligSceneEdition;
    }

    public Integer getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(Integer clientVersion) {
        this.clientVersion = clientVersion;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRoleGrey() {
        return roleGrey;
    }

    public void setRoleGrey(String roleGrey) {
        this.roleGrey = roleGrey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getExpectedRelease() {
        return expectedRelease;
    }

    public void setExpectedRelease(long expectedRelease) {
        this.expectedRelease = expectedRelease;
    }

    public long getActualRelease() {
        return actualRelease;
    }

    public void setActualRelease(long actualRelease) {
        this.actualRelease = actualRelease;
    }

    public String getBizVersionCode() {
        return bizVersionCode;
    }

    public void setBizVersionCode(String bizVersionCode) {
        this.bizVersionCode = bizVersionCode;
    }

    @Override
    public String toString() {
        return "PublishStrategyForm{" +
                "strategyId='" + strategyId + '\'' +
                ", name='" + name + '\'' +
                ", bizVersionCode='" + bizVersionCode + '\'' +
                ", intelligSceneEdition='" + intelligSceneEdition + '\'' +
                ", clientVersion=" + clientVersion +
                ", type=" + type +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileName='" + fileName + '\'' +
                ", roleGrey='" + roleGrey + '\'' +
                ", status=" + status +
                ", expectedRelease=" + expectedRelease +
                ", actualRelease=" + actualRelease +
                '}';
    }
}
