/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import java.util.ArrayList;
import java.util.Collection;
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
public class SourceCodeRepositoryTest {
    
    private static final Logger logger = LoggerFactory.getLogger(SourceCodeRepositoryTest.class);
    
    @Autowired
    private SourceCodeRepository instance;
    
    public SourceCodeRepositoryTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        SourceCode sc = new SourceCode();
        sc.setSrcTxt("I am a test");
        instance.save(sc);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testFindAll() {
        Iterable<SourceCode> i = instance.findAll();
        Collection<SourceCode> sourceCodes = new ArrayList<>();
        i.forEach(sourceCodes::add);
        assertFalse(sourceCodes.isEmpty());
        assertEquals(1, sourceCodes.size());
    }
    
}
