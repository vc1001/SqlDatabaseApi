package com.example.sqldatabaseapiquizzapp;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    Context context;
    ArrayList<Table> questionArrayList=new ArrayList<>();
    MutableLiveData<List<Table>> mutableLiveData =new MutableLiveData<>();
    public Repository(Context context) {
        this.context = context;
    }
    public MutableLiveData<List<Table>> getMutableLiveData(){
        GetService getCountryDataService = RetrofitInstance.getService();
        Call<Tablelist> call = getCountryDataService.getData();
      call.enqueue(new Callback<Tablelist>() {
          @Override
          public void onResponse(Call<Tablelist> call, Response<Tablelist> response) {
              if(response.isSuccessful());
              Tablelist tablelist=response.body();
              if(tablelist!=null && tablelist.getArrayList()!=null){
                  questionArrayList = tablelist.getArrayList();
                  mutableLiveData.setValue(questionArrayList);
              }else{

              }

          }

          @Override
          public void onFailure(Call<Tablelist> call, Throwable t) {
              Toast.makeText(context, "no data", Toast.LENGTH_SHORT).show();


          }
      });

        return mutableLiveData;
    }

    }
