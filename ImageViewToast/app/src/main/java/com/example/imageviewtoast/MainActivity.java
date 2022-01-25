package com.example.imageviewtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    test = (ImageView) findViewById(R.id.test);
    test.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"성공입니다.",Toast.LENGTH_SHORT).show();
        }
    });
    }
}