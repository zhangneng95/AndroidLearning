package com.nengz.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nengz.helloworld.Event.EventActivity;
import com.nengz.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnEvent,mBtnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this,UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this,DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
