package gui.controller;

import fachada.Hotel;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.entidade.Hospede;
import negocio.entidade.TipoQuartoEnum;
import negocio.execao.hospede.HospedeNaoExisteException;

public class TelaReservaController implements Initializable {
    
    private Hospede hospede;
    @FXML
    private Label nomeCadastrar;
    @FXML
    private Label nomeBuscar;
    @FXML
    private Label nomeRemover;
    @FXML
    private Label cpfBuscar;
    @FXML
    private Label quartoBuscar;
    @FXML
    private Label cpfRemover;
    @FXML
    private Label quartoRemover;
    @FXML
    private TextField cpfCadastrar;
    @FXML
    private TextField idAlterar;
    @FXML
    private TextField idBuscar;
    @FXML
    private TextField idRemover;
    @FXML
    private ComboBox<TipoQuartoEnum> quartoCadastrar = new ComboBox<TipoQuartoEnum>();
    @FXML
    private ComboBox<String> quartoAlterar;
    @FXML
    private DatePicker dataSaidaCadastrar;
    @FXML
    private DatePicker dataEntradaCadastrar;
    @FXML
    private DatePicker dataSaidaAlterar;
    
    @FXML
    protected void cadastrarReserva(){
           
    }
    @FXML
    protected void preencherTipoQuarto(){
        
        ArrayList<TipoQuartoEnum> tipoQuarto = Hotel.getInstance().tiposQuartosVagos();
        
        ObservableList<TipoQuartoEnum> itens = FXCollections.observableArrayList(tipoQuarto);
        quartoCadastrar.setItems(itens);
    }
    
    @FXML
    protected void buscarCadastrar(){
        try{
           hospede = Hotel.getInstance().buscarHospede(cpfCadastrar.getText());
           nomeCadastrar.setText(hospede.getNome());
        }catch(HospedeNaoExisteException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
}
