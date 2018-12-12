package com.nengz.helloworld.Event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nengz.helloworld.R;


//给同一个事件源设置同种类监听器的时候 系统会响应最后一个监听器  布局（视图）文件中的监听器 默认为最先注册
public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        //内部类实现
        mBtnEvent.setOnClickListener(new OnClick());
        //匿名内部类
        mBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventActivity.this,"click 匿名内部类",Toast.LENGTH_LONG).show();
            }
        });
        ///通过事件源所在类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);
        //通过外部类实现 (不常用)
//        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    //通过事件源所在类(内部类)实现  这个类（即EventActiviry）需要实现OnClickListener的接口
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                Toast.makeText(EventActivity.this, "click 内部类", Toast.LENGTH_LONG).show();
                break;
        }
    }

    //通过内部类实现
    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_event:
                    Toast.makeText(EventActivity.this,"click...",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    //在视图文件中 声明android:onClick="show" 并且方法名一致（都为show）
    public void show(View v){
        switch (v.getId()) {
            case R.id.btn_event:
                Toast.makeText(EventActivity.this, "click布局", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
