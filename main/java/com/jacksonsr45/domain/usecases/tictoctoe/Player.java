package com.jacksonsr45.domain.usecases.tictoctoe;

public class Player {
    private String id;
    private String name;

    public Player(String id, String name) {
        this.setId(id);
        this.name = name;
    }

    public void move(Table table, int line, int column) {
        boolean validation = false;
        do {
            if (table.isValid(line, column)) {
                table.setField(line, column, 1);
                validation = true;
            }
        } while (!validation);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
