package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.PlayerManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.fragments.SelectLevelFragment;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerManagerPresenter;

import java.sql.SQLClientInfoException;

public class AddPlayerActivity extends AppCompatActivity {
    private android.content.Intent intent;
    private PlayerManagerRepository repository;
    private PlayerRequest request;
    private PlayerManager player;
    private PlayerManagerPresenter presenter;
    private EditText textPlayerName;

    private ImageButton buttonAddNewPlayer, buttonAboutPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        this.buttonAddNewPlayer = findViewById(R.id.buttonAddNewPlayer);
        this.buttonAboutPage = findViewById(R.id.buttonAboutPage);

        this.repository = new PlayerManagerRepository(getApplicationContext());
        this.player = new PlayerManager(this.repository);
        this.presenter = new PlayerManagerPresenter();

        this.textPlayerName = findViewById(R.id.textPlayerName);

        this.addPlayer();
        this.getAboutPage();
    }

    public void addPlayer() {
        this.buttonAddNewPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request = new PlayerRequest(String.valueOf(textPlayerName.getText()));
                player.addPlayer(request, presenter);
                Bundle args = new Bundle();
                args.putString("playerID", presenter.getPlayer().id);
                intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
    }

    public void getAboutPage() {
        this.buttonAboutPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}