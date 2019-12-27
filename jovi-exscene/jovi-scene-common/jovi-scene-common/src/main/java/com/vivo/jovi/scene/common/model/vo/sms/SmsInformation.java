package com.vivo.jovi.scene.common.model.vo.sms;

/**
 * @Classname SmsInformation
 * @Description TODO
 * @Date 2019-07-17 15:22
 * @Created by Administrator
 * @Version 1.0
 */
public class SmsInformation {

    public SmsInformation() {
    }

    private String path;

    private JobState jobState;

    private Integer type;

    private String url;

    private String md5;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public JobState getJobState() {
        return jobState;
    }

    public void setJobState(JobState jobState) {
        this.jobState = jobState;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    class JobState {
        public JobState() {

        }

        private Integer network;

        public Integer getNetwork() {
            return network;
        }

        public void setNetwork(Integer network) {
            this.network = network;
        }
    }
}
