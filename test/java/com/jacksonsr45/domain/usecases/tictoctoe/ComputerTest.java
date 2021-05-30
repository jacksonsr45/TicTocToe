package com.jacksonsr45.domain.usecases.tictoctoe;

import org.junit.Test;

import static org.junit.Assert.*;

class NewComputer extends Computer {
    @Override
    public void move(Table table, int checker, int player) {
        this.checkMovedDiagonalOne(table, checker, player);
    }
}

public class ComputerTest {
    @Test
    public void shouldBeComputerBHasMovedInDiagonalOne() {
        Computer computer = new NewComputer();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,1,1);

        computer.move(table, 2, -1);

        assertEquals(true, computer.isValid());
        assertEquals(-1, table.getField()[2][2]);
    }

    @Test
    public void shouldBeComputerBHasMovedInDiagonalTwo() {
        Computer computer = new NewComputer();
        Table table = new Table();

        table.setField(0,2,1);
        table.setField(1,1,1);

        computer.checkMovedDiagonalTwo(table, 2, -1);

        assertEquals(true, computer.isValid());
        assertEquals(-1, table.getField()[2][0]);
    }

    @Test
    public void shouldBeComputerHasMovedInColumn() {
        Computer computer = new NewComputer();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(1,0,1);

        computer.checkMovedColumns(table, 2, -1);

        assertEquals(true, computer.isValid());
        assertEquals(-1, table.getField()[2][0]);
    }

    @Test
    public void shouldBeComputerHasMovedInLine() {
        Computer computer = new NewComputer();
        Table table = new Table();

        table.setField(0,0,1);
        table.setField(0,1,1);

        computer.checkMovedLines(table, 2, -1);

        assertEquals(true, computer.isValid());
        assertEquals(-1, table.getField()[0][2]);
    }

    @Test
    public void shouldBeComputerBHasARandomMovement() {
        Computer computer = new NewComputer();
        Table table = new Table();

        computer.movedRandom(table, -1);
        int line = computer.getLine();
        int column = computer.getColumn();

        assertEquals(-1, table.getField()[line][column]);
    }
}
