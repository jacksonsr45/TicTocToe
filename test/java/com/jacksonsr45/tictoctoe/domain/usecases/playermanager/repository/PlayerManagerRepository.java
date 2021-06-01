package com.jacksonsr45.tictoctoe.domain.usecases.playermanager.repository;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.gateway.PlayerManagerInterface;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;

import java.util.ArrayList;

public class PlayerManagerRepository implements PlayerManagerInterface {
    @Override
    public PlayerResponse addPlayer(PlayerEntity player) {
        return new PlayerResponse(player);
    }

    @Override
    public PlayerResponse updatedPlayer(PlayerEntity player) {
        return new PlayerResponse(player);
    }

    @Override
    public PlayerResponse deletePlayer(String id) {
        PlayerRequest request = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e035", "Jackson");
        PlayerEntity player = new PlayerEntity(request);
        if (player.id == id) {
            player.id = null;
            player.name = null;
        }
        return new PlayerResponse(player);
    }

    @Override
    public ArrayList<PlayerResponse> listPlayers() {
        ArrayList<PlayerResponse> players = new ArrayList<PlayerResponse>();
        PlayerRequest request = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e035", "Test One");
        PlayerEntity player = new PlayerEntity(request);
        players.add(new PlayerResponse(player));
        PlayerRequest request1 = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e057", "Test Two");
        PlayerEntity player1 = new PlayerEntity(request1);
        players.add(new PlayerResponse(player1));
        PlayerRequest request2 = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e084", "Test Three");
        PlayerEntity player2 = new PlayerEntity(request2);
        players.add(new PlayerResponse(player2));
        return players;
    }

    @Override
    public PlayerResponse showPlayer(String id) {
        PlayerResponse returnPlayer = null;
        ArrayList<PlayerEntity> players = new ArrayList<PlayerEntity>();
        PlayerRequest request = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e035", "Test One");
        players.add(new PlayerEntity(request));
        PlayerRequest request1 = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e057", "Test Two");
        players.add(new PlayerEntity(request1));
        PlayerRequest request2 = new PlayerRequest("53d051ec-f1c3-4b52-9878-12954563e084", "Test Three");
        players.add(new PlayerEntity(request2));
        for (PlayerEntity playerEntity: players) {
            if (playerEntity.id == id ) {
                returnPlayer = new PlayerResponse(playerEntity);
            }
        }
        return returnPlayer;
    }
}
