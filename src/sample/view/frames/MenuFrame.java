package sample.view.frames;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.controller.GameController;
import sample.model.Model;

public class MenuFrame extends VBox {
    private GameController gameController = new GameController(new GameFrame(3));

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
            gameController.startGame((int)size.getValue());
            Main.primaryStage.setScene(new Scene(new GameFrame((int)size.getValue()), 500, 500));

        });
        scoreBoard.setOnAction(event -> gameController.showScoreboard());

        getChildren().addAll(size, startButton, scoreBoard);
    }
}
