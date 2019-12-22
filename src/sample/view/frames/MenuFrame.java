package sample.view.frames;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.controller.GameController;

import java.util.ArrayList;

public class MenuFrame extends VBox {
    private Slider size;

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

        startButton.setOnAction(event -> {
            GameFrame gameFrame = new GameFrame((int)size.getValue(), pGameController);
            pGameController.startGame((int)size.getValue());
            Main.primaryStage.setScene(new Scene(gameFrame, 700, 700));

        });

        scoreBoard.setOnAction(event -> showScoreBoard(pGameController));

        getChildren().addAll(size, startButton, scoreBoard);
    }

    public void showScoreBoard(GameController controller) {
        ArrayList<String> board = controller.getScoreboard();
        String tBoard = "Name\n";
        Dialog scoreBoard = new Dialog();
        for (int i = 0; i < board.size(); i++) {
            tBoard += board.get(i) + "\n";
        }

        scoreBoard.setContentText(tBoard);
        scoreBoard.getDialogPane().getButtonTypes().add(new ButtonType("Close", ButtonBar.ButtonData.OK_DONE));
        scoreBoard.showAndWait();
    }
}
