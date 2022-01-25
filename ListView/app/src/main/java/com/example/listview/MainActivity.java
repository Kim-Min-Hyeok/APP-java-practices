 package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    private ListView list; //ListView 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);//list에 ListView id 설정

        List<String> data = new ArrayList<>();//String 데이터를 받는 ArrayList선언

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        //ArrayList와 ListView를 연결할 ArrayAdapter생성
        list.setAdapter(adapter);//ArrayAdapter에 ListView연결

        data.add("김민혁");
        data.add("안드로이드");
        data.add("사과");//데이터 추가
        adapter.notifyDataSetChanged();//데이터 저장
    }
}