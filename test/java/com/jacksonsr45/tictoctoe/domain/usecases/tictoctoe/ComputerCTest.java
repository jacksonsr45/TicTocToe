package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerCTest {
    @Test
    public void shouldBeComputerCSetValueInTableOnDiagonalOneByVictory() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0, 0, -1);
        table.setField(1, 1, -1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][2]);
    }

    @Test
    public void shouldBeComputerCSetValueInTableOnDiagonalTwoByVictory() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,2,-1);
        table.setField(1,1,-1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][0]);
    }

    @Test
    public void shouldBeComputerCSetValueInTableOnColumnByVictory() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,1,-1);
        table.setField(1,1,-1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][1]);
    }

    @Test
    public void shouldBeComputerCSetValueInTableOnLineByVictory() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,0,-1);
        table.setField(0,1,-1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[0][2]);
    }

    @Test
    public void shouldBeComputerCCheckDiagonalOne() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(2,2,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[1][1]);
    }

    @Test
    public void shouldBeComputerCCheckDiagonalTwo() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(1,1, 1);
        table.setField(2,0,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[0][2]);
    }

    @Test
    public void shouldBeComputerCCheckColumn() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,0, 1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[2][0]);
    }

    @Test
    public void shoutBeComputerCCheckLine() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(0,1,1);
        computer.move(table,2,-1);

        assertEquals(-1, table.getField()[0][2]);
    }

    @Test
    public void shouldBeComputerCHasReturnInGetSelectedCorrectValue() {
        Computer computer = new ComputerC();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,1,1);
        computer.move(table,2,-1);

        assertEquals(9, computer.getSelected());
    }
}
