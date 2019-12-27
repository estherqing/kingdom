package com.vivo.jovi.exscene.backend.service;

import com.vivo.jovi.scene.common.CommonVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhongjiajun
 * @date 2019/12/5 10:35
 * @describe 活动卡片通知翻译
 */
public interface IActivityCardTranslationService {
    /**
     * 导出通知信息execl文件
     *
     * @param id
     * @param response
     * @return
     */
    XSSFWorkbook exportNoticeToExcel(HttpServletResponse response, Long id) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException;

    /**
     * 导入通知翻译后的文件
     *
     * @param id
     * @param in
     * @return
     */
    CommonVO importNoticeTranslationData(Long id, InputStream in) throws Exception;
}
