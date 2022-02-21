/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author scott
 */
@Repository
public interface QuoteRepository extends CrudRepository<Quote, String> {
    
    public List<Quote> findBySrcCde(String srcCde);
}
