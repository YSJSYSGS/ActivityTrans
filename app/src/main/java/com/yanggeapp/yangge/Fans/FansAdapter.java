package com.yanggeapp.yangge.Fans;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yanggeapp.yangge.R;
import java.util.List;

/**
 * Created by aa on 2017/11/9.
 */

public class FansAdapter extends ArrayAdapter<Fans>{
    private int resourceId;
    public FansAdapter(Context context, int textViewResourceId, List<Fans> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fans fans = getItem(position);//获取当前项的Follow实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.fansHeader = (ImageView) view.findViewById(R.id.header);
            viewHolder.fansName = (TextView) view.findViewById(R.id.author);
            viewHolder.fansBrief = (TextView) view.findViewById(R.id.fans_brief);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.fansHeader.setImageResource(fans.getHeader());
        viewHolder.fansName.setText(fans.getName());
        viewHolder.fansBrief.setText(fans.getBrief());
        return view;
    }
    class ViewHolder{
        ImageView fansHeader;
        TextView fansName;
        TextView fansBrief;
    }
}
