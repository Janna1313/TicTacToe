package sample.controller;

import sample.model.Model;
import sample.view.frames.GameFrame;

import java.util.ArrayList;

public class GameController implements Controller {
    private int active_player;
    private Model model;
    private GameFrame view;

    public GameController(GameFrame mainFrame) {
        this.view = mainFrame;
        active_player = 1;
    }

    public GameController(){
    }


    @Override
    public int checkMove(int x, int y) {
        Boolean win = model.makeTurn(x, y, active_player);
        if (win) {
            view.showWinner(active_player);
        } else if (win = null) {
            view.showTie();
        }
        switchPlayer();
        return active_player;
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
        ArrayList<String> scoreboard = Model.getScoreBord();
        view.showScoreBoard(scoreboard);
    }

    public int getActive_player() {
        return active_player;
    }

    public GameFrame getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }

    public void setView(GameFrame view) {
        this.view = view;
    }

    public void setActive_player(int player) {
        this.active_player = player;
    }
}
