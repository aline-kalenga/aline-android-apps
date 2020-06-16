package com.example.e_clothes.entities;

public class Panier {

   private Article article;

    public Panier(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
