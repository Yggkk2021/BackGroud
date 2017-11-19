package com.ysf.ssm.service.impl;

import com.ysf.ssm.dao.ArticleDao;
import com.ysf.ssm.entity.Article;
import com.ysf.ssm.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create by Tars on 2017/11/18
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao acticleDao;

    @Override
    public List<Article> findArticles(Map<String, Object> map) {
        return acticleDao.findArticles( map );
    }

    @Override
    public long getTotalArticles(Map<String, Object> map) {
        return acticleDao.getTotalArticles( map );
    }


    @Override
    public int addArticle(Article article) {
        return acticleDao.addArticle( article );
    }

    @Override
    public int delArticle(String id) {
        return acticleDao.delArticle( id );
    }

    @Override
    public Article findArticleById(String id) {
        return acticleDao.findArticleById( id );
    }
}
