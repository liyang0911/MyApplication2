package com.jiyun.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class InfoFragment extends Fragment {


    private RecyclerView rv;
    private List<Student.CardBean> list = new ArrayList<>();

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        initView(view);
        initData();
        initAdapter();
        return view;
    }

    private void initAdapter() {

        InfoAdapter infoAdapter =new InfoAdapter(list,getActivity());
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        rv.setAdapter(infoAdapter);
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
                Student o = gson.fromJson(string, type);

                Log.e("gftysedrftgyhj",o.getCard().toString());
                list.addAll(o.getCard());

            }
        });
    }

    private void initView(View view) {
        rv = (RecyclerView) view.findViewById(R.id.rv);
    }
}
