package sample.model;

import java.util.ArrayList;

public class Model {
    int size;
    int[][] grid;

    public boolean makeTurn(int x, int y, int player) {
        setField(x, y, player);
        return ready(x,y,player);
    }

    private boolean ready(int x, int y, int player){
        if (checkRows(player)){
            return true;
        }
        if (checkDraw()){
            return true;
        }
        return false;
    };

    private void setField(int x, int y, int player) {
        grid[x][y] = player;
    }

    public void generateField(int size) {
        grid = new int[size][size];
        for (int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                grid[x][y] = 0;
            }
        }
    }

    private boolean checkRows(int player){
        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < size; x++) {
                int y = 0;
                if (checkRow(x,y,i,player)){
                    return true;
                }
            }
        }
        if (checkRow(0,0,2,player)){
            return true;
        }
        if (checkRow(0,0,3,player)){
            return true;
        }
        return false;
    };

    private boolean checkRow(int x, int y, int mode, int player){
        boolean correctPlayer = true;
        while (correctPlayer) {
            if (mode == 0) {correctPlayer = checkField(x, y, player);}
            if (mode == 1) {correctPlayer = checkField(y, x, player);}
            if (mode == 2) {correctPlayer = checkField(y, y, player);}
            if (mode == 3) {correctPlayer = checkField(y, size-y, player);}
            y++;
            if (y == size) {
            return true;
            }
        }
        return false;
    };

    private boolean checkField(int x, int y, int player) {
        if (grid[x][y] == player){
            return true;
        }
        return false;
    };

    private boolean checkDraw(){
        for (int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                if (grid[x][y] == 0){
                    return false;
                }
            }
        }
        return true;
    };
}