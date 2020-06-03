package com.example.e_clothes.ui.articles;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.e_clothes.ArticleDetails;
import com.example.e_clothes.R;

public class ArticlesFragment extends Fragment {

    private ArticlesViewModel homeViewModel;
    Button camera_open_id;
    ImageView click_image_id;
    private static final int pic_id = 123;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(ArticlesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        camera_open_id = root.findViewById(R.id.btn_picture);
        click_image_id = root.findViewById(R.id.taken_image);

        camera_open_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent camera_intent
                        = new Intent(MediaStore
                        .ACTION_IMAGE_CAPTURE);

                startActivityForResult(camera_intent, pic_id);
            }
        });

        Button btnDetails = root.findViewById(R.id.details_btn);

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailsActivity = new Intent(getContext(), ArticleDetails.class);
                startActivity(detailsActivity);
            }
        });

        return root;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap)data.getExtras()
                    .get("data");

            click_image_id.setImageBitmap(photo);
        }
    }
}
