package com.qs.test.model;

import java.util.Date;

/**
 * Created by QinYupeng on 2017/7/2.
 */
public class UserModel {
    private String userName;
    private int age;
    private Date birth;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
