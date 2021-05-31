package com.jacksonsr45.tictoctoe.domain.usecases.playermanager.repository;

import com.jacksonsr45.tictoctoe.domain.entity.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerManagerInterface;
import com.jacksonsr45.tictoctoe.domain.request.PlayerManagerRequest;
import com.jacksonsr45.tictoctoe.domain.response.PlayerManagerResponse;

import java.util.ArrayList;

public class PlayerManagerRepository implements PlayerManagerInterface {
    @Override
    public PlayerManagerResponse addPlayer(PlayerEntity player) {
        return new PlayerManagerResponse(player);
    }

    @Override
    public PlayerManagerResponse updatedPlayer(PlayerEntity player) {
        return new PlayerManagerResponse(player);
    }

    @Override
    public PlayerManagerResponse deletePlayer(String id) {
        PlayerManagerRequest request = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e035", "Jackson");
        PlayerEntity player = new PlayerEntity(request);
        if (player.getId() == id) {
            player.setId(null);
            player.setName(null);
        }
        return new PlayerManagerResponse(player);
    }

    @Override
    public ArrayList<PlayerManagerResponse> listPlayers() {
        ArrayList<PlayerManagerResponse> players = new ArrayList<PlayerManagerResponse>();
        PlayerManagerRequest request = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e035", "Test One");
        PlayerEntity player = new PlayerEntity(request);
        players.add(new PlayerManagerResponse(player));
        PlayerManagerRequest request1 = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e057", "Test Two");
        PlayerEntity player1 = new PlayerEntity(request1);
        players.add(new PlayerManagerResponse(player1));
        PlayerManagerRequest request2 = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e084", "Test Three");
        PlayerEntity player2 = new PlayerEntity(request2);
        players.add(new PlayerManagerResponse(player2));
        return players;
    }

    @Override
    public PlayerManagerResponse showPlayer(String id) {
        PlayerManagerResponse returnPlayer = null;
        ArrayList<PlayerEntity> players = new ArrayList<PlayerEntity>();
        PlayerManagerRequest request = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e035", "Test One");
        players.add(new PlayerEntity(request));
        PlayerManagerRequest request1 = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e057", "Test Two");
        players.add(new PlayerEntity(request1));
        PlayerManagerRequest request2 = new PlayerManagerRequest("53d051ec-f1c3-4b52-9878-12954563e084", "Test Three");
        players.add(new PlayerEntity(request2));
        for (PlayerEntity playerEntity: players) {
            if (playerEntity.getId() == id ) {
                returnPlayer = new PlayerManagerResponse(playerEntity);
            }
        }
        return returnPlayer;
    }
}
