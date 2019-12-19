package sample.view;

import javafx.scene.control.Button;

public class FieldButton extends Button {
    private boolean isClickable = true;
    private int x, y;

    public FieldButton(int pX, int pY, int fieldSize) {
        super();
        this.x = pX;
        this.y = pY;
        int size = 512 / fieldSize;

        setMinHeight(size);
        setMaxHeight(size);

        setMinWidth(size);
        setMinWidth(size);

        setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000;-fx-border-width: 10");


        setOnAction(event -> {
            if (this.isClickable) {
                setText(getPlayer());
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

    public void toggleClickable() {
        this.isClickable = !this.isClickable;
    }

    public String getPlayer() {
        int player = 0;
        String stringPlayer = "";

        if (player == 1) stringPlayer = "X";
        else if (player == 2) stringPlayer = "O";

        return stringPlayer;
    }
}
