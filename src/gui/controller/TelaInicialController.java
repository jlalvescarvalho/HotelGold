package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;

public class TelaInicialController implements Initializable {

    @FXML
    private Button btHospede;
    @FXML
    private Button btReserva;
    @FXML
    private Button btQuarto;
    
    @FXML
    private AnchorPane pane;
    
    

    @FXML
    public void abrirTelaHospede() {
        pane.getChildren().clear();
        pane.getChildren().add(getNode("/gui/view/TelaHospede.fxml"));
    }
    
    @FXML
    public void abrirTelaReserva() {
        pane.getChildren().clear();
        pane.getChildren().add(getNode("/gui/view/TelaReserva.fxml"));
    }
    
    @FXML
    public void abrirTelaQuarto() {
        pane.getChildren().clear();
        pane.getChildren().add(getNode("/gui/view/TelaQuarto.fxml"));
    }
    

    public Node getNode(String node) {
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (Exception e) {

        }
        return no;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
