package com.davrodrila.rover.beans;

/**
 * Created by David on 28/08/2015.
 */
public class Coordinates {

    private int x;
    private int y;

    public Coordinates() {}

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinates aggregateCoordinates(Coordinates coordinates) {
        Coordinates aggregatedCoordinates = new Coordinates();
        aggregatedCoordinates.setX(this.x + coordinates.getX());
        aggregatedCoordinates.setY(this.y + coordinates.getY());
        return aggregatedCoordinates;
    }


    public boolean equals(Coordinates coordinates) {
        if (this.x == coordinates.getX() && this.y == coordinates.getY()) {
            return true;
        } else {
            return false;
        }
    }
}

