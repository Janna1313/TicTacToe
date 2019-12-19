package sample.view.frames;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.controller.GameController;
import sample.model.Model;

public class MenuFrame extends VBox {
    private GameController gameController;
    private Slider size;

    public MenuFrame() {
        size = new Slider(3, 13, 3);
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
            GameFrame gameFrame = new GameFrame((int)size.getValue());
            gameController = new GameController(gameFrame);
            gameFrame.setController(this.gameController);
            gameController.startGame((int)size.getValue());
            Main.primaryStage.setScene(new Scene(gameFrame, size.getValue()*Main.SIZE_MULTIPLIER, size.getValue()*Main.SIZE_MULTIPLIER));

        });

        scoreBoard.setOnAction(event -> gameController.showScoreboard());

        getChildren().addAll(size, startButton, scoreBoard);
    }
}
