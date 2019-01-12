package com.example.demo.moudle.controller;

import com.example.demo.moudle.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/9/6 21:25
 *
 * @author 朱超
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model){

        Person single = new Person("刘备",60);

        List<Person> people = new ArrayList<>();

        Person p1 = new Person("张飞",57);
        Person p2 = new Person("关羽",53);
        Person p3 = new Person("赵云",50);

        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);

        return "index";
    }
}
