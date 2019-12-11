package sample.view;

import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;

public class MainFrame extends GridPane implements View {
    public MainFrame (int fieldSize){
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++)
                add(new FieldButton(x, y), x, y);
        }
    }

    @Override
    public void showWinner(int who) {
        Dialog winner = new Dialog();
        winner.setContentText("Player " + who + " has won!");
        winner.show();

    }

    @Override
    public void showScoreBoard(String board) {
        Dialog scoreBoard = new Dialog();
        scoreBoard.setContentText(board);
        scoreBoard.show();
    }

    @Override
    public void put(int pl, int typ) {


    }

    @Override
    public void illegalMove(int pl) {

    }

    @Override
    public void init() {

    }


}
