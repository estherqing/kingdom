package com.esther.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;

    private String name;

    private String uclass;

    private String email;

    private Date birthday;

    private int age;

    private int dataStatus;

    private List<Book> bookList;
}
