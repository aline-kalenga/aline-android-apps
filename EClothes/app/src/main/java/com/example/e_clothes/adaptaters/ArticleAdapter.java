package com.example.e_clothes.adaptaters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_clothes.R;
import com.example.e_clothes.entities.Article;
import com.example.e_clothes.entities.Panier;
import com.example.e_clothes.services.PanierService;
import com.example.e_clothes.ui.ArticleDetails;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> implements Serializable{

    Context context;
    List<Article> articles;
    List<Article> cartArticles;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View articleItem = layoutInflater.inflate(R.layout.article_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(articleItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ArticleAdapter.ViewHolder holder, final int position) {

        final Article article = articles.get(position);

        holder.articleName.setText(articles.get(position).getArticleName());
        holder.articleImage.setImageResource(articles.get(position).getImgId());
        holder.articlePrice.setText(articles.get(position).getArticlePrice());
        holder.articleDesc.setText(articles.get(position).getDescription());

        holder.cartIcone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+article.getDescription(),Toast.LENGTH_LONG).show();
            }
        });

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ArticleDetails.class);
                intent.putExtra("Article", article);
                context.startActivity(intent);
                //Toast.makeText(view.getContext(),"click on item: "+article.getDescription(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView articleImage;
        public ImageView cartIcone;
        public TextView articleName;
        public TextView articlePrice;
        public TextView articleDesc;
        public Button btnDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            this.articleImage = (ImageView) itemView.findViewById(R.id.article_image);
            this.cartIcone = (ImageView) itemView.findViewById(R.id.cart);
            this.articleName = (TextView) itemView.findViewById(R.id.article_title);
            this.articlePrice = (TextView) itemView.findViewById(R.id.price);
            this.articleDesc = (TextView) itemView.findViewById(R.id.article_desc);
            btnDetails = (Button) itemView.findViewById(R.id.btn_details);
        }
    }
}
