package com.ysf.ssm.service;


import java.util.List;
import com.ysf.ssm.entity.Article;

import java.util.Map;

/**
 * Create by Tars on 2017/11/18
 */
public interface ArticleService {
    /**
     * 返回响应的数据集合
     * @param map
     * @return
     */
    public List<Article> findArticles(Map<String,Object> map);

    /**
     * 数据条目
     * @param map
     * @return
     */
    public long getTotalArticles(Map<String,Object> map);

    /**
     * 添加文章
     * @param article
     * @return
     */
    public int addArticle(Article article);

    /**
     * 删除文章
     * @param id
     * @return
     */
    public int delArticle(String id);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public Article findArticleById(String id);
}
