package com.vivo.jovi.exscene.backend.service.impl;

import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.jovi.exscene.backend.service.IQuestionnaireTranslationService;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.constant.QuestionnaireExcelPreType;
import com.vivo.jovi.scene.common.constant.QuestionnaireLanguageType;
import com.vivo.jovi.scene.common.dal.dao.IQuestionDao;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireDao;
import com.vivo.jovi.scene.common.dal.dao.IQuestionnaireDescDao;
import com.vivo.jovi.scene.common.dal.entity.QuestionEntity;
import com.vivo.jovi.scene.common.dal.entity.QuestionnaireDescEntity;
import com.vivo.jovi.scene.common.domain.basic.ExcelBean;
import com.vivo.jovi.scene.common.domain.basic.QuestionnaireTranslationBO;
import com.vivo.jovi.scene.common.util.ExcelUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author huhan
 * @description
 * @date 2019-05-06 15:29
 */
@Service
public class QuestionnaireTranslationServer implements IQuestionnaireTranslationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionnaireTranslationServer.class);

    @Autowired
    private IQuestionnaireDao questionnaireDao;

    @Autowired
    private IQuestionnaireDescDao questionnaireDescDao;

    @Autowired
    private IQuestionDao questionDao;

    @Override
    public XSSFWorkbook createQuestionnaireToExcel(HttpServletResponse response, QuestionnaireTranslationBO questionnaireTranslationBo) throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException, IntrospectionException {
        List<QuestionnaireTranslationBO> targetList = new ArrayList<>();

        List<QuestionnaireDescEntity> questionnaireDescEntities = questionnaireDescDao.selectByQuestionnaireId(questionnaireTranslationBo.getQuestionnaireId(), null);
        assembleDesc(questionnaireDescEntities, targetList);
        QuestionnaireDescEntity questionnaireDescEntity = questionnaireDescEntities.get(0);
        String translateLanguage = questionnaireDescEntity.getTranslateLanguage();
        if (StringUtils.isBlank(translateLanguage)) {
            return null;
        }
        List<String> languagesList = new ArrayList<>();
        languagesList.add(QuestionnaireLanguageType.CN);
        languagesList.add(QuestionnaireLanguageType.EN);
        languagesList.add(QuestionnaireLanguageType.HI);

        try {
            // 标题： 问卷翻译列表_问卷id_当前时间(yyyy-MM-dd).xlsx
            ExcelUtils.setHeader(response, questionnaireDescEntity.getTitle() + "-" + questionnaireTranslationBo.getQuestionnaireId() + "-" + translateLanguage + ".xlsx");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("createQuestionnaireToExcel set title error！ e : {}", e);
            return null;
        }

        List<QuestionEntity> questionEntities = questionDao.selectByQuestionnaireId(questionnaireTranslationBo.getQuestionnaireId(), languagesList);
        addembleQuestion(questionEntities, targetList);
        targetList.get(0).setRemark("please do not translate text before “:::”,and keep the position of “|”");

        List<ExcelBean> ebs = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        ebs.add(new ExcelBean("备注", "remark", 0));
        for (String language : languagesList) {
            if (QuestionnaireLanguageType.CN.equals(language)) {
                ebs.add(new ExcelBean("vzh_rCN", "chinese", 0));
            }
            if (QuestionnaireLanguageType.EN.equals(language)) {
                ebs.add(new ExcelBean("vus", "english", 0));
            }
            if (QuestionnaireLanguageType.HI.equals(language)) {
                ebs.add(new ExcelBean("vhi", "hindi", 0));
            }
        }

        map.put(0, ebs);

        return ExcelUtils.createExcelFile(QuestionnaireTranslationBO.class, targetList, map, "问卷翻译国际化列表", false);
    }

    @Override
    public CommonVO importTextTranslationData(String questionnaireId, InputStream in) throws Exception {
        List<List<Object>> tgList = ExcelUtils.getDataListByExcel(in);
        if (CollectionUtils.isEmpty(tgList)) {
            return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(), "excel解析失败!");
        }

        List<QuestionnaireDescEntity> questionnaireDescEntityList = questionnaireDescDao.selectByQuestionnaireId(questionnaireId, null);
        QuestionnaireDescEntity questionnaireDescEntity = questionnaireDescEntityList.get(0);

        String[] translateLanguages = questionnaireDescEntity.getTranslateLanguage().split(",");
        for (String language : translateLanguages) {
            if (QuestionnaireLanguageType.EN.equals(language)) {
                saveQuestionDescENMsg(tgList, questionnaireDescEntity);
                saveQuestionENMsg(tgList, questionnaireId);
            }
            if (QuestionnaireLanguageType.HI.equals(language)) {
                saveQuestionDescHIMsg(tgList, questionnaireDescEntity);
                saveQuestionHIMsg(tgList, questionnaireId);
            }
        }

        return CommonVO.success();
    }

    /**
     * 保存问卷问题英文翻译信息
     */
    private void saveQuestionENMsg(List<List<Object>> tgList, String questionnaireId) {
        List<QuestionEntity> questionEntity = questionDao.selectByQuestionnaireId(questionnaireId, null);
        Map<Long, QuestionEntity> questionEntityMap = new HashMap<>();
        for (QuestionEntity entity : questionEntity) {
            questionEntityMap.put(entity.getId(), entity);
        }

        for (List<Object> obj : tgList) {
            // 格式：ttl:::XXXXXXX
            String en = String.valueOf(obj.get(1));
            if (StringUtils.isBlank(en)) {
                continue;
            }
            Long tarId = Long.valueOf(en.substring(4, en.indexOf(":")));
            QuestionEntity question = questionEntityMap.get(tarId);
            String enPre = en.substring(0, 4);
            switch (enPre) {
                case QuestionnaireExcelPreType.Q_QUESTION:
                    question.setContent(en.substring(en.indexOf(":") + 3));
                    question.setLanguage(QuestionnaireLanguageType.EN);
                    questionDao.insertSelective(question);
                    break;
                case QuestionnaireExcelPreType.Q_ANSWER:
                    question.setAnswer(en.substring(en.indexOf(":") + 3));
                    question.setLanguage(QuestionnaireLanguageType.EN);
                    questionDao.insertSelective(question);
                    break;
                case QuestionnaireExcelPreType.Q_REMARK:
                    question.setRemark(en.substring(en.indexOf(":") + 3));
                    question.setLanguage(QuestionnaireLanguageType.EN);
                    questionDao.insertSelective(question);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 保存问卷问题印地语翻译信息
     */
    private void saveQuestionHIMsg(List<List<Object>> tgList, String questionnaireId) {
        List<QuestionEntity> questionEntity = questionDao.selectByQuestionnaireId(questionnaireId, null);
        Map<Long, QuestionEntity> questionEntityMap = new HashMap<>();
        for (QuestionEntity entity : questionEntity) {
            questionEntityMap.put(entity.getId(), entity);
        }

        for (List<Object> obj : tgList) {
            // 格式：ttl:::XXXXXXX
            String hi = String.valueOf(obj.get(2));
            if (StringUtils.isBlank(hi)) {
                continue;
            }
            // 该问题中文的主键id
            Long tarId = Long.valueOf(hi.substring(4, hi.indexOf(":")));
            QuestionEntity question = questionEntityMap.get(tarId);
            String hiPre = hi.substring(0, 4);
            switch (hiPre) {
                case QuestionnaireExcelPreType.Q_QUESTION:
                    question.setContent(hi.substring(hi.indexOf(":") + 3));
                    question.setLanguage(QuestionnaireLanguageType.HI);
                    questionDao.insertSelective(question);
                    break;
                case QuestionnaireExcelPreType.Q_ANSWER:
                    question.setAnswer(hi.substring(hi.indexOf(":") + 3));
                    question.setLanguage(QuestionnaireLanguageType.HI);
                    questionDao.insertSelective(question);
                    break;
                case QuestionnaireExcelPreType.Q_REMARK:
                    question.setRemark(hi.substring(hi.indexOf(":") + 3));
                    question.setLanguage(QuestionnaireLanguageType.HI);
                    questionDao.insertSelective(question);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 保存问卷描述英文翻译信息
     */
    private void saveQuestionDescENMsg(List<List<Object>> tgList, QuestionnaireDescEntity questionnaireDescEntity) {
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
                    questionnaireDescEntity.setTitle(en.substring(en.indexOf(":") + 3));
                    questionnaireDescEntity.setLanguage(QuestionnaireLanguageType.EN);
                    questionnaireDescDao.insertSelective(questionnaireDescEntity);
                    break;
                case QuestionnaireExcelPreType.Q_DESC:
                    questionnaireDescEntity.setDescription(en.substring(en.indexOf(":") + 3));
                    questionnaireDescEntity.setLanguage(QuestionnaireLanguageType.EN);
                    questionnaireDescDao.insertSelective(questionnaireDescEntity);
                    break;
                case QuestionnaireExcelPreType.Q_CUE:
                    questionnaireDescEntity.setCueWord(en.substring(en.indexOf(":") + 3));
                    questionnaireDescEntity.setLanguage(QuestionnaireLanguageType.EN);
                    questionnaireDescDao.insertSelective(questionnaireDescEntity);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 保存问卷描述印地语翻译信息
     */
    private void saveQuestionDescHIMsg(List<List<Object>> tgList, QuestionnaireDescEntity questionnaireDescEntity) {
        // 保存英文的数据
        for (List<Object> obj : tgList) {
            // 格式：ttl:::XXXXXXX
            String hi = String.valueOf(obj.get(2));
            if (StringUtils.isBlank(hi)) {
                continue;
            }
            String hiPre = hi.substring(0, 4);
            switch (hiPre) {
                case QuestionnaireExcelPreType.Q_TITLE:
                    questionnaireDescEntity.setTitle(hi.substring(hi.indexOf(":") + 3));
                    questionnaireDescEntity.setLanguage(QuestionnaireLanguageType.HI);
                    questionnaireDescDao.insertSelective(questionnaireDescEntity);
                    break;
                case QuestionnaireExcelPreType.Q_DESC:
                    questionnaireDescEntity.setDescription(hi.substring(hi.indexOf(":") + 3));
                    questionnaireDescEntity.setLanguage(QuestionnaireLanguageType.HI);
                    questionnaireDescDao.insertSelective(questionnaireDescEntity);
                    break;
                case QuestionnaireExcelPreType.Q_CUE:
                    questionnaireDescEntity.setCueWord(hi.substring(hi.indexOf(":") + 3));
                    questionnaireDescEntity.setLanguage(QuestionnaireLanguageType.HI);
                    questionnaireDescDao.insertSelective(questionnaireDescEntity);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 组装问卷question信息
     */
    private void addembleQuestion(List<QuestionEntity> questionEntities, List<QuestionnaireTranslationBO> targetList) {
        if (questionEntities.isEmpty()) {
            return;
        }

        Map<String, List<QuestionEntity>> map = new HashMap<>();
        for (QuestionEntity entity : questionEntities) {
            // 保存questionId相同的question
            if (map.containsKey(entity.getQuestionId())) {
                List<QuestionEntity> questionEntityList = map.get(entity.getQuestionId());
                questionEntityList.add(entity);
            } else {
                List<QuestionEntity> questionEntityList = new ArrayList<>();
                questionEntityList.add(entity);
                map.put(entity.getQuestionId(), questionEntityList);
            }
        }

        // 外层循环有多少个问题
        for (Map.Entry<String, List<QuestionEntity>> entry : map.entrySet()) {
            QuestionnaireTranslationBO qtContext = new QuestionnaireTranslationBO();
            QuestionnaireTranslationBO qtAnswer = new QuestionnaireTranslationBO();
            QuestionnaireTranslationBO qtRemark = new QuestionnaireTranslationBO();
            List<QuestionEntity> questionEntityList = entry.getValue();
            // 内层循环将同一个questionId的question封装到QuestionnaireTranslationBo对象中
            for (QuestionEntity entity : questionEntityList) {
                // 格式 前缀:::翻译
                if (QuestionnaireLanguageType.CN.equals(entity.getLanguage())) {
                    qtContext.setChinese(QuestionnaireExcelPreType.Q_QUESTION + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getContent());
                    qtAnswer.setChinese(QuestionnaireExcelPreType.Q_ANSWER + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getAnswer());
                    if (StringUtils.isNotBlank(entity.getRemark())) {
                        qtRemark.setChinese(QuestionnaireExcelPreType.Q_REMARK + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getRemark());
                    }
                }
                if (QuestionnaireLanguageType.EN.equals(entity.getLanguage())) {
                    qtContext.setEnglish(QuestionnaireExcelPreType.Q_QUESTION + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getContent());
                    qtAnswer.setEnglish(QuestionnaireExcelPreType.Q_ANSWER + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getAnswer());
                    if (StringUtils.isNotBlank(entity.getRemark())) {
                        qtRemark.setEnglish(QuestionnaireExcelPreType.Q_REMARK + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getRemark());
                    }
                }
                if (QuestionnaireLanguageType.HI.equals(entity.getLanguage())) {
                    qtContext.setHindi(QuestionnaireExcelPreType.Q_QUESTION + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getContent());
                    qtAnswer.setHindi(QuestionnaireExcelPreType.Q_ANSWER + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getAnswer());
                    if (StringUtils.isNotBlank(entity.getRemark())) {
                        qtRemark.setHindi(QuestionnaireExcelPreType.Q_REMARK + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getRemark());
                    }
                }
            }
            targetList.add(qtContext);
            targetList.add(qtAnswer);
            if (StringUtils.isNotBlank(qtRemark.getChinese()) || StringUtils.isNotBlank(qtRemark.getEnglish()) || StringUtils.isNotBlank(qtRemark.getHindi())) {
                targetList.add(qtRemark);
            }
        }

    }

    /**
     * 组装问卷描述信息
     */
    private void assembleDesc(List<QuestionnaireDescEntity> questionnaireDescEntities, List<QuestionnaireTranslationBO> targetList) {
        if (questionnaireDescEntities.isEmpty()) {
            return;
        }
        QuestionnaireTranslationBO qbTitle = new QuestionnaireTranslationBO();
        QuestionnaireTranslationBO qbDesc = new QuestionnaireTranslationBO();
        QuestionnaireTranslationBO qbCue = new QuestionnaireTranslationBO();
        // 因为这里只有一个描述，不用做和问题一样的处理
        for (QuestionnaireDescEntity entity : questionnaireDescEntities) {
            if (QuestionnaireLanguageType.CN.equals(entity.getLanguage())) {
                qbTitle.setChinese(QuestionnaireExcelPreType.Q_TITLE + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getTitle());
                if (StringUtils.isNotBlank(entity.getDescription())) {
                    qbDesc.setChinese(QuestionnaireExcelPreType.Q_DESC + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getDescription());
                }
                qbCue.setChinese(QuestionnaireExcelPreType.Q_CUE + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getCueWord());
            }
            if (QuestionnaireLanguageType.EN.equals(entity.getLanguage())) {
                qbTitle.setEnglish(QuestionnaireExcelPreType.Q_TITLE + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getTitle());
                if (StringUtils.isNotBlank(entity.getDescription())) {
                    qbDesc.setEnglish(QuestionnaireExcelPreType.Q_DESC + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getDescription());
                }
                qbCue.setEnglish(QuestionnaireExcelPreType.Q_CUE + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getCueWord());
            }
            if (QuestionnaireLanguageType.HI.equals(entity.getLanguage())) {
                qbTitle.setHindi(QuestionnaireExcelPreType.Q_TITLE + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getTitle());
                if (StringUtils.isNotBlank(entity.getDescription())) {
                    qbDesc.setHindi(QuestionnaireExcelPreType.Q_DESC + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getDescription());
                }
                qbCue.setHindi(QuestionnaireExcelPreType.Q_CUE + entity.getId() + QuestionnaireExcelPreType.TAG + entity.getCueWord());
            }
        }

        targetList.add(qbTitle);
        if (StringUtils.isNotBlank(qbDesc.getChinese()) || StringUtils.isNotBlank(qbDesc.getHindi()) || StringUtils.isNotBlank(qbDesc.getEnglish())) {
            targetList.add(qbDesc);
        }
        targetList.add(qbCue);
    }

    /**
     * 字符串数组转int数组
     */
    private Integer[] StringToInteger(String[] strArrs) {
        Integer[] intArrs = new Integer[strArrs.length];
        for (int i = 0; i < strArrs.length; i++) {
            intArrs[i] = Integer.parseInt(strArrs[i]);
        }

        return intArrs;
    }

}
