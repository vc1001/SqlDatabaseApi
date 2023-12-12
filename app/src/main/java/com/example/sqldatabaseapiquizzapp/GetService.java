package com.example.sqldatabaseapiquizzapp;


import retrofit2.Call;

import retrofit2.http.GET;

public interface GetService {
        @GET("myquizapi.php")

        Call<Tablelist> getData();

    }


