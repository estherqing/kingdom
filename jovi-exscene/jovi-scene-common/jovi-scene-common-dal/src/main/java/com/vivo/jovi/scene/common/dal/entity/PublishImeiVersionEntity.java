package com.vivo.jovi.scene.common.dal.entity;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-25 17:19
 */
public class PublishImeiVersionEntity {

    private Long id;

    private String strategyId;

    private String type;

    private String data;

    private String fileName;

    private Integer version;

    private Integer cacheCleaned;

    public PublishImeiVersionEntity() {
    }

    public PublishImeiVersionEntity(Long id, String strategyId, String type, String data, String fileName, Integer version, Integer cacheCleaned) {
        this.id = id;
        this.strategyId = strategyId;
        this.type = type;
        this.data = data;
        this.fileName = fileName;
        this.version = version;
        this.cacheCleaned = cacheCleaned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCacheCleaned() {
        return cacheCleaned;
    }

    public void setCacheCleaned(Integer cacheCleaned) {
        this.cacheCleaned = cacheCleaned;
    }
}
