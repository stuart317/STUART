package com.ber.dao;

import com.ber.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述： 图书数据访问接口
 * 创建时间：2018/11/7 11:36
 *
 * @author 朱超
 */
public interface BookDao {
    /**
     * 获得所有图书
     */
    List<Book> getAllBooks();
    /**
     * 根据图书编号获得图书对象
     */
    Book getBookById(@Param("id") int id);
    /**
     * 添加图书
     */
    int add(Book entity);
    /**
     * 根据图书编号删除图书
     */
    int delete(int id);
    /**
     * 更新图书
     */
    int update(Book entity);
}
