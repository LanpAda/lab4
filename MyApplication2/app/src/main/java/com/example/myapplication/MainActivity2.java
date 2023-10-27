package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {
    private EditText set_drink;
    private RadioGroup rg1,rg2;
    private Button btn_send;
    private  String suger="無糖";
    private  String ice_opt="去冰";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rg1 = findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener((radioGroup, i) ->
        {
            if(i == R.id.radioButton)
            {
                suger ="無糖";
            }
            else if(i == R.id.radioButton2)
            {
                suger ="少糖";
            }
            else if(i == R.id.radioButton3)
            {
                suger ="半糖";
            }
            else if(i == R.id.radioButton4)
            {
                suger ="全糖";
            }
        });
        rg2 = findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener((radioGroup2, i) ->
        {
            if(i == R.id.radioButton5)
            {
                ice_opt ="少冰";
            }
            else if(i == R.id.radioButton6)
            {
                ice_opt ="正常";
            }
            else if(i == R.id.radioButton7)
            {
                ice_opt ="微冰";
            }
            else if(i == R.id.radioButton8)
            {
                ice_opt ="去冰";
            }
        });
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intnet();
            Bundle b = new Bundle();
            b.putString("drink",drink);
            b.putString("suger",suger);
            b.putString("ice",ice_opt);
            i.putExtras(b);
            setResult(Activity.RESULT_OK,i);
            finish();
        });
    }
}