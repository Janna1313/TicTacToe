package sample.controller;

import sample.model.Model;
import sample.view.*;

public class GameController implements Controller {
    private int active_player = 1;
    private Model model;
    private MainFrame view;

    public GameController(Model model, MainFrame mainFrame) {
        this.model = model;
        this.view = mainFrame;
    }


    @Override
    public void checkMove() {

    }

    @Override
    public void switchPlayer() {
        active_player = active_player % 2 + 1;
    }

    @Override
    public void restart() {

    }

    @Override
    public void startGame() {

    }
}
