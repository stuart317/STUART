package com.ber.solr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ber.solr.dao")
public class SolrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolrApplication.class, args);
    }

}

