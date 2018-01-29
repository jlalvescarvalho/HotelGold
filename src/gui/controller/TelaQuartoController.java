package gui.controller;

import fachada.Hotel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.entidade.Quarto;
import negocio.entidade.TipoQuartoEnum;
import negocio.execao.quarto.QuartoJaExisteException;
import negocio.execao.quarto.QuartoNaoExisteException;

public class TelaQuartoController implements Initializable {

    @FXML
    private ComboBox<TipoQuartoEnum> comboBox = new ComboBox<>();
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btBuscar;
    @FXML
    private Button btAlterar;
    @FXML
    private Button btBuscarAlterar;
    @FXML
    private Button btBuscarRemover;
    @FXML
    private Button btRemover;
    @FXML
    private ListView<String> listaQuarto = new ListView<>();
    @FXML
    private TextField txtNumeroBuscar;
    @FXML
    private TextField txtNumeroAlterar;
    @FXML
    private TextField txtNumeroRemover;
    @FXML
    private Label labelTipoQuarto;
    @FXML
    private Label labelTipoRemover;
    @FXML
    private ComboBox<TipoQuartoEnum> comboBoxAlterar = new ComboBox<>();

    ArrayList<TipoQuartoEnum> tipoQuarto = new ArrayList<>();

    Quarto quarto;

    @FXML
    protected void cadastrar() {
        Quarto quarto = new Quarto(comboBox.getValue());
        try {
            Hotel.getInstance().adicionarQuarto(quarto);
            JOptionPane.showMessageDialog(null, "Quarto cadastrado.");
        } catch (QuartoJaExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @FXML
    protected void preencherComboBox() {

        ArrayList<TipoQuartoEnum> tipoQuarto = new ArrayList<>();
        tipoQuarto.add(TipoQuartoEnum.QuartoCasal);
        tipoQuarto.add(TipoQuartoEnum.QuartoSolteiro);
        tipoQuarto.add(TipoQuartoEnum.QuartoDuploSolteiro);
        tipoQuarto.add(TipoQuartoEnum.QuartoFamilia);

        ObservableList<TipoQuartoEnum> itens = FXCollections.observableArrayList(tipoQuarto);
        comboBox.setItems(itens);
        comboBoxAlterar.setItems(itens);
    }

    @FXML
    protected void ListarQuartos() {
        ArrayList<String> apresentacao = new ArrayList<>();
        ArrayList<Quarto> quartos = Hotel.getInstance().listaQuartos();

        for (Quarto q : quartos) {
            apresentacao.add(q.toString());
        }

        ObservableList<String> itens = FXCollections.observableArrayList(apresentacao);
        listaQuarto.setItems(itens);
    }

    @FXML
    protected void bucarQuarto() {
        try {
            if (!txtNumeroBuscar.getText().equals("")) {
                quarto = Hotel.getInstance().buscarQuarto(Integer.parseInt(txtNumeroBuscar.getText()));
                labelTipoQuarto.setText(quarto.getTipo().name());
            } else {
                JOptionPane.showMessageDialog(null, "Quarto não identificado.");
            }

        } catch (QuartoNaoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @FXML
    protected void buscarQuartoAlterar() {
        try {
            if (!txtNumeroAlterar.getText().equals("")) {
                quarto = Hotel.getInstance().buscarQuarto(Integer.parseInt(txtNumeroAlterar.getText()));
                preencherComboBox();
                comboBoxAlterar.setValue(quarto.getTipo());
            } else {
                JOptionPane.showMessageDialog(null, "Quarto não identificado.");
            }
        } catch (QuartoNaoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @FXML
    protected void alterarQuarto() {
        try {
            if (quarto != null) {
                TipoQuartoEnum t = comboBoxAlterar.getValue();
                quarto.setTipo(t);
                Hotel.getInstance().alterarQuarto(quarto);
                JOptionPane.showMessageDialog(null, "Quarto alterado.");
            } else {
                JOptionPane.showMessageDialog(null, "Quarto não identificado.");
            }
        } catch (QuartoNaoExisteException ex) {
            Logger.getLogger(TelaQuartoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    protected void buscarRemover() {
        try {
            if (!txtNumeroRemover.getText().equals("")) {
                quarto = Hotel.getInstance().buscarQuarto(Integer.parseInt(txtNumeroRemover.getText()));
                labelTipoRemover.setText(quarto.getTipo().name());
            } else {
                JOptionPane.showMessageDialog(null, "Quarto não identificado.");
            }
        } catch (QuartoNaoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @FXML
    protected void remover() {
        try {
            if (quarto != null) {
                Hotel.getInstance().removerQuarto(Integer.parseInt(txtNumeroRemover.getText()));
                labelTipoRemover.setText("");
                JOptionPane.showMessageDialog(null, "Quarto removido.");
            } else {
                JOptionPane.showMessageDialog(null, "Quarto não identificado.");
            }
        } catch (QuartoNaoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
