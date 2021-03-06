package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Check your card");
        this.primaryStage=primaryStage;
        mainWindow();
    }

    public void mainWindow(){
        try {
            FXMLLoader loader=new FXMLLoader(Main.class.getResource("sample.fxml"));
            AnchorPane pane=loader.load();

            Controller mainController=loader.getController();
            mainController.setMain(this);

            primaryStage.setScene(new Scene(pane));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
