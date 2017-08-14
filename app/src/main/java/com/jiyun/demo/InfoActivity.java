package com.jiyun.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private Toolbar toobar;
    private ListView lv;
    private FrameLayout frame;
    private List<String> stringList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager vp;
    private Adapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initView();
        initData();
        initAdapter();

    }


    private void initAdapter() {

        adapter2 = new Adapter2(getSupportFragmentManager(),fragmentList);
        vp.setAdapter(adapter2);
        MyAdapter adapter = new MyAdapter(InfoActivity.this, stringList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                vp.setCurrentItem(position);

            }
        });

    }

    private void initData() {

        stringList.add("个人简述");
        stringList.add("个人图片");
        stringList.add("更多内容");

        fragmentList.add(new InfoFragment());
        fragmentList.add(new ImageFragment());
        fragmentList.add(new GengduoFragment());

        vp.setCurrentItem(0);
    }

    private void initView() {
        toobar = (Toolbar) findViewById(R.id.toobar);
        MyView myView = new MyView(InfoActivity.this);
        toobar.addView(myView);
        toobar.setTitle("高晓松简介");
        setSupportActionBar(toobar);
        lv = (ListView) findViewById(R.id.lv);
        vp = (ViewPager) findViewById(R.id.vp);

    }
}
