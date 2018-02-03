package com.yanggeapp.yangge.Article;

/**
 * Created by aa on 2017/11/9.
 */

public class Article {
    private String title;
    private String intro;
    private int imageId;

    public Article(String title,String intro,int imageId){
        this.title = title;
        this.intro = intro;
        this.imageId = imageId;
    }

    public String getTitle(){
        return title;
    }

    public String getIntro(){
        return intro;
    }

    public int getImageId(){
        return imageId;
    }
}
