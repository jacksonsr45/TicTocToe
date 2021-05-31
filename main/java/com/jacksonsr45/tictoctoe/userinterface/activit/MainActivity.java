package com.jacksonsr45.tictoctoe.userinterface.activit;

import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jacksonsr45.tictoctoe.domain.entity.PlayerEntity;
import com.jacksonsr45.tictoctoe.domain.request.PlayerManagerRequest;
import com.jacksonsr45.tictoctoe.domain.response.PlayerManagerResponse;
import com.jacksonsr45.tictoctoe.infrastructure.database.DBOpenHelper;
import com.jacksonsr45.tictoctoe.infrastructure.factory.DBFactory;
import com.jacksonsr45.tictoctoe.infrastructure.repository.PlayerManagerRepository;
import com.jacksonsr45.tictoctoe.userinterface.activit.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private PlayerEntity playerEntity;
    private PlayerManagerRepository repository;
    private PlayerManagerRequest request;
    private PlayerManagerResponse response;

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