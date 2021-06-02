package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PlayerManagerRepositoryTest {
    private Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    private PlayerManagerRepository playerManagerRepository = new PlayerManagerRepository(appContext);
    private ArrayList<PlayerResponse> players;
    private PlayerResponse response, response1, response2, response3;
    private PlayerRequest request, request1, request2, request3;
    private PlayerEntity entity, entity1, entity2, entity3;
    private String name = "Test One";
    private String name1 = "Test Two";
    private String name2 = "Test Three";
    private String name3 = "Test Four";

    @Test
    public void shouldBeAddPlayerInsertInDBValues() {
        this.request = new PlayerRequest(this.name);
        this.entity = new PlayerEntity(request);

        this.playerManagerRepository.addPlayer(this.entity);
        this.response = this.playerManagerRepository.showPlayer(request.getId());

        assertEquals(request.getId(), response.id);
        assertEquals(this.name, response.name);
        this.playerManagerRepository.deletePlayer(request.getId());
    }

    @Test
    public void shouldBeUpdatePlayerSetValuesByUpdatePlayer() {
        this.request = new PlayerRequest(this.name);
        this.entity = new PlayerEntity(request);

        this.playerManagerRepository.addPlayer(this.entity);
        this.response = this.playerManagerRepository.showPlayer(request.getId());
        this.request1 = new PlayerRequest(request.getId(), this.name1);
        this.entity = new PlayerEntity(this.request1);
        this.response = this.playerManagerRepository.updatedPlayer(this.entity);

        assertEquals(request.getId(), response.id);
        assertEquals(this.name1, response.name);
        this.playerManagerRepository.deletePlayer(request.getId());
    }

    @Test
    public void shouldBeListPlayerGetValuesAndCompareWithDataResponse() {
        this.request = new PlayerRequest(this.name);
        this.entity = new PlayerEntity(request);
        this.playerManagerRepository.addPlayer(this.entity);
        this.request1 = new PlayerRequest(this.name1);
        this.entity1 = new PlayerEntity(request1);
        this.playerManagerRepository.addPlayer(this.entity1);
        this.request2 = new PlayerRequest(this.name2);
        this.entity2 = new PlayerEntity(request2);
        this.playerManagerRepository.addPlayer(this.entity2);
        this.request3 = new PlayerRequest(this.name3);
        this.entity3 = new PlayerEntity(request3);
        this.playerManagerRepository.addPlayer(this.entity3);

        this.players = this.playerManagerRepository.listPlayers();

        assertEquals(true, this.players.contains(request.getId()));
//        assertEquals(request1.getId(), this.players.get(1).id);
//        assertEquals(request1.getName(), this.players.get(1).name);
//        assertEquals(request2.getId(), this.players.get(2).id);
//        assertEquals(request2.getName(), this.players.get(2).name);
//        assertEquals(request3.getId(), this.players.get(3).id);
//        assertEquals(request3.getName(), this.players.get(3).name);
        this.playerManagerRepository.deletePlayer(request.getId());
//        this.playerManagerRepository.deletePlayer(request1.getId());
//        this.playerManagerRepository.deletePlayer(request2.getId());
//        this.playerManagerRepository.deletePlayer(request3.getId());
    }
}
