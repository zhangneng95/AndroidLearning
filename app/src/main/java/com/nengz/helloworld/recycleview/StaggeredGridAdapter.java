package com.nengz.helloworld.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nengz.helloworld.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnTtemClickListener mlinster;

    public StaggeredGridAdapter(Context context, OnTtemClickListener listener){
        this.mContext = context;
        this.mlinster = listener;
    }

    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_staggered_grid_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(StaggeredGridAdapter.LinearViewHolder viewHolder, final int i) {
        if(i % 2 != 0) {
            viewHolder.imageView.setImageResource(R.drawable.image1);
        }else {
            viewHolder.imageView.setImageResource(R.drawable.image2);
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
    public int getItemCount() {
        return 30;
    }


    class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    public interface OnTtemClickListener {
        void onClick(int pos);
    }
}
