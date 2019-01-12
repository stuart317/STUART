package com.ber.solr.service;

import com.ber.solr.bean.Books;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述: 图书业务层
 * 创建时间：2018/12/18 11:16
 *
 * @author 朱超
 */
public interface BookService {

    /**
     * 获取图书 条数
     * @param books
     * @return
     */
    int selectBookCount(Books books);
}
