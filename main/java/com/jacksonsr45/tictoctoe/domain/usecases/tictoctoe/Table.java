package com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe;

public class Table {
    private int field[][] = new int[3][3];
    private int result;

    public boolean isValid(int line, int column) {
        if (this.getField()[line][column] != 1 && this.getField()[line][column] != -1) return true;
        return false;
    }

    public boolean checkResult(int value, int player) {
        if (this.checkDiagonalOne(value, player)) return true;
        else if (this.checkDiagonalTwo(value, player)) return true;
        else if (this.checkColumn(value, player)) return true;
        else if (this.checkLine(value, player)) return true;
        else if (this.checkATie()) return true;
        return false;
    }

    public boolean checkDiagonalOne(int value, int player) {
        if((this.getField()[0][0] + this.getField()[1][1] + this.getField()[2][2]) == value){
            this.setResult(player);
            return true;
        }
        return false;
    }

    public boolean checkDiagonalTwo(int value, int player) {
        if( (this.getField()[0][2] + this.getField()[1][1] + this.getField()[2][0]) == value){
            this.setResult(player);
            return true;
        }
        return false;
    }

    public boolean checkColumn(int value, int player) {
        for(int column=0 ; column<3 ; column++){
            if( (this.getField()[0][column] + this.getField()[1][column]
                    + this.getField()[2][column]) == value) {
                this.setResult(player);
                return true;
            }
        }
        return false;
    }

    public boolean checkLine(int value, int player) {
        for(int linha=0 ; linha<3 ; linha++){
            if( (this.getField()[linha][0] + this.getField()[linha][1]
                    + this.getField()[linha][2]) == value){
                this.setResult(player);
                return true;
            }
        }
        return false;
    }

    public boolean checkATie() {
        int count = 0;
        for (int i = 0; i < this.getField().length; i++) {
            for (int j = 0; j < this.getField().length; j++) {
                if (this.getField()[i][j] != 0) count ++;
            }
        }
        if (count == 9) {
            this.setResult(0);
            return true;
        }
        return false;
    }

    public int[][] getField() {
        return field;
    }

    public void setField(int line, int column, int value) {
        this.field[line][column] = value;
    }

    private void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
