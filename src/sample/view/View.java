package sample.view;

import java.util.ArrayList;

public interface View {
    String showWinner();
    void showTie();
    void showScoreBoard(ArrayList<String> board);
    void init(int fieldSize);
}
