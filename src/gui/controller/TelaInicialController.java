package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;


public class TelaInicialController implements Initializable {
    
    @FXML
    private Button btHospede;
    
    @FXML
    public void abrirTelaHospede(MouseEvent event){
        JOptionPane.showMessageDialog(null, "fufou");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btHospede.setOnMouseClicked((event) -> {
            abrirTelaHospede(event);
        });
    }     
}