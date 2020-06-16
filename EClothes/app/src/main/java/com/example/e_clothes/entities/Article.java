package com.example.e_clothes.entities;

import java.io.Serializable;

public class Article implements Serializable {

    private String articleName;
    private String articleColors;
    private String articlePrice;
    private String articleSize;
    private String description;
    private int imgId;

    public Article(String articleName, String articleColors, String articlePrice, String articleSize, String description, int imgId) {
        this.articleName = articleName;
        this.articleColors = articleColors;
        this.articlePrice = articlePrice;
        this.articleSize = articleSize;
        this.description = description;
        this.imgId = imgId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleColors() {
        return articleColors;
    }

    public void setArticleColors(String articleColors) {
        this.articleColors = articleColors;
    }

    public String getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(String articlePrice) {
        this.articlePrice = articlePrice;
    }

    public String getArticleSize() {
        return articleSize;
    }

    public void setArticleSize(String articleSize) {
        this.articleSize = articleSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
