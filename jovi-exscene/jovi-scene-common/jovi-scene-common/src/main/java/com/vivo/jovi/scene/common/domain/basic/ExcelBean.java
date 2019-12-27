package com.vivo.jovi.scene.common.domain.basic;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.Serializable;

/**
 * @author huhan
 * @version 1.0
 */
public class ExcelBean implements Serializable {
    private String headTextName; // 列头(标题)名
    private String fieldName; // 对应字段名
    private Integer cols; // 合并单元格数
    private XSSFCellStyle xssfCellStyle; // 单元格样式

    public ExcelBean() {
    }

    public ExcelBean(String headTextName, String fieldName) {
        this.headTextName = headTextName;
        this.fieldName = fieldName;
    }

    public ExcelBean(String headTextName, String fieldName, Integer cols) {
        this.headTextName = headTextName;
        this.fieldName = fieldName;
        this.cols = cols;
    }

    public String getHeadTextName() {
        return headTextName;
    }

    public void setHeadTextName(String headTextName) {
        this.headTextName = headTextName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public XSSFCellStyle getXssfCellStyle() {
        return xssfCellStyle;
    }

    public void setXssfCellStyle(XSSFCellStyle xssfCellStyle) {
        this.xssfCellStyle = xssfCellStyle;
    }
}
