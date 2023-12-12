package com.example.sqldatabaseapiquizzapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class TableViewModel extends ViewModel {
    Repository repository=new Repository();

    LiveData<Tablelist> tablelistLiveData;

    public TableViewModel() {
        tablelistLiveData =repository.get1();
    }
    public LiveData<Tablelist> getTablelistLiveData(){

        return tablelistLiveData;
    }
}
