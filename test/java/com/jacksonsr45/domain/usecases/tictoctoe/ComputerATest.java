package com.jacksonsr45.domain.usecases.tictoctoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerATest {
    @Test
    public void shouldBeComputerACheckPlayRandomSetMovementInTable() {
        Computer computer = new ComputerA();
        Table table = new Table();

        computer.move(table,0,-1);
        int line = computer.getLine();
        int column = computer.getColumn();

        assertEquals(-1, table.getField()[line][column]);
    }
}
