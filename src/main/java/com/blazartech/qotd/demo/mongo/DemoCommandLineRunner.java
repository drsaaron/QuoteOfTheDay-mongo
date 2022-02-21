/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.qotd.demo.mongo;

import com.blazartech.qotd.demo.mongo.data.Quote;
import com.blazartech.qotd.demo.mongo.data.QuoteOfTheDay;
import com.blazartech.qotd.demo.mongo.data.QuoteOfTheDayRepository;
import com.blazartech.qotd.demo.mongo.data.QuoteRepository;
import com.blazartech.qotd.demo.mongo.data.SourceCode;
import com.blazartech.qotd.demo.mongo.data.SourceCodeRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author scott
 */
@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DemoCommandLineRunner.class);
    
    @Autowired
    private SourceCodeRepository sourceCodeRepo;
    
    @Autowired
    private QuoteRepository quoteRepository;
    
    @Autowired
    private QuoteOfTheDayRepository qotdRepository;
    
    private static final String SOURCE_CODE = "620ea464cb7d84e5aaf5011d";
    private static final String START_DATE = "2021-01-01";
    private static final String END_DATE = "2021-05-15";
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public void run(String... args) throws Exception {
        
        logger.info("getting all source codes");
        Iterable<SourceCode> sourceCodeIterable = sourceCodeRepo.findAll();
        List<SourceCode> sourceCodes = new ArrayList<>();
        sourceCodeIterable.forEach(sourceCodes::add); // convert iterable to list, because why not
        sourceCodes.forEach(sc -> logger.info("sourceCode " + sc.toString()));
        
        logger.info("getting quotes for source code " + SOURCE_CODE);
        SourceCode sourceCode = sourceCodeRepo.findById(SOURCE_CODE).get();
        logger.info("source code is " + sourceCode);
        List<Quote> quotes = quoteRepository.findBySrcCde(SOURCE_CODE);
        quotes.forEach(q -> logger.info("quote " + q.toString()));
        
        logger.info("finding quotes of the day between " + START_DATE + " and " + END_DATE);
        Query datesQuery = new Query();
        datesQuery.addCriteria(Criteria.where("quoteDate").gte(START_DATE).lte(END_DATE));
        List<QuoteOfTheDay> qotds = mongoTemplate.find(datesQuery, QuoteOfTheDay.class);
        qotds.forEach(qotd -> logger.info("qotd (query method): " + qotd));
        qotds = qotdRepository.findByQuoteDateBetween(START_DATE, END_DATE);
        qotds.forEach(qotd -> logger.info("qotd (repo method): " + qotd));
        qotds = qotdRepository.findInDateRange(START_DATE, END_DATE);
        qotds.forEach(qotd -> logger.info("qotd (repo + query): " + qotd));
    }
    
}
