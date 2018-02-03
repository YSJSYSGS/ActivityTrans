package com.yanggeapp.yangge.Me.Notice.Care;

/**
 * Created by aa on 2017/12/19.
 */

public class Care {
    private String name;
    private int header;
    public Care(String name,int header){
        this.header = header;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public int getHeader(){
        return header;
    }
}

