package com.yanggeapp.yangge.Me.Publish;

/**
 * Created by aa on 2018/1/19.
 */

public class Publish {
    private String articletitle;
    private int articleimage;
    public Publish(String articletitle, int articleimage){
        this.articleimage = articleimage;
        this.articletitle = articletitle;
    }
    public String getArticletitle(){
        return articletitle;
    }
    public int getArticleimage(){
        return articleimage;
    }
}
