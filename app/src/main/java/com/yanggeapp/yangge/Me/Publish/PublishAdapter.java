package com.yanggeapp.yangge.Me.Publish;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanggeapp.yangge.R;

import java.util.Calendar;
import java.util.List;

/**
 * Created by aa on 2018/1/19.
 */

public class PublishAdapter extends ArrayAdapter<Publish> {
    //声明日期及时间变量
    private int mMonth;
    private int mDay;
    private int resourceId;
    public PublishAdapter(Context context, int textViewResourceId, List<Publish> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Publish publish = getItem(position);//获取当前项的Follow实例
        //取得当前的日期及时间
        Calendar c = Calendar.getInstance();
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.articleTitle = (TextView) view.findViewById(R.id.article_title);
            viewHolder.articleImage = (ImageView) view.findViewById(R.id.article_image);
            viewHolder.date = (TextView) view.findViewById(R.id.date);
            viewHolder.month = (TextView) view.findViewById(R.id.month);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.articleImage.setImageResource(publish.getArticleimage());
        viewHolder.articleTitle.setText(publish.getArticletitle());
        viewHolder.date.setText(new StringBuilder().append(mDay));
        viewHolder.month.setText(new StringBuilder().append(mMonth + 1).append("月"));
        return view;
    }
    class ViewHolder{
        ImageView articleImage;
        TextView articleTitle;
        private TextView date;
        private TextView month;
    }
}