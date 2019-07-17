package com.aisino.invoice.test;

/**
 * 
 *java 博客实体
 *
 * @date   2017年8月24日
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class JavaBokeModel {

    //标题
    private String title;
    
    //链接地址
    private String linke;
    
    //作者
    private String author;
    
    //作者主页地址
    private String authorUrl;
    
    //简介
    private String summary;

    
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinke() {
        return linke;
    }

    public void setLinke(String linke) {
        this.linke = linke;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }
    
    
}