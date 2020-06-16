package com.example.e_clothes.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_clothes.R;
import com.example.e_clothes.entities.Article;

import java.io.Serializable;

public class ArticleDetails extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        ImageView imageArticle = (ImageView) findViewById(R.id.slide_images);
        TextView articleName = (TextView) findViewById(R.id.dtls_article_title);
        TextView colors = (TextView) findViewById(R.id.dtls_article_colors);
        TextView price = (TextView) findViewById(R.id.dtls_article_price);
        TextView sizes = (TextView) findViewById(R.id.dtls_article_sizes);
        TextView description = (TextView) findViewById(R.id.dtls_article_desc);

        Intent intent = getIntent();
        Article article = (Article) intent.getSerializableExtra("Article");
        imageArticle.setImageResource(article.getImgId());
        articleName.setText(article.getArticleName());
        colors.setText(article.getArticleColors());
        price.setText(article.getArticlePrice());
        sizes.setText(article.getArticleSize());
        description.setText(article.getDescription());
    }
}
