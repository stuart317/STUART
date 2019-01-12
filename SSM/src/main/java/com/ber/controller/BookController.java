package com.ber.controller;


import com.ber.bean.Book;
import com.ber.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/book")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    // 图书列表
    @RequestMapping(value = "/listbook",method= RequestMethod.GET)
    public String ListBook(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("books", bookService.getAllBooks());
        return "ListBook";
    }

    @RequestMapping(value = "/{id}",produces = "application/json; charset=utf-8",method= RequestMethod.GET)
    @ResponseBody
    public Book getBookById(@PathVariable(value = "id") Integer id) {
        log.info("---------------|||||||| "+id);
        Book bookById = bookService.getBookById(id);
        return bookById;
    }

    // 删除图书
    @RequestMapping(value = "/delete",method= RequestMethod.GET)
    public String Delete(HttpServletRequest request, @RequestParam("id") Integer id) {
        request.setAttribute("message", bookService.delete(id) > 0 ? "删除成功！" : "删除失败！");
        request.setAttribute("books", bookService.getAllBooks());
        return "ListBook";
    }

    // 多删除图书
    @RequestMapping(value = "/deletes",method= RequestMethod.POST)
    public String Deletes(HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("ids");
        if (ids!=null&&ids.length > 0) {
            request.setAttribute("message", bookService.delete(ids) > 0 ? "删除成功！" : "删除失败！");
        } else {
            request.setAttribute("message", "请选择删除项！");
        }
        request.setAttribute("books", bookService.getAllBooks());
        return "ListBook";
    }

    // 添加图书
    @RequestMapping(value = "/addbook",method= RequestMethod.GET)
    public String AddBook(HttpServletRequest request, HttpServletResponse response) {
        return "AddBook";
    }

    // 保存添加图书
    @RequestMapping(value = "/addbookpost",method= RequestMethod.POST)
    public String AddBookPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String title = request.getParameter("title");
            double price = Double.parseDouble(request.getParameter("price"));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date publishDate = simpleDateFormat.parse(request.getParameter("publishDate"));

            Book entity = new Book(0, title, price, publishDate);
            if (bookService.add(entity) > 0) {
                request.setAttribute("model", new Book());
                request.setAttribute("message", "添加成功！");
            } else {
                request.setAttribute("model", entity);
                request.setAttribute("message", "添加失败！");
            }
        } catch (Exception exp) {
            request.setAttribute("message", exp.getMessage());
            exp.printStackTrace();
        }
        return "AddBook";
    }

    //编辑图书
    @RequestMapping(value = "/editbook",method= RequestMethod.GET)
    public String EditBook(HttpServletRequest request, @RequestParam("id") Integer id) {
        Book model=bookService.getBookById(id);
        log.info("------------request id : "+id);
        request.setAttribute("model", model);
        return "EditBook";
    }

    // 保存编辑图书
    @RequestMapping(value = "/editbookpost")
    public String EditBookPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id=Integer.parseInt(request.getParameter("id"));

            String title = request.getParameter("title");
            double price = Double.parseDouble(request.getParameter("price"));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date publishDate = simpleDateFormat.parse(request.getParameter("publishDate"));

            Book entity = new Book(id, title, price, publishDate);
            request.setAttribute("message", bookService.update(entity) > 0 ? "更新成功！" : "更新失败！");
            request.setAttribute("model", entity);
        } catch (Exception exp) {
            request.setAttribute("message", exp.getMessage());
            exp.printStackTrace();
        }
        return "EditBook";
    }

}
