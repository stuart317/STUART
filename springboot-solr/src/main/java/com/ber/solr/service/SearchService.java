package com.ber.solr.service;

import com.ber.solr.bean.Books;

import java.io.IOException;
import java.util.List;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：搜索
 * 创建时间：2018/12/18 18:54
 *
 * @author 朱超
 */
public interface SearchService {

    /**
     * 添加索引
     * @return
     */
    int addIndex(Books books) throws Exception;

    /**
     * @param title 搜索关键字
     * @param offset   分页开始条数
     * @param count    分页结束条数
     * @return
     */
    List<Books> searchBooks(String title, int offset, int count) throws Exception;


    /**
     * 通过id来删除数据
     * @throws Exception
     * @throws IOException
     */
    void deleteById(Integer id) throws Exception;

    /**
     * 通过查询条件来删除
     * @throws Exception
     * @throws IOException
     */
    void deleteByQuery(Books books) throws Exception;




}
