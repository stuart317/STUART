package com.ber.controller;

import com.ber.dto.UserDto;
import com.ber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/11/8 19:18
 *
 * @author 朱超
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @RequestMapping(value = "/userList")
    @ResponseBody
    public List<UserDto> selectUsers(){
        final List<UserDto> userDtos = userService.selectUserList();
        return userDtos;
    }

    @RequestMapping(value = "user/{id}")
    @ResponseBody
    public UserDto getUserById(@PathVariable("id") Integer id){
        final UserDto userById = userService.getUserById(id);
        return userById;
    }
}
