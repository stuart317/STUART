package com.zc.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.zc.bean.User;
import com.zc.service.TestService;
import com.zc.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

//暴露服务
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String str) {
        if(StringUtils.isEmtry(str)){
            return "怎么能为空呢";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()) + ": " + str;
    }

    @Override
    public User findUser() {
        User user = new User();
        user.setId(1001);
        user.setUsername("scott");
        user.setPassword("tiger");
        user.setAge(20);
        user.setGender(0);
        return user;
    }

    @Override
    public String getFbnq(int n) {

        if(n<1){
            return "请输入正整数";
        }

        StringBuilder b = new StringBuilder();
        for (int j = 1; j <= n; j++) {
            b.append(getFibo(j)).append("\t\t\t");
            if (j % 5 == 0)
                b.append("\n");
        }
        return b.toString();
    }


    // 斐波那契额数列   递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2)
            return 1;
        else
            return getFibo(i - 1) + getFibo(i - 2);
    }
}
