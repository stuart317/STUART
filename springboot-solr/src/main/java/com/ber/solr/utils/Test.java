package com.ber.solr.utils;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/12/19 15:22
 *
 * @author 朱超
 */
public class Test {

    public static void main(String[] args) {

        SolrDocumentList list = new SolrDocumentList();

        SolrDocument doc = new SolrDocument();
        doc.addField("id", 1);
        doc.addField("title", "今天天气很不错");
        doc.addField("price", 12.5);

        SolrDocument doc2 = new SolrDocument();
        doc2.addField("id", 2);
        doc2.addField("title", "明天会更好");
        doc2.addField("price", 20.2);

        list.add(doc);
        list.add(doc2);




    }

}
