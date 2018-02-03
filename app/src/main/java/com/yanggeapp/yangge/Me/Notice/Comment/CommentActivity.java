package com.yanggeapp.yangge.Me.Notice.Comment;

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

public class CommentActivity extends AppCompatActivity{
    private List<Comment> mCommentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button25);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        //初始化页面组件及一些数据
        initComment();
        CommentAdapter adapter = new CommentAdapter(CommentActivity.this,R.layout.notice_item, mCommentList);
        ListView listView = (ListView) findViewById(R.id.list_view8);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Comment comment = mCommentList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }
    //载入文章内容
    private void initComment(){
        for (int i = 0;i < 50; i++) {
            Comment comment = new Comment(R.drawable.img1,"毛毛","一个苹果一个苹果一个苹果一个苹果",R.drawable.img1,"毛毛说拿木头玩具学编程，这是麻省理工设计的早教方法！","毛毛说拿木头玩具学编程，这是麻省理工设计的早教方法！毛毛说拿木头玩具学编程，这是麻省理工设计的早教方法！");
            mCommentList.add(comment);
        }
    }
}
