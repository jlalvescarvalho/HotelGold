package gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import negocio.entidade.BebidasEnum;
import negocio.entidade.RefeicaoEnum;

public class TelaConsumoController implements Initializable {
    
    @FXML
    private TextField idAdicionar;
    @FXML
    private TextField idRemover;
    @FXML
    private Label nomeAdicionar;
    @FXML
    private Label cpfAdicionar;
    @FXML
    private Label nomeRemover;
    @FXML
    private Label cpfRemover;
    @FXML
    private ComboBox<BebidasEnum> listaBebidas = new ComboBox<>();
    @FXML
    private ComboBox<RefeicaoEnum> listaRefeicoes = new ComboBox<>();
    @FXML
    private ComboBox<Enum> listaRemocao = new ComboBox<>();
    @FXML
    private ListView<Enum> listaConsumo = new ListView<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
