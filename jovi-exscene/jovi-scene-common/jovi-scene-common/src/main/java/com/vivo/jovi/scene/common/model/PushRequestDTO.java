
package com.vivo.jovi.scene.common.model;

@SuppressWarnings("unused")
public class PushRequestDTO {

    private String mAppKey;

    private String mCustomMessage;

    private Long mIsEncrypt;

    private String mSign;

    private String mTargetUsers;

    private Long mTimeToLive;

    private Long timestamp;

    private Integer userType;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppKey() {
        return mAppKey;
    }

    public void setAppKey(String appKey) {
        mAppKey = appKey;
    }

    public String getCustomMessage() {
        return mCustomMessage;
    }

    public void setCustomMessage(String customMessage) {
        mCustomMessage = customMessage;
    }

    public Long getIsEncrypt() {
        return mIsEncrypt;
    }

    public void setIsEncrypt(Long isEncrypt) {
        mIsEncrypt = isEncrypt;
    }

    public String getSign() {
        return mSign;
    }

    public void setSign(String sign) {
        mSign = sign;
    }

    public String getTargetUsers() {
        return mTargetUsers;
    }

    public void setTargetUsers(String targetUsers) {
        mTargetUsers = targetUsers;
    }

    public Long getTimeToLive() {
        return mTimeToLive;
    }

    public void setTimeToLive(Long timeToLive) {
        mTimeToLive = timeToLive;
    }

    @Override
    public String toString() {
        return "PushPublishReqDTO{" +
                "mAppKey='" + mAppKey + '\'' +
                ", mCustomMessage='" + mCustomMessage + '\'' +
                ", mIsEncrypt=" + mIsEncrypt +
                ", mSign='" + mSign + '\'' +
                ", mTargetUsers='" + mTargetUsers + '\'' +
                ", mTimeToLive=" + mTimeToLive +
                ", timestamp=" + timestamp +
                '}';
    }
}
