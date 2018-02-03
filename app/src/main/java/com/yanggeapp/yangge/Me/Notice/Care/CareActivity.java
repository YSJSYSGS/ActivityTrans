package com.yanggeapp.yangge.Me.Notice.Care;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.List;

public class CareActivity extends AppCompatActivity {
    private List<Care> careList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        Button backButton = (Button) findViewById(R.id.back_button7);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        //载入文章
        initFollow();//初始化文章数据
        CareAdapter adapter = new CareAdapter(CareActivity.this,R.layout.care_item,careList);
        ListView listView = (ListView) findViewById(R.id.list_view1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Care care = careList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });

    }

    //载入文章内容
    private void initFollow(){
        for (int i = 0;i < 50; i++) {
            Care care = new Care("一个苹果",R.drawable.header);
            careList.add(care);
        }
    }
}
