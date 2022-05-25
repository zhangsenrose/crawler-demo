package com.skyline.crawler.service.impl;

import com.skyline.crawler.config.ArticleCrawler;
import com.skyline.crawler.mapper.ArticleDao;
import com.skyline.crawler.service.ArticleCrawlerService;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zhangsw
 * @date ：2022/5/24
 */
@Service
@Slf4j
public class ArticleCrawlerServiceImpl implements ArticleCrawlerService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void crawler() throws Exception {

        //本地存储位置（本实例未用到，但是这个是一定要配置的）
        String crawlStorageFolder = "/data/crawl/root";
        //爬虫线程数
        int numberOfCrawlers = 3;
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);

        //爬虫的一些基本配置
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        controller.addSeed("http://blog.sina.com.cn/lm/baby/");

        CrawlController.WebCrawlerFactory<ArticleCrawler> factory = ArticleCrawler::new;

        controller.start(factory, numberOfCrawlers);

    }
}
