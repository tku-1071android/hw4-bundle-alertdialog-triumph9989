package com.example.a66;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;
import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity{
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        tvResult = findViewById(R.id.tvResult);
        showResults();
    }

    private void showResults(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int programming = bundle.getInt("programming");
        int dataStructure = bundle.getInt("dataStructure");
        int algorithm = bundle.getInt("algorithm");
        int sum = programming + dataStructure + algorithm;
        double average = sum/3.0;

        String text = "programming = " + programming +
                        "\ndataStructure = "  + dataStructure +
                        "\nalgorithm = " + algorithm +
                        "\nsum = " + sum +
                        "\naverage" + nf.format(average);
            tvResult.setText(text);
    }
        public void onBackClick(View view){finish();}

}
