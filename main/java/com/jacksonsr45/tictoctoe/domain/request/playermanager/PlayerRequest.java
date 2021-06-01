package com.jacksonsr45.tictoctoe.domain.request.playermanager;

import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.Player;

public class PlayerRequest {
    private Player player;
    private String id;
    private String name;

    public PlayerRequest(String id, String name) {
        this.player = new Player(id, name);
        this.setId(this.player.getId());
        this.setName(this.player.getName());
    }

    public PlayerRequest(String name) {
        this.player = new Player(name);
        this.setId(this.player.getId());
        this.setName(this.player.getName());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
