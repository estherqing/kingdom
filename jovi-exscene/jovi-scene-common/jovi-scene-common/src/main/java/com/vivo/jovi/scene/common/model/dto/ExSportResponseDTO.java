package com.vivo.jovi.scene.common.model.dto;

/**
 * @description: 外销赛事获取数据
 * @author: Lu Guodong
 * @CreateDate: 2019-07-20
 */
public class ExSportResponseDTO {
    private Integer retcode;

    private ExSportReturnDTO data;

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public ExSportReturnDTO getData() {
        return data;
    }

    public void setData(ExSportReturnDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExSportResponseDTO{" +
                "retcode=" + retcode +
                ", data=" + data +
                '}';
    }
}
