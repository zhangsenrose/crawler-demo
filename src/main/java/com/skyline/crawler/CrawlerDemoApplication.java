package com.skyline.crawler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.skyline.crawler.mapper*"})
public class CrawlerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerDemoApplication.class, args);
    }

}
