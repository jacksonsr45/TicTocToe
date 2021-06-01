package com.jacksonsr45.tictoctoe.userinterface.activit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.entity.playermanager.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.request.playermanager.PlayerRequest;
import com.jacksonsr45.tictoctoe.domain.response.playermanager.PlayerResponse;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;

public class MainActivity extends AppCompatActivity {
    private PlayerEntity playerEntity;
    private PlayerManagerRepository repository;
    private PlayerRequest request;
    private PlayerResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String id = UUID.randomUUID().toString();
//        this.request = new PlayerManagerRequest("654321","Jackson 654321");
//        this.playerEntity = new PlayerEntity(request);
//        this.repository = new PlayerManagerRepository(getApplicationContext());
//        this.repository.addPlayer(this.playerEntity);
//
//        this.response = this.repository.showPlayer("654321");
//
//        System.out.println("Id: "+this.response.getId());
//        System.out.println("Name: "+this.response.getName());
    }
}