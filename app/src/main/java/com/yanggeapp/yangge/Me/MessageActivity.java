package com.yanggeapp.yangge.Me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yanggeapp.yangge.R;

import java.util.Calendar;

public class MessageActivity extends AppCompatActivity {
    private TextView date;
    private TextView time;
    private TextView date1;
    private TextView time1;
    private TextView date2;
    private TextView time2;
    //声明日期及时间变量
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        Button backButton = (Button) findViewById(R.id.back_button5);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        //取得当前的日期及时间
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        //获取控件
        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        date1 = (TextView) findViewById(R.id.date1);
        time1 = (TextView) findViewById(R.id.time1);
        date2 = (TextView) findViewById(R.id.date2);
        time2 = (TextView) findViewById(R.id.time2);
        //在TextView中显示日期及时间
        date.setText(new StringBuilder().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
        date1.setText(new StringBuilder().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        time1.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
        date2.setText(new StringBuilder().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        time2.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
    }
}
