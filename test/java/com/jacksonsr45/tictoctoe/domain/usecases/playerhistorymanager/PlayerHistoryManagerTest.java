package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager;

import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.presenter.PlayerHistoryPresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.repository.PlayerHistoryRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class PlayerHistoryManagerTest {
    private PlayerHistoryRepository repository;
    private PlayerHistoryManager playerHistory;
    private PlayerHistoryPresenter presenter;
    private String matchId1, historyId1, historyId2, historyId3, playerId1;

    @Before
    public void initComponentsDefaults() {
        repository = new PlayerHistoryRepository();
        playerHistory = new PlayerHistoryManager(repository);
        presenter = new PlayerHistoryPresenter();

        matchId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
        historyId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
        historyId2 = "afa36c80-8172-4370-8914-d4a148fa3175";
        historyId3 = "afa36c80-8172-4370-8914-d4a148fa3116";
        playerId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    }

    @Test
    public void shouldBeCreatePlayerHistoryAndCompareResult() {
        PlayerHistoryRequest request = new PlayerHistoryRequest(playerId1);

        playerHistory.createPlayerHistory(request, presenter);

        assertEquals(PlayerHistoryResponse.class, presenter.getPlayerHistory().getClass());
        assertNotEquals(null, presenter.getPlayerHistory().id);
        assertEquals(playerId1, presenter.getPlayerHistory().playerId);
    }

    @Test
    public void shouldBeDeletePlayerHistoryByPlayerID() {
        playerHistory.deletePlayerHistory(playerId1, presenter);

        assertEquals(null, presenter.getPlayerHistory());
    }

    @Test
    public void shouldBeShowPlayerHistoryReturnPlayerValue() {
        playerHistory.showPlayerHistory(playerId1, presenter);

        assertEquals(PlayerHistoryResponse.class, presenter.getPlayerHistory().getClass());
        assertEquals(historyId1, presenter.getPlayerHistory().id);
        assertEquals(playerId1, presenter.getPlayerHistory().playerId);
        assertEquals(1, presenter.getPlayerHistory().victories);
        assertEquals(0, presenter.getPlayerHistory().defeats);
        assertEquals(0, presenter.getPlayerHistory().ties);
        assertEquals(1, presenter.getPlayerHistory().total);
    }

    @Test
    public void shouldBeListMatchReturnArrayListWithValues() {
        playerHistory.listMatch( historyId1, presenter);

        assertEquals(ArrayList.class, presenter.getMatches().getClass());
        assertEquals(MatchResponse.class, presenter.getMatches().get(0).getClass());
        assertEquals(1, presenter.getMatches().get(0).level);
        assertEquals(historyId1, presenter.getMatches().get(0).playersHistoryId);
        assertEquals(2, presenter.getMatches().get(1).level);
        assertEquals(historyId2, presenter.getMatches().get(1).playersHistoryId);
        assertEquals(3, presenter.getMatches().get(2).level);
        assertEquals(historyId3, presenter.getMatches().get(2).playersHistoryId);
    }

    @Test
    public void shouldBeShouMatchReturnValuesMatchResponseByMatchId() {
        playerHistory.showMatch(matchId1, presenter);

        assertEquals(MatchResponse.class, presenter.getMatch().getClass());
        assertEquals(matchId1, presenter.getMatch().id);
        assertEquals(historyId1, presenter.getMatch().playersHistoryId);
    }

    @Test
    public void shouldBeListMovementsReturnAllMovementsInMatchInArrayListWithMovementsResponse() {
        playerHistory.listMovements(matchId1, presenter);

        assertEquals(ArrayList.class, presenter.getMovements().getClass());
        assertEquals(MovementsResponse.class, presenter.getMovements().get(0).getClass());
        assertEquals(1, presenter.getMovements().get(0).id);
        assertEquals(matchId1, presenter.getMovements().get(0).matchId);
        assertEquals(0, presenter.getMovements().get(0).line);
        assertEquals(0, presenter.getMovements().get(0).column);
        assertEquals(1, presenter.getMovements().get(0).value);
        assertEquals(2, presenter.getMovements().get(1).id);
        assertEquals(matchId1, presenter.getMovements().get(1).matchId);
        assertEquals(1, presenter.getMovements().get(1).line);
        assertEquals(1, presenter.getMovements().get(1).column);
        assertEquals(1, presenter.getMovements().get(1).value);
        assertEquals(3, presenter.getMovements().get(2).id);
        assertEquals(matchId1, presenter.getMovements().get(2).matchId);
        assertEquals(2, presenter.getMovements().get(2).line);
        assertEquals(2, presenter.getMovements().get(2).column);
        assertEquals(1, presenter.getMovements().get(2).value);
    }

    @After
    public void setNull() {
        repository = null;
        playerHistory = null;
        presenter = null;
        matchId1 = null;
        historyId1 = null;
        historyId2 = null;
        historyId3 = null;
        playerId1 = null;
    }
}
