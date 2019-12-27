package com.vivo.jovi.scene.common.service.impl;

import com.vivo.framework.redis.cluster.JedisClusterTemplate;
import com.vivo.internet.vivocfg.client.VivoConfigManager;
import com.vivo.jovi.scene.common.constant.RedisKeyConstants;
import com.vivo.jovi.scene.common.model.DeviceBasicParam;
import com.vivo.jovi.scene.common.service.ICommonMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WangWenqian
 * @version 1.0
 * @describe
 * @date 2018/4/15
 */
@Service
public class CommonMonitorService implements ICommonMonitorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonMonitorService.class);

    /**
     * 推送预警的次数
     */
    private static final int PUSH_IMEI_TIMES = VivoConfigManager.getInteger("push.imei.times", 500); //500次

    private static final boolean MONITOR_PUSH_BYZSET = VivoConfigManager.getBoolean("monitor.push.byzset",false);

    private static final int PUSH_IMEI_EXPIRE = VivoConfigManager.getInteger("push.imei.expire",24 * 60 * 60);

    @Autowired
    private JedisClusterTemplate jedisClusterTemplate;

    /**
     * 根据key value进行监控
     * @param imei
     * @return
     */
    private boolean monitorPushByKV(String imei) {
        String redisKey = "push:" + imei;   //用于记录对某个imei推送了多少次

        if (!jedisClusterTemplate.exists(redisKey)) {
            jedisClusterTemplate.setex(redisKey, PUSH_IMEI_EXPIRE, "1");
        } else {
            long times = jedisClusterTemplate.incr(redisKey);
            if (Integer.valueOf(jedisClusterTemplate.get(redisKey)) > PUSH_IMEI_TIMES) {
                LOGGER.warn("imei : {}, {}s request more than {} times,request times is {}", imei, PUSH_IMEI_EXPIRE, PUSH_IMEI_TIMES, times);
                return true;
            }
        }
        return false;
    }

    /**
     * 根据zset 进行监控
     * @param imei
     * @return
     */
    private boolean monitorPushByZSET(String imei) {
        Double times = jedisClusterTemplate.zincrby(RedisKeyConstants.MONITOR_PUSHTIMES, 1, imei); //imei的推送次数+1
        if (times > PUSH_IMEI_TIMES) {
            LOGGER.warn("imei : {}, 1 day request more than {} times,request times is {}", imei, PUSH_IMEI_TIMES, times);
            return true; //有异常
        } else {
            return false;
        }
    }


    @Override
    public boolean monitorImeiPush(String imei) {
        if(MONITOR_PUSH_BYZSET){
            return monitorPushByZSET(imei);
        }else{
            return monitorPushByKV(imei);
        }
    }

    @Override
    public void monitorSubCode(String subCode, Integer creType , DeviceBasicParam basicParam) {
//        jedisClusterTemplate.hset(RedisKeyConstants.MONITOR_SUBCODE_LASTREQ, creType + "#" + subCode, String.valueOf(new Date().getTime())); //subCode最后请求时间
//        jedisClusterTemplate.hset(RedisKeyConstants.MONITOR_SUBCODE_APPVER, creType + "#" + subCode, basicParam.getAppver()); //把appVer也记录下来
    }


}
