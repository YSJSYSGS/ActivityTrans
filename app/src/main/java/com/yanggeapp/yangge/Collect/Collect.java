package com.yanggeapp.yangge.Collect;

/**
 * Created by aa on 2017/12/21.
 */

public class Collect {
    private String title;
    private String author;
    private int imageId;
    private int header;

    public Collect(String title,String author,int imageId,int header){
        this.title = title;
        this.author = author;
        this.imageId = imageId;
        this.header = header;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getImageId(){
        return imageId;
    }

    public int getHeader(){
        return header;
    }
}
