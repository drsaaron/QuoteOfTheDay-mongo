/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author scott
 */
@ExtendWith(SpringExtension.class)
@DataMongoTest
@PropertySource("classpath:mongo-test.properties")
public class QuoteOfTheDayRepositoryTest {
    
    private static final Logger logger = LoggerFactory.getLogger(QuoteOfTheDayRepositoryTest.class);
    
    @Autowired
    private QuoteOfTheDayRepository instance;
    
    public QuoteOfTheDayRepositoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    private static final String DATE_1 = "2022-02-01";
    private static final String DATE_2 = "2022-02-15";
    private static final String DATE_3 = "2022-02-28";
    
    @BeforeEach
    public void setUp() {
        instance.deleteAll();
        
        QuoteOfTheDay qotd1 = new QuoteOfTheDay();
        qotd1.setQuoteDate(DATE_1);
        qotd1.setQuoteNum("1");
        instance.save(qotd1);
        
        QuoteOfTheDay qotd2 = new QuoteOfTheDay();
        qotd2.setQuoteDate(DATE_2);
        qotd2.setQuoteNum("2");
        instance.save(qotd2);
        
        QuoteOfTheDay qotd3 = new QuoteOfTheDay();
        qotd3.setQuoteDate(DATE_3);
        qotd3.setQuoteNum("3");
        instance.save(qotd3);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findByQuoteDateBetween method, of class QuoteOfTheDayRepository.
     */
    @Test
    public void testFindByQuoteDateBetween() {
        logger.info("findByQuoteDateBetween");
        String startDate = DATE_1;
        String endDate = DATE_3;

        List<QuoteOfTheDay> result = instance.findByQuoteDateBetween(startDate, endDate);
        
        // as this method doesn't handle boundary conditions, there should just be one row
        assertEquals(1, result.size());
    }

    /**
     * Test of findInDateRange method, of class QuoteOfTheDayRepository.
     */
    @Test
    public void testFindInDateRange() {
        logger.info("findInDateRange");
        String startDate = DATE_1;
        String endDate = DATE_3;

        List<QuoteOfTheDay> result = instance.findInDateRange(startDate, endDate);
        
        // as this method does handle boundary, we should get all three.
        assertEquals(3, result.size());
    }
    
}
