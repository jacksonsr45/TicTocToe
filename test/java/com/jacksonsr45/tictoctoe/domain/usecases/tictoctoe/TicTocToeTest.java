package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

import com.jacksonsr45.tictoctoe.domain.request.TicTocToeRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.presenter.TicTocToePresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.repository.TicTocToeRepository;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class TicTocToeTest {
    @Test
    public void shouldBeCreatingNewTicTocToeWithValues() {
        TicTocToeRepository repository = new TicTocToeRepository();
        TicTocToe ticTocToe = new TicTocToe(repository);
        String id = UUID.randomUUID().toString();
        TicTocToeRequest request = new TicTocToeRequest( id, "Jackson",0);

        request.getTable().setField(0,0,1);
        TicTocToePresenter presenter = new TicTocToePresenter();
        ticTocToe.initGame(request, presenter);

        assertEquals(request.getPlayer().getName(), presenter.ticTocToeViewModel().getPlayer().getName());
        assertEquals(id, presenter.ticTocToeViewModel().getPlayer().getId());
        assertEquals(1, presenter.ticTocToeViewModel().getTable().getField()[0][0]);
    }

    @Test
    public void shouldBeTicTocToeSetComputerMovement() {
        TicTocToeRepository repository = new TicTocToeRepository();
        TicTocToe ticTocToe = new TicTocToe(repository);
        String id = UUID.randomUUID().toString();
        TicTocToeRequest request = new TicTocToeRequest( id, "Jackson",2);
        TicTocToePresenter presenter = new TicTocToePresenter();

        request.getTable().setField(0,0,1);
        request.getTable().setField(1,1,1);
        ticTocToe.computerMove(request, presenter);

        assertEquals(1, presenter.ticTocToeViewModel().getTable().getField()[0][0]);
        assertEquals(1, presenter.ticTocToeViewModel().getTable().getField()[1][1]);
        assertEquals(-1, presenter.ticTocToeViewModel().getTable().getField()[2][2]);
    }

    @Test
    public void shouldBeTicTocToeSetPlayerMovement() {
        TicTocToeRepository repository = new TicTocToeRepository();
        TicTocToe ticTocToe = new TicTocToe(repository);
        String id = UUID.randomUUID().toString();
        TicTocToeRequest request = new TicTocToeRequest( id, "Jackson",0);
        TicTocToePresenter presenter = new TicTocToePresenter();

        request.getPlayer().move(request.getTable(), 0,0);
        ticTocToe.playerMove(request, presenter);

        assertEquals(1, presenter.ticTocToeViewModel().getTable().getField()[0][0]);
    }
}
