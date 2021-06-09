package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

    private ImageButton buttonAddPlayer, buttonCancelSelectPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);
        this.listPlayers = findViewById(R.id.listPlayers);
        this.buttonAddPlayer = findViewById(R.id.buttonAddPlayer);
        this.buttonCancelSelectPlayer = findViewById(R.id.buttonCancelSelectPlayer);

        this.getPlayerList();
        ListPlayersAdapter adapter = new ListPlayersAdapter(this.presenter);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getApplicationContext());
        this.listPlayers.setLayoutManager(layoutManager);
        this.listPlayers.setHasFixedSize(true);
        this.listPlayers.setAdapter(adapter);

        this.addNewPlayer();
        this.exitGame();
    }

    private void getPlayerList() {
        this.repository = new PlayerManagerRepository(getApplicationContext());
        this.player = new PlayerManager(this.repository);
        this.presenter = new PlayerManagerPresenter();
        this.player.listPlayers(this.presenter);
    }

    public void addNewPlayer() {
        this.buttonAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLauncher.launch(new Intent(getApplicationContext(), AddPlayerActivity.class));
            }
        });
    }

    public void exitGame() {
        this.buttonCancelSelectPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                    }
                }
            });
}