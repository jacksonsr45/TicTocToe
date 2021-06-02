package com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager;

import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerHistoryInterface;
import com.jacksonsr45.tictoctoe.domain.presenter.PlayerHistoryPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;

import java.util.ArrayList;

public class PlayerHistoryManager {
    private PlayerHistoryInterface playerHistory;

    public PlayerHistoryManager(PlayerHistoryInterface playerHistory) {
        this.playerHistory = playerHistory;
    }

    public void createPlayerHistory(PlayerHistoryRequest request, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.createPlayerHistory(new PlayerHistoryEntity(request)));
    }


    public void deletePlayerHistory(String playerId, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.deletePlayerHistory(playerId));
    }

    public void showPlayerHistory(String playerId, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.showPlayerHistory(playerId));
    }

    public void listMatch(String playerHistoryId, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.listMatch(playerHistoryId));
    }

    public void showMatch(String id, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.showMatch(id));
    }

    public void listMovements(String matchId, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.listMovements(matchId));
    }
}
