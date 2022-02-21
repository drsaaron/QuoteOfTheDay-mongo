/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author scott
 */
@Document(collection = "qotd")
public class QuoteOfTheDay {
    
    @Id
    private String id;
    
    private String quoteDate;
    private String quoteNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(String quoteDate) {
        this.quoteDate = quoteDate;
    }

    public String getQuoteNum() {
        return quoteNum;
    }

    public void setQuoteNum(String quoteNumber) {
        this.quoteNum = quoteNumber;
    }

    @Override
    public String toString() {
        return "QuoteOfTheDay{" + "id=" + id + ", quoteDate=" + quoteDate + ", quoteNum=" + quoteNum + '}';
    }
    
    
}
