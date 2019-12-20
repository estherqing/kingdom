package com.esther.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "user_sub_mail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSubByMail extends UserSub implements Serializable {
    private String mailNo;

    private String cpCode;
}
