package com.jiyun.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jiyun.demo.utils.OkHttp;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class GengduoFragment extends Fragment {


    private WebView wv;
    private List<String> strings = new ArrayList<>();
 String    url ;
    public GengduoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gengduo, container, false);

        initView(view);
        initData();

        return view;
    }

    private void initData() {
        OkHttp.getInstance().get("http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%AB%98%E6%99%93%E6%9D%BE&bk_length=600", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();

                Gson gson = new Gson();

                Type type = new TypeToken<Student>() {
                }.getType();

                Student stu = gson.fromJson(string, type);
                Log.e("!@#$",stu.getWapUrl());
                url = stu.getWapUrl();
                wv.loadUrl(url);
            }
        });
    }

    private void initView(View view) {
        wv = (WebView) view.findViewById(R.id.wv);
    }
}
