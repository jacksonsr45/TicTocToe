package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.PlayerManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerManagerPresenter;

public class MainActivity extends AppCompatActivity {
    private Intent Intent;
    private PlayerManagerRepository repository;
    private PlayerManager player;
    private PlayerManagerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.repository = new PlayerManagerRepository(getApplicationContext());
        this.player = new PlayerManager(this.repository);
        this.presenter = new PlayerManagerPresenter();
        this.checkStartDefaultPage();
    }

    public void checkStartDefaultPage() {
        this.player.listPlayers(this.presenter);
        if (this.presenter.getPlayers().size() > 0)
            this.Intent = new Intent(getApplicationContext(), SelectPlayerActivity.class);
        else this.Intent = new Intent(getApplicationContext(), AddPlayerActivity.class);
        startActivity(this.Intent);
    }
}