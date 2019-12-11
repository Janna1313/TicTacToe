package sample.view.frames;

import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;
import sample.controller.GameController;
import sample.model.Model;

public class MenuFrame extends VBox {
    private GameController gameController = new GameController(new Model(), new GameFrame(3));
    MenuFrame() {
        Button startButton = new Button();
        Button scoreBoard = new Button();

        startButton.setOnAction(event -> gameController.startGame());
        scoreBoard.setOnAction(event -> showScoreBoard());
    }

    public void showScoreBoard(String board) {
        Dialog scoreBoard = new Dialog();
        scoreBoard.setContentText(board);
        scoreBoard.show();
    }
}
