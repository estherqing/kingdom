package com.vivo.jovi.scene.common.model.dto;

import java.util.List;

/**
 * @description: ExHotSportResponseDTO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-24
 */
public class ExHotSportResponseDTO {
    private Integer retcode;

    private List<ExHotSportContentDTO> data;

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public List<ExHotSportContentDTO> getData() {
        return data;
    }

    public void setData(List<ExHotSportContentDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExHotSportResponseDTO{" +
                "retcode=" + retcode +
                ", data=" + data +
                '}';
    }
}
