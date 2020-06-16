package com.example.e_clothes.adaptaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_clothes.R;
import com.example.e_clothes.entities.Panier;

import java.util.List;

public class PanierAdaptater extends RecyclerView.Adapter<PanierAdaptater.ViewHolder> {

    Context context;
    List<Panier> articles;

    public PanierAdaptater(Context context, List<Panier> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View panierItem = layoutInflater.inflate(R.layout.panier_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(panierItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.articleTitle.setText(articles.get(position).getArticle().getArticleName());
        holder.imageArticle.setImageResource(articles.get(position).getArticle().getImgId());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageArticle;
        public TextView articleTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.articleTitle = (TextView) itemView.findViewById(R.id.p_article_title);
            this.imageArticle = (ImageView) itemView.findViewById(R.id.p_article_image);
        }

    }
}
