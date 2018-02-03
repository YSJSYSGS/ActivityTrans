package com.yanggeapp.yangge.Article;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by aa on 2017/11/22.
 */

public class ArticleView extends ListView {

    public ArticleView(Context context) {
        super(context);
    }

    public ArticleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //解决ScrollView和ListView高度冲突的问题
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ArticleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, // 设计一个较大的值和AT_MOST模式
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);//再调用原方法测量
    }
}