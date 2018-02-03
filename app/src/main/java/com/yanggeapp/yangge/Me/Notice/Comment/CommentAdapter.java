package com.yanggeapp.yangge.Me.Notice.Comment;

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
 * Created by aa on 2018/2/2.
 */
public class CommentAdapter extends ArrayAdapter<Comment> {
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int resourceId;
    public CommentAdapter(Context context, int textViewResourceId, List<Comment> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Calendar c = Calendar.getInstance();
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mYear = c.get(Calendar.YEAR);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        Comment comment = getItem(position);//获取当前项的Follow实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.commentHeader = (ImageView) view.findViewById(R.id.header);
            viewHolder.commentImage = (ImageView) view.findViewById(R.id.article_image);
            viewHolder.commentName = (TextView) view.findViewById(R.id.author);
            viewHolder.commentContent = (TextView) view.findViewById(R.id.content);
            viewHolder.commentTitle = (TextView) view.findViewById(R.id.article_title);
            viewHolder.commentIntro = (TextView) view.findViewById(R.id.article_intro);
            viewHolder.date = (TextView) view.findViewById(R.id.date);
            viewHolder.time = (TextView) view.findViewById(R.id.time);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.commentHeader.setImageResource(comment.getHeader());
        viewHolder.commentImage.setImageResource(comment.getImage());
        viewHolder.commentName.setText(comment.getName());
        viewHolder.commentContent.setText(comment.getContent());
        viewHolder.commentTitle.setText(comment.getTitle());
        viewHolder.commentIntro.setText(comment.getIntro());
        viewHolder.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        viewHolder.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
        return view;
    }
    class ViewHolder{
        ImageView commentHeader;
        ImageView commentImage;
        TextView commentContent;
        TextView commentName;
        TextView commentTitle;
        TextView commentIntro;
        TextView date;
        TextView time;
    }
}