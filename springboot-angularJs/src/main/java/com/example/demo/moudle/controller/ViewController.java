package com.example.demo.moudle.controller;

import com.example.demo.moudle.bean.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/9/26 15:44
 *
 * @author 朱超
 */
@RestController
public class ViewController {

    @RequestMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName){
        return new Person(personName,22,"小雷音寺");
    }
}
