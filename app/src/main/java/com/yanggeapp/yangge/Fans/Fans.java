package com.yanggeapp.yangge.Fans;

/**
 * Created by aa on 2017/12/19.
 */

public class Fans {
    private String name;
    private String brief;
    private int header;
    public Fans(String name,String brief,int header){
        this.header = header;
        this.brief = brief;
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String getBrief(){
        return brief;
    }
    public int getHeader(){
        return header;
    }
}
