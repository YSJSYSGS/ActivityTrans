package com.yanggeapp.yangge.Article;

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

public class ArticleAdapter extends ArrayAdapter<Article> {
    private int resourceId;
    public ArticleAdapter(Context context, int textViewResourceId, List<Article> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = getItem(position);//获取当前项的Article实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);//使用LayoutInflater加载布局
            viewHolder = new ViewHolder();//创建ViewHolder对象
            viewHolder.articleImage = (ImageView) view.findViewById(R.id.article_image);//将控件的实例都存放在ViewHolder里
            viewHolder.articleTitle = (TextView) view.findViewById(R.id.article_title);
            viewHolder.articleIntro = (TextView) view.findViewById(R.id.article_intro);
            view.setTag(viewHolder);//将viewHolder存储在View中
        }else {
            view = convertView;//直接对convertView进行重用
            viewHolder = (ViewHolder) view.getTag();//重新获得viewHolder
        }
        viewHolder.articleImage.setImageResource(article.getImageId());
        viewHolder.articleTitle.setText(article.getTitle());
        viewHolder.articleIntro.setText(article.getIntro());
        return view;
    }
    class ViewHolder{
        ImageView articleImage;
        TextView articleTitle;
        TextView articleIntro;
    }

}
