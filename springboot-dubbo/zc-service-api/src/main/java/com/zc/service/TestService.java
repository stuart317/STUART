package com.zc.service;


import com.zc.bean.User;

public interface TestService {

    String sayHello(String str);

    User findUser();

    /**
     *  获取 到第 n 位  斐波那契数列
     */
    String getFbnq(int n);
}
