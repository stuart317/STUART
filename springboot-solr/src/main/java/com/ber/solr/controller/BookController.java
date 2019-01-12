package com.ber.solr.controller;

import com.ber.solr.bean.Books;
import com.ber.solr.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/12/18 11:35
 *
 * @author 朱超
 */
@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/count")
    private int boottest(){
        Books b = new Books();
        b.setTitle("好");
        final int bookCount = bookService.selectBookCount(b);
        System.out.println("bookCount:>>>>>>>"+bookCount);
        return bookCount;
    }
}
