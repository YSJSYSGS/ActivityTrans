package com.yanggeapp.yangge.Collect;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
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

public class CollectActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Collect> mCollectList = new ArrayList<>();
    private Dialog dialog;
    private View inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button10);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //载入文章
        initCollect();//初始化文章数据
        CollectAdapter adapter = new CollectAdapter(CollectActivity.this,R.layout.collect_item, mCollectList);
        ListView listView = (ListView) findViewById(R.id.list_view4);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Collect collect = mCollectList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }

    //载入文章内容
    private void initCollect(){
        for (int i = 0;i < 50; i++) {
            Collect collect = new Collect("拿木头玩具学编程，这是麻省理工设计的早教方法","某某某",R.drawable.img1,R.drawable.img3);
            mCollectList.add(collect);
        }
    }
    public void show(View view){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.collect_control, null);
        //初始化控件
        Button uncollect = (Button) inflate.findViewById(R.id.uncollect);
        Button share = (Button) inflate.findViewById(R.id.share);
        Button cancel = (Button) inflate.findViewById(R.id.btn_cancel);
        uncollect.setOnClickListener(this);
        share.setOnClickListener(this);
        cancel.setOnClickListener(this);
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //lp.y = 20;//设置Dialog距离底部的距离
        // 将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialogWindow.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
        dialog.show();//显示对话框
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.uncollect:
                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this,"点击了从相册选择",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
        }
        dialog.dismiss();
    }
}