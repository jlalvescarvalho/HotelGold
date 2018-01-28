package gui.controller;

import fachada.Hotel;
import negocio.entidade.Hospede;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
    private Pane pane;
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
    

    @FXML
    public void cancelar() {
        pane.getChildren().clear();
        pane.getChildren().add(getNode("/gui/view/TelaInicial.fxml"));
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
