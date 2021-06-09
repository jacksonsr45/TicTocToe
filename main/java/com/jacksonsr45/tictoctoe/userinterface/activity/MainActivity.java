package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.usecases.playermanager.PlayerManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerManagerPresenter;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private PlayerManagerRepository repository;
    private PlayerManager player;
    private PlayerManagerPresenter presenter;

    public static final int RESULT_CODE_SELECT_PLAYER = 2;

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
        if (this.presenter.getPlayers().size() > 0) openSelectPlayer();
        else openAddPlayer();
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

    public void openSelectPlayer() {
        Intent intent = new Intent(this, SelectPlayerActivity.class);
        setResult(2);
        resultLauncher.launch(intent);
    }

    public void openAddPlayer() {
        Intent intent = new Intent(this, AddPlayerActivity.class);
        resultLauncher.launch(intent);
    }
}