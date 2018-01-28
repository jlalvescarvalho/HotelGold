package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        FXMLLoader load = new FXMLLoader();      
        load.setLocation(getClass().getResource("/gui/view/TelaInicial.fxml"));
        root = (AnchorPane) load.load();
        primaryStage.setTitle("Hotel Gold");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
