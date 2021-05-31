package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.response.PlayerManagerResponse;

import java.util.ArrayList;

public interface PlayerManagerInterface {
    public PlayerManagerResponse addPlayer(PlayerEntity player);

    public PlayerManagerResponse updatedPlayer(PlayerEntity player);

    public PlayerManagerResponse deletePlayer(String id);

    public ArrayList<PlayerManagerResponse> listPlayers();

    public PlayerManagerResponse showPlayer(String id);
}
