package com.ber.solr.dao;

import com.ber.solr.bean.Books;
import com.ber.solr.bean.BooksExample;

public interface BooksMapper {
    int countByExample(BooksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);
}