package com.jacksonsr45.tictoctoe.domain.usecases.playermanager;

import java.util.UUID;

public class Player {
    private String id;
    private String name;

    public Player(String id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Player(String name) {
        this.setId(UUID.randomUUID().toString());
        this.setName(name);
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
