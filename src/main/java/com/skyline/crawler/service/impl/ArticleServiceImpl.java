package com.skyline.crawler.service.impl;

import com.skyline.crawler.domain.Article;
import com.skyline.crawler.mapper.ArticleDao;
import com.skyline.crawler.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zhangsw
 * @date ：2022/5/25
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;



    @Override
    public void save(Article article) {
        articleDao.save(article);
    }
}
