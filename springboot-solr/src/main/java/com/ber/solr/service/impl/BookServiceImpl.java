package com.ber.solr.service.impl;

import com.ber.solr.bean.Books;
import com.ber.solr.bean.BooksExample;
import com.ber.solr.dao.BooksMapper;
import com.ber.solr.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/12/18 11:19
 *
 * @author 朱超
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksMapper booksMapper;

    @Override
    public int selectBookCount(Books books) {

        BooksExample example = new BooksExample();
        BooksExample.Criteria criteria = example.createCriteria();

        if(books !=null){
            if(books.getId()!=null){
                criteria.andIdEqualTo(books.getId());
            }
            //图书名称
            if(StringUtils.isNotBlank(books.getTitle())){
                criteria.andTitleLike("%"+books.getTitle()+"%");
            }
        }
        final int count = booksMapper.countByExample(example);
        return count;
    }
}
