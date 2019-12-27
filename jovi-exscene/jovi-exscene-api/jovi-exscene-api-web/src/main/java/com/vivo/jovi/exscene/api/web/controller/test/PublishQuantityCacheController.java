package com.vivo.jovi.exscene.api.web.controller.test;

import com.vivo.jovi.exscene.api.service.ICacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 点检实际发布量
 * @author: Lu Guodong
 * @CreateDate: 2019-06-20
 */
@Controller
@RequestMapping("publishquatity")
public class PublishQuantityCacheController {
    @Autowired
    private ICacheManager cacheManager;

    @RequestMapping(value = "get")
    @ResponseBody
    public String getPublishQuantityCache(String bizId){
        return "调研卡片实际发布量为：" + cacheManager.getQNRPublishQuatity(bizId);
    }
}
