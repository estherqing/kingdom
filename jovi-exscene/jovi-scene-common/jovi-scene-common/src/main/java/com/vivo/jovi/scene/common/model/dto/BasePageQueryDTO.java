package com.vivo.jovi.scene.common.model.dto;

/**
 * @Classname BasePageQueryDTO
 * @Description TODO
 * @Date 2019-05-06 16:12
 * @Created by Administrator
 * @Version 1.0
 */
public class BasePageQueryDTO {

    /**分页index*/
    private Integer page;

    /**分页size*/
    private Integer size;

    private Integer offset;

    private Integer limit;

    /**排序字段*/
    private String field;

    /**排序顺序*/
    private String order;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
