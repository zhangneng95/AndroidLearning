package com.nengz.helloworld.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nengz.helloworld.R;

public class ContainerActivity extends AppCompatActivity {

    private AFragment aFragment;
//    private BFragment bFragment;
//    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
//        mBtnChange = findViewById(R.id.btn_change);
//        mBtnChange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(bFragment == null) {
//                    bFragment = new BFragment();
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
//            }
//        });

        //实例化AFragment
        aFragment = AFragment.newInstance("我是参数");
        //aFragment添加到Activity中,记得要用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment,"a").commitAllowingStateLoss();  //给aFragment加了一个a的标识
    }
}
