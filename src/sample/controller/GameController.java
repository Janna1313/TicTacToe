package sample.controller;

import sample.model.Model;
import sample.view.frames.GameFrame;

public class GameController implements Controller {
    private int active_player;
    private Model model;
    private GameFrame view;

    public GameController(Model model, GameFrame mainFrame) {
        this.view = mainFrame;
        active_player = 1;
    }


    @Override
    public int checkMove(int x, int y) {

        if (model.makeTurn(x, y, active_player)) {

            view.showWinner(active_player);
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
        // view.confirm
    }

    @Override
    public void startGame(int size) {
        model = new Model(size);
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
}
