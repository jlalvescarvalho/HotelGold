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
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import negocio.execao.hospede.HospedeJaExisteException;
import negocio.execao.hospede.HospedeNaoExisteException;

public class TelaHospedeController implements Initializable {

    @FXML
    private TextField txtNomeAlterar;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtTelefoneAlterar;
    @FXML
    private TextField cpfCadastrar;
    @FXML
    private TextField txtTelefone;
    @FXML
    private Pane pane;
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btBuscar;
    @FXML
    private Button btBuscarAlterar;
    private Hospede hospede;
    @FXML
    private TextField cpfBuscar;
    @FXML
    private TextField cpfAlterar;
    @FXML
    private TextField cpfRemover;
    @FXML
    private Label labelNome;
    @FXML
    private Label labelTelefone;
    @FXML
    private Label nomeRemover;
    @FXML
    private Label telefoneRemover;
    @FXML
    private Button btBuscarRemover;
    @FXML
    private Button btRemover;
    
    @FXML
    protected void cadastrarHospede() {
        String nome, cpf, telefone;
        nome = txtNome.getText();
        cpf = cpfCadastrar.getText();
        telefone = txtTelefone.getText();

        try {
            Hospede h = new Hospede(nome, cpf, telefone);
            Hotel.getInstance().adicionarHospede(h);

        } catch (HospedeJaExisteException he) {
            JOptionPane.showMessageDialog(null, he.getMessage());
        }
    }

    @FXML
    protected void buscarHospede() {
        try {
            hospede = Hotel.getInstance().buscarHospede(cpfBuscar.getText());
            labelNome.setText(hospede.getNome());
            labelTelefone.setText(hospede.getTelefone());
        } catch (HospedeNaoExisteException hne) {
            JOptionPane.showMessageDialog(null, hne.getMessage());
        }

    }

    @FXML
    protected void buscarAlterar() {
        try {
            hospede = Hotel.getInstance().buscarHospede(cpfAlterar.getText());
            txtNomeAlterar.setText(hospede.getNome());
            txtTelefoneAlterar.setText(hospede.getTelefone());
        } catch (HospedeNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void buscarRemover(){
        try{
           hospede = Hotel.getInstance().buscarHospede(cpfRemover.getText());
           nomeRemover.setText(hospede.getNome());
           telefoneRemover.setText(hospede.getTelefone());
        }catch(HospedeNaoExisteException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

    @FXML
    protected void alterarHospede() {
        try {
            hospede = Hotel.getInstance().buscarHospede(cpfAlterar.getText());
            hospede.setNome(txtNomeAlterar.getText());
            hospede.setTelefone(txtTelefoneAlterar.getText());
            Hotel.getInstance().alterarHospede(hospede);
        } catch (HospedeNaoExisteException hne) {
            JOptionPane.showMessageDialog(null, hne.getMessage());
        }
    }
    
    @FXML
    protected void removerHospede(){
        try{
            hospede = Hotel.getInstance().buscarHospede(cpfRemover.getText());
            Hotel.getInstance().removerHospede(hospede.getCpf());
            
        }catch(HospedeNaoExisteException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
