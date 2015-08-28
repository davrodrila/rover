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

    public boolean areThisCoordinatesValid(Coordinates coordinates) {
        if (coordinates.getX()<=width && coordinates.getY()<=height && coordinates.getX() >= 0 && coordinates.getY()>=0 ) {
            return true;
        } else {
            return false;
        }
    }
}
