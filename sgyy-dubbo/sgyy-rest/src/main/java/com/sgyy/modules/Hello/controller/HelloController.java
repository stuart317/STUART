package com.sgyy.modules.Hello.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sgyy.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/4/28 16:26
 *
 * @author 朱超
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Reference
    private HelloService helloService;

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String hello(@PathVariable("id") String id) throws Exception {
        log.info("--------------打印日志[HelloController.hello]-----:"+id);
        String str = helloService.sayHello("东方明珠！ 哈哈哈哈-----！"+id);
        return str;
    }


}
