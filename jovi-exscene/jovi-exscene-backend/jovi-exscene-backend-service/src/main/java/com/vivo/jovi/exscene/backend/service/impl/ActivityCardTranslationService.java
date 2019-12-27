package com.vivo.jovi.exscene.backend.service.impl;

import com.google.common.collect.Lists;
import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.jovi.exscene.backend.service.IActivityCardTranslationService;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.constant.QuestionnaireExcelPreType;
import com.vivo.jovi.scene.common.constant.QuestionnaireLanguageType;
import com.vivo.jovi.scene.common.dal.dao.IExActivityCardDao;
import com.vivo.jovi.scene.common.dal.dao.IExActivityNoticeDao;
import com.vivo.jovi.scene.common.dal.entity.ExActivityCardEntity;
import com.vivo.jovi.scene.common.dal.entity.ExActivityNoticeEntity;
import com.vivo.jovi.scene.common.domain.basic.ExcelBean;
import com.vivo.jovi.scene.common.domain.basic.NoticeTranslationBO;
import com.vivo.jovi.scene.common.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongjiajun
 * @date 2019/12/5 10:39
 * @describe 通知信息管理
 */
@Service
@Slf4j
public class ActivityCardTranslationService implements IActivityCardTranslationService {
    @Autowired
    private IExActivityCardDao exActivityCardDao;
    @Autowired
    private IExActivityNoticeDao activityNoticeDao;

    @Override
    public XSSFWorkbook exportNoticeToExcel(HttpServletResponse response, Long id) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException {
        //查询详情
        ExActivityCardEntity activityCardEntity = exActivityCardDao.selectByPrimaryKey(id);

        //组装到处数据
        List<NoticeTranslationBO> targetList = new ArrayList<>();
        //活动名称
        NoticeTranslationBO activityName = new NoticeTranslationBO();
        activityName.setChinese(QuestionnaireExcelPreType.Q_NAME + activityCardEntity.getId() + QuestionnaireExcelPreType.TAG + activityCardEntity.getName());
        targetList.add(activityName);
        //弹窗文案
        NoticeTranslationBO activityPopup = new NoticeTranslationBO();
        activityPopup.setChinese(QuestionnaireExcelPreType.Q_POPUP + activityCardEntity.getId() + QuestionnaireExcelPreType.TAG + activityCardEntity.getPopup());
        targetList.add(activityPopup);
        //通知文案
        if (StringUtils.isNotBlank(activityCardEntity.getNoticeTitle())) {
            NoticeTranslationBO noticeTitle = new NoticeTranslationBO();
            noticeTitle.setChinese(QuestionnaireExcelPreType.Q_TITLE + activityCardEntity.getId() + QuestionnaireExcelPreType.TAG + activityCardEntity.getNoticeTitle());
            NoticeTranslationBO noticeContent = new NoticeTranslationBO();
            noticeContent.setChinese(QuestionnaireExcelPreType.Q_DESC + activityCardEntity.getId() + QuestionnaireExcelPreType.TAG + activityCardEntity.getNoticeContent());
            targetList.add(noticeTitle);
            targetList.add(noticeContent);
        }
        targetList.get(NumberUtils.INTEGER_ZERO.intValue()).setRemark("please do not translate text before “:::”,and keep the position of “|”");

        //设置导出文件标题
        String translateLanguage = activityCardEntity.getTranslateLanguage();
        if (StringUtils.isBlank(translateLanguage)) {
            return null;
        }
        try {
            // 标题： 问卷翻译列表_问卷id_当前时间(yyyy-MM-dd).xlsx
            ExcelUtils.setHeader(response, activityCardEntity.getName() + "-" + activityCardEntity.getActivityId() + "-" + translateLanguage + ".xlsx");
        } catch (UnsupportedEncodingException e) {
            log.error("createQuestionnaireToExcel set title error！ e : {}", e);
            return null;
        }

        List<ExcelBean> ebs = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        ebs.add(new ExcelBean("备注", "remark", 0));
        List<String> languagesList = Lists.newArrayList(translateLanguage.split(","));
        if (languagesList.contains(QuestionnaireLanguageType.CN)) {
            ebs.add(new ExcelBean("vzh_rCN", "chinese", 0));
        }
        if (languagesList.contains(QuestionnaireLanguageType.EN)) {
            ebs.add(new ExcelBean("vus", "english", 0));
        }
        if (languagesList.contains(QuestionnaireLanguageType.HI)) {
            ebs.add(new ExcelBean("vhi", "hindi", 0));
        }

        map.put(0, ebs);

        return ExcelUtils.createExcelFile(NoticeTranslationBO.class, targetList, map, "活动卡片通知国际化列表", false);
    }

    @Override
    public CommonVO importNoticeTranslationData(Long id, InputStream in) throws Exception {
        List<List<Object>> tgList = ExcelUtils.getDataListByExcel(in);
        if (CollectionUtils.isEmpty(tgList)) {
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "excel解析失败!");
        }

        ExActivityCardEntity activityCardEntity = exActivityCardDao.selectByPrimaryKey(id);
        //移除已有的翻译文案
        activityNoticeDao.deleteByActivityId(activityCardEntity.getActivityId());
        String[] translateLanguages = activityCardEntity.getTranslateLanguage().split(",");
        for (String language : translateLanguages) {
            if (QuestionnaireLanguageType.EN.equals(language)) {
                saveEnglishNotice(tgList, activityCardEntity.getActivityId());
            }
            if (QuestionnaireLanguageType.HI.equals(language)) {
                saveIndiaNotice(tgList, activityCardEntity.getActivityId());
            }
        }
        return CommonVO.success("导入成功");
    }

    /**
     * 保存翻译后的英语文案
     *
     * @param tgList     解析后的文案列表
     * @param activityId 活动卡片Id
     */

    private void saveEnglishNotice(List<List<Object>> tgList, String activityId) {
        ExActivityNoticeEntity enNoticeText = new ExActivityNoticeEntity();
        enNoticeText.setLanguage(QuestionnaireLanguageType.EN);
        enNoticeText.setActivityId(activityId);
        // 保存英文的数据
        for (List<Object> obj : tgList) {
            // 格式：ttl:::XXXXXXX
            String en = String.valueOf(obj.get(1));
            if (StringUtils.isBlank(en)) {
                continue;
            }
            // 内容的前缀
            String enPre = en.substring(0, 4);
            switch (enPre) {
                case QuestionnaireExcelPreType.Q_TITLE:
                    enNoticeText.setTitle(en.substring(en.indexOf(":") + 3));
                    break;
                case QuestionnaireExcelPreType.Q_DESC:
                    enNoticeText.setContent(en.substring(en.indexOf(":") + 3));
                    break;
                case QuestionnaireExcelPreType.Q_NAME:
                    enNoticeText.setActivityName(en.substring(en.indexOf(":") + 3));
                    break;
                case QuestionnaireExcelPreType.Q_POPUP:
                    enNoticeText.setPopup(en.substring(en.indexOf(":") + 3));
                    break;
                default:
                    break;
            }
        }
        activityNoticeDao.insert(enNoticeText);
    }

    /**
     * 保存翻译后的印度文本
     *
     * @param tgList     解析后的文案列表
     * @param activityId 活动卡片Id
     */
    private void saveIndiaNotice(List<List<Object>> tgList, String activityId) {
        ExActivityNoticeEntity hiNoticeText = new ExActivityNoticeEntity();
        hiNoticeText.setLanguage(QuestionnaireLanguageType.HI);
        // 保存英文的数据
        for (List<Object> obj : tgList) {
            // 格式：ttl:::XXXXXXX
            String hi = String.valueOf(obj.get(2));
            if (StringUtils.isBlank(hi)) {
                continue;
            }
            // 内容的前缀
            String enPre = hi.substring(0, 4);
            switch (enPre) {
                case QuestionnaireExcelPreType.Q_TITLE:
                    hiNoticeText.setTitle(hi.substring(hi.indexOf(":") + 3));
                    break;
                case QuestionnaireExcelPreType.Q_DESC:
                    hiNoticeText.setContent(hi.substring(hi.indexOf(":") + 3));
                    break;
                case QuestionnaireExcelPreType.Q_NAME:
                    hiNoticeText.setActivityName(hi.substring(hi.indexOf(":") + 3));
                    break;
                case QuestionnaireExcelPreType.Q_POPUP:
                    hiNoticeText.setPopup(hi.substring(hi.indexOf(":") + 3));
                    break;
                default:
                    break;
            }
        }
        hiNoticeText.setActivityId(activityId);
        activityNoticeDao.insert(hiNoticeText);
    }
}
