package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.PlayerManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;
import com.jacksonsr45.tictoctoe.userinterface.fragments.SelectLevelFragment;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerManagerPresenter;

public class AddPlayerActivity extends AppCompatActivity {
    private android.content.Intent intent;
    private PlayerManagerRepository repository;
    private PlayerRequest request;
    private PlayerManager player;
    private PlayerManagerPresenter presenter;
    private EditText textPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        this.repository = new PlayerManagerRepository(getApplicationContext());
        this.player = new PlayerManager(this.repository);
        this.presenter = new PlayerManagerPresenter();

        this.textPlayerName = findViewById(R.id.textPlayerName);
    }

    public void addPlayer(View view) {
        this.request = new PlayerRequest(String.valueOf(this.textPlayerName.getText()));
        this.player.addPlayer(this.request,this.presenter);
        this.intent = new Intent(getApplicationContext(), HomeActivity.class);
        this.intent.putExtra("playerID", this.presenter.getPlayer().id);
        startActivity(this.intent);
    }

    public void getAboutPage(View view) {
        this.intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(this.intent);
    }
}