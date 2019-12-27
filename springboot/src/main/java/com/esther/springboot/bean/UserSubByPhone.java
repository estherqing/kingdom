package com.esther.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


//@Document(collection = "user_sub_phone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSubByPhone extends UserSub implements Serializable {
    private String subKey;

    private String subPhone;
}
