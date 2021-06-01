package com.jacksonsr45.tictoctoe.domain.gateway;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;

import java.util.ArrayList;

public interface PlayerManagerInterface {
    public PlayerResponse addPlayer(PlayerEntity player);

    public PlayerResponse updatedPlayer(PlayerEntity player);

    public PlayerResponse deletePlayer(String id);

    public ArrayList<PlayerResponse> listPlayers();

    public PlayerResponse showPlayer(String id);
}
