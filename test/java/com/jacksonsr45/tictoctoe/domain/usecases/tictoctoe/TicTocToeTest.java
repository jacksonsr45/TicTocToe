package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MovementRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.presenter.TicTocToePresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.repository.TicTocToeRepository;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class TicTocToeTest {
    TicTocToePresenter presenter = new TicTocToePresenter();
    TicTocToeRepository repository = new TicTocToeRepository();
    TicTocToe ticTocToe = new TicTocToe(repository);
    String playerHistoryId = UUID.randomUUID().toString();
    String matchId = UUID.randomUUID().toString();
    String playerId = UUID.randomUUID().toString();
    @Test
    public void shouldBeStartMatchCreateAndReturnValues() {
        MatchRequest request = new MatchRequest(playerHistoryId, 2);

        this.ticTocToe.startMatch(request, this.presenter);

        assertNotEquals(null, this.presenter.getMatch().id);
        assertEquals(playerHistoryId, this.presenter.getMatch().playersHistoryId);
        assertEquals(2, this.presenter.getMatch().level);
        assertEquals(0, this.presenter.getMatch().result);
        assertNotEquals(null, this.presenter.getMatch().createdAt);
    }

    @Test
    public void shouldBeComputerMovementReturnValueCorrect() {
        Table table = new Table();
        table.setField(0,0,1);
        table.setField(1,1,1);
        MovementRequest request = new MovementRequest(3, matchId, table, 2, 2);

        this.ticTocToe.computerMove(request, this.presenter);

        assertEquals(3, this.presenter.getMovements().id);
        assertEquals(matchId, this.presenter.getMovements().matchId);
        assertEquals(2, this.presenter.getMovements().line);
        assertEquals(2, this.presenter.getMovements().column);
        assertEquals(-1, this.presenter.getMovements().value);
        assertEquals(table.getField()[2][2], this.presenter.getMovements().table.getField()[2][2]);
    }

    @Test
    public void shouldBePlayerMovementReturnValueCorrect() {
        MovementRequest request = new MovementRequest(1, matchId, null, 0,0,1);

        this.ticTocToe.playerMove(request, this.presenter);

        assertEquals(1, this.presenter.getMovements().id);
        assertEquals(0, this.presenter.getMovements().line);
        assertEquals(0, this.presenter.getMovements().column);
        assertEquals(1, this.presenter.getMovements().value);
        assertEquals(1, this.presenter.getMovements().table.getField()[0][0]);
    }

    @Test
    public void shouldBeCheckResultReturnValueTrueAndSetValueInTableGetResult() {
        int player = 1;
        Table table = new Table();
        table.setField(1,0,player);
        table.setField(1,1,player);
        table.setField(1,2,player);

        boolean value = this.ticTocToe.checkResult(table);

        assertEquals(true, value);
        assertEquals(1, table.getResult());
    }

    @Test
    public void shouldBeSetPlayerHistoryReturnValueCorrect() {
        Table table = new Table();
        table.setField(0,0,1);
        table.setField(1,1,1);
        table.setField(2,2,1);

        this.ticTocToe.checkResult(table);
        PlayerHistoryRequest request = new PlayerHistoryRequest(table, playerHistoryId, playerId, 0,0,0,0);
        this.ticTocToe.setPlayerHistory(request, this.presenter);

        assertEquals(playerHistoryId, this.presenter.getPlayerHistory().id);
        assertEquals(playerId, this.presenter.getPlayerHistory().playerId);
        assertEquals(1, this.presenter.getPlayerHistory().total);
        assertEquals(1, this.presenter.getPlayerHistory().victories);
        assertEquals(0, this.presenter.getPlayerHistory().defeats);
        assertEquals(0, this.presenter.getPlayerHistory().ties);
    }
}
