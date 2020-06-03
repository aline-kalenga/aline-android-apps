package com.example.e_clothes.ui.commandes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommandeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CommandeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("La liste des commandes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}