package com.sgyy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/5/31 15:45
 *
 * @author 朱超
 */
public class testMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring/*.xml" });



        InterfaceA a = new testB();
        a.test();

    }
}
