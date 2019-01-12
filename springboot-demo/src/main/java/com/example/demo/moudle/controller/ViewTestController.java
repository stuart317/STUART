package com.example.demo.moudle.controller;

import com.example.demo.moudle.bean.Person;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：View测试类
 * 创建时间：2018/9/6 21:50
 *
 * @author 朱超
 */
public class ViewTestController {


    //在控制器中,返回值为字符串 jsonView,他会找Bean的名称为jsonView的视图来渲染。
    public String json(Model model){
        Person single = new Person("黄忠",60);
        model.addAttribute("single",single);
        return "jsonView";
    }


    //定义一个 view的bean，名称为jsonView
    public MappingJackson2JsonView jsonView(){
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        return jsonView;
    }


    //定义  BeanNameViewResolver的bean
    public BeanNameViewResolver beanNameViewResolver(){
        BeanNameViewResolver beanNameViewResolver = new BeanNameViewResolver();
        return beanNameViewResolver;
    }

}
