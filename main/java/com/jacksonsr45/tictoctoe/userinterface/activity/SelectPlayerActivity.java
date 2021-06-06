package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.PlayerManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.adapter.ListPlayersAdapter;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerManagerPresenter;

public class SelectPlayerActivity extends AppCompatActivity {
    private Intent intent;
    private PlayerManagerRepository repository;
    private PlayerManager player;
    private PlayerManagerPresenter presenter;
    private RecyclerView listPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);
        this.listPlayers = findViewById(R.id.listPlayers);

        this.getPlayerList();
        ListPlayersAdapter adapter = new ListPlayersAdapter(this.presenter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        this.listPlayers.setLayoutManager(layoutManager);
        this.listPlayers.setHasFixedSize(true);
        this.listPlayers.setAdapter(adapter);
    }

    private void getPlayerList() {
        this.repository = new PlayerManagerRepository(getApplicationContext());
        this.player = new PlayerManager(this.repository);
        this.presenter = new PlayerManagerPresenter();
        this.player.listPlayers(this.presenter);
    }

    public void addNewPlayer(View view) {
        this.intent = new Intent(getApplicationContext(), AddPlayerActivity.class);
        startActivity(this.intent);
    }

    public void exitGame(View view) {
        this.finishAffinity();
    }
}