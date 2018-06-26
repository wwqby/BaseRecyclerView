package com.example.baserecyclerview.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baserecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<MyApp> myAppsList=new ArrayList<>();
        myAppsList.add(new MyApp("客户管理", R.drawable.ic_launcher_background, "A"));
        myAppsList.add(new MyApp("报备管理", R.drawable.ic_launcher_background, "a"));
        myAppsList.add(new MyApp("我的业绩", R.drawable.ic_launcher_background, "a"));
        myAppsList.add(new MyApp("工作汇报", R.drawable.ic_launcher_background, "a"));
        myAppsList.add(new MyApp("考勤打卡", R.drawable.ic_launcher_background, "a"));
        myAppsList.add(new MyApp("班车点", R.drawable.ic_launcher_background, "a"));
        myAppsList.add(new MyApp("客户公海", R.drawable.ic_launcher_background, "a"));
        RecyclerView rvMyApp=findViewById(R.id.rv_my_app);
        GridLayoutManager grid = new GridLayoutManager(this, 4);
        rvMyApp.setLayoutManager(grid);
        MyAppAdapter adapter = new MyAppAdapter(myAppsList);
        rvMyApp.setAdapter(adapter);
    }
}
