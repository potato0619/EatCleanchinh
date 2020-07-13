package com.example.eatclean2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_thucdon;
    TextView tv_search;
    TextView tv_cacbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_search=findViewById(R.id.tv_tk);
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SeachActivity.class));
            }
        });

        tv_thucdon=findViewById(R.id.tv_thucdon);
        tv_thucdon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ThucdonActivity.class));
            }
        });
        tv_cacbt=findViewById(R.id.tv_cacbt);
        tv_cacbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CacbtActivity.class));
            }
        });
        findViewById(R.id.tv_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,link.class));

            }
        });

    }
}