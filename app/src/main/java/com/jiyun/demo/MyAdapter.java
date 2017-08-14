package com.jiyun.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sd on 2017/8/11.
 */

public class MyAdapter extends BaseAdapter{

    Context context;
    List<String> list;
    private MyHolder myHolder;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            myHolder = new MyHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.ietm_a, null);
            myHolder.textView = (TextView) convertView.findViewById(R.id.tv1);

            convertView.setTag(myHolder);
        }else {
            myHolder = (MyHolder) convertView.getTag();

        }

        myHolder.textView.setText(list.get(position));

        return convertView;
    }

    class MyHolder{
        TextView textView;

    }
}
