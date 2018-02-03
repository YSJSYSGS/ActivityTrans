package com.yanggeapp.yangge.Fans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.List;

public class FansActivity extends AppCompatActivity {
    private List<Fans> fansList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button8);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        //载入文章
        initFans();//初始化文章数据
        FansAdapter adapter = new FansAdapter(FansActivity.this,R.layout.fans_item,fansList);
        ListView listView = (ListView) findViewById(R.id.list_view2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fans fans = fansList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });

    }

    //载入文章内容
    private void initFans(){
        for (int i = 0;i < 50; i++) {
            Fans fans = new Fans("一个苹果","一个苹果一个苹果一个苹果一个苹果",R.drawable.header);
            fansList.add(fans);
        }
    }
}