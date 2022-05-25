package com.skyline.crawler.controller;

import com.skyline.crawler.service.ArticleCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：zhangsw
 * @date ：2022/5/24
 */
@RestController
@RequestMapping(value = "/article/sina")
public class ArticleCrawlerController {

    @Autowired
    private ArticleCrawlerService articleCrawlerService;


    @GetMapping("/crawler")
    public void crawler() throws Exception {

        articleCrawlerService.crawler();

    }
}
