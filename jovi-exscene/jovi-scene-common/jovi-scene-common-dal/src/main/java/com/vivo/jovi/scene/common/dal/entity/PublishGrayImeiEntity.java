package com.vivo.jovi.scene.common.dal.entity;

/**
 * @Description
 * @Author Hu Han
 * @Date 2019-02-15 10:02
 */
public class PublishGrayImeiEntity {

    private Long id;

    private String strategyId;

    private String imei;

    public PublishGrayImeiEntity() {
    }

    public PublishGrayImeiEntity(Long id, String strategyId, String imei) {
        this.id = id;
        this.strategyId = strategyId;
        this.imei = imei;
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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "PublishGrayImeiEntity{" +
                "id=" + id +
                ", strategyId='" + strategyId + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
