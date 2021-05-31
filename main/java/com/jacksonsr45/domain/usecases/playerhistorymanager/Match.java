package com.jacksonsr45.domain.usecases.playerhistorymanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Match {
    private String id;
    private ArrayList<Movements> movements = new ArrayList<Movements>();
    private int movementsIndex;
    private int level;
    private int result;
    private Date createdAt;

    public Match(int level) {
        this.setId(UUID.randomUUID().toString());
        this.setLevel(level);
    }

    public Match(String matchId) {
        this.setId(matchId);
    }

    public Match(String matchId, int level) {
        this.setId(matchId);
        this.setLevel(level);
        this.setCreatedAt(new Date());
    }

    public void move(int id, int line, int column, int value) {
        this.movements.add(new Movements(id, line, column, value));
    }

    public void getMove(int index) {
        this.setMovementsIndex(index);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMovementsIndex() {
        return movementsIndex;
    }

    public void setMovementsIndex(int movementsIndex) {
        this.movementsIndex = movementsIndex;
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
