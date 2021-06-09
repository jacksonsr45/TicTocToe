package com.jacksonsr45.tictoctoe.userinterface.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.request.playerhistory.PlayerHistoryRequest;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.PlayerHistoryManager;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerHistoryRepository;
import com.jacksonsr45.tictoctoe.userinterface.presenter.PlayerHistoryPresenter;
import com.jacksonsr45.tictoctoe.userinterface.presenter.TicTocToePresenter;

public class GameResultActivity extends AppCompatActivity {
    private PlayerHistoryRequest request;
    private PlayerHistoryRepository repository;
    private PlayerHistoryManager playerHistory;
    private PlayerHistoryPresenter presenter;
    private TicTocToePresenter ticTocToePresenter;
    private Bundle bundle;
    private Intent intent;

    private ImageView imageEmojiResult, imageStarResult;
    private ImageButton buttonContinueGame, buttonExitToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);

        this.bundle = getIntent().getExtras();
        this.ticTocToePresenter = this.bundle.getParcelable("presenter");

        this.imageEmojiResult = findViewById(R.id.imageEmojiResult);
        this.imageStarResult = findViewById(R.id.imageStarResult);
        this.buttonContinueGame = findViewById(R.id.buttonContinueGame);
        this.buttonExitToHome = findViewById(R.id.buttonExitToHome);

        this.getResultInScreen();
        this.initButtonContinueGame();
        this.initButtonExitToHome();
    }

    private void getResultInScreen() {
        switch (this.ticTocToePresenter.getMatch().result) {
            case 1: this.imageEmojiResult.setImageResource(R.drawable.ic_emoji_victory);
                    this.imageStarResult.setImageResource(R.drawable.ic_star_min_result_victory);
                break;
            case -1: this.imageEmojiResult.setImageResource(R.drawable.ic_emoji_defeat);
                this.imageStarResult.setImageResource(R.drawable.ic_star_min_result_defeat);
                break;
            default: this.imageEmojiResult.setImageResource(R.drawable.ic_emoji_tie);
                this.imageStarResult.setImageResource(R.drawable.ic_star_min_result_tie);
                break;
        }
    }

    private void initButtonContinueGame() {
        this.buttonContinueGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InGameActivity.class);
                bundle.putString("playerHistoryID", ticTocToePresenter.getMatch().playersHistoryId);
                bundle.putString("level", String.valueOf(ticTocToePresenter.getMatch().level));
                intent.putExtras(bundle);
                resultLauncher.launch(intent);
            }
        });
    }

    private void initButtonExitToHome() {
        this.buttonExitToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLauncher.launch(new Intent(getApplicationContext(), MainActivity.class));
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