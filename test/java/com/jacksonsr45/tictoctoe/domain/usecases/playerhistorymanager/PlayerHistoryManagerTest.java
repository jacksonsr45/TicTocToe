package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager;

import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.presenter.PlayerHistoryPresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.repository.PlayerHistoryRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class PlayerHistoryManagerTest {
    String matchId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String matchId2 = "afa36c80-8172-4370-8914-d4a148fa3987";
    String matchId3 = "afa36c80-8172-4370-8914-d4a148fa3456";
    String historyId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String historyId2 = "afa36c80-8172-4370-8914-d4a148fa3175";
    String historyId3 = "afa36c80-8172-4370-8914-d4a148fa3116";
    String playerId1 = "afa36c80-8172-4370-8914-d4a148fa3128";

    String id = UUID.randomUUID().toString();
    int victories = 2, defeats = 2, ties = 1, total = 5;

    @Test
    public void shouldBeCreatePlayerHistoryWithValuesUserAndGetReturn() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryRequest request = new PlayerHistoryRequest(playerId1);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.createPlayerHistory(request, presenter);

        assertNotEquals(null, presenter.getPlayerHistory().id);
        assertEquals(playerId1, presenter.getPlayerHistory().playerId);
    }

    @Test
    public void shouldBeShowPlayerHistoryReturnPlayerValue() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.showPlayerHistory(playerId1, presenter);

        assertEquals(historyId1, presenter.getPlayerHistory().id);
        assertEquals(playerId1, presenter.getPlayerHistory().playerId);
        assertEquals(1, presenter.getPlayerHistory().victories);
        assertEquals(0, presenter.getPlayerHistory().defeats);
        assertEquals(0, presenter.getPlayerHistory().ties);
        assertEquals(1, presenter.getPlayerHistory().total);
    }

    @Test
    public void shouldBeListMatchReturnListWithValues() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.listMatch(presenter);

        assertEquals(1, presenter.getMatches().get(0).level);
        assertEquals(historyId1, presenter.getMatches().get(0).playersHistoryId);
        assertEquals(2, presenter.getMatches().get(1).level);
        assertEquals(historyId2, presenter.getMatches().get(1).playersHistoryId);
        assertEquals(3, presenter.getMatches().get(2).level);
        assertEquals(historyId3, presenter.getMatches().get(2).playersHistoryId);
    }

    @Test
    public void shouldBeShouMatchReturnValuesById() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.showMatch(matchId1, presenter);

        assertEquals(matchId1, presenter.getMatch().id);
        assertEquals(historyId1, presenter.getMatch().playersHistoryId);
    }

    @Test
    public void shouldBeListMovementsReturnAllMovementsInMatch() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.listMovements(presenter);

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
}
