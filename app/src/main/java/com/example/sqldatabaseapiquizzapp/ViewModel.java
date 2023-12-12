package com.example.sqldatabaseapiquizzapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    Repository repository;
    public ViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application.getApplicationContext());
    }
    public LiveData<List<Table>> get2(){

        return repository.getMutableLiveData();
    }
}
