package com.ber.solr.service.impl;

import com.ber.solr.bean.Books;
import com.ber.solr.service.SearchService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/12/18 19:03
 *
 * @author 朱超
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SolrClient solrClient;

    @Override
    public int addIndex(Books books) throws Exception {

        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", books.getId());
        doc.addField("price", books.getPrice());
        doc.addField("title", books.getTitle());

        solrClient.add(doc);
        UpdateResponse commit = solrClient.commit();
        int status = commit.getStatus();
        return status;
    }


    @Override
    public List<Books> searchBooks(String title, int offset, int count) throws Exception{

        List<Books> list = new ArrayList<>();

        //solr的相关配置
        SolrQuery query = new SolrQuery();

        if(StringUtils.isEmpty(title)){ //如果条件为空  查所有
            query.set("q","*:*");
        }else{
            query.set("q","title:"+title); //搜索关键字
        }

        //参数fq, 给query增加过滤查询条件
        query.set("fq","id:[0 TO 9]");//id为0-9

        //参数sort,设置返回结果的排序规则
        query.setSort("id",SolrQuery.ORDER.desc);

        query.setRows(count);
        query.setStart(offset);


        //参数hl,设置高亮
        query.setHighlight(true);
        //设置高亮的字段
        query.addHighlightField("title");
        query.setHighlightSimplePre("<strong style='color:red'>");  //前缀
        query.setHighlightSimplePost("</strong>");  //后缀


        QueryResponse queryResponse = solrClient.query(query);

        //查询结果
        SolrDocumentList docs = queryResponse.getResults();

        //高亮结果
        Map<String, Map<String, List<String>>> highlist = queryResponse.getHighlighting();

        //查询到的条数
        long cnt = docs.getNumFound();
        System.out.println("查询到的条数\t"+cnt);

        //获取查询结果
        for(SolrDocument doc :docs) {
            Books bo = new Books();
            String id = doc.get("id").toString();
            String price = doc.get("price").toString();
            String title1 = "";
            //获取 高亮字段
            if(highlist.containsKey(id) && highlist.get(id).get("title")!=null){
                title1 =highlist.get(id).get("title").get(0);
            }else{
                title1 = doc.get("title").toString();
            }

            System.out.printf("%s:%s:%s\r\n",id,price,title1);

            bo.setId(Integer.parseInt(id));
            bo.setTitle(title1);
            bo.setPrice(new BigDecimal(price));
            list.add(bo);
        }
        return list;
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        solrClient.deleteById(id.toString());

        //需要提交，不提交，就没有删除
        solrClient.commit();
    }

    @Override
    public void deleteByQuery(Books books) throws Exception {

        //只是一个案列
        if(books==null && StringUtils.isEmpty(books.getTitle())){
            return;
        }

        solrClient.deleteByQuery("title:"+books.getTitle());
        //需要提交，不提交，就没有删除
        solrClient.commit();

    }
}
