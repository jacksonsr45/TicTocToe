package com.jacksonsr45.domain.usecases.playerhistorymanager;

import com.jacksonsr45.domain.entity.PlayerHistoryEntity;
import com.jacksonsr45.domain.gateway.PlayerHistoryInterface;
import com.jacksonsr45.domain.presenter.PlayerHistoryPresenterInterface;
import com.jacksonsr45.domain.request.PlayerHistoryRequest;

public class PlayerHistoryManager {
    private PlayerHistoryInterface playerHistory;

    public PlayerHistoryManager(PlayerHistoryInterface playerHistory) {
        this.playerHistory = playerHistory;
    }

    public void createPlayerHistory(PlayerHistoryRequest request, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.createPlayerHistory(new PlayerHistoryEntity(request)));
    }

    public void updatePlayerHistory(PlayerHistoryRequest request, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.updatePlayerHistory(new PlayerHistoryEntity(request)));
    }

    public void showPlayerHistory(String id, PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.showPlayerHistory(id));
    }

    public void listPlayerHistories(PlayerHistoryPresenterInterface presenter) {
        presenter.present(this.playerHistory.listPlayerHistories());
    }
}
