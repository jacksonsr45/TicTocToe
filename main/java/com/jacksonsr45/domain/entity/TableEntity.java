package com.jacksonsr45.domain.entity;

import com.jacksonsr45.domain.request.TicTocToeRequest;

public class TableEntity {
    private int field[][] = new int[3][3];
    private int result;

    public TableEntity(TicTocToeRequest request) {
        this.setField(request.getTable().getField());
        this.setResult(request.getTable().getResult());
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int[][] field) {
        this.field = field;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
