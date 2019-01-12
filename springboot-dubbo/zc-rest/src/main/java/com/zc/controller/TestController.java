package com.zc.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.zc.bean.User;
import com.zc.service.TestService;
import com.zc.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    @Reference
    private TestService testService;

    @RequestMapping("hello")
    public String hello() {
        log.info(">>>进入方法hello"); //测试一下提交
        return testService.sayHello("给你的爱一直很安静！");
    }

    @RequestMapping("user")
    @ResponseBody
    public User user() {
        return testService.findUser();
    }

    //@PathVariable通过获取URL上以模板{}标记的参数。
    @RequestMapping("fbnq/{num}")
    public String getFbnq(@PathVariable(name = "num") String num) {
        log.info("斐波那契 num:"+num);
        if(StringUtils.isNumeric(num)){
            return "请输入数字";
        }
        return testService.getFbnq(Integer.parseInt(num));
    }
}
