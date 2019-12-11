package sample;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.view.frames.GameFrame;
import sample.view.frames.MenuFrame;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent gameView = new GameFrame(5);
        Parent menuView = new MenuFrame();

        primaryStage.setTitle("Ticke di tacke di toe");
        primaryStage.setScene(new Scene(gameView, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
