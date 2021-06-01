package com.jacksonsr45.tictoctoe.domain.usecases.playermanager;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerManagerInterface;
import com.jacksonsr45.tictoctoe.domain.presenter.PlayerManagerPresenterInterface;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;

public class PlayerManager {
    private PlayerManagerInterface player;

    public PlayerManager(PlayerManagerInterface player) {
        this.player = player;
    }

    public void addPlayer(PlayerRequest request, PlayerManagerPresenterInterface presenter) {
        presenter.present(player.addPlayer(new PlayerEntity(request)));
    }

    public void updatePlayer(PlayerRequest request, PlayerManagerPresenterInterface presenter) {
        presenter.present(player.updatedPlayer(new PlayerEntity(request)));
    }

    public void deletePlayer(String id, PlayerManagerPresenterInterface presenter) {
        presenter.present(player.deletePlayer(id));
    }

    public void listPlayers(PlayerManagerPresenterInterface presenter) {
        presenter.present(player.listPlayers());
    }

    public void showPlayer(String id, PlayerManagerPresenterInterface presenter) {
        presenter.present(player.showPlayer(id));
    }
}
