/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author scott
 */
@Document(collection = "sourceCode")
public class SourceCode {
    
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String srcTxt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcTxt() {
        return srcTxt;
    }

    public void setSrcTxt(String srcTxt) {
        this.srcTxt = srcTxt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.srcTxt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SourceCode other = (SourceCode) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.srcTxt, other.srcTxt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SourceCode{" + "id=" + id + ", srcTxt=" + srcTxt + '}';
    }
    
    
}
