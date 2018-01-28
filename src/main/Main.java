package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{
    
    private Stage stage;
    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;     
        FXMLLoader load = new FXMLLoader();      
        load.setLocation(getClass().getResource("/gui/view/TelaInicial.fxml"));
        root = (AnchorPane) load.load();
        stage.setTitle("Hotel Gold");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
