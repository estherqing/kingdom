package com.esther.code.proxy.dynamicProxy.cglib;

import net.sf.cglib.beans.BeanCopier;

/**
 * @author esther
 * 2018-04-27 15:22
 * $DESCRIPTION}
 */

public class PropertyCopyDemo {
    public static void main(String[] args) {
        //两个对象

        Other other = new Other("test", "1234");

        Myth myth = new Myth();

        System.out.println(other);

        System.out.println(myth);


        //构建BeanCopier,并copy对象的属性值。

        BeanCopier copier = BeanCopier.create(Other.class, Myth.class, false);

        copier.copy(other, myth, null);


        System.out.println(other);

        System.out.println(myth);

    }

    static class Other {

        private String username;

        private String password;

        private int age;


        public String getUsername() {

            return username;

        }


        public void setUsername(String username) {

            this.username = username;

        }


        public String getPassword() {

            return password;

        }


        public void setPassword(String password) {

            this.password = password;

        }


        public Other(String username, String password) {

            super();

            this.username = username;

            this.password = password;

        }


        @Override

        public String toString() {

            return "Other: " + username + ", " + password + ", " + age;

        }


        public int getAge() {

            return age;

        }


        public void setAge(int age) {

            this.age = age;

        }

    }


    static class Myth {

        private String username;

        private String password;

        private String remark;


        public String getUsername() {

            return username;

        }


        public void setUsername(String username) {

            this.username = username;

        }


        public String getPassword() {

            return password;

        }


        public void setPassword(String password) {

            this.password = password;

        }


        @Override

        public String toString() {

            return "Myth: " + username + ", " + password + ", " + remark;

        }


        public void setRemark(String remark) {

            this.remark = remark;

        }


        public String getRemark() {

            return remark;

        }

    }
}
