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

public class MainActivity extends AppCompatActivity {
    private EditText etProgramming,etDataStructure,etAlgorithm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findviews();
    }

    private void findviews(){
        etProgramming=(EditText) findViewById(R.id.etProgramming);
        etDataStructure=(EditText) findViewById(R.id.etDataStructure);
        etAlgorithm=(EditText) findViewById(R.id.etAlgorithm);
    }

    private boolean isValid(EditText editText){
        String pattern="1[0]{2}|[0-9]{1,2}";
        String text=editText.getText().toString();
        if(!text.matches(pattern)){
            editText.setError("0~100");
            return false;
        }else{
            return true;
        }
    }

    public void onSubmitClick(View view) {

        boolean valid = isValid(etProgramming) & isValid(etDataStructure) & isValid(etAlgorithm);

        if (!valid) {
            return;
        }

        int programming= Integer.parseInt(etProgramming.getText().toString());
        int dataStructure= Integer.parseInt(etDataStructure.getText().toString());
        int algorithm= Integer.parseInt(etAlgorithm.getText().toString());
        Intent intent = new Intent(this,ResultActivity.class);
        Bundle bundle=new Bundle();

        bundle.putInt("programming",programming);
        bundle.putInt("dataStructure",dataStructure);
        bundle.putInt("algorithm",algorithm);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

