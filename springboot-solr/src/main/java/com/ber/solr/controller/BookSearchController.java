package com.ber.solr.controller;

import com.ber.solr.bean.Books;
import com.ber.solr.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/12/19 16:58
 *
 * @author 朱超
 */
@Controller
@RequestMapping("/query")
public class BookSearchController {

    @Autowired
    private SearchService searchService;

    // ModelAndView 可以支持 @RestController  （相当于 @Controller + @Resp）
    @RequestMapping("/list")
    private ModelAndView  query(@RequestParam(defaultValue = "") String title, ModelAndView model){

        List<Books> booksList = null;
        try {
            booksList = searchService.searchBooks(title, 0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("booksList:>>>>>>>"+booksList.size());

        model.addObject("booklist",booksList);
        model.addObject("test","张飞吃豆芽");
        model.setViewName("/index");
        return model;
    }


    // Model 只支持 @Controller
    @RequestMapping("/list2")
    private String query1(@RequestParam(defaultValue = "") String title, Model model){

        List<Books> booksList = null;
        try {
            booksList = searchService.searchBooks(title, 0, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("booksList:>>>>>>>"+booksList.size());

        model.addAttribute("booklist",booksList);
        model.addAttribute("test","张飞吃豆芽");
        return "index";
    }

}
