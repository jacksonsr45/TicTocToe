package com.jacksonsr45.domain.request;

import com.jacksonsr45.domain.usecases.playermanager.Player;

public class PlayerManagerRequest {
    private Player player;

    public PlayerManagerRequest(String id, String name) {
        this.setPlayer(new Player(id, name));
    }

    public PlayerManagerRequest(String name) {
        this.setPlayer(new Player(name));
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
