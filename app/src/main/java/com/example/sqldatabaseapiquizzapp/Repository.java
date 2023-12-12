package com.example.sqldatabaseapiquizzapp;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    GetService getServicedata;


    public LiveData<Tablelist> get1() {
        MutableLiveData<Tablelist> data = new MutableLiveData<>();
        getServicedata =RetrofitInstance.getService();

        Call<Tablelist> response = getServicedata.getData();

        response.enqueue(new Callback<Tablelist>() {
            @Override
            public void onResponse(Call<Tablelist> call, Response<Tablelist> response) {


                Tablelist questionList = response.body();

                data.setValue(questionList);


            }

            @Override
            public void onFailure(Call<Tablelist> call, Throwable t) {

            }
        });

        return data;


    }
}


