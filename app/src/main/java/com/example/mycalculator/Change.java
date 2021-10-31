package com.example.mycalculator;

public class Change {

    private int clicked=0;
    private int imagenum;

    public int imagenumber(int a)  {
       switch (a) {
        case 0:
            imagenum = R.drawable.goguma1;
            break;
        case 1:
            imagenum = R.drawable.goguma2;
            break;
        case 2:
            imagenum = R.drawable.goguma3;
            break;
        case 3:
            imagenum = R.drawable.goguma4;
            break;
        case 4:
            imagenum = R.drawable.goguma5;
            break;
        }
        return imagenum;

    }

    void click() {
        clicked++;
    }

    int getClicked() {
        return clicked;
    }

    void setClicked() {
        clicked=0;
    }


}
