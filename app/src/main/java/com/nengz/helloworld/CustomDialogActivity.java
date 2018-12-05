package com.nengz.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nengz.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog = findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项？").setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        Toast.makeText(CustomDialogActivity.this,"cancle...",Toast.LENGTH_LONG).show();
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmlListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        Toast.makeText(CustomDialogActivity.this,"confirm...",Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
    }
}
