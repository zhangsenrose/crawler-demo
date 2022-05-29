package com.skyline.crawler.config;

import com.skyline.crawler.domain.Article;
import com.skyline.crawler.service.ArticleService;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.commons.lang3.ObjectUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author ：zhangsw
 * @date ：2022/5/24
 */
public class ArticleCrawler extends WebCrawler {


    private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$");





    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        if(IMAGE_EXTENSIONS.matcher(href).matches()){
            return false;
        }
        //遍历条件： 只有Url是以下打头的才爬取
        return href.startsWith("http://blog.sina.com.cn/s/blog");
    }

    @Override
    public void visit(Page page) {

        String url = page.getWebURL().getURL();

        System.out.println(url);

        /*if(page.getParseData() instanceof HtmlParseData){

            Article article = getArticleByParseDoc(url, "育儿");

            if (ObjectUtils.isNotEmpty(article.getTitle()) &&
                    ObjectUtils.isNotEmpty(article.getTitle()) && ObjectUtils.isNotEmpty(article.getContent())) {

                ArticleService articleService;articleService = (ArticleService) SpringUtil.getBean("articleService");

                articleService.save(article);
            }
        }*/
    }



    public Article getArticleByParseDoc(String url, String category){
        Article article = new Article();
        Document doc = null;
        try{
            doc = Jsoup.connect(url).get();

        }catch(IOException e){
            e.printStackTrace();
        }

        String title = doc.select("#articlebody > div.articalTitle h2").text();
        String content = doc.select("#sina_keyword_ad_area2").text();

        article.setTitle(title);
        article.setContent(content);
        article.setUrl(url);
        article.setCategory(category);

        return article;
    }
}
