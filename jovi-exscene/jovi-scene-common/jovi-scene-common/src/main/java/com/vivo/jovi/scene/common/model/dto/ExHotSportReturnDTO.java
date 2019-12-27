package com.vivo.jovi.scene.common.model.dto;

import java.util.List;

/**
 * @description: ExHotSportReturnDTO
 * @author: Lu Guodong
 * @CreateDate: 2019-07-24
 */
public class ExHotSportReturnDTO {

    private List<ExHotSportContentDTO> contentList;

    public List<ExHotSportContentDTO> getContentList() {
        return contentList;
    }

    public void setContentList(List<ExHotSportContentDTO> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String toString() {
        return "ExHotSportReturnDTO{" +
                "contentList=" + contentList +
                '}';
    }
}
