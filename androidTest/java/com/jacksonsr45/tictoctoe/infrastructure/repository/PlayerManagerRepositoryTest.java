package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PlayerManagerRepositoryTest {
    private Context appContext;
    private PlayerManagerRepository playerManagerRepository;
    private ArrayList<PlayerResponse> players;
    private PlayerResponse response;
    private PlayerRequest request, request1, request2, request3, requestUp;
    private PlayerEntity entity, entity1, entity2, entity3, entityUp;
    private String name = "Test One";
    private String name1 = "Test Two";
    private String name2 = "Test Three";
    private String name3 = "Test Four";

    @Before
    public void initContextAndDefaultsComponents() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        playerManagerRepository = new PlayerManagerRepository(appContext);

        this.request = new PlayerRequest(this.name);
        this.entity = new PlayerEntity(request);
        this.request1 = new PlayerRequest(this.name1);
        this.entity1 = new PlayerEntity(request1);
        this.request2 = new PlayerRequest(this.name2);
        this.entity2 = new PlayerEntity(request2);
        this.request3 = new PlayerRequest(this.name3);
        this.entity3 = new PlayerEntity(request3);
        this.requestUp = new PlayerRequest(request.getId(), this.name1);
        this.entityUp = new PlayerEntity(this.requestUp);
    }

    @Test
    public void shouldBeAddPlayerInsertInDBValues() {
        this.request = new PlayerRequest(this.name);
        this.entity = new PlayerEntity(request);

        this.playerManagerRepository.addPlayer(this.entity);
        this.response = this.playerManagerRepository.showPlayer(request.getId());

        assertEquals(request.getId(), response.id);
        assertEquals(this.name, response.name);
    }

    @Test
    public void shouldBeDeletePlayerInDataBaseAndReturnResponseNull() {
        this.playerManagerRepository.addPlayer(this.entity);
        this.playerManagerRepository.deletePlayer(this.request.getId());

        this.response = this.playerManagerRepository.showPlayer(this.request.getId());

        assertNull(null, this.response);
    }

    @Test
    public void shouldBeShowPlayerReceivePlayerIdAndCompareReturnDatabase() {
        this.playerManagerRepository.addPlayer(this.entity);

        this.response = this.playerManagerRepository.showPlayer(this.request.getId());

        assertEquals(this.request.getId(), this.response.id);
        assertEquals(this.name, this.response.name);
    }

    @Test
    public void shouldBeUpdatePlayerSetValuesByPlayerIdAndReturnValuesDatabaseUpdated() {
        this.playerManagerRepository.addPlayer(this.entity);
        this.response = this.playerManagerRepository.showPlayer(request.getId());
        this.response = this.playerManagerRepository.updatedPlayer(this.entityUp);

        assertEquals(request.getId(), response.id);
        assertEquals(this.name1, response.name);
    }

    @Test
    public void shouldBeListPlayerGetValuesAndCompareArrayListWithPlayerResponse() {
        this.playerManagerRepository.addPlayer(this.entity);
        this.playerManagerRepository.addPlayer(this.entity1);
        this.playerManagerRepository.addPlayer(this.entity2);
        this.playerManagerRepository.addPlayer(this.entity3);

        this.players = this.playerManagerRepository.listPlayers();

        assertEquals(ArrayList.class, this.players.getClass());
        for (PlayerResponse test: this.players) {
            assertEquals(PlayerResponse.class, test.getClass());
            assertNotEquals(null, test.id);
            assertNotEquals(null, test.name);
        }
    }

    @After
    public void dropTable() {
        this.playerManagerRepository.deletePlayer(request.getId());
        this.playerManagerRepository.deletePlayer(request1.getId());
        this.playerManagerRepository.deletePlayer(request2.getId());
        this.playerManagerRepository.deletePlayer(request3.getId());
    }
}
