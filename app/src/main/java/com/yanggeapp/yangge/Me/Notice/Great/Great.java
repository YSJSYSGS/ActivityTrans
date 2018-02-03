package com.yanggeapp.yangge.Me.Notice.Great;

/**
 * Created by aa on 2018/2/2.
 */
public class Great {
    private String name;
    private int header;
    private String title;
    private String intro;
    private int image;
    public Great(int header, String name, int image, String title, String intro){
        this.header = header;
        this.image = image;
        this.name = name;
        this.title = title;
        this.intro = intro;
    }
    public int getHeader(){
        return header;
    }
    public String getName(){
        return name;
    }
    public int getImage(){
        return image;
    }
    public String getTitle(){
        return title;
    }
    public String getIntro(){
        return intro;
    }
}
