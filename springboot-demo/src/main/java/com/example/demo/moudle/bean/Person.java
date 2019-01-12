package com.example.demo.moudle.bean;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：此类用于在模板中展示 数据用
 * 创建时间：2018/9/5 21:32
 *
 * @author 朱超
 */
public class Person {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
