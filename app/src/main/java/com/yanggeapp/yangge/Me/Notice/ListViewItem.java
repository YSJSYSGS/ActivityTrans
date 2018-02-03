package com.yanggeapp.yangge.Me.Notice;

import java.util.HashMap;

/**
 * Created by aa on 2018/1/30.
 */

public class ListViewItem {
    //用于区分listview显示的不同item,告诉适配器我这是什么类型，listview适配器根据type决定怎么显示
    public int type;
    //将要显示的数据用HashMap包装好
    public HashMap<String,Object> map ;
    public ListViewItem(int type, HashMap<String, Object> map) {
        this.type = type;
        this.map = map;
    }
}
