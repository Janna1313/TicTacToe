package sample.controller;

import sample.model.Model;
import sample.view.*;

import java.util.ArrayList;

public class GameController implements Controller {
    private int active_player;
    private Model model;
    private MainFrame view;

    public GameController(MainFrame mainFrame) {
        this.view = mainFrame;
        active_player = 1;
    }


    @Override
    public int checkMove(int x, int y) {
        Boolean win = model.makeTurn(x, y, active_player);
        if (win) {
            view.showWinner(active_player);
        } else if (win = null) {
            //view.showTie();
        }
        switchPlayer();
        return active_player;
    }

    @Override
    public void switchPlayer() {
        active_player = active_player % 2 + 1;
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
        //view.showScoreboard(scoreboard);
    }

    public int getActive_player() {
        return active_player;
    }

    public MainFrame getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }

}
