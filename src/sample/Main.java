package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.GameController;
import sample.view.frames.MenuFrame;

public class Main extends Application {
    public static Stage primaryStage;
    public static final int SIZE_MULTIPLIER = 100;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;

        Main.primaryStage.setTitle("Ticke di tacke di toe");
        Main.primaryStage.setResizable(true);

        Parent menuView = new MenuFrame(new GameController());

        Main.primaryStage.setScene(new Scene(menuView, 500, 500));
        //primaryStage.setScene(new Scene(gameView, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
