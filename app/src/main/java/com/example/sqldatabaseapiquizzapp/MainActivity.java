package com.example.sqldatabaseapiquizzapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sqldatabaseapiquizzapp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TableViewModel viewmodel;
    ActivityMainBinding binding;

    List<Table> tableList;

    static int result = 0;
    static int totalQuestions = 0;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewmodel = new ViewModelProvider(this).get(TableViewModel.class);
        result = 0;

        totalQuestions = 0;

        DisplayFirstQuestion();
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shownextquestion();
            }
        });
    }


    private void DisplayFirstQuestion() {
        viewmodel.getTablelistLiveData().observe(this, new Observer<List<Table>>() {
            @Override
            public void onChanged(List<Table> tables) {
                tableList = tables;


                binding.txtQuestion.setText("Question 1:" + tables.get(0).getQuestion());
                binding.radio1.setText(tables.get(0).getOption1());
                binding.radio2.setText(tables.get(0).getOption2());
                binding.radio3.setText(tables.get(0).getOption3());
                binding.radio4.setText(tables.get(0).getOption4());

            }
        });

    }

    private void Shownextquestion() {
        if (binding.btnNext.getText().toString().equals("Done")) {

            Intent intent = new Intent(MainActivity.this, Result.class);
            startActivity(intent);
            finish();
        }
        int selectedoption = binding.radioGroup.getCheckedRadioButtonId();
        if (selectedoption != -1) {
            RadioButton radioButton = findViewById(selectedoption);
            if (tableList.size() - 1 > 0) {
                totalQuestions = tableList.size();
                if (radioButton.getText().toString().equals((tableList.get(i).getCorrectOption()))) {
                    result++;
                    binding.txtResult.setText(String.valueOf(result));
                }
                if (i == 0) {
                    i++;
                }
                binding.txtQuestion.setText(String.format("Question" + ((i + 1)) + ":" + tableList.get(i).getQuestion()));
                binding.radio1.setText(tableList.get(i).getOption1());
                binding.radio2.setText(tableList.get(i).getOption2());
                binding.radio3.setText(tableList.get(i).getOption3());
                binding.radio4.setText(tableList.get(i).getOption4());
                if (i == (tableList.size() - 1)) {
                    binding.btnNext.setText("Done");
                }
                binding.radioGroup.clearCheck();
                i++;


            }

        } else {
            Toast.makeText(this, "please select answer", Toast.LENGTH_SHORT).show();
        }
    }
}





