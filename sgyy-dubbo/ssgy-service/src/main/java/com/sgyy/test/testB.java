package com.sgyy.test;

import org.springframework.stereotype.Service;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/5/31 15:43
 *
 * @author 朱超
 */
@Service
public class testB implements InterfaceA {
    @Override
    public void test() {
        System.out.println("我是实现类 B----B");
    }
}
