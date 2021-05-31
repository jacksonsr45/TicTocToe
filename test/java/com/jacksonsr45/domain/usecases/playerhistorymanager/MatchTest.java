package com.jacksonsr45.domain.usecases.playerhistorymanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    @Test
    public void shouldBeCreatNewMatchAndSetValueInMoveReturnValue() {
        Match match = new Match(2);

        match.move(1,2,1,-1);

        assertNotEquals(null, match.getId());
        assertEquals(1, match.getMovements().get(0).getId());
        assertEquals(2, match.getMovements().get(0).getLine());
        assertEquals(1, match.getMovements().get(0).getColumn());
        assertEquals(-1, match.getMovements().get(0).getValue());
    }
}
