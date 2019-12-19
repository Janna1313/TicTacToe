package sample.view.frames;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.controller.GameController;

public class MenuFrame extends VBox {
    private Slider size;
    private GameController gameController;

    public MenuFrame(GameController pGameController) {
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

        GameFrame gameFrame = new GameFrame((int)size.getValue(), pGameController);


        startButton.setOnAction(event -> {
            pGameController.startGame((int)size.getValue());
            Main.primaryStage.setScene(new Scene(gameFrame, size.getValue()*Main.SIZE_MULTIPLIER, size.getValue()*Main.SIZE_MULTIPLIER));

        });

        scoreBoard.setOnAction(event -> pGameController.showScoreboard());

        getChildren().addAll(size, startButton, scoreBoard);
    }
}
