package com.example.demo.autoConfig;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：判断依据类
 * 创建时间：2018/9/5 19:41
 *
 * @author 朱超
 */
public class HelloService {

    private String msg;

    public String sayHello(){
        return "Hello" + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
