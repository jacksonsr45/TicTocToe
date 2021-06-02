package com.jacksonsr45.tictoctoe.infrastructure.repository;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.jacksonsr45.tictoctoe.domain.entity.playerhistory.PlayerHistoryEntity;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MatchResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.MovementsResponse;
import com.jacksonsr45.tictoctoe.domain.response.playerhistory.PlayerHistoryResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PlayerHistoryRepositoryTest {
    private Context appContext;
    private PlayerHistoryRepository repository;
    private PlayerHistoryResponse response;
    private ArrayList<MatchResponse> matchResponses;
    private ArrayList<MovementsResponse> movementsResponses;
    private MatchResponse matchResponse;
    private String playerId;
    private String playerHistoryID;
    private String matchId;
    private int victories, defeats, ties, total;

    @Before
    public void initAppContextAndPlayerHistoryRepository() {
        this.appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        this.repository = new PlayerHistoryRepository(appContext);
        this.playerId = UUID.randomUUID().toString();
        this.playerHistoryID = UUID.randomUUID().toString();
        this.matchId = UUID.randomUUID().toString();
        this.victories = 1;
        this.defeats = 0;
        this.ties = 0;
        this.total = 1;
    }

    @Test
    public void shouldBeCreatePlayerHistoryInDatabaseAndCheckValueWithShowPlayerHistory() {
        PlayerHistoryRequest request = new PlayerHistoryRequest(playerHistoryID, playerId, victories, defeats, ties, total);
        PlayerHistoryEntity entity = new PlayerHistoryEntity(request);

        this.repository.createPlayerHistory(entity);
        this.response = this.repository.showPlayerHistory(playerId);

        assertEquals(playerId, this.response.playerId);
        assertEquals(playerHistoryID, this.response.id);
        assertEquals(victories, this.response.victories);
        assertEquals(defeats, this.response.defeats);
        assertEquals(ties, this.response.ties);
        assertEquals(total, this.response.total);
    }

    @Test
    public void shouldBeListMathGetPlayerHistoryIdAndHasReturnAArrayListNullWithMatchResponse() {
        PlayerHistoryRequest request = new PlayerHistoryRequest(playerHistoryID, playerId, victories, defeats, ties, total);
        PlayerHistoryEntity entity = new PlayerHistoryEntity(request);
        this.repository.createPlayerHistory(entity);

        this.matchResponses = this.repository.listMatch(request.getId());

        assertEquals(ArrayList.class, this.matchResponses.getClass());
        for (MatchResponse matchResponse: this.matchResponses) {
            assertEquals(null, matchResponse.id);
        }
    }

    @Test
    public void shouldBeShowMatchReceiveMatchIdAndHasReturnMatchResponseWithValuesNull() {
        this.matchResponse = this.repository.showMatch(matchId);

        assertEquals(MatchResponse.class, this.matchResponse.getClass());
        assertEquals(null, this.matchResponse.id);
        assertEquals(null, this.matchResponse.playersHistoryId);
    }

    @Test
    public void shouldBeListMovementsReceiveMatchIdAndReturnArrayListByListMovementsNull() {
        this.movementsResponses = this.repository.listMovements(matchId);

        assertEquals(ArrayList.class, this.movementsResponses.getClass());
        for (MovementsResponse movements: this.movementsResponses) {
            assertEquals(null, movements.id);
        }
    }

    @After
    public void dropTableValues() {
        this.repository.deletePlayerHistory(this.playerId);
    }
}
