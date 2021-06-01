package com.jacksonsr45.tictoctoe.domain.usecases.playermanager;

import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.presenter.PlayerManagerPresenter;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.repository.PlayerManagerRepository;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class PlayerManagerTest {
    String idOne = "53d051ec-f1c3-4b52-9878-12954563e035";
    String idTwo = "53d051ec-f1c3-4b52-9878-12954563e057";
    String idThree = "53d051ec-f1c3-4b52-9878-12954563e084";
    String nameOne = "Test One";
    String nameTwo = "Test Two";
    String nameThree = "Test Three";

    @Test
    public void shouldBeAddPlayerAndReturnValuePresent() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerRequest request = new PlayerRequest(nameOne);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();

        playerManager.addPlayer(request, presenter);

        assertEquals(nameOne, presenter.getPlayer().name);
        assertNotEquals(null, presenter.getPlayer().id);
    }

    @Test
    public void shouldBeUpdatePlayerAndReturnValuePresent() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerRequest request = new PlayerRequest(nameOne);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();

        String id = UUID.randomUUID().toString();
        playerManager.addPlayer(request, presenter);
        request.setId(idTwo);
        request.setName(nameTwo);
        playerManager.updatePlayer(request, presenter);

        assertEquals(nameTwo, presenter.getPlayer().name);
        assertEquals(idTwo, presenter.getPlayer().id);
    }

    @Test
    public void shouldBeDeletePlayerReturnValue() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();

        playerManager.deletePlayer(idOne, presenter);

        assertNull(null, presenter.getPlayer().id);
        assertNull(null, presenter.getPlayer().name);
    }

    @Test
    public void shouldBeListPlayersReturnValue() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();
        playerManager.listPlayers(presenter);

        assertEquals(idOne, presenter.getPlayers().get(0).id);
        assertEquals(nameOne, presenter.getPlayers().get(0).name);
        assertEquals(idTwo, presenter.getPlayers().get(1).id);
        assertEquals(nameTwo, presenter.getPlayers().get(1).name);
        assertEquals(idThree, presenter.getPlayers().get(2).id);
        assertEquals(nameThree, presenter.getPlayers().get(2).name);
    }

    @Test
    public void shouldBeShowPlayersReturnValue() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerManagerPresenter presenterOne = new PlayerManagerPresenter();
        PlayerManagerPresenter presenterTwo = new PlayerManagerPresenter();
        PlayerManagerPresenter presenterThree = new PlayerManagerPresenter();

        playerManager.showPlayer( idOne, presenterOne);
        playerManager.showPlayer( idTwo, presenterTwo);
        playerManager.showPlayer( idThree, presenterThree);

        assertEquals(idOne, presenterOne.getPlayer().id);
        assertEquals(nameOne, presenterOne.getPlayer().name);
        assertEquals(idTwo, presenterTwo.getPlayer().id);
        assertEquals(nameTwo, presenterTwo.getPlayer().name);
        assertEquals(idThree, presenterThree.getPlayer().id);
        assertEquals(nameThree, presenterThree.getPlayer().name);
    }
}
