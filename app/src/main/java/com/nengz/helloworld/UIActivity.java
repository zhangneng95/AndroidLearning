package com.nengz.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nengz.helloworld.jump.AActivity;
import com.nengz.helloworld.recycleview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnRv;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCoustomDialog;
    private Button mBtnPopupWindow;
    private Button mBtnLifeCycle;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView=(Button)findViewById(R.id.btn_textview);
        mBtnButton = (Button)findViewById(R.id.btn_button);
        mBtnEditText = (Button)findViewById(R.id.btn_edittext);
        mBtnRadioButton = (Button)findViewById(R.id.btn_radiobutton);
        mBtnCheckBox = (Button)findViewById(R.id.btn_checkbox);
        mBtnImageView = (Button)findViewById(R.id.btn_imageview);
        mBtnRv = findViewById(R.id.btn_recyclerview);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress = findViewById(R.id.btn_progress);
        mBtnCoustomDialog = findViewById(R.id.btn_customdialog);
        mBtnPopupWindow = findViewById(R.id.btn_popupwindow);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnRv.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCoustomDialog.setOnClickListener(onClick);
        mBtnPopupWindow.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_textview:
                    //跳转到TextView演示界面
                    intent  = new Intent(UIActivity.this,TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    //跳转到Button演示界面
                    intent  = new Intent(UIActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    //跳转到EditText演示界面
                    intent  = new Intent(UIActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    //跳转到RadioButton演示界面
                    intent  = new Intent(UIActivity.this,RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    //跳转到CheckBox演示界面
                    intent  = new Intent(UIActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    //跳转到ImageView演示界面
                    intent  = new Intent(UIActivity.this,ImageViewActivity.class);
                    break;
                case R.id.btn_recyclerview:
                    //跳转到RecyclerView演示界面
                    intent  = new Intent(UIActivity.this,RecyclerViewActivity.class);
                    break;
                case R.id.btn_webview:
                    //跳转到WebView演示界面
                    intent  = new Intent(UIActivity.this,WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //跳转到Toast演示界面
                    intent  = new Intent(UIActivity.this,ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    //跳转到Dialog演示界面
                    intent  = new Intent(UIActivity.this,DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    //跳转到Progress演示界面
                    intent  = new Intent(UIActivity.this,ProgressActivity.class);
                    break;
                case R.id.btn_customdialog:
                    //跳转到CustomDialog演示界面
                    intent  = new Intent(UIActivity.this,CustomDialogActivity.class);
                    break;
                case R.id.btn_popupwindow:
                    //跳转到PopupWindow演示界面
                    intent  = new Intent(UIActivity.this,PopupWindowActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    //跳转到LifeCycle演示界面
                    intent  = new Intent(UIActivity.this,LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    //跳转到AActivity演示界面
                    intent  = new Intent(UIActivity.this,AActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
