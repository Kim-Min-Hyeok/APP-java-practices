package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_save; //EditText의 id 지정할 변수 선언
    String shared = "file"; //저장할 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText) findViewById(R.id.et_save); //EditText의 id 지정

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0); // // mode 0으로 shared를 저장할 SharedPreferences 변수 선언
        String value = sharedPreferences.getString("min",""); //sharedPreferences로 값을 받아오는 것이므로 별명값:"min", 받아오는 값:""로 지정
        et_save.setText(value); //앱이 실행 될 때 저장된 값(value)로 text 세팅

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);  // mode 0으로 shared를 저장할 SharedPreferences 변수 선언
        SharedPreferences.Editor editor = sharedPreferences.edit(); //저장된 값을 받아줄 Editor함수 선언
        String value = et_save.getText().toString(); //EditText에 있는 값을 String으로 저장
        editor.putString("min",value); //editor에 얻은 String값 저장
        editor.commit(); //커밋
    }
}