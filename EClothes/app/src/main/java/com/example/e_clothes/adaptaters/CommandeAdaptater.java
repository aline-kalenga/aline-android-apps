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
import com.example.e_clothes.entities.Commande;

import java.util.List;

public class CommandeAdaptater extends RecyclerView.Adapter<CommandeAdaptater.ViewHolder> {

    Context context;
    List<Commande> commandes;

    public CommandeAdaptater(Context context, List<Commande> commandes) {
        this.context = context;
        this.commandes = commandes;
    }

    @NonNull
    @Override
    public CommandeAdaptater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View panierItem = layoutInflater.inflate(R.layout.commande_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(panierItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommandeAdaptater.ViewHolder holder, int position) {

        holder.articleTitle.setText(commandes.get(position).getArticle().getArticleName());
        holder.imageArticle.setImageResource(commandes.get(position).getArticle().getImgId());

    }


    @Override
    public int getItemCount() {
        return commandes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageArticle;
        public TextView articleTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.articleTitle = (TextView) itemView.findViewById(R.id.c_article_title);
            this.imageArticle = (ImageView) itemView.findViewById(R.id.c_article_image);
        }

    }
}
