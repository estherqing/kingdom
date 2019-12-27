package com.vivo.jovi.exscene.api.service;

import com.vivo.jovi.exscene.api.service.model.form.LuckDrawForm;
import com.vivo.jovi.exscene.api.service.model.form.QuestionnaireForm;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireDetailVO;
import com.vivo.jovi.exscene.api.service.model.vo.QuestionnaireVO;
import com.vivo.jovi.scene.common.CommonVO;
import com.vivo.jovi.scene.common.model.ExsceneBizQueryParam;

import java.util.List;

public interface IQuestionnaireService {

    /**
     * 问卷答案回调接口
     * @param questionnaireForm
     * @return
     */
    CommonVO answer(QuestionnaireForm questionnaireForm);

    /**
     * 抽奖接口
     * @param luckDrawForm
     * @return
     */
    CommonVO luckDraw(LuckDrawForm luckDrawForm);

    /**
     * 客户端主动轮询获取最新调研卡片
     * @param exsceneBizQueryParam
     * @return
     */
    List<QuestionnaireVO> getQuestionnaireList(ExsceneBizQueryParam exsceneBizQueryParam);

    /**
     * 根据questionnaireId和language获取调研卡片的详情，用于h5界面
     * @param questionnaireId
     * @param language
     * @return
     */
    QuestionnaireDetailVO getQuestionDetail(String questionnaireId, String language);
}
