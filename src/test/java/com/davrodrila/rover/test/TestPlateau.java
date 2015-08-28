package com.davrodrila.rover.test;

import com.davrodrila.rover.beans.*;
import org.junit.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by David on 28/08/2015.
 */
public class TestPlateau {

    Plateau plateau;

    @Before
    public void setUpPlateau() {
        plateau = new Plateau(5,5);
    }

    @Test
    public void coordinatesBiggerThanThePlateauShouldNotBeValid() {
        Coordinates coords = new Coordinates(6,3);
        assertFalse(plateau.areThisCoordinatesValid(coords));
    }

    @Test
    public void coordinatesWithinTheRangeOfThePlateauShouldBeValid() {
        Coordinates coords = new Coordinates(3,2);
        assertTrue(plateau.areThisCoordinatesValid(coords));
    }

    @Test
    public void negativeCoordinatesShouldNotBeValid() {
        Coordinates coords = new Coordinates(-1,-4);
        assertFalse(plateau.areThisCoordinatesValid(coords));
    }

    @Test
    public void coordinatesInTheEdgeOfThePlateauShouldBeValid() {
        Coordinates coords = new Coordinates(5,5);
        assertTrue(plateau.areThisCoordinatesValid(coords));
    }

}
