package com.skyline.crawler.mapper;

import com.skyline.crawler.BaseTest;
import com.skyline.crawler.domain.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ArticleMapperTest extends BaseTest {


    @Autowired
    private ArticleDao articleDao;


    @Test
    public void testInsert() {
        Article article = new Article();
        article.setTitle("测试article").setCategory("分类").setContent("上上下下左右左右BABA").setUrl("www.fk.com");
        articleDao.save(article);
    }



}
