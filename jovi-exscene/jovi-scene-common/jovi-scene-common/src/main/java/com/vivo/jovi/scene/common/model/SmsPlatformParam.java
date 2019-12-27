package com.vivo.jovi.scene.common.model;

/**
 * @Classname SmsPlatformParam
 * @Description TODO
 * @Date 2019-07-17 10:37
 * @Created by xj
 * @Version 1.0
 */
public class SmsPlatformParam {

    private Data data;

    private Header header;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public SmsPlatformParam(){
    }

    class Data{
        /**
         * 是否是wifi环境
         */
        private Integer isWifi;

        /**
         * 本地升级索引号
         */
        private Integer index;

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

        public Data(){
        }
    }

    class Header{
        /**
         * 扩展ID
         */
        private String p2;

        /**
         * 应用版本(app/apk version)
         */
        private String p3;

        /**
         * 系统版本(android version)
         */
        private String p4;

        /**
         * 机型model
         */
        private String p5;

        /**
         * teddy版本号tedSdkVersion
         */
        private String p17;

        private String p8;

        public String getP2() {
            return p2;
        }

        public void setP2(String p2) {
            this.p2 = p2;
        }

        public String getP3() {
            return p3;
        }

        public void setP3(String p3) {
            this.p3 = p3;
        }

        public String getP4() {
            return p4;
        }

        public void setP4(String p4) {
            this.p4 = p4;
        }

        public String getP5() {
            return p5;
        }

        public void setP5(String p5) {
            this.p5 = p5;
        }

        public String getP17() {
            return p17;
        }

        public void setP17(String p17) {
            this.p17 = p17;
        }

        public String getP8() {
            return p8;
        }

        public void setP8(String p8) {
            this.p8 = p8;
        }

        public Header(){
        }
    }
}
