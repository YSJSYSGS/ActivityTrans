package com.yanggeapp.yangge.Me;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yanggeapp.yangge.Activity.MainActivity;
import com.yanggeapp.yangge.Collect.CollectActivity;
import com.yanggeapp.yangge.Fans.FansActivity;
import com.yanggeapp.yangge.Me.Draft.DraftActivity;
import com.yanggeapp.yangge.Me.Follow.FollowActivity;
import com.yanggeapp.yangge.Me.Money.MoneyActivity;
import com.yanggeapp.yangge.Me.Notice.NoticeActivity;
import com.yanggeapp.yangge.Me.Publish.PublishActivity;
import com.yanggeapp.yangge.R;
import com.yanggeapp.yangge.Set.SetActivity;

public class MeActivity extends AppCompatActivity implements View.OnClickListener{
    private Dialog dialog;
    private View inflate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,MainActivity.class);
                startActivityForResult(intent,1);
            }
        });
        ImageButton setbutton = (ImageButton) findViewById(R.id.set_button);
        setbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,SetActivity.class);
                startActivityForResult(intent,1);
            }
        });
        Button versionbutton = (Button) findViewById(R.id.version);
        versionbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,VersionActivity.class);
                startActivityForResult(intent,1);
            }
        });
        Button messagebutton = (Button) findViewById(R.id.message);
        messagebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,MessageActivity.class);
                startActivityForResult(intent,1);
            }
        });
        Button infobutton = (Button) findViewById(R.id.info);
        infobutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,InfoActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button fansbutton = (Button) findViewById(R.id.fans);
        fansbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,FansActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button collectbutton = (Button) findViewById(R.id.collect);
        collectbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,CollectActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button moneybutton = (Button) findViewById(R.id.money);
        moneybutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,MoneyActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button publishbutton = (Button) findViewById(R.id.publish);
        publishbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,PublishActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button noticebutton = (Button) findViewById(R.id.notice);
        noticebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,NoticeActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button draftbutton = (Button) findViewById(R.id.draft);
        draftbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this,DraftActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button followbutton = (Button) findViewById(R.id.follow);
        followbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this, FollowActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button share = (Button) findViewById(R.id.share);//分享按钮
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(v);
            }
        });

        //TextView tv=(TextView)findViewById(R.id.login);
        //String format = getResources().getString(R.string.login);
        //String result = String.format(format,100);//对应xml中定义的123顺序
        //Log.e("", result);
        //tv.setText(result);

        Button tv1=(Button) findViewById(R.id.follow);
        String format1 = getResources().getString(R.string.follow);
        String result1 = String.format(format1,0);//对应xml中定义的123顺序
        Log.e("", result1);
        tv1.setText(result1);

        Button tv2=(Button) findViewById(R.id.fans);
        String format2 = getResources().getString(R.string.fans);
        String result2 = String.format(format2,0);//对应xml中定义的123顺序
        Log.e("", result2);
        tv2.setText(result2);

        Button tv3=(Button) findViewById(R.id.publish);
        String format3 = getResources().getString(R.string.output);
        String result3 = String.format(format3,0);//对应xml中定义的123顺序
        Log.e("", result3);
        tv3.setText(result3);

        Button tv4=(Button) findViewById(R.id.collect);
        String format4 = getResources().getString(R.string.collect);
        String result4 = String.format(format4,0);//对应xml中定义的123顺序
        Log.e("", result4);
        tv4.setText(result4);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode ==  KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MeActivity.this,MainActivity.class);
            startActivityForResult(intent,1);
        }
        return true;
    }
    public void show(View view){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.share_control,null);
        //初始化控件
        Button qq = (Button) inflate.findViewById(R.id.qq);
        Button qqspace = (Button) inflate.findViewById(R.id.qqspace);
        Button wechat = (Button) inflate.findViewById(R.id.wechat);
        Button friend = (Button) inflate.findViewById(R.id.friend);
        Button copylink = (Button) inflate.findViewById(R.id.copylink);
        Button main = (Button) inflate.findViewById(R.id.main);
        Button cancel = (Button) inflate.findViewById(R.id.btn_cancel);
        qq.setOnClickListener(this);
        qqspace.setOnClickListener(this);
        wechat.setOnClickListener(this);
        friend.setOnClickListener(this);
        copylink.setOnClickListener(this);
        main.setOnClickListener(this);
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
            case R.id.qq:
                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
                break;
            case R.id.qqspace:
                Toast.makeText(this,"点击了从相册选择",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wechat:
                Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.friend:
                Toast.makeText(this,"拍照",Toast.LENGTH_SHORT).show();
                break;
            case R.id.copylink:
                Toast.makeText(this,"相册",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main:
                Toast.makeText(this,"找事",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                dialog.dismiss();
        }
        dialog.dismiss();
    }
}
