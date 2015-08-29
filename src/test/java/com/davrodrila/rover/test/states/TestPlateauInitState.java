package com.davrodrila.rover.test.states;

import com.davrodrila.rover.exceptions.MalformedCommandException;
import com.davrodrila.rover.states.PlateauInitState;
import org.junit.*;

/**
 * Created by David on 29/08/2015.
 */
public class TestPlateauInitState {

    PlateauInitState state;

    @Before
    public void setUpstate() {
        state = new PlateauInitState();
    }

    @Test
    public void firstCommandSentProperlyFormed() {
        int maxSize = 5;
        state.checkCommand("5 5");
    }

    @Test(expected=MalformedCommandException.class)
    public void firstCommandSentMalformed()  {
        state.checkCommand("55");
    }

    @Test(expected=MalformedCommandException.class)
    public void firstCommandSentWithNegativeNumbers() {
        state.checkCommand("-5 -5");
    }

}
