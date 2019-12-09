package com.esther.code;

import com.esther.code.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author esther
 * 2018-06-07 17:24
 * $DESCRIPTION}
 */

public class MyTest {

    public static void main(String[] args) {
        int ii=1/0;
        Thread.dumpStack();

        User user;
        List<User> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            user=new User(i,"rose"+i);
            list.add(user);
        }
        list.stream().forEach(u->{
            switch (u.getUserRealName()){
                case "rose1":
                    System.out.println("rose1");
                    break;
                case "rose2":
                    System.out.println("rose2");
                    break;
                    default:
            }
        });
    }
}
