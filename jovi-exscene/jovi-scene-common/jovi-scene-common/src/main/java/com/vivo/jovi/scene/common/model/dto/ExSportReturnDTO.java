package com.vivo.jovi.scene.common.model.dto;

import java.util.List;

/**
 * @description: 外销赛事返回数据
 * @author: Lu Guodong
 * @CreateDate: 2019-07-23
 */
public class ExSportReturnDTO {

    private Integer totalPages;

    private Integer pageNum;

    private Integer pageSize;

    private Integer totalRows;

    private List<ExSportReturnContentDTO> content;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public List<ExSportReturnContentDTO> getContent() {
        return content;
    }

    public void setContent(List<ExSportReturnContentDTO> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ExSportReturnDTO{" +
                "totalPages=" + totalPages +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                ", content=" + content +
                '}';
    }
}
