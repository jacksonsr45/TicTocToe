package com.jacksonsr45.domain.usecases.tictoctoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerBTest {
    @Test
    public void shouldBeComputerBCheckPlayInMoveAndSetMovementRandomInTable() {
        Computer computer = new ComputerB();
        Table table = new Table();

        computer.move(table,2,-1);
        int line = computer.getLine();
        int column = computer.getColumn();

        assertEquals(-1, table.getField()[line][column]);
    }

    @Test
    public void shouldBeComputerBInMoveHasMovedInDiagonalOne() {
        Computer computer = new ComputerB();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,1,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][2]);
    }

    @Test
    public void shouldBeComputerBInMoveHasMovedInDiagonalTwo() {
        Computer computer = new ComputerB();
        Table table = new Table();

        table.setField(0,2,1);
        table.setField(1,1,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][0]);
    }

    @Test
    public void shouldBeComputerBInMoveHasMovedInLine() {
        Computer computer = new ComputerB();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(0,1,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[0][2]);
    }

    @Test
    public void shouldBeComputerBInMoveHasMovedInColumn() {
        Computer computer = new ComputerB();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,0,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][0]);
    }

    @Test
    public void shouldBeComputerBSetValueInTable() {
        Computer computer = new ComputerB();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,0,-1);
        table.setField(2,0,1);
        table.setField(0,2,-1);
        table.setField(1,1,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][2]);
    }

    @Test
    public void shouldBeComputerBHasReturnInGetSelectedCorrectValue() {
        Computer computer = new ComputerB();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,1,1);
        computer.move(table,2,-1);

        assertEquals(9, computer.getSelected());
    }
}
