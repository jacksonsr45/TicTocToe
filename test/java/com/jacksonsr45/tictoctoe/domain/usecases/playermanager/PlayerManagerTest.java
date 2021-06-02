package com.jacksonsr45.tictoctoe.domain.usecases.playermanager;

import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.presenter.PlayerManagerPresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.repository.PlayerManagerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class PlayerManagerTest {
    PlayerManagerRepository repository;
    PlayerManager playerManager;
    PlayerRequest request;
    PlayerManagerPresenter presenter, presenterOne, presenterTwo, presenterThree;
    String idOne, idTwo, idThree, nameOne, nameTwo, nameThree;

    @Before
    public void initDefault() {
        repository = new PlayerManagerRepository();
        playerManager = new PlayerManager(repository);
        presenter = new PlayerManagerPresenter();
        presenterOne = new PlayerManagerPresenter();
        presenterTwo = new PlayerManagerPresenter();
        presenterThree = new PlayerManagerPresenter();

        idOne = "53d051ec-f1c3-4b52-9878-12954563e035";
        idTwo = "53d051ec-f1c3-4b52-9878-12954563e057";
        idThree = "53d051ec-f1c3-4b52-9878-12954563e084";
        nameOne = "Test One";
        nameTwo = "Test Two";
        nameThree = "Test Three";

        request = new PlayerRequest(nameOne);
    }

    @Test
    public void shouldBeAddPlayerReturnPlayerManagerResponseAndCompare() {
        playerManager.addPlayer(request, presenter);

        assertEquals(PlayerResponse.class, presenter.getPlayer().getClass());
        assertEquals(nameOne, presenter.getPlayer().name);
        assertNotEquals(null, presenter.getPlayer().id);
    }

    @Test
    public void shouldBeUpdatePlayerReturnPlayerManagerResponseAndCompare() {
        playerManager.addPlayer(request, presenter);
        request.setId(idTwo);
        request.setName(nameTwo);
        playerManager.updatePlayer(request, presenter);

        assertEquals(PlayerResponse.class, presenter.getPlayer().getClass());
        assertEquals(nameTwo, presenter.getPlayer().name);
        assertEquals(idTwo, presenter.getPlayer().id);
    }

    @Test
    public void shouldBeDeletePlayerReturnPlayerManagerResponseAndCompare() {
        playerManager.deletePlayer(idOne, presenter);

        assertEquals(PlayerResponse.class, presenter.getPlayer().getClass());
        assertNull(null, presenter.getPlayer().id);
        assertNull(null, presenter.getPlayer().name);
    }

    @Test
    public void shouldBeListPlayersReturnArrayListWithPlayerManagerResponseAndCompare() {
        playerManager.listPlayers(presenter);

        assertEquals(ArrayList.class, presenter.getPlayers().getClass());
        assertEquals(PlayerResponse.class, presenter.getPlayers().get(0).getClass());
        assertEquals(idOne, presenter.getPlayers().get(0).id);
        assertEquals(nameOne, presenter.getPlayers().get(0).name);
        assertEquals(idTwo, presenter.getPlayers().get(1).id);
        assertEquals(nameTwo, presenter.getPlayers().get(1).name);
        assertEquals(idThree, presenter.getPlayers().get(2).id);
        assertEquals(nameThree, presenter.getPlayers().get(2).name);
    }

    @Test
    public void shouldBeShowPlayerReturnPlayerManagerResponseAndCompare() {
        playerManager.showPlayer( idOne, presenterOne);
        playerManager.showPlayer( idTwo, presenterTwo);
        playerManager.showPlayer( idThree, presenterThree);

        assertEquals(PlayerResponse.class, presenterOne.getPlayer().getClass());
        assertEquals(idOne, presenterOne.getPlayer().id);
        assertEquals(nameOne, presenterOne.getPlayer().name);
        assertEquals(PlayerResponse.class, presenterTwo.getPlayer().getClass());
        assertEquals(idTwo, presenterTwo.getPlayer().id);
        assertEquals(nameTwo, presenterTwo.getPlayer().name);
        assertEquals(PlayerResponse.class, presenterThree.getPlayer().getClass());
        assertEquals(idThree, presenterThree.getPlayer().id);
        assertEquals(nameThree, presenterThree.getPlayer().name);
    }

    @After
    public void setNull() {
        repository = null;
        playerManager = null;
        presenter = null;
        presenterOne = null;
        presenterTwo = null;
        presenterThree = null;

        idOne = null;
        idTwo = null;
        idThree = null;
        nameOne = null;
        nameTwo = null;
        nameThree = null;

        request = null;
    }
}
