package com.yanggeapp.yangge.Set;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.yanggeapp.yangge.R;

public class SecretActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button12);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        rd = (RadioGroup) findViewById(R.id.remind);
        rd.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch(checkedId){//判定不同的RadioButton被按下并执行响应操作
            case R.id.all:
                Log.i("tag","r1");
                break;
            case R.id.only_care:
                Log.i("Tag", "r2");
                break;
        }
    }
}
