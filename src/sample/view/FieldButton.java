package sample.view;

import javafx.scene.control.Button;

class FieldButton extends Button {
    private boolean isClickable = true;
    private int x, y;

    FieldButton(int pX, int pY) {
        super();
        this.x = pX;
        this.y = pY;
        int size = 512/3;

        setMinHeight(size);
        setMaxHeight(size);

        setMinWidth(size);
        setMinWidth(size);

        setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000;-fx-border-width: 10");

        setOnAction(event -> System.out.println("click"));
    }

    public int[] getPosition(){
        return new int[] {this.x, this.y};
    }

    public boolean getIsClickable() {
        return this.isClickable;
    }

    public void toggleClickable() {
        this.isClickable = !this.isClickable;
    }
}
