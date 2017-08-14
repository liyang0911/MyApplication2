package com.jiyun.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by sd on 2017/8/11.
 */
public class InfoAdapter extends RecyclerView.Adapter<ViewHolders>{
    List<Student.CardBean> list ;
    Context context;

    public InfoAdapter(List<Student.CardBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.mi,null);
        ViewHolders vh=new ViewHolders(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
        holder.te.setText(list.get(position).getName());
        holder.te2.setText(list.get(position).getKey());
        holder.te3.setText(list.get(position).getValue()+"");
        holder.te4.setText(list.get(position).getFormat()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
