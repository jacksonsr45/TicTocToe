package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager;

import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.presenter.PlayerHistoryPresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.repository.PlayerHistoryRepository;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PlayerHistoryManagerTest {
//    String playerId1 = "afa36c80-8172-4370-8914-d4a148fa3128";
//    String playerId2 = "afa36c80-8172-4370-8914-d4a148fa3174";
//    String playerId3 = "afa36c80-8172-4370-8914-d4a148fa3182";
//
//    String id = UUID.randomUUID().toString();
//    String idPlayer = UUID.randomUUID().toString();
//    int victories = 2, defeats = 2, ties = 1, total = 5;
//
//    @Test
//    public void shouldBeCreatePlayerHistoryWithValuesUserAndGetReturn() {
//        PlayerHistoryRepository repository = new PlayerHistoryRepository();
//        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
//        PlayerHistoryRequest request = new PlayerHistoryRequest(idPlayer);
//        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();
//
//        playerHistory.createPlayerHistory(request, presenter);
//
//        assertNotEquals(null, presenter.playerHistory().id);
//        assertEquals(idPlayer, presenter.playerHistory().playerId);
//    }
//
//    @Test
//    public void shouldBeCreatNewMoveWithValuesAndGetReturn() {
//        PlayerHistoryRepository repository = new PlayerHistoryRepository();
//        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
//        PlayerHistoryRequest request = new PlayerHistoryRequest(id, idPlayer, victories, defeats, ties, total);
//        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();
//
//        playerHistory.updatePlayerHistory(request, presenter);
//
//        assertEquals(id, presenter.playerHistory().id);
//        assertEquals(idPlayer, presenter.playerHistory().playerId);
//        assertEquals(victories, presenter.playerHistory().victories);
//        assertEquals(defeats, presenter.playerHistory().defeats);
//        assertEquals(ties, presenter.playerHistory().ties);
//        assertEquals(total, presenter.playerHistory().total);
//    }
//
//    @Test
//    public void shouldBeShowPlayerHistoryByPlayerIdAndReturnValue() {
//        PlayerHistoryRepository repository = new PlayerHistoryRepository();
//        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
//        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();
//
//        playerHistory.showPlayerHistory(playerId1, presenter);
//
//        assertEquals(playerId1, presenter.playerHistory().playerId);
//    }
//
//    @Test
//    public void shouldBeListPlayerHistoryByPlayersAndReturnValue() {
//        PlayerHistoryRepository repository = new PlayerHistoryRepository();
//        PlayerHistoryManager playerHistory = new PlayerHistoryManager(repository);
//        PlayerHistoryPresenter presenter = new PlayerHistoryPresenter();
//
//        playerHistory.listPlayerHistories(presenter);
//
//        assertEquals(playerId1, presenter.playersHistory().get(0).playerId);
//        assertEquals(playerId2, presenter.playersHistory().get(1).playerId);
//        assertEquals(playerId3, presenter.playersHistory().get(2).playerId);
//    }
}
