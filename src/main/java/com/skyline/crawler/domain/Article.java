package com.skyline.crawler.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ：zhangsw
 * @date ：2022/5/24
 */
@Data
@Accessors(chain = true)
public class Article {

    private Integer id;

    private String title;

    private String content;

    private String url;

    private String abstractText;

    private String category;

}
