package com.yanggeapp.yangge.Me.Notice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.yanggeapp.yangge.Me.Notice.Care.CareActivity;
import com.yanggeapp.yangge.Me.Notice.Comment.CommentActivity;
import com.yanggeapp.yangge.Me.Notice.Great.GreatActivity;
import com.yanggeapp.yangge.Me.Notice.Reward.RewardActivity;
import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.HashMap;

public class NoticeActivity extends AppCompatActivity {
    private ListView listView;                               //页面listview
    private ListViewAdapter listViewAdapter;                 //listview适配器
    private ArrayList<ListViewItem> viewItemsArraylists;     //Arraylist主要装载的是传给适配器的数据集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button22);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Button carebutton = (Button) findViewById(R.id.care);
        carebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeActivity.this,CareActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button commentbutton = (Button) findViewById(R.id.comment);
        commentbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeActivity.this,CommentActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button greatbutton = (Button) findViewById(R.id.great);
        greatbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeActivity.this,GreatActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button rewardbutton = (Button) findViewById(R.id.reward);
        rewardbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeActivity.this,RewardActivity.class);
                startActivityForResult(intent,1);
            }
        });
        //初始化页面组件及一些数据
        initView();
        //为listview设置适配器
        ListViewAdapter listViewAdapter = new ListViewAdapter(NoticeActivity.this, getDatas());
        listView.setAdapter(listViewAdapter);
    }
    //初始化页面组件及一些数据
    private void initView() {
        listView = (ListView) this.findViewById(R.id.list_view5);
        listViewAdapter = new ListViewAdapter(NoticeActivity.this, getDatas());
    }
    /**
     * 这里我们用三种不同的样式进行测试
     **/
    private ArrayList<ListViewItem> getDatas() {
        viewItemsArraylists = new ArrayList<ListViewItem>();
        viewItemsArraylists.add(new ListViewItem(0,getHashMapNoticeType("拿木头玩具学编程，这是麻省理工设计的早教方法！", "拿木头玩具学编程，这是麻省理工设计的早教方法！","毛毛","厉害啊",R.drawable.img1,R.drawable.img1)));
        viewItemsArraylists.add(new ListViewItem(1,getHashMapNoticegreatType("拿木头玩具学编程，这是麻省理工设计的早教方法！", "拿木头玩具学编程，这是麻省理工设计的早教方法！","毛毛",R.drawable.img1,R.drawable.img1)));
        viewItemsArraylists.add(new ListViewItem(2,getHashMapNoticecareType("拿木头玩具学编程，这是麻省理工设计的早教方法！", "拿木头玩具学编程，这是麻省理工设计的早教方法！","毛毛","大仙",R.drawable.img1,R.drawable.img1)));
        viewItemsArraylists.add(new ListViewItem(3,getHashMapNoticerewardType("拿木头玩具学编程，这是麻省理工设计的早教方法！", "拿木头玩具学编程，这是麻省理工设计的早教方法！","毛毛",R.drawable.img1,R.drawable.img1)));
        return viewItemsArraylists;
    }
    //第一种样式，带按钮的评论样式
    private HashMap<String, Object> getHashMapNoticeType(String title, String intro,String anthor,String content,int image,int header) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Title", title);
        hashMap.put("Intro", intro);
        hashMap.put("Picture",image);
        hashMap.put("Content",content);
        hashMap.put("Author",anthor);
        hashMap.put("Header",header);
        return hashMap;
    }
    //第二种样式，点赞
    private HashMap<String, Object> getHashMapNoticegreatType(String title, String intro,String anthor,int image,int header) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Title", title);
        hashMap.put("Intro", intro);
        hashMap.put("Picture",image);
        hashMap.put("Author",anthor);
        hashMap.put("Header",header);
        return hashMap;
    }
    //第三种样式，关注
    private HashMap<String, Object> getHashMapNoticecareType(String title, String intro, String anthor,String name, int image, int header) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Title", title);
        hashMap.put("Intro", intro);
        hashMap.put("Picture",image);
        hashMap.put("Author",anthor);
        hashMap.put("Name",name);
        hashMap.put("Header",header);
        return hashMap;
    }
    //第四种样式，打赏
    private HashMap<String, Object> getHashMapNoticerewardType(String title, String intro,String anthor,int image,int header) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Title", title);
        hashMap.put("Intro", intro);
        hashMap.put("Picture",image);
        hashMap.put("Author",anthor);
        hashMap.put("Header",header);
        return hashMap;
    }
}
