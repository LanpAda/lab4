package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_meal;
    private Button btn_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_meal = findViewById(R.id.tv_meal);
        btn_select = findViewById(R.id.button);
        btn_select.setOnClickListener(view ->
        {
            mStartForResult.launch(
                new Intent(this, MainActivity2.class)
            );
        });
    }

    private final ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->
            {
                if(result.getResultCode()== RESULT_OK)
                {
                    Intent intent = result.getData();
                    if(intent != null && intent.getExtras() != null)
                    {
                        Bundle b = intent.getExtras();
                        String str1 = b.getString("drink");
                        String str2 = b.getString("suger");
                        String str3 = b.getString("ice");
                        tv_meal.setText(String.format("%s\n\n%s\n\n%s",str1,str2,str3));
                    }
                }
            });
}