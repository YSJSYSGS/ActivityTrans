package com.yanggeapp.yangge.Me.Notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by aa on 2018/1/30.
 */
public class ListViewAdapter extends BaseAdapter {
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private ArrayList<ListViewItem> listDatas;
    public ListViewAdapter(Context context, ArrayList<ListViewItem> listDatas) {
        this.listDatas = listDatas;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //返回当前布局的样式type
    @Override
    public int getItemViewType(int position) {
        return listDatas.get(position).type;
    }
    //返回你有多少个不同的布局
    @Override
    public int getViewTypeCount() {
        return 4;
    }
    @Override
    public int getCount() {
        return listDatas.size();
    }
    @Override
    public Object getItem(int position) {
        return listDatas.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Calendar c = Calendar.getInstance();
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mYear = c.get(Calendar.YEAR);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        ListViewItem listItem = listDatas.get(position);
        int Type = getItemViewType(position);
        ViewHoldernoticeType viewHoldernoticeType = null;
        ViewHoldernoticegreatType viewHoldernoticegreatType = null;
        ViewHoldernoticecareType viewHoldernoticecareType = null;
        ViewHoldernoticerewardType viewHoldernoticerewardType = null;
        if (convertView == null) {
            switch (Type) {
                case 0:
                    viewHoldernoticeType = new ViewHoldernoticeType();
                    convertView = mLayoutInflater.inflate(R.layout.notice_item,null);
                    viewHoldernoticeType.article_title = (TextView) convertView.findViewById(R.id.article_title);
                    viewHoldernoticeType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticeType.article_intro = (TextView) convertView.findViewById(R.id.article_intro);
                    viewHoldernoticeType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticeType.article_content = (TextView) convertView.findViewById(R.id.content);
                    viewHoldernoticeType.article_content.setText(listItem.map.get("Content").toString());
                    viewHoldernoticeType.article_image = (ImageView) convertView.findViewById(R.id.article_image);
                    viewHoldernoticeType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticeType.header = (ImageView) convertView.findViewById(R.id.header);
                    viewHoldernoticeType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticeType.author = (TextView) convertView.findViewById(R.id.author);
                    viewHoldernoticeType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticeType.date = (TextView) convertView.findViewById(R.id.date);
                    viewHoldernoticeType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticeType.time = (TextView) convertView.findViewById(R.id.time);
                    viewHoldernoticeType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
//                  convertView.setTag(viewHolderfirstType);  //如果要复用，不同于一种样式的listView ,这样的写法是错误的,具体原因看下面第一个小哥评论的说法
                    convertView.setTag(R.id.viewHoldernoticeType, viewHoldernoticeType);
                    break;
                case 1:
                    viewHoldernoticegreatType = new ViewHoldernoticegreatType();
                    convertView = mLayoutInflater.inflate(R.layout.noticegreat_item,null);
                    viewHoldernoticegreatType.article_title = (TextView) convertView.findViewById(R.id.article_title);
                    viewHoldernoticegreatType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticegreatType.article_intro = (TextView) convertView.findViewById(R.id.article_intro);
                    viewHoldernoticegreatType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticegreatType.article_image = (ImageView) convertView.findViewById(R.id.article_image);
                    viewHoldernoticegreatType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticegreatType.header = (ImageView) convertView.findViewById(R.id.header);
                    viewHoldernoticegreatType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticegreatType.author = (TextView) convertView.findViewById(R.id.author);
                    viewHoldernoticegreatType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticegreatType.date = (TextView) convertView.findViewById(R.id.date);
                    viewHoldernoticegreatType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticegreatType.time = (TextView) convertView.findViewById(R.id.time);
                    viewHoldernoticegreatType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
//                  convertView.setTag(viewHolderfirstType);  //如果要复用，不同于一种样式的listView ,这样的写法是错误的,具体原因看下面第一个小哥评论的说法
                    convertView.setTag(R.id.viewHoldernoticegreatType, viewHoldernoticegreatType);
                    break;
                case 2:
                    viewHoldernoticecareType = new ViewHoldernoticecareType();
                    convertView = mLayoutInflater.inflate(R.layout.noticecare_item,null);
                    viewHoldernoticecareType.article_title = (TextView) convertView.findViewById(R.id.article_title);
                    viewHoldernoticecareType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticecareType.article_intro = (TextView) convertView.findViewById(R.id.article_intro);
                    viewHoldernoticecareType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticecareType.name = (TextView) convertView.findViewById(R.id.name);
                    viewHoldernoticecareType.name.setText(listItem.map.get("Name").toString());
                    viewHoldernoticecareType.article_image = (ImageView) convertView.findViewById(R.id.article_image);
                    viewHoldernoticecareType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticecareType.header = (ImageView) convertView.findViewById(R.id.header);
                    viewHoldernoticecareType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticecareType.author = (TextView) convertView.findViewById(R.id.author);
                    viewHoldernoticecareType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticecareType.date = (TextView) convertView.findViewById(R.id.date);
                    viewHoldernoticecareType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticecareType.time = (TextView) convertView.findViewById(R.id.time);
                    viewHoldernoticecareType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
//                  convertView.setTag(viewHolderfirstType);  //如果要复用，不同于一种样式的listView ,这样的写法是错误的,具体原因看下面第一个小哥评论的说法
                    convertView.setTag(R.id.viewHoldernoticecareType, viewHoldernoticecareType);
                    break;
                case 3:
                    viewHoldernoticerewardType = new ViewHoldernoticerewardType();
                    convertView = mLayoutInflater.inflate(R.layout.noticereward_item,null);
                    viewHoldernoticerewardType.article_title = (TextView) convertView.findViewById(R.id.article_title);
                    viewHoldernoticerewardType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticerewardType.article_intro = (TextView) convertView.findViewById(R.id.article_intro);
                    viewHoldernoticerewardType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticerewardType.article_image = (ImageView) convertView.findViewById(R.id.article_image);
                    viewHoldernoticerewardType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticerewardType.header = (ImageView) convertView.findViewById(R.id.header);
                    viewHoldernoticerewardType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticerewardType.author = (TextView) convertView.findViewById(R.id.author);
                    viewHoldernoticerewardType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticerewardType.date = (TextView) convertView.findViewById(R.id.date);
                    viewHoldernoticerewardType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticerewardType.time = (TextView) convertView.findViewById(R.id.time);
                    viewHoldernoticerewardType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
//                  convertView.setTag(viewHolderfirstType);  //如果要复用，不同于一种样式的listView ,这样的写法是错误的,具体原因看下面第一个小哥评论的说法
                    convertView.setTag(R.id.viewHoldernoticerewardType, viewHoldernoticerewardType);
                    break;
            }
        } else {
            switch (Type) {
                case 0:
                    viewHoldernoticeType = (ViewHoldernoticeType) convertView.getTag(R.id.viewHoldernoticeType);
                    viewHoldernoticeType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticeType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticeType.article_content.setText(listItem.map.get("Content").toString());
                    viewHoldernoticeType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticeType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticeType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticeType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticeType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
                    break;
                case 1:
                    viewHoldernoticegreatType = (ViewHoldernoticegreatType) convertView.getTag(R.id.viewHoldernoticegreatType);
                    viewHoldernoticegreatType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticegreatType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticegreatType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticegreatType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticegreatType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticegreatType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticegreatType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
                    break;
                case 2:
                    viewHoldernoticecareType = (ViewHoldernoticecareType) convertView.getTag(R.id.viewHoldernoticecareType);
                    viewHoldernoticecareType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticecareType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticecareType.name.setText(listItem.map.get("Name").toString());
                    viewHoldernoticecareType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticecareType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticecareType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticecareType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticecareType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
                    break;
                case 3:
                    viewHoldernoticerewardType = (ViewHoldernoticerewardType) convertView.getTag(R.id.viewHoldernoticerewardType);
                    viewHoldernoticerewardType.article_title.setText(listItem.map.get("Title").toString());
                    viewHoldernoticerewardType.article_intro.setText(listItem.map.get("Intro").toString());
                    viewHoldernoticerewardType.article_image.setImageResource(Integer.parseInt(listItem.map.get("Picture").toString()));
                    viewHoldernoticerewardType.header.setImageResource(Integer.parseInt(listItem.map.get("Header").toString()));
                    viewHoldernoticerewardType.author.setText(listItem.map.get("Author").toString());
                    viewHoldernoticerewardType.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
                    viewHoldernoticerewardType.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
            }
        }
        return convertView;
    }

    class ViewHoldernoticeType {
        TextView article_title;
        TextView article_intro;
        TextView article_content;
        ImageView article_image;
        TextView author;
        ImageView header;
        private TextView date;
        private TextView time;
    }
    class ViewHoldernoticegreatType{
        TextView article_title;
        TextView article_intro;
        ImageView article_image;
        TextView author;
        ImageView header;
        private TextView date;
        private TextView time;
    }
    class ViewHoldernoticecareType{
        TextView article_title;
        TextView article_intro;
        ImageView article_image;
        TextView name;
        TextView author;
        ImageView header;
        private TextView date;
        private TextView time;
    }
    class ViewHoldernoticerewardType{
        TextView article_title;
        TextView article_intro;
        ImageView article_image;
        TextView author;
        ImageView header;
        private TextView date;
        private TextView time;
    }
}
