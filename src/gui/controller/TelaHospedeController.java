package gui.controller;

import fachada.Hotel;
import negocio.entidade.Hospede;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import negocio.execao.hospede.HospedeInvalidoException;
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
    private ListView<String> listaHospedes = new ListView<>();
    @FXML
    private Label frequenciaHospede;

    @FXML
    protected void cadastrarHospede() {
        String nome, cpf, telefone;
        nome = txtNome.getText();
        cpf = cpfCadastrar.getText();
        telefone = txtTelefone.getText();

        try {
            Hospede h = new Hospede(nome, cpf, telefone);
            Hotel.getInstance().adicionarHospede(h);
            JOptionPane.showMessageDialog(null, "Hóspede cadastrado.");
            txtNome.setText("");
            cpfCadastrar.setText("");
            txtTelefone.setText("");
        } catch (HospedeJaExisteException | HospedeInvalidoException he) {
            JOptionPane.showMessageDialog(null, he.getMessage());
        }
    }

    @FXML
    protected void buscarHospede() {
        try {
            if (!cpfBuscar.getText().equals("")) {
                hospede = Hotel.getInstance().buscarHospede(cpfBuscar.getText());
                labelNome.setText(hospede.getNome());
                labelTelefone.setText(hospede.getTelefone());
                frequenciaHospede.setText(String.valueOf(hospede.getFrequencia()));
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não identificado.");
            }

        } catch (HospedeNaoExisteException hne) {
            JOptionPane.showMessageDialog(null, hne.getMessage());
        }

    }

    @FXML
    protected void buscarAlterar() {
        try {
            if (!cpfAlterar.getText().equals("")) {
                hospede = Hotel.getInstance().buscarHospede(cpfAlterar.getText());
                txtNomeAlterar.setText(hospede.getNome());
                txtTelefoneAlterar.setText(hospede.getTelefone());
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não identificado.");
            }

        } catch (HospedeNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void buscarRemover() {
        try {
            if (!cpfRemover.getText().equals("")) {
                hospede = Hotel.getInstance().buscarHospede(cpfRemover.getText());
                nomeRemover.setText(hospede.getNome());
                telefoneRemover.setText(hospede.getTelefone());
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não identificado.");
            }

        } catch (HospedeNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void alterarHospede() {
        try {
            if (hospede != null) {
                hospede = Hotel.getInstance().buscarHospede(cpfAlterar.getText());
                hospede.setNome(txtNomeAlterar.getText());
                hospede.setTelefone(txtTelefoneAlterar.getText());
                Hotel.getInstance().alterarHospede(hospede);
                JOptionPane.showMessageDialog(null, "Hóspede alterado.");
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não identificado.");
            }
        } catch (HospedeNaoExisteException hne) {
            JOptionPane.showMessageDialog(null, hne.getMessage());
        }
    }

    @FXML
    protected void removerHospede() {
        try {
            if (hospede != null) {
                Hotel.getInstance().removerHospede(hospede.getCpf());
                JOptionPane.showMessageDialog(null, "Hóspede removido.");
                nomeRemover.setText("");
                telefoneRemover.setText("");
                cpfRemover.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Hóspede não identificado.");
            }

        } catch (HospedeNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @FXML
    protected void listarHospedes() {
        ArrayList<String> apresentacao = new ArrayList<>();
        ArrayList<Hospede> hospedes = Hotel.getInstance().listaHospedes();

        for (Hospede h : hospedes) {
            apresentacao.add(h.toString());
        }

        ObservableList<String> itens = FXCollections.observableArrayList(apresentacao);
        listaHospedes.setItems(itens);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
