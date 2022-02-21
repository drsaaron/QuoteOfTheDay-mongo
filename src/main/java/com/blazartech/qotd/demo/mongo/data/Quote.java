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
@Document(collection = "quotes")
public class Quote {
    
    @Id
    private String id;
    
    private String srcCde;
    private String quoteTxt;
    private String usable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcCde() {
        return srcCde;
    }

    public void setSrcCde(String srcCde) {
        this.srcCde = srcCde;
    }

    public String getQuoteTxt() {
        return quoteTxt;
    }

    public void setQuoteTxt(String quoteTxt) {
        this.quoteTxt = quoteTxt;
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

    @Override
    public String toString() {
        return "Quote{" + "id=" + id + ", srcCde=" + srcCde + ", quoteTxt=" + quoteTxt + ", usable=" + usable + '}';
    }
    
    
}
