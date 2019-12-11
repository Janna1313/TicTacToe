package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controller.Controller;
import sample.view.MainFrame;

public class Main extends Application {
    public static Controller controller = new Controller();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = new MainFrame(3);

        primaryStage.setTitle("Ticke di tacke di toe");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
