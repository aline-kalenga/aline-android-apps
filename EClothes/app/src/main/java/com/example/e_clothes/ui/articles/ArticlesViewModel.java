package com.example.e_clothes.ui.articles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArticlesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ArticlesViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}