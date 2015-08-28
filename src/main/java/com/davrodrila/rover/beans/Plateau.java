package com.davrodrila.rover.beans;
/**
 * Created by David on 28/08/2015.
 */
public class Plateau {
    private int width;
    private int height;

    public Plateau(int width,int height) {
        this.width=width;
        this.height=height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
