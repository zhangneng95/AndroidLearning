package com.nengz.helloworld.Event;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

//外部类
public class MyClickListener implements View.OnClickListener{

    private Activity mActivity;

    public MyClickListener(Activity activity) {
        mActivity = activity;
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(mActivity,"click...",Toast.LENGTH_LONG).show();
    }
}
