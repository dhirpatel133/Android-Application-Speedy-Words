package com.example.pateldhirspeedywords;

import android.widget.ImageView;

public class Letter {
    //Instance Variable
    private int picnum;

    //Default constructor
    public Letter() {
        picnum = 1;
    }

    //Dynamic constructor
    public Letter(int n) {
        picnum = n;
    }

    //Accessor: returns the picnum of the card
    public int getpicnum() {
        return picnum;
    }

    //Mutator: sets a value for picnum
    public void setpicnum(int n) {
        picnum = n;
    }

    //This method outputs a string
    public String toString() {
        return "" + picnum;
    }

    //Checks if picnum entered by another person has the same value as the default one
    public boolean equalsto(Picture n) {
        if (n.getpicnum() == picnum)
            return true;
        else
            return false;
    }

    //Compares the value of picnum
    public int compareTo(Picture n) {
        if (n.equals(this))
            return 0;
        else if (n.getpicnum() > this.getpicnum())
            return -1;
        else
            return 1;
    }

    //This method sets up all the images needed for the game
    public void setPic(ImageView picture) {
        if (picnum == 1)
            picture.setImageResource(R.drawable.p27);
        else if (picnum == 2)
            picture.setImageResource(R.drawable.p1);
        else if (picnum == 3)
            picture.setImageResource(R.drawable.p2);
        else if (picnum == 4)
            picture.setImageResource(R.drawable.p3);
        else if (picnum == 5)
            picture.setImageResource(R.drawable.p4);
        else if (picnum == 6)
            picture.setImageResource(R.drawable.p5);
        else if (picnum == 7)
            picture.setImageResource(R.drawable.p6);
        else if (picnum == 8)
            picture.setImageResource(R.drawable.p7);
        else if (picnum == 9)
            picture.setImageResource(R.drawable.p8);
        else if (picnum == 10)
            picture.setImageResource(R.drawable.p9);
        else if (picnum == 11)
            picture.setImageResource(R.drawable.p10);
        else if (picnum == 12)
            picture.setImageResource(R.drawable.p11);
        else if (picnum == 13)
            picture.setImageResource(R.drawable.p12);
        else if (picnum == 14)
            picture.setImageResource(R.drawable.p13);
        else if (picnum == 15)
            picture.setImageResource(R.drawable.p14);
        else if (picnum == 16)
            picture.setImageResource(R.drawable.p15);
        else if (picnum == 17)
            picture.setImageResource(R.drawable.p16);
        else if (picnum == 18)
            picture.setImageResource(R.drawable.p17);
        else if (picnum == 19)
            picture.setImageResource(R.drawable.p18);
        else if (picnum == 20)
            picture.setImageResource(R.drawable.p19);
        else if (picnum == 21)
            picture.setImageResource(R.drawable.p20);
        else if (picnum == 22)
            picture.setImageResource(R.drawable.p21);
        else if (picnum == 23)
            picture.setImageResource(R.drawable.p22);
        else if (picnum == 24)
            picture.setImageResource(R.drawable.p23);
        else if (picnum == 25)
            picture.setImageResource(R.drawable.p24);
        else if (picnum == 26)
            picture.setImageResource(R.drawable.p25);
        else if (picnum == 27)
            picture.setImageResource(R.drawable.p26);
    }
}