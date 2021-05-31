package com.jacksonsr45.tictoctoe.domain.entity;

import com.jacksonsr45.tictoctoe.domain.request.PlayerManagerRequest;
import com.jacksonsr45.tictoctoe.domain.request.TicTocToeRequest;

public class PlayerEntity {
    private String id;
    private String name;

    public PlayerEntity(PlayerManagerRequest request) {
        setId(request.getPlayer().getId());
        this.setName(request.getPlayer().getName());
    }

    public PlayerEntity(TicTocToeRequest request) {
        this.setId(request.getPlayer().getId());
        this.setName(request.getPlayer().getName());
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
