package com.jiyun.demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sd on 2017/8/11.
 */
public class ViewHolders extends RecyclerView.ViewHolder{
       TextView te2;
      TextView te4;
      TextView te3;
      TextView te;

    public ViewHolders(View itemView) {
        super(itemView);
        te=(TextView)itemView.findViewById(R.id.te);
        te2=(TextView)itemView.findViewById(R.id.te2);
        te3=(TextView)itemView.findViewById(R.id.te3);
        te4=(TextView)itemView.findViewById(R.id.te4);

    }
}
