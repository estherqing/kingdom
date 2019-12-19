package com.esther.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSubByMail extends UserSub implements Serializable {
    private String mailNo;

    private String cpCode;
}
