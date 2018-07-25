package com.esther.code.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author esther
 * 2018-07-25 10:59
 * $DESCRIPTION}
 */
public class CustomDateEditor extends PropertyEditorSupport {
    private String datePattern = "yyyy-MM-dd";

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        SimpleDateFormat format = new SimpleDateFormat(getDatePattern());
        try {
            Date dateValue = format.parse(text);
            setValue(dateValue);
            System.out.println("调用了自定义的日期类型转换器" + dateValue);
        } catch (Exception e) {
            System.out.println("日期格式不对");
        }
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }
}
