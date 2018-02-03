package com.yanggeapp.yangge.Me.Publish;

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

public class PublishActivity extends AppCompatActivity {

    private List<Publish> publishList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button21);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        initOutput();//初始化文章数据
        PublishAdapter adapter = new PublishAdapter(PublishActivity.this,R.layout.publish_item, publishList);
        ListView listView = (ListView) findViewById(R.id.list_view3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Publish publish = publishList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(String.valueOf(articleList.get(position))));
                startActivity(intent);
            }
        });
    }
    private void initOutput(){
        for (int i = 0;i < 50; i++) {
            Publish publish = new Publish("拿木头玩具学编程，这是麻省理工设计的早教方法！",R.drawable.img2);
            publishList.add(publish);
        }
    }
}
