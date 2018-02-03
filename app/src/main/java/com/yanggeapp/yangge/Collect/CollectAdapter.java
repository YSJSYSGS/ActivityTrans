package com.yanggeapp.yangge.Collect;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanggeapp.yangge.R;

import java.util.List;

/**
 * Created by aa on 2017/12/21.
 */

public class CollectAdapter extends ArrayAdapter<Collect> {
    CollectActivity context;
    private int resourceId;
    public CollectAdapter(CollectActivity context, int textViewResourceId, List<Collect> objects){
        super(context,textViewResourceId,objects);
        this.context = context;
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Collect collect = getItem(position);//获取当前项的Follow实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.collectImage = (ImageView) view.findViewById(R.id.article_image);
            viewHolder.collectHeader = (ImageView) view.findViewById(R.id.header);
            viewHolder.collectTitle = (TextView) view.findViewById(R.id.article_title);
            viewHolder.collectAuthor = (TextView) view.findViewById(R.id.author);
            viewHolder.collectButton = (Button) view.findViewById(R.id.more);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.collectImage.setImageResource(collect.getImageId());
        viewHolder.collectHeader.setImageResource(collect.getHeader());
        viewHolder.collectTitle.setText(collect.getTitle());
        viewHolder.collectAuthor.setText(collect.getAuthor());
        viewHolder.collectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.show(view);
            }
        });
        return view;
    }
    class ViewHolder{
        ImageView collectImage;
        ImageView collectHeader;
        TextView collectTitle;
        TextView collectAuthor;
        Button collectButton;
    }
}

