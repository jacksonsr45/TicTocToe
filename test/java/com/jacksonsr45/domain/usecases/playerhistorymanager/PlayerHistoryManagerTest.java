package com.jacksonsr45.domain.usecases.playerhistorymanager;

import com.jacksonsr45.domain.request.PlayerHistoryRequest;
import com.jacksonsr45.domain.usecases.playerhistorymanager.presenter.PlayerHistoryPresenter;
import com.jacksonsr45.domain.usecases.playerhistorymanager.repository.PlayerHistoryRepository;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PlayerHistoryManagerTest {
    String playerId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String playerId2 = "afa36c80-8172-4370-8914-d4a148fa3174";
    String playerId3 = "afa36c80-8172-4370-8914-d4a148fa3182";
    String historyId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
    String historyId2 = "afa36c80-8172-4370-8914-d4a148fa3175";
    String historyId3 = "afa36c80-8172-4370-8914-d4a148fa3116";

    String id = UUID.randomUUID().toString();
    String idPlayer = UUID.randomUUID().toString();
    int victories = 2, defeats = 2, ties = 1, total = 5;

    @Test
    public void shouldBeCreatePlayerHistoryWithValuesUserAndGetReturn() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryRequest request = new PlayerHistoryRequest(idPlayer);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.createPlayerHistory(request, presenter);

        assertNotEquals(null, presenter.getPlayerHistoryViewModel().getId());
        assertEquals(idPlayer, presenter.getPlayerHistoryViewModel().getPlayerId());
    }

    @Test
    public void shouldBeCreatNewMoveWithValuesAndGetReturn() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryRequest request = new PlayerHistoryRequest(id, idPlayer,2, victories, defeats, ties, total);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.updatePlayerHistory(request, presenter);

        assertEquals(id, presenter.getPlayerHistoryViewModel().getId());
        assertEquals(idPlayer, presenter.getPlayerHistoryViewModel().getPlayerId());
        assertNotEquals(null, presenter.getPlayerHistoryViewModel().getMatch().get(0));
        assertEquals(2, presenter.getPlayerHistoryViewModel().getMatch().get(0).getLevel());
        assertEquals(victories, presenter.getPlayerHistoryViewModel().getVictories());
        assertEquals(defeats, presenter.getPlayerHistoryViewModel().getDefeats());
        assertEquals(ties, presenter.getPlayerHistoryViewModel().getTies());
        assertEquals(total, presenter.getPlayerHistoryViewModel().getTotal());
    }

    @Test
    public void shouldBeUpdateMovementAndGetReturn() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryRequest request = new PlayerHistoryRequest(id, idPlayer,2, victories, defeats, ties, total);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        request.getMatch().get(0).move(1,1,1,1);
        playerHistory.updatePlayerHistory(request, presenter);

        assertEquals(1, presenter.getPlayerHistoryViewModel().getMatch().get(0).getMovements().get(0).getId());
        assertEquals(1, presenter.getPlayerHistoryViewModel().getMatch().get(0).getMovements().get(0).getLine());
        assertEquals(1, presenter.getPlayerHistoryViewModel().getMatch().get(0).getMovements().get(0).getColumn());
        assertEquals(1, presenter.getPlayerHistoryViewModel().getMatch().get(0).getMovements().get(0).getValue());
    }

    @Test
    public void shouldBeShowPlayerHistoryByPlayerIdAndReturnValue() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.showPlayerHistory(playerId1, presenter);

        assertEquals(playerId1, presenter.getPlayerHistoryViewModel().getPlayerId());
        assertEquals(historyId1, presenter.getPlayerHistoryViewModel().getMatch().get(0).getId());
        assertEquals(historyId2, presenter.getPlayerHistoryViewModel().getMatch().get(1).getId());
        assertEquals(historyId3, presenter.getPlayerHistoryViewModel().getMatch().get(2).getId());
    }

    @Test
    public void shouldBeListPlayerHistoryByPlayersAndReturnValue() {
        PlayerHistoryRepository repository = new PlayerHistoryRepository();
        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();

        playerHistory.listPlayerHistories(presenter);

        assertEquals(playerId1, presenter.getPlayersHistoryViewModel().get(0).getPlayerId());
        assertEquals(playerId2, presenter.getPlayersHistoryViewModel().get(1).getPlayerId());
        assertEquals(playerId3, presenter.getPlayersHistoryViewModel().get(2).getPlayerId());
    }
}
