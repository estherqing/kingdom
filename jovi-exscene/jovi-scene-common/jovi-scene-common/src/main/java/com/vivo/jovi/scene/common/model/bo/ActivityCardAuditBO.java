package com.vivo.jovi.scene.common.model.bo;

import lombok.Data;

/**
 * @author zhongjiajun
 * @date 2019/12/5 14:50
 * @describe 活动卡片审核参数
 */
@Data
public class ActivityCardAuditBO {
    /**
     * 活动卡片Id
     */
    private Long id;
    /**
     * 审核结果
     */
    private boolean approval;
    /**
     * 审核不通过原因
     */
    private String reason;
}
