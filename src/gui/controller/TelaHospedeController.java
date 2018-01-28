package gui.controller;

import fachada.Hotel;
import negocio.entidade.Hospede;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.execao.hospede.HospedeJaExisteException;

public class TelaHospedeController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtTelefone;
   

    @FXML
    protected void cadastrarHospede(ActionEvent e) {
        String nome, cpf, telefone;
        nome = txtNome.getText();
        cpf = txtCpf.getText();
        telefone = txtTelefone.getText();

        try {
            Hospede h = new Hospede(nome, cpf, telefone);
            Hotel.getInstance().adicionarHospede(h);

        } catch (HospedeJaExisteException he) {
            JOptionPane.showMessageDialog(null, he.getMessage());
        }
    }
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
