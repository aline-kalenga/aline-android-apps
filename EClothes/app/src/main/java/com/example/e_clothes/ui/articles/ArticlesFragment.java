package com.example.e_clothes.ui.articles;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_clothes.R;
import com.example.e_clothes.adaptaters.ArticleAdapter;
import com.example.e_clothes.entities.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArticlesFragment extends Fragment {

    View view;
    private RecyclerView articlesRecyclerView;
    private List<Article> articleList;

    public ArticlesFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);
        articlesRecyclerView = (RecyclerView) view.findViewById(R.id.articles_recyclerview);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            ArticleAdapter articleAdapter = new ArticleAdapter(getContext(), articleList);
            articlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            articlesRecyclerView.setAdapter(articleAdapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        articleList = new ArrayList<>();
        addItemsFromJSON();

    }

    private void addItemsFromJSON() {
        try {

            String jsonDataString = readJSONDataFromFile();
            JSONArray jsonArray = new JSONArray(jsonDataString);
            Resources resources = getContext().getResources();

            for (int i=0; i<jsonArray.length(); ++i) {

                JSONObject itemObj = jsonArray.getJSONObject(i);

                String name = itemObj.getString("name");
                String price = itemObj.getString("price");
                String size = itemObj.getString("size");

                String imgName = itemObj.getString("imgName");
                final int resourceId = resources.getIdentifier(imgName, "drawable", getContext().getPackageName());


                String description = itemObj.getString("description");
                String colors = "Rouge, Bleu, Vert, Noir";

                Article article = new Article(name, colors, price, size,  description, resourceId);
                articleList.add(article);
            }

        } catch (IOException | JSONException e) {
            Log.d(String.valueOf(getContext()), "addItemsFromJSON: ", e);
        }
    }


    private String readJSONDataFromFile() throws IOException {

        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {

            String jsonString = null;
            inputStream = getContext().getAssets().open("articles.json");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));

            while ((jsonString = bufferedReader.readLine()) != null) {
                builder.append(jsonString);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return new String(builder);
    }
}
