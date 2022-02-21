/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author scott
 */
@Repository
public interface QuoteOfTheDayRepository extends CrudRepository<QuoteOfTheDay, String> {
    
    public List<QuoteOfTheDay> findByQuoteDateBetween(String startDate, String endDate); // uses gt adn lt, not gte or lte so doesn't handle boundary
    
    @Query("{quoteDate: { $gte: ?0, $lte: ?1 }}")
    public List<QuoteOfTheDay> findInDateRange(String startDate, String endDate);
}
