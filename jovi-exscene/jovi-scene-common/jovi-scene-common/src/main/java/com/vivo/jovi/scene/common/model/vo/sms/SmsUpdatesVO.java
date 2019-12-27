package com.vivo.jovi.scene.common.model.vo.sms;

import java.util.List;

/**
 * @Classname SmsUpdatesVO
 * @Description TODO
 * @Date 2019-07-17 11:22
 * @Created by Administrator
 * @Version 1.0
 */
public class SmsUpdatesVO {

    public SmsUpdatesVO() {
    }

    private Integer index;

    private Content content;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    class Content {
        public Content() {
        }

        private List<Object> a;

        private List<SmsInformation> d;

        private List<Object> r;

        private List<Object> u;

        private List<Object> e;

        public List<SmsInformation> getD() {
            return d;
        }

        public void setD(List<SmsInformation> d) {
            this.d = d;
        }

        public List getR() {
            return r;
        }

        public void setR(List r) {
            this.r = r;
        }

        public List<Object> getA() {
            return a;
        }

        public void setA(List<Object> a) {
            this.a = a;
        }

        public List<Object> getU() {
            return u;
        }

        public void setU(List<Object> u) {
            this.u = u;
        }

        public List<Object> getE() {
            return e;
        }

        public void setE(List<Object> e) {
            this.e = e;
        }
    }

}
