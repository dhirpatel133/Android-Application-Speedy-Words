package com.example.pateldhirspeedywords;

import android.widget.ImageView;

public class Picture {
    //Instance Variables
    private String category;
    private int picnum;

    //Default constructor
    public Picture() {
        category = "back";
        picnum = 1;
    }

    //Dynamic constructor
    public Picture(String c, int n) {
        category = c;
        picnum = n;
    }

    //Accessor: returns the category of the card
    public String getCategory() {
        return category;
    }

    //Accessor: returns the picnum of the card
    public int getpicnum() {
        return picnum;
    }

    //Mutator: sets a value for picnum
    public void setpicnum(int n) {
        picnum = n;
    }

    //Mutator: sets the image for category
    public void setCategory(String c) {
        category = c;
    }

    //This method outputs a string
    public String toString() {
        return "" + category;
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
            picture.setImageResource(R.drawable.cityorange);
        else if (picnum == 2)
            picture.setImageResource(R.drawable.plantblue);
        else if (picnum == 3)
            picture.setImageResource(R.drawable.nameblue);
        else if (picnum == 4)
            picture.setImageResource(R.drawable.nameorange);
        else if (picnum == 5)
            picture.setImageResource(R.drawable.objectgreen);
        else if (picnum == 6)
            picture.setImageResource(R.drawable.moviegblue);
        else if (picnum == 7)
            picture.setImageResource(R.drawable.plantorange);
        else if (picnum == 8)
            picture.setImageResource(R.drawable.objectorange);
        else if (picnum == 9)
            picture.setImageResource(R.drawable.namegreen);
        else if (picnum == 10)
            picture.setImageResource(R.drawable.plantgreen);
        else if (picnum == 11)
            picture.setImageResource(R.drawable.objectblue);
        else if (picnum == 12)
            picture.setImageResource(R.drawable.foodblue);
        else if (picnum == 13)
            picture.setImageResource(R.drawable.movieorange);
        else if (picnum == 14)
            picture.setImageResource(R.drawable.famousblue);
        else if (picnum == 15)
            picture.setImageResource(R.drawable.foodgreen);
        else if (picnum == 16)
            picture.setImageResource(R.drawable.countrygreen);
        else if (picnum == 17)
            picture.setImageResource(R.drawable.objectorange);
        else if (picnum == 18)
            picture.setImageResource(R.drawable.famousgreenjpg);
        else if (picnum == 19)
            picture.setImageResource(R.drawable.cityblue);
        else if (picnum == 20)
            picture.setImageResource(R.drawable.objectorange);
        else if (picnum == 21)
            picture.setImageResource(R.drawable.foodorange);
        else if (picnum == 22)
            picture.setImageResource(R.drawable.countryorange);
        else if (picnum == 23)
            picture.setImageResource(R.drawable.famousorange);
        else if (picnum == 24)
            picture.setImageResource(R.drawable.citygreen);
        else if (picnum == 25)
            picture.setImageResource(R.drawable.objectorange);
        else if (picnum == 26)
            picture.setImageResource(R.drawable.countryblue);
        else if (picnum == 27)
            picture.setImageResource(R.drawable.moviegreen);
    }
}