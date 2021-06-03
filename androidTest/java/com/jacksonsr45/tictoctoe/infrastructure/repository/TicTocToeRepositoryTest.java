package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MatchRequest;
import com.jacksonsr45.tictoctoe.domain.request.tictoctoe.MovementRequest;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;
import com.jacksonsr45.tictoctoe.domain.response.tictoctoe.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class TicTocToeRepositoryTest {
    private Context appContext;
    private TicTocToeRepository repository;
    private PlayerHistoryRepository playerHistoryRepository;
    private PlayerHistoryResponse playerHistoryResponse;
    private MovementsResponse movementsResponse;
    private MatchRequest matchRequest;
    private MatchResponse matchResponse;
    private MatchEntity entity;
    private String playerId, playerHistoryId, matchId;
    private int level, victories, defeats, ties, total;

    @Before
    public void initDefaults() {
        this.appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        this.repository = new TicTocToeRepository(this.appContext);
        this.playerHistoryRepository = new PlayerHistoryRepository(this.appContext);

        playerId = UUID.randomUUID().toString();
        playerHistoryId = UUID.randomUUID().toString();
        this.level = 2;
        this.victories = 0;
        this.defeats = 0;
        this.ties = 0;
        this.total = 0;

        PlayerHistoryRequest request = new PlayerHistoryRequest(playerHistoryId, playerId, victories, defeats, ties, total);
        PlayerHistoryEntity playerHistoryEntity = new PlayerHistoryEntity(request);
        this.playerHistoryResponse = this.playerHistoryRepository.createPlayerHistory(playerHistoryEntity);

        this.matchRequest = new MatchRequest(playerHistoryId, this.level);
        this.entity = new MatchEntity(this.matchRequest);
    }

    @Test
    public void shouldStartMatchHasReturnNewMatchInMatchResponse() {
        this.matchResponse = this.repository.startMatch(entity);

        assertEquals(MatchResponse.class, this.matchResponse.getClass());
        assertEquals(this.playerHistoryId, this.matchResponse.playersHistoryId);
        assertEquals(0, this.matchResponse.result);
        assertEquals(this.level, this.matchResponse.level);
    }

    @Test
    public void shouldComputerMoveHasReturnCorrectInMovementResponse() {
        Table table = new Table();
        table.setField(0,0,1);
        table.setField(1,1,1);
        this.matchResponse = this.repository.startMatch(entity);
        MovementRequest movementRequest = new MovementRequest(3, this.matchResponse.id, table, 2, 2);
        MovementEntity movementEntity = new MovementEntity(movementRequest);

        this.movementsResponse = this.repository.computerMove(movementEntity);

        assertEquals(MovementsResponse.class, this.movementsResponse.getClass());
        assertEquals(3, this.movementsResponse.id);
        assertEquals(2, this.movementsResponse.line);
        assertEquals(2, this.movementsResponse.column);
        assertEquals(-1, this.movementsResponse.value);
    }

    @Test
    public void shouldBePlayerMoveHasReturnCorrectInMovementResponse() {
        Table table = new Table();
        this.matchResponse = this.repository.startMatch(entity);
        MovementRequest movementRequest = new MovementRequest(4, this.matchResponse.id, table, 2, 2, 1);
        MovementEntity movementEntity = new MovementEntity(movementRequest);

        this.movementsResponse = this.repository.playerMove(movementEntity);

        assertEquals(MovementsResponse.class, this.movementsResponse.getClass());
        assertEquals(4, this.movementsResponse.id);
        assertEquals(2, this.movementsResponse.line);
        assertEquals(2, this.movementsResponse.column);
        assertEquals(1, this.movementsResponse.value);
    }

    @After
    public void dropTable() {
        this.playerHistoryRepository.deletePlayerHistory(playerId);
    }
}
