package com.yanggeapp.yangge.Me.Follow;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.List;

public class FollowActivity extends AppCompatActivity implements View.OnClickListener{
    private Dialog dialog;
    private View inflate;
    private List<Follow> followList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button24);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        //初始化页面组件及一些数据
        initFollow();
        FollowAdapter adapter = new FollowAdapter(FollowActivity.this,R.layout.follow_item,followList);
        ListView listView = (ListView) findViewById(R.id.list_view7);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Follow follow = followList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
    //载入文章内容
    private void initFollow(){
        for (int i = 0;i < 50; i++) {
            Follow follow = new Follow("毛毛","一个苹果一个苹果一个苹果一个苹果",R.drawable.img1);
            followList.add(follow);
        }
    }
    public void followControlDialog(){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.follow_control, null);
        //初始化控件
        Button cancel = (Button) inflate.findViewById(R.id.cancel);
        Button sure = (Button) inflate.findViewById(R.id.sure);
        cancel.setOnClickListener(this);
        sure.setOnClickListener(this);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        // 将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sure:
                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                dialog.dismiss();
        }
        dialog.dismiss();
    }
}
