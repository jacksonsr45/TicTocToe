package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;


public class PlayerHistory {
    private Table table;
    private String id;
    private String playerId;
    private int total, victories, defeats, ties;

    public PlayerHistory(Table table, String id, String playerId, int total, int victories, int defeats, int ties) {
        this.table = table;
        this.setId(id);
        this.setPlayerId(playerId);
        this.setTotal(total + 1);
        this.getResult(victories, defeats, ties);
    }

    private void getResult(int victories, int defeats, int ties) {
        this.table.checkResult(3,1);
        this.table.checkResult(-3,-1);
        switch (this.table.getResult()) {
            case 1: this.victories = victories + 1; break;
            case -1: this.defeats = defeats + 1;break;
            default: this.ties = ties + 1;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats(int defeats) {
        this.defeats = defeats;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
}
