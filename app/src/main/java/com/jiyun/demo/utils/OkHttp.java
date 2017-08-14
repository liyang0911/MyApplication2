package com.jiyun.demo.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/6/19.
 */

public class OkHttp {
    private static OkHttp okHttp;
    private final OkHttpClient okHttpClient;

    private OkHttp() {
        okHttpClient = new OkHttpClient.Builder().build();
    }
    public static OkHttp getInstance(){
        if (okHttp==null){
            synchronized (OkHttp.class){
                if (okHttp==null){
                    okHttp = new OkHttp();
                }
            }
        }
        return okHttp;
    }
    public void get(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
