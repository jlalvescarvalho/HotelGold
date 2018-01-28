package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class TelaHospedeController implements Initializable {
    
    private TextField txtNome;
    private TextField txtCpf;
    private TextField txtTelefone;
    
    protected void cadastrarHospede(ActionEvent e){
        
        String nome, cpf, telefone;
        nome = txtNome.getText();
        nome = txtCpf.getText();
        nome = txtTelefone.getText();  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
              
    }     
}