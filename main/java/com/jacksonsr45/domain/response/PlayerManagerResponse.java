package com.jacksonsr45.domain.response;

import com.jacksonsr45.domain.entity.PlayerEntity;

public class PlayerManagerResponse {
    private String id;
    private String name;

    public PlayerManagerResponse(PlayerEntity player) {
        this.setId(player.getId());
        this.setName(player.getName());
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
