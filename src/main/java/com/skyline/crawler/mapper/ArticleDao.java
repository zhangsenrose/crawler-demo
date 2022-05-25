package com.skyline.crawler.mapper;

import com.skyline.crawler.domain.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：zhangsw
 * @date ：2022/5/24
 */
@Mapper
public interface ArticleDao {

    void save(Article article);
}
