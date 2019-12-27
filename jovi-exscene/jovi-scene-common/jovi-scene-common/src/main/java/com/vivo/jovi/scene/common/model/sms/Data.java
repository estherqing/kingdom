package com.vivo.jovi.scene.common.model.sms;

/**
 * @Classname Data
 * @Description TODO
 * @Date 2019-07-18 10:54
 * @Created by Administrator
 * @Version 1.0
 */
public class Data{
        /**
         * 是否是wifi环境
         */
        private Integer isWifi;

        /**
         * 本地升级索引号
         */
        private Integer index;

        private String ip;

        public Integer getIsWifi() {
            return isWifi;
        }

        public void setIsWifi(Integer isWifi) {
            this.isWifi = isWifi;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Data(){
        }
}
