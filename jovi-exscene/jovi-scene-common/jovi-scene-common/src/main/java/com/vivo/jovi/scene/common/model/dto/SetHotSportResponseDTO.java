package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: SetHotSportResponseDTO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-25
 */
public class SetHotSportResponseDTO {
    private Integer retcode;
    private Integer data;

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SetHotSportResponseDTO{" +
                "retcode=" + retcode +
                ", data=" + data +
                '}';
    }
}
