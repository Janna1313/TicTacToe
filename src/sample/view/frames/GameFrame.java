package sample.view.frames;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import sample.Main;
import sample.controller.GameController;
import sample.view.FieldButton;
import sample.view.View;

import java.util.ArrayList;

public class GameFrame extends BorderPane implements View {
    private GameController controller = new GameController(this);

    private class ButtonGrid extends GridPane {
        ButtonGrid(int fieldSize) {
            for (int x = 0; x < fieldSize; x++) {
                for (int y = 0; y < fieldSize; y++)
                    add(new FieldButton(x, y, fieldSize, controller), x, y);
            }
        }

    }

    public GameFrame(int fieldSize){
        ButtonBar buttonBar = new ButtonBar();

        Button scoreBoardButton = new Button("Scoreboard");
        scoreBoardButton.setOnAction(event -> {
            controller.showScoreboard();
        });

        Button menu = new Button("Main Menu");

        menu.setOnAction(event -> {
            Main.primaryStage.setScene(new Scene(new MenuFrame(), 500, 500));
        });

        Button restart = new Button("Restart");

        restart.setOnAction(event -> {
            Main.primaryStage.setScene(new Scene(new GameFrame(fieldSize), 500, 500));
        });

        Button endGame = new Button("End Game");

        endGame.setOnAction(event -> {
            System.exit(0);
        });

        buttonBar.getButtons().addAll(scoreBoardButton, menu, restart, endGame);

        setTop(buttonBar);
        setCenter(new ButtonGrid(fieldSize));

    }

    @Override
    public void showWinner(int who) {
        Dialog winner = new Dialog();
        winner.setContentText("Player " + who + " has won!");
        winner.show();

    }

    @Override
    public void showTie() {
        Dialog tie = new Dialog();
        tie.setContentText("No one won!");
        tie.show();
    }

    @Override
    public void showScoreBoard(ArrayList<String> board) {
        String tBoard = "Name\n";
        Dialog scoreBoard = new Dialog();
        for (int i = 0; i < board.size(); i++) {
            tBoard += board.get(i) + "\n";
        }

        scoreBoard.setOnCloseRequest(event -> {
            scoreBoard.close();
        });

        scoreBoard.setContentText(tBoard);
        scoreBoard.show();
    }
}
