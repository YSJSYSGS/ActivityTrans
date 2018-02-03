package com.yanggeapp.yangge.Me.Money;

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

public class Money1Activity extends AppCompatActivity {

    private List<Money> moneyList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money1);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button20);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        initMoney();//初始化文章数据
        MoneyAdapter adapter = new MoneyAdapter(Money1Activity.this,R.layout.money_item,moneyList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Money money = moneyList.get(position);
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse(String.valueOf(articleList.get(position))));
                startActivity(intent);
            }
        });
    }
    private void initMoney(){
        for (int i = 0;i < 50; i++) {
            Money money = new Money("+10.00");
            moneyList.add(money);
        }
    }
}
