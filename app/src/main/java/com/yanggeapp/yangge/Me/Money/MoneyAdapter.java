package com.yanggeapp.yangge.Me.Money;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yanggeapp.yangge.R;

import java.util.Calendar;
import java.util.List;

/**
 * Created by aa on 2018/1/17.
 */

public class MoneyAdapter extends ArrayAdapter<Money> {
    //声明日期及时间变量
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int resourceId;
    public MoneyAdapter(Context context, int textViewResourceId, List<Money> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Money money = getItem(position);//获取当前项的Follow实例
        //取得当前的日期及时间
        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.moneyNumber = (TextView) view.findViewById(R.id.money_num);
            viewHolder.date = (TextView) view.findViewById(R.id.date);
            viewHolder.time = (TextView) view.findViewById(R.id.time);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.moneyNumber.setText(money.getMoneynum());
        viewHolder.date.setText(new StringBuilder().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        viewHolder.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
        return view;
    }
    class ViewHolder{
        TextView moneyNumber;
        private TextView date;
        private TextView time;
    }
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}

