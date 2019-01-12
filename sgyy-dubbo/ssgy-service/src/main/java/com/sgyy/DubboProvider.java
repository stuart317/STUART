package com.sgyy;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/4/28 15:37
 *
 * @author 朱超
 */
@Service
public class DubboProvider {

    public static void main(String[] args) {
        try {
            /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
            context.start();
            System.out.println("服务启动成功!");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (DubboProvider.class) {
            while (true) {
                try {
                    DubboProvider.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
