package com.example.e_clothes.entities;

public class Commande {

    private Article article;

    public Commande(Article article) {
        this.article = article;
    }

    public Article getArticle() {
        return article;
    }
}
