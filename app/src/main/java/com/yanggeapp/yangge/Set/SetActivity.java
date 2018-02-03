package com.yanggeapp.yangge.Set;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.yanggeapp.yangge.Me.MeActivity;
import com.yanggeapp.yangge.R;

public class SetActivity extends AppCompatActivity implements View.OnClickListener{
    private Dialog dialog;
    private View inflate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button4);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,MeActivity.class);
                startActivityForResult(intent,1);
                SetActivity.this.finish();
            }
        });
        Button logout = (Button) findViewById(R.id.logout);//注销按钮
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setControlDialog();
            }
        });
        Button clean = (Button) findViewById(R.id.clean);//清除按钮
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCleanDialog();
            }
        });

        Button mesbutton = (Button) findViewById(R.id.mes);
        mesbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,MesActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button secretbutton = (Button) findViewById(R.id.secret);
        secretbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,SecretActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button bindbutton = (Button) findViewById(R.id.Bind);
        bindbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,BindActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button persetbutton = (Button) findViewById(R.id.PerSet);
        persetbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,PerSetActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button modifypsbutton = (Button) findViewById(R.id.modifyps);
        modifypsbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetActivity.this,ModifyPSActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    private void setControlDialog(){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.set_control, null);
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
    private void setCleanDialog(){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.clean_control, null);
        //初始化控件
        Button cancel = (Button) inflate.findViewById(R.id.cancel1);
        Button sure = (Button) inflate.findViewById(R.id.sure1);
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
            case R.id.sure1:
                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel1:
                dialog.dismiss();
            case R.id.cancel:
                dialog.dismiss();
        }
        dialog.dismiss();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode ==  KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(SetActivity.this,MeActivity.class);
            startActivityForResult(intent,1);
        }
        return true;
    }
}
