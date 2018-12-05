package com.nengz.helloworld.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nengz.helloworld.R;

import java.security.PublicKey;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private OnTtemClickListener mlinster;

    public LinearAdapter(Context context,OnTtemClickListener listener){
        this.mContext = context;
        this.mlinster = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if(i == 0) {
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,viewGroup,false));
        }else {
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,viewGroup,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        if(getItemViewType(i) == 0 ){
            ((LinearViewHolder)viewHolder).textview.setText("Hello World!");
        } else {
            ((LinearViewHolder2)viewHolder).textview.setText("znKami");
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"Click "+i,Toast.LENGTH_SHORT).show();
                mlinster.onClick(i);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textview;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends RecyclerView.ViewHolder {

        private TextView textview;
        private ImageView imageView;

        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }

    public interface OnTtemClickListener {
        void onClick(int pos);
    }
}
