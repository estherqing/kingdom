package com.vivo.jovi.scene.common.domain.basic;

import lombok.Data;

/**
 * @author zhongjiajun
 * @date 2019/12/5 10:52
 * @describe 通知信息
 */
@Data
public class NoticeTranslationBO {
    /**
     * 中文
     */
    private String chinese = "";

    /**
     * 英语
     */
    private String english = "";

    /**
     * 印地语
     */
    private String hindi = "";
    /**
     * excel的备注信息
     */
    private String remark = "";
}
