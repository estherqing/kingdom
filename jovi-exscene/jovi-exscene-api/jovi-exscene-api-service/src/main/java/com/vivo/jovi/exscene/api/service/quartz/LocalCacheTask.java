package com.vivo.jovi.exscene.api.service.quartz;

import com.vivo.jovi.exscene.api.service.ILocalCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: 更新本地缓存策略
 * @author: Lu Guodong
 * @CreateDate: 2019-06-12
 */
@Component
public class LocalCacheTask {
    private final static Logger LOGGER = LoggerFactory.getLogger(LocalCacheTask.class);

    @Autowired
    private ILocalCacheManager localCacheManager;

    /**
     * 每隔10秒钟执行一次定时任务
     */
    @Scheduled(cron="0/10 * * * * ?")
    public void updateLocalCache(){
        LOGGER.debug("update local cache");
        localCacheManager.refreshCaches();
    }

    /**
     * 每天凌晨2点将缓存进行清除
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanLocalCache(){
        LOGGER.debug("clean up cache");
        localCacheManager.cleanCaches();
    }
}
