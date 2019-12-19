package sample.controller;

public interface Controller {
    int checkMove(int x, int y);
    void switchPlayer();
    void restart();
    void startGame(int size);
    void showScoreboard();

}
