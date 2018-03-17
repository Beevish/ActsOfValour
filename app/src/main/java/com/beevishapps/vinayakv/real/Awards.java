package com.beevishapps.vinayakv.real;

/**
 * Created by Vinayak v on 9/18/2016.
 */
public class Awards {

    public int pcolor;
    private String title, text1, text2;
    private int imageset;


    public Awards() {

    }

    public Awards(String title, String text1, String text2, int imageset) {
        this.title = title;
        this.text1 = text1;
        this.text2 = text2;
        this.imageset = imageset;



    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

//    public int getPcolor() {
//        return pcolor;
//    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getImageset() {
        return imageset;
    }

    public void setImageset(int imageset) {
        this.imageset = imageset;
    }


//    public void setPcolor(int pcolor) {
//        this.pcolor = pcolor;
//    }
}
