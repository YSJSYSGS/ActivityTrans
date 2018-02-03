package com.yanggeapp.yangge.Me.Notice.Comment;

/**
 * Created by aa on 2018/2/2.
 */
public class Comment {
    private String name;
    private int header;
    private String title;
    private String intro;
    private String content;
    private int image;
    public Comment(int header,String name,String content,int image,String title,String intro){
        this.header = header;
        this.image = image;
        this.name = name;
        this.title = title;
        this.intro = intro;
        this.content = content;
    }
    public int getHeader(){
        return header;
    }
    public String getName(){
        return name;
    }
    public String getContent(){
        return content;
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
