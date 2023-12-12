package com.example.sqldatabaseapiquizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ViewModel viewmodel;
    ArrayList<Table> questionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        viewmodel = new ViewModelProvider(this).get(ViewModel.class);
        GetQuizdata();
    }

    private void GetQuizdata() {
        viewmodel.get2().observe(this, new Observer<List<Table>>() {
            @Override
            public void onChanged(List<Table> tables) {
                questionArrayList = (ArrayList<Table>) tables;
                display();
            }
        });

    }

    private void display() {
        String abc = "Question";
        textView.setText(abc);
    }
}