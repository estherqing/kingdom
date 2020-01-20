package com.esther.springboot;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BasicTest {
    public static void main(String[] args) throws Exception {
      /*  System.out.println(0 | 1);
        System.out.println(0 | 2);
        System.out.println(0 | 4);
        System.out.println(1 | 2);
        System.out.println(1 | 4);
        System.out.println(2 | 4);

        UserSub userSub = UserSub.builder().subCode("subCode")
                .subIp("subIp")
                .imei("11").emmcid("r3")
                .model("132")
                .sysver("232")
                .recState(1)
                .build();
        System.out.println(userSub);
        UserSubByPhone userSubByPhone = new UserSubByPhone();
        BeanPropertyUtils.copyProperties(userSubByPhone, userSub);
        userSubByPhone.setSubPhone("11223");
        userSubByPhone.setSubKey("32535");
        System.out.println(userSubByPhone);
        System.out.println(userSubByPhone.getSubIp()+","+userSubByPhone.getImei());*/
        for (int i = 0; i < 50; i++) {

            Random random=new Random();
          //  System.out.println(random.nextInt(7));
           // System.out.println((int) (Math.random() * 7));
        }


        Set<String> codeSet = new HashSet<>();
        if(!codeSet.contains("key")){
            codeSet.add("key");
            codeSet.add("key1");
        }
        System.out.println(codeSet.toString());
    }
}