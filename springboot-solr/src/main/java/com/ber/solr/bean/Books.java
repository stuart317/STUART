package com.ber.solr.bean;

import org.apache.solr.client.solrj.beans.Field;

import java.math.BigDecimal;
import java.util.Date;

public class Books {

    @Field
    private Integer id;

    @Field
    private String title;

    @Field
    private BigDecimal price;

    @Field
    private Date publishdate;

    @Field
    private Date updatedate;

    public Integer getId() {
        return id;
    }

    public Books() {
    }

    public Books(Integer id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}