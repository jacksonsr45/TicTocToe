package com.jacksonsr45.tictoctoe.domain.entity;

import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Match;
import com.jacksonsr45.tictoctoe.domain.usecases.playerhistorymanager.Movements;

import java.util.ArrayList;
import java.util.Date;

public class MatchEntity {
    private String id;
    private ArrayList<Movements> movements = new ArrayList<Movements>();
    private int level;
    private int result;
    private Date createdAt;

    public MatchEntity(Match match) {
        this.setId(match.getId());
        this.setMovements(match.getMovements());
        this.setLevel(match.getLevel());
        this.setResult(match.getResult());
        this.setCreatedAt(match.getCreatedAt());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Movements> getMovements() {
        return movements;
    }

    public void setMovements(ArrayList<Movements> movements) {
        this.movements = movements;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
