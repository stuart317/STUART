package com.ber.service;

import com.ber.bean.Book;
import com.ber.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/11/7 14:15
 *
 * @author 朱超
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Book getBookById(int id){
        return bookDao.getBookById(id);
    }

    public int add(Book entity) throws Exception {
        if(entity.getTitle()==null||entity.getTitle().equals("")){
            throw new Exception("书名必须不为空");
        }
        return bookDao.add(entity);
    }

    @Transactional
    public int add(Book entity1,Book entityBak){
        int rows=0;
        rows=bookDao.add(entity1);
        rows=bookDao.add(entityBak);
        return rows;
    }

    public int delete(int id) {
        return bookDao.delete(id);
    }

    /**
     * 多删除
     */
    public int delete(String[] ids){
        int rows=0;
        for (String idStr : ids) {
            int id=Integer.parseInt(idStr);
            rows+=delete(id);
        }
        return rows;
    }

    public int update(Book entity) {
        return bookDao.update(entity);
    }
}
