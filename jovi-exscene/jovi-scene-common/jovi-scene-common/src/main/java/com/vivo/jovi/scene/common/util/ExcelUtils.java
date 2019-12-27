package com.vivo.jovi.scene.common.util;

import com.vivo.jovi.scene.common.domain.basic.ExcelBean;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author huhan
 * @describe excel操作工具类
 * @date 2019-05-05 9:55
 */
public class ExcelUtils {
    private static final String NUMBER_FORMAT = "#,##0.00";
    private static final String NUMBER_FORMAT1 = "0";
    private static final String NUMBER_FORMAT2 = "0.00";
    private static XSSFCellStyle headerStyle;
    private static XSSFCellStyle rowsStyle;

    /**
     * 创建excel工作薄
     *
     * @param clazz     数据bean
     * @param objs      数据集
     * @param map       key:行号 value:数据
     * @param sheetName sheet页名称
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws IntrospectionException
     */
    public static XSSFWorkbook createExcelFile(Class clazz, List objs, Map<Integer, List<ExcelBean>> map, String sheetName, boolean isDate)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        setCellStyle(workbook);
        createTableHeader(sheet, map);
        createTableRows(clazz, objs, map, sheet, isDate);
        return workbook;
    }

    /**
     * 设置单元格样式
     *
     * @param workbook
     */
    private static void setCellStyle(XSSFWorkbook workbook) {
        // 设置表头格式
        headerStyle = workbook.createCellStyle();
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setFontName("宋体");
        headerFont.setFontHeightInPoints((short) 14);
        headerStyle.setFont(headerFont);
        setBorder(headerStyle);
        headerStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        // 设置内容格式
        rowsStyle = workbook.createCellStyle();
        XSSFFont rowsFont = workbook.createFont();
        rowsFont.setFontName("宋体");
        rowsFont.setFontHeightInPoints((short) 10);
        rowsStyle.setFont(rowsFont);
        setBorder(rowsStyle);
        rowsStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
    }

    private static void setBorder(XSSFCellStyle cellStyle) {
        cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
    }

    /**
     * 创建表头
     *
     * @param sheet
     * @param map   key:行号 value:数据
     */
    private static void createTableHeader(XSSFSheet sheet, Map<Integer, List<ExcelBean>> map) {
        int startIndex = 0; // cell起始位置
        int endIndex = 0; // cell终止位置

        for (Map.Entry<Integer, List<ExcelBean>> entry : map.entrySet()) {
            XSSFRow row = sheet.createRow(entry.getKey());
            List<ExcelBean> excels = entry.getValue();

            for (int i = 0; i < excels.size(); i++) {
                ExcelBean excelBean = excels.get(i);
                if (excelBean.getCols() > 1) {
                    // 和并单元格
                    if (i == 0) {
                        endIndex += excelBean.getCols() - 1;
                        CellRangeAddress range = new CellRangeAddress(0, 0, startIndex, endIndex);
                        sheet.addMergedRegion(range);
                        startIndex += excelBean.getCols();
                    } else {
                        endIndex += excelBean.getCols();
                        CellRangeAddress range = new CellRangeAddress(0, 0, startIndex, endIndex);
                        sheet.addMergedRegion(range);
                        startIndex += excelBean.getCols();
                    }
                    createCell(excelBean, row, startIndex - excelBean.getCols());
                } else {
                    createCell(excelBean, row, i);
                }
            }
        }
    }

    /**
     * 创建表头单元格
     *
     * @param excelBean 携带数据
     * @param row       行号
     * @param index     列下标
     */
    private static void createCell(ExcelBean excelBean, XSSFRow row, int index) {
        XSSFCell cell = row.createCell(index);
        cell.setCellValue(excelBean.getHeadTextName());
        if (excelBean.getXssfCellStyle() != null) {
            cell.setCellStyle(excelBean.getXssfCellStyle());
        }
        cell.setCellStyle(headerStyle);
    }

    /**
     * 创建表格内容
     *
     * @param clazz 数据bean
     * @param objs  数据集
     * @param map   key:行号 value:数据
     * @param sheet
     */
    private static void createTableRows(Class clazz, List objs, Map<Integer, List<ExcelBean>> map, XSSFSheet sheet, boolean isDate)
            throws IllegalArgumentException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        if (CollectionUtils.isEmpty(objs)) {
            return;
        }

        int rowIndex = map.size();
        int maxKey = 0;
        List<ExcelBean> ebs;

        for (Map.Entry<Integer, List<ExcelBean>> entry : map.entrySet()) {
            if (entry.getKey() > maxKey) {
                maxKey = entry.getKey();
            }
        }
        ebs = map.get(maxKey);

        List<Integer> widths = new ArrayList<>(ebs.size());
        for (Object obj : objs) {
            XSSFRow row = sheet.createRow(rowIndex);
            for (int i = 0; i < ebs.size(); i++) {
                ExcelBean excelBean = ebs.get(i);

                //获取get方法
                Object rtn = new PropertyDescriptor(excelBean.getFieldName(), clazz).getReadMethod().invoke(obj);

                if (rtn == null) {
                    continue;
                }

                String value;
                //进行类型转换
                if (rtn instanceof Date) {
                    if (isDate) {
                        value = DateUtil.formatDate((Date) rtn);
                    } else {
                        value = DateUtil.formatTime((Date) rtn);
                    }
                } else if (rtn instanceof BigDecimal) {
                    NumberFormat nf = new DecimalFormat(NUMBER_FORMAT);
                    value = nf.format(rtn.toString());
                } else if (rtn instanceof Integer && (Integer.valueOf(rtn.toString()) < 0)) {
                    value = "--";
                } else {
                    value = rtn.toString();
                }

                XSSFCell cell = row.createCell(i);
                cell.setCellValue(value);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellStyle(rowsStyle);

                //计算列宽
                int width = value.getBytes().length * 300;
                if (widths.size() <= i) {
                    widths.add(width);
                    continue;
                }

                if (width > widths.get(i)) {
                    widths.set(i, width);
                }
            }
            rowIndex++;
        }

        //设置列宽
        for (int index = 0; index < widths.size(); index++) {
            Integer width = widths.get(index);
            width = width < 2500 ? 2500 : width + 300;
            width = width > 10000 ? 10000 + 300 : width + 300;
            sheet.setColumnWidth(index, width);
        }
    }

    public static List<List<Object>> getDataListByExcel(InputStream in) throws Exception {

        Workbook workbook = getWorkBook(in);
        if (workbook == null) {
            throw new Exception("Excel工作簿为空");
        }

        Sheet sheet;
        List<List<Object>> dataList = new ArrayList<>();
        //遍历所有sheet
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            Row headRow = sheet.getRow(0);
            //遍历当前sheet所有行
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                //遍历所有列
                List<Object> rowDatas = new ArrayList<>();
                for (int k = headRow.getFirstCellNum(); k < headRow.getLastCellNum(); k++) {
                    Object obj = getCellValue(row.getCell(k));
                    if (obj != null) {
                        rowDatas.add(obj);
                    } else {
                        rowDatas.add("");
                    }
                }
                dataList.add(rowDatas);
            }
        }
        return dataList;
    }

    /**
     * 获取WorkBook对象
     *
     * @param in 输入流
     * @return WorkBook
     */
    private static Workbook getWorkBook(InputStream in) throws Exception {
        return WorkbookFactory.create(in);
    }

    /**
     * 获取表格内容
     *
     * @param cell 单元格
     * @return 表格内容
     */
    private static Object getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }

        Object value = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                    value = new DecimalFormat(NUMBER_FORMAT1).format(cell.getNumericCellValue());
                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
                    value = DateUtil.formatTime(cell.getDateCellValue());
                } else {
                    value = new DecimalFormat(NUMBER_FORMAT2).format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            default:
                break;
        }
        return value;
    }

    public static HttpServletResponse setHeader(HttpServletResponse response, String excelName) throws UnsupportedEncodingException {
        response.reset();
        //指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(excelName, "utf-8"));
        response.setHeader("fileName", URLEncoder.encode(excelName, "utf-8"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        return response;
    }
}
