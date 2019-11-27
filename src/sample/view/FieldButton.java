package sample.view;

import javafx.scene.control.Button;

public class FieldButton extends Button {
    boolean isClickable = true;
    int x, y;

    FieldButton(int pX, int pY) {
        super();
        this.x = pX;
        this.y = pY;

    }

    public int[] getPosition(){
        return new int[] {this.x, this.y};
    }


}
