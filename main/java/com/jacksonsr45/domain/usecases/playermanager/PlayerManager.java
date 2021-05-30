package com.jacksonsr45.domain.usecases.playermanager;

import com.jacksonsr45.domain.entity.PlayerEntity;
import com.jacksonsr45.domain.gateway.PlayerManagerInterface;
import com.jacksonsr45.domain.presenter.PlayerManagerPresenterInterface;
import com.jacksonsr45.domain.request.PlayerManagerRequest;

public class PlayerManager {
    private PlayerManagerInterface player;

    public PlayerManager(PlayerManagerInterface player) {
        this.player = player;
    }

    public void addPlayer(PlayerManagerRequest request, PlayerManagerPresenterInterface presenter) {
        presenter.present(player.addPlayer(new PlayerEntity(request)));
    }

    public void updatePlayer(PlayerManagerRequest request, PlayerManagerPresenterInterface presenter) {
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
