package com.ysf.ssm.entity;

import java.io.Serializable;

/**
 * @author Tars
 */
public class Article implements Serializable {
    private String id;//主键

    private String articleTitle;//文章标题

    private String articleCreateDate;//创建日期

    private String articleContext;//文章内容

    private String addName;//添加者

    @Override
    public String toString() {
        return "ArticleDao{" + "id='" + id + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleCreateDate='" + articleCreateDate + '\'' +
                ", articleContext='" + articleContext + '\'' + ", addName='" + addName + '\'' + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(String articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public String getArticleContext() {
        return articleContext;
    }

    public void setArticleContext(String articleContext) {
        this.articleContext = articleContext;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }
}
