package com.vivo.jovi.exscene.backend.web.controller;

import com.vivo.framework.spring.webmvc.CommonVORetcodeEnum;
import com.vivo.jovi.scene.common.CommonVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huhan
 * @description
 * @date 2019-05-06 16:57
 */
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected CommonVO handleException(Exception e, String uri) {
        //TODO 这里可以对不同异常做处理
        LOGGER.error("Invoke {} error! cause by ", uri, e);
        return CommonVO.error(CommonVORetcodeEnum.SERVER_ERROR.getCode(),"server error:" + e.getMessage());
    }
}
