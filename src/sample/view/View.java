package sample.view;

interface View {
    void showWinner(int who);
    void put(int pl, int typ);
    void illegalMove(int pl);
    void init();

}
