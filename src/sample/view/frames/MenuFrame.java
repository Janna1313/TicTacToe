package sample.view.frames;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.controller.GameController;
import sample.model.Model;

public class MenuFrame extends VBox {
    private GameController gameController = new GameController(new Model(3), new GameFrame(3));

    public MenuFrame() {
        Slider size = new Slider(3, 13, 3);
        size.setMajorTickUnit(2);
        size.setMinorTickCount(0);
        size.setBlockIncrement(2);
        size.setSnapToTicks(true);
        size.setShowTickLabels(true);
        size.setShowTickMarks(true);

        Button startButton = new Button();
        startButton.setText("Start new Game");

        Button scoreBoard = new Button();
        scoreBoard.setText("Show Scoreboard");

        startButton.setOnAction(event -> {
            gameController.startGame(3);
            Main.primaryStage.setScene(new Scene(new GameFrame((int)size.getValue()), 500, 500));

        });
        scoreBoard.setOnAction(event -> showScoreBoard("ngk"));

        getChildren().addAll(size, startButton, scoreBoard);
    }

    private void showScoreBoard(String board) {
        Dialog scoreBoard = new Dialog();
        scoreBoard.setContentText(board);
        scoreBoard.show();
    }
}
