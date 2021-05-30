package com.jacksonsr45.domain.usecases.playermanager;

import com.jacksonsr45.domain.request.PlayerManagerRequest;
import com.jacksonsr45.domain.usecases.playermanager.presenter.PlayerManagerPresenter;
import com.jacksonsr45.domain.usecases.playermanager.repository.PlayerManagerRepository;
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
        PlayerManagerRequest request = new PlayerManagerRequest(nameOne);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();

        playerManager.addPlayer(request, presenter);

        assertEquals(nameOne, presenter.getPlayerViewModel().getName());
        assertNotEquals(null, presenter.getPlayerViewModel().getId());
    }

    @Test
    public void shouldBeUpdatePlayerAndReturnValuePresent() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerManagerRequest request = new PlayerManagerRequest(nameOne);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();

        String id = UUID.randomUUID().toString();
        playerManager.addPlayer(request, presenter);
        request.getPlayer().setId(idTwo);
        request.getPlayer().setName(nameTwo);
        playerManager.updatePlayer(request, presenter);

        assertEquals(nameTwo, presenter.getPlayerViewModel().getName());
        assertEquals(idTwo, presenter.getPlayerViewModel().getId());
    }

    @Test
    public void shouldBeDeletePlayerReturnValue() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();

        playerManager.deletePlayer(idOne, presenter);

        assertNull(null, presenter.getPlayerViewModel().getId());
        assertNull(null, presenter.getPlayerViewModel().getName());
    }

    @Test
    public void shouldBeListPlayersReturnValue() {
        PlayerManagerRepository repository = new PlayerManagerRepository();
        PlayerManager playerManager = new PlayerManager(repository);
        PlayerManagerPresenter presenter = new PlayerManagerPresenter();
        playerManager.listPlayers(presenter);

        assertEquals(idOne, presenter.getPlayersViewModel().get(0).getId());
        assertEquals(nameOne, presenter.getPlayersViewModel().get(0).getName());
        assertEquals(idTwo, presenter.getPlayersViewModel().get(1).getId());
        assertEquals(nameTwo, presenter.getPlayersViewModel().get(1).getName());
        assertEquals(idThree, presenter.getPlayersViewModel().get(2).getId());
        assertEquals(nameThree, presenter.getPlayersViewModel().get(2).getName());
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

        assertEquals(idOne, presenterOne.getPlayerViewModel().getId());
        assertEquals(nameOne, presenterOne.getPlayerViewModel().getName());
        assertEquals(idTwo, presenterTwo.getPlayerViewModel().getId());
        assertEquals(nameTwo, presenterTwo.getPlayerViewModel().getName());
        assertEquals(idThree, presenterThree.getPlayerViewModel().getId());
        assertEquals(nameThree, presenterThree.getPlayerViewModel().getName());
    }
}
