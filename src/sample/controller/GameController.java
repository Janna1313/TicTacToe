package sample.controller;

import sample.model.Model;
import sample.view.frames.GameFrame;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class GameController implements Controller {
    private int active_player;
    private Model model;
    private GameFrame view;
    private ArrayList<String> scoreboard;

    public GameController(){
        scoreboard = Model.getScoreBord();
    }

    @Override
    public int checkMove(int x, int y) {
        Boolean win = model.makeTurn(x, y, active_player);
        if (win == null) {
            view.showTie();
        } else if (win) {
            saveWin(view.showWinner());
        }
        switchPlayer();
        return active_player;
    }

    public void saveWin(String name){
        model.saveWin(name);
        scoreboard = Model.getScoreBord();
    }

    @Override
    public void switchPlayer() {
        this.active_player = this.active_player % 2 + 1;
    }

    @Override
    public void restart() {
        model.restart();
        active_player = 1;
    }

    @Override
    public void startGame(int size) {
        model = new Model(size);
    }

    @Override
    public void showScoreboard() {
        view.showScoreBoard(this.scoreboard);
    }

    public ArrayList<String> getScoreboard() {
        return this.scoreboard;
    }

    public int getActive_player() {
        return active_player;
    }

    public void setView(GameFrame view) {
        this.view = view;
    }

    public void setActive_player(int player) {
        this.active_player = player;
    }
}
