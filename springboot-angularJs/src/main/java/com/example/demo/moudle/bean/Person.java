package com.example.demo.moudle.bean;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：人模型
 * 创建时间：2018/9/26 15:42
 *
 * @author 朱超
 */
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
