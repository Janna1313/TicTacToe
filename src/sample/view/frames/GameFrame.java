package sample.view.frames;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import sample.Main;
import sample.controller.GameController;
import sample.view.FieldButton;
import sample.view.View;

import java.util.ArrayList;

public class GameFrame extends BorderPane implements View {
    private GameController controller;

    private static class ButtonGrid extends GridPane {
        ButtonGrid(double fieldSize, GameController controller) {
            setAlignment(Pos.CENTER);

            double size = fieldSize/700;

            for (int x = 0; x < fieldSize; x++) {
                for (int y = 0; y < fieldSize; y++) {
                    add(new FieldButton(x, y, controller), x, y);

                    setMinHeight(size);
                    setMinWidth(size);
                }
            }
            setPrefSize(size, size);
        }
    }

    public GameFrame(int fieldSize, GameController pController) {
        controller = pController;
        controller.setView(this);
        controller.setActive_player(1);
        init(fieldSize);

        setCenter(new ButtonGrid(fieldSize, this.controller));
    }

    @Override
    public String showWinner() {
        TextInputDialog player = new TextInputDialog();
        player.setContentText("What's your name?");
        player.showAndWait();

        player.getEditor().setOnAction(event -> {
            Dialog winner = new Dialog();
            winner.setContentText("Player " + player.getEditor().getText() + " has won!");
            winner.showAndWait();

            winner.setOnCloseRequest(event1 -> {
                winner.close();
                player.close();
            });
        });

        return player.getEditor().getText();
    }

    @Override
    public void showTie() {
        Dialog tie = new Dialog();
        tie.setContentText("No one won!");
        tie.getDialogPane().getButtonTypes().add(new ButtonType("Close", ButtonBar.ButtonData.OK_DONE));
        tie.showAndWait();
    }


    @Override
    public void showScoreBoard(ArrayList<String> board) {
        String tBoard = "Name\n";
        Dialog scoreBoard = new Dialog();
        for (int i = 0; i < board.size(); i++) {
            tBoard += board.get(i) + "\n";
        }

        scoreBoard.setContentText(tBoard);
        scoreBoard.getDialogPane().getButtonTypes().add(new ButtonType("Close", ButtonBar.ButtonData.OK_DONE));
        scoreBoard.showAndWait();
    }

    @Override
    public void init(int fieldSize) {
        ButtonBar buttonBar = new ButtonBar();

        Button scoreBoardButton = new Button("Scoreboard");
        scoreBoardButton.setOnAction(event -> {
            controller.showScoreboard();
        });

        Button menu = new Button("Main Menu");

        menu.setOnAction(event -> {
            Main.primaryStage.setScene(new Scene(new MenuFrame(controller), this.getWidth(), getHeight()));
        });

        Button restart = new Button("Restart");

        restart.setOnAction(event -> {
            controller.restart();
            Main.primaryStage.setScene(new Scene(new GameFrame(fieldSize, controller), this.getWidth(), this.getHeight()));
        });

        Button endGame = new Button("End Game");

        endGame.setOnAction(event -> {
            System.exit(0);
        });

        buttonBar.getButtons().addAll(scoreBoardButton, menu, restart, endGame);

        setTop(buttonBar);
    }
}
