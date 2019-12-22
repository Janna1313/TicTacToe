package sample.view;

import java.util.ArrayList;

public interface View {
    String showWinner();
    void showTie();
    void showScoreBoard();
    void init(int fieldSize);
}
