/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.qotd.demo.mongo.data;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author scott
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.blazartech.qotd.demo.mongo.data")
public class MongoConfiguration extends AbstractMongoClientConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MongoConfiguration.class);
    
    @Value("${demo.databaseName}")
    private String databaseName;
    
    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
    
    @Value("${demo.host}")
    private String hostName;
    
    @Value("${demo.port}")
    private int port;
    
    @Override
    public MongoClient mongoClient() {
        logger.info("creating mongo client");
        String url = "mongodb://" + hostName + ":" + port + "/" + databaseName + "?retryWrites=true";
        return MongoClients.create(url);
    }
    
}
