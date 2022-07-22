package com.fanafaire.shoptask.ui.prodUser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProdUserViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProdUserViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is buy fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}