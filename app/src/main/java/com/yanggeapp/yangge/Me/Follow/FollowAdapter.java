package com.yanggeapp.yangge.Me.Follow;

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
 * Created by aa on 2018/2/1.
 */
public class FollowAdapter extends ArrayAdapter<Follow> {
    FollowActivity context;
    private int resourceId;
    public FollowAdapter(FollowActivity context, int textViewResourceId, List<Follow> objects){
        super(context,textViewResourceId,objects);
        this.context = context;
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Follow follow = getItem(position);//获取当前项的Follow实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.followHeader = (ImageView) view.findViewById(R.id.header);
            viewHolder.followName = (TextView) view.findViewById(R.id.author);
            viewHolder.followBrief = (TextView) view.findViewById(R.id.brief);
            viewHolder.followUnattion = (Button) view.findViewById(R.id.unattion);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.followHeader.setImageResource(follow.getHeader());
        viewHolder.followName.setText(follow.getName());
        viewHolder.followBrief.setText(follow.getBrief());
        viewHolder.followUnattion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.followControlDialog();
            }
        });
        return view;
    }
    class ViewHolder{
        ImageView followHeader;
        TextView followName;
        TextView followBrief;
        Button followUnattion;
    }
}
