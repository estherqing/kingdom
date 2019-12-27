package com.vivo.jovi.exscene.backend.service.quartz;

import com.vivo.framework.redis.cluster.JedisClusterTemplate;
import com.vivo.jovi.scene.common.dal.dao.IExPublishDao;
import com.vivo.jovi.scene.common.dal.entity.ExPublishEntity;
import com.vivo.jovi.scene.common.util.CacheUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 定时刷新实际发布量
 * @Author Lu Guodong
 * @Date 2019-05-21
 */
@Component
public class RefreshTheActualReleaseTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(RefreshTheActualReleaseTask.class);

    @Autowired
    private IExPublishDao publishDao;

    @Autowired
    private JedisClusterTemplate jedisClusterTemplate;

    //每10分钟执行定时任务
    @Scheduled(cron = "0 */10 * * * ?")
    public void RefreshTheActualRelease() {
        List<ExPublishEntity> publishEntities = new ArrayList<>();
        try {
            List<ExPublishEntity> publishEntityList = publishDao.findAllPublish();
            if(publishEntityList.size() == 0){
                return;
            }
            for (ExPublishEntity entity : publishEntityList) {
                String actualRelease = jedisClusterTemplate.get(CacheUtil.getQNRPublishQuantityKey(entity.getBizId()));
                if (StringUtils.isNotBlank(actualRelease)) {
                    entity.setActualRelease(Long.valueOf(actualRelease));
                }
                publishEntities.add(entity);
            }
            publishDao.updateActualRelease(publishEntities);
        }catch (Exception e) {
            LOGGER.error("RefreshTheActualRelease error! e : {}", e);
        }
    }
}
