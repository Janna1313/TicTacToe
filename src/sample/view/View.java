package sample.view;

import java.util.ArrayList;

public interface View {
    void showWinner(int who);
    void showTie();
    void showScoreBoard(ArrayList<String> board);
    void init(int fieldSize);
}
