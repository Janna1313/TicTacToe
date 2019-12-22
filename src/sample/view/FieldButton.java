package sample.view;

import javafx.scene.control.Button;
import sample.controller.GameController;
import sample.view.frames.MenuFrame;

public class FieldButton extends Button {
    private boolean isClickable = true;
    private int x, y;
    private GameController controller;

    public FieldButton(int pX, int pY, GameController pController) {
        super();
        this.x = pX;
        this.y = pY;
        controller = pController;

        setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000;-fx-border-width: 10");


        setOnAction(event -> {
            if (getIsClickable()) {
                setText(getPlayer());
                this.controller.checkMove(this.x, this.y);
                toggleClickable();
            }
        });
    }

    public int[] getPosition() {
        return new int[]{this.x, this.y};
    }

    public boolean getIsClickable() {
        return this.isClickable;
    }

    private void toggleClickable() {
        this.isClickable = !this.isClickable;
    }

    private String getPlayer() {
        int player = this.controller.getActive_player();
        String stringPlayer;

        if (player == 1) stringPlayer = "X"; // Player 1
        else if (player == 2) stringPlayer = "O"; // Player 2
        else stringPlayer = "E"; // ERROR

        return stringPlayer;
    }
}
