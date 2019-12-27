package com.vivo.jovi.scene.common.model;

import com.vivo.jovi.scene.common.model.dto.BasePageQueryDTO;
import lombok.Data;

/**
 * @author zhongjiajun
 * @date 2019/12/3 15:17
 * @describe 搜索请求参数
 */
@Data
public class ActivityCardSearchDTO extends BasePageQueryDTO {
    /**
     * 活动卡片名称
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
}
