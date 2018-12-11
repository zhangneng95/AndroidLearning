package com.nengz.helloworld.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nengz.helloworld.R;

public class AFragment extends Fragment {

    private TextView mTvTitle;
    private Button mBtnChange,mBtnRest,mBtnMessage;
    private BFragment bFragment;
    private IOnMessageClick listener;

    //传递参数 从Activity到Fragment
    public static AFragment newInstance(String title) {
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    public interface  IOnMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        }catch (ClassCastException e) {
            throw new ClassCastException("Activity 必须实现IOnMessageClick 接口");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnRest = view.findViewById(R.id.btn_reset);
        mBtnMessage = view.findViewById(R.id.btn_message);
        //转跳到BFragment
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null) {
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null) {
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();     //返回上一个Fragment的时候，不刷新view
                }else {
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();//addToBackStack返回时，返回到上一个Fragment而不是Activity replace是先销毁后创建view 因此之前view不会被保存
                }
            }
        });
        //改变文字
        mBtnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("我是新文字");
            }
        });
        //从Fragment到Activity传参数
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ((ContainerActivity)getActivity()).setData("你好");    这个方法不推荐
                listener.onClick("你好");

            }
        });


        if(getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }
    }

}
