package com.ber.solr;

import com.ber.solr.bean.Books;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrApplicationTests {


    @Autowired
    private SolrClient client;

    @Test
    public void contextLoads() {

        try {
            //创建索引
            SolrInputDocument solrInputFields=new SolrInputDocument();
            solrInputFields.addField("id", "1");
            solrInputFields.addField("title", "张飞吃豆芽");
            solrInputFields.addField("price", "0.5");
            client.add(solrInputFields);
            client.commit();


            //基于实体类创建索引   -- solr不支持 BigDecimal
           /* List<Books> books=new ArrayList<Books>();
            books.add(new Books(2,"关羽单刀赴会",new BigDecimal("12")));
            books.add(new Books(3,"刘备大混子",new BigDecimal("0.6")));
            client.addBeans(books);
            client.commit();*/


            //查询第一种方式
            ModifiableSolrParams params =new ModifiableSolrParams();
            params.add("q","title:关羽");
            params.add("ws","json");
            params.add("start","0");
            params.add("rows","10");
            QueryResponse queryResponse=client.query(params);
            System.out.println("查询第一种方式>:"+queryResponse);


            //查询第二种方式
            int page = 1;
            int rows = 10;

            SolrQuery solrQuery = new SolrQuery(); // 构造搜索条件
            solrQuery.setQuery("title:张飞");// 搜索关键词
            // 设置分页
            solrQuery.setStart((Math.max(page, 1) - 1) * rows);
            solrQuery.setRows(rows);
            QueryResponse  docs = client.query(solrQuery);
            SolrDocumentList solrDocuments=docs.getResults();
            System.out.println("查询第二种方式:>>>");
            for(SolrDocument sd : solrDocuments){
                System.out.println(sd.get("id")+"#  "+sd.get("title")+"# "+sd.get("price"));
            }


            //List<User> userList=docs.getBeans(User.class);//直接转实体(!这个B有问题，只有用上面的循环赋值比较靠谱)


            //删除索引
          /*  client.deleteByQuery("id:1");
            client.commit();*/

            //通过版本号删除索引
          /*  client.deleteById("123123");
            client.commit();*/

        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

