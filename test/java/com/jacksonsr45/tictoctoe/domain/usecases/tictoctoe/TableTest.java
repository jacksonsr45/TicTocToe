package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {
    @Test
    public void shouldBeCreatedANewTable() {
        Table table = new Table();
        for (int i = 0; i < table.getField().length; i++) {
            for (int j = 0; j < table.getField().length; j++) {
                int value = table.getField()[i][j];
                assertEquals(0, value);
            }
        }
    }

    @Test
    public void shouldBeVerifyPlayIsValid() {
        Table table = new Table();

        assertEquals(true, table.isValid(1, 1));
    }

    @Test
    public void shouldBeResultInDiagonalOneHasTrue() {
        Table table = new Table();

        table.setField(0, 0, 1);
        table.setField(1, 1, 1);
        table.setField(2, 2, 1);

        assertEquals(true, table.checkDiagonalOne(3, 1));
    }

    @Test
    public void shouldBeResultInDiagonalTwoHasTrue() {
        Table table = new Table();

        table.setField(0, 2, 1);
        table.setField(1, 1, 1);
        table.setField(2, 0, 1);

        assertEquals(true, table.checkDiagonalTwo(3, 1));
    }

    @Test
    public void shouldBeResultInColumnHasTrue() {
        Table table = new Table();

        table.setField(0, 1, 1);
        table.setField(1, 1, 1);
        table.setField(2, 1, 1);

        assertEquals(true, table.checkColumn(3, 1));
    }

    @Test
    public void shouldBeResultInLineHasTrue() {
        Table table = new Table();

        table.setField(0, 0, 1);
        table.setField(0, 1, 1);
        table.setField(0, 2, 1);

        assertEquals(true, table.checkLine(3, 1));
    }

    @Test
    public void shouldBeResultInATieHasTrue() {
        Table table = new Table();

        table.setField(0, 0, 1);
        table.setField(0, 1, 1);
        table.setField(0, 2, -1);
        table.setField(1, 0, -1);
        table.setField(1, 1, -1);
        table.setField(1, 2, 1);
        table.setField(2, 0, -1);
        table.setField(2, 1, 1);
        table.setField(2, 2, 1);

        assertEquals(true, table.checkATie());
    }

    @Test
    public void shouldBeResultReturnValueCorrect() {
        Table table = new Table();

        table.setField(0, 0, 1);
        table.setField(0, 1, 1);
        table.setField(0, 2, 1);

        table.checkLine(3, 1);

        assertEquals(1, table.getResult());
    }
}
