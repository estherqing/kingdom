package com.esther.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "user_sub")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSub implements Serializable {
    @Id
    private String subCode;

    private String imei;

    private String emmcid;

    private String model;

    private String sysver;

    private String subIp;

    /**
     * 订阅状态 见SubRecordState类
     */
    private Integer recState;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date modifyTime;

}
