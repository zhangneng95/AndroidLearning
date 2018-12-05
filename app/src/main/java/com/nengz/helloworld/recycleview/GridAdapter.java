package com.nengz.helloworld.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nengz.helloworld.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {

    private Context mContext;
    private OnTtemClickListener mlinster;

    public GridAdapter(Context context, OnTtemClickListener listener){
        this.mContext = context;
        this.mlinster = listener;
    }

    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(GridAdapter.LinearViewHolder viewHolder, final int i) {
        viewHolder.textview.setText("Hello World!");
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
        return 80;
    }


    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textview;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnTtemClickListener {
        void onClick(int pos);
    }
}
