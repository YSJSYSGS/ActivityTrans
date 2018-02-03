package com.yanggeapp.yangge.Me.Follow;

/**
 * Created by aa on 2018/2/1.
 */
public class Follow {
    private String name;
    private String brief;
    private int header;
    public Follow(String name,String brief,int header){
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
