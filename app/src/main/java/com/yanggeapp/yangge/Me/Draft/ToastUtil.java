package com.yanggeapp.yangge.Me.Draft;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by aa on 2018/1/30.
 */
public class ToastUtil {
    private static Toast toast;
    public static void show(Context context, String content){
        if (toast==null){
            toast=Toast.makeText(context,content,Toast.LENGTH_SHORT);
        }
        toast.setText(content);
        toast.show();
    }
}

