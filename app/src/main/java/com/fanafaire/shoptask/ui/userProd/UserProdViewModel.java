package com.fanafaire.shoptask.ui.userProd;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProdViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UserProdViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is user prod fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}