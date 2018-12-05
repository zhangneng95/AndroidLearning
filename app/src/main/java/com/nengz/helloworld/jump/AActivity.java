package com.nengz.helloworld.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nengz.helloworld.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnJump = findViewById(R.id.jump);
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1        通常用这一种
                Intent intent = new Intent(AActivity.this,BActivity.class);
                //传递数据
                Bundle bundle = new Bundle();
                bundle.putString("name","ZhangNeng");
                bundle.putInt("number",95);
                intent.putExtras(bundle);
//                startActivity(intent);
                //跳转后 返回一些数据 需要重写onActivityResult方法
                startActivityForResult(intent,0);  //0为请求码 区分是由哪个跳转过去的

                //显式跳转2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式跳转3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.nengz.helloworld.jump.BActivity");
//                startActivity(intent);

                //显式跳转4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.nengz.helloworld.jump.BActivity"));
//                startActivity(intent);

                //隐式跳转1
//                Intent intent = new Intent();
//                intent.setAction("com.nengz.jump.BActivity");
//                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {        //接受返回的数据   requsetCode为传过去的请求码 resultCode为返回回来的，如Activity.RESULT_OK
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }
}
