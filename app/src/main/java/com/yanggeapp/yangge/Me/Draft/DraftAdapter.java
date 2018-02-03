package com.yanggeapp.yangge.Me.Draft;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanggeapp.yangge.Activity.PenActivity;
import com.yanggeapp.yangge.R;

import java.util.ArrayList;
import java.util.Calendar;

import static com.yanggeapp.yangge.Me.Draft.Draft.image;
import static com.yanggeapp.yangge.Me.Draft.Draft.intro;
import static com.yanggeapp.yangge.Me.Draft.Draft.title;

/**
 * Created by aa on 2018/1/30.
 */
public class DraftAdapter extends BaseAdapter {
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private final ArrayList<SwipeLayout> openItems;
    private DraftActivity context;
    public DraftAdapter(DraftActivity context) {
        this.context = context;
        openItems = new ArrayList<SwipeLayout>();
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int n) {
        return title[n];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Calendar c = Calendar.getInstance();
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        mYear = c.get(Calendar.YEAR);
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        View root = view;
        if (view == null) {
            root = View.inflate(context, R.layout.draftp_item, null);
        }
        ViewHolder mHolder = ViewHolder.getHolder(root);
        mHolder.title.setText(title[i]);
        mHolder.intro.setText(intro[i]);
        mHolder.image.setImageResource(image[i]);
        mHolder.date.setText(new StringBuilder().append(mYear - 2000).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
        mHolder.time.setText(new StringBuilder().append(mHour).append(":").append(mMinute));
        mHolder.repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PenActivity.class);
                context.startActivityForResult(intent,1);
            }
        });
        SwipeLayout layout = (SwipeLayout) root;
        layout.setListener(new SwipeLayout.OnSwipeLayoutListener() {
            @Override
            public void onClose(SwipeLayout mSwipeLayout) {
                openItems.remove(mSwipeLayout);
            }

            @Override
            public void onOpen(SwipeLayout mSwipeLayout) {
                //添加进集合
                openItems.add(mSwipeLayout);
            }

            @Override
            public void onDragging(SwipeLayout mSwipeLayout) {

            }

            @Override
            public void onStartClose(SwipeLayout mSwipeLayout) {

            }

            @Override
            public void onStartOpen(SwipeLayout mSwipeLayout) {
                //要去开始时，先遍历所有已打开条目，逐个关闭
                for (SwipeLayout layout:openItems){
                    layout.close(true);
                }
            }
        });
        return root;
    }

    static class ViewHolder {
        TextView intro;
        TextView del;
        TextView title;
        ImageView image;
        Button repeat;
        TextView date;
        TextView time;
        public static ViewHolder getHolder(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.intro = (TextView) view.findViewById(R.id.article_intro);
                viewHolder.del = (TextView) view.findViewById(R.id.delete);
                viewHolder.title = (TextView) view.findViewById(R.id.article_title);
                viewHolder.image = (ImageView) view.findViewById(R.id.article_image);
                viewHolder.repeat = (Button) view.findViewById(R.id.repeat);
                viewHolder.date = (TextView) view.findViewById(R.id.date);
                viewHolder.time = (TextView) view.findViewById(R.id.time);
                tag = viewHolder;
                view.setTag(tag);
            }
            return (ViewHolder) tag;
        }
    }
}

