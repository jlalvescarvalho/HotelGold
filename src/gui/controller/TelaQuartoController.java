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
    private ComboBox<TipoQuartoEnum> comboBox = new ComboBox<TipoQuartoEnum>();
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btBuscar;
    @FXML
    private ListView<String> listaQuarto = new ListView<>();
    @FXML
    private TextField txtNumeroQuarto;
    @FXML
    private Label labelTipoQuarto;
    
    ArrayList<TipoQuartoEnum> tipoQuarto = new ArrayList<>();
    
    Quarto quarto;
    
    @FXML
    protected void cadastrar(){
        Quarto quarto = new Quarto(comboBox.getValue());
        try {
            Hotel.getInstance().adicionarQuarto(quarto);
        } catch (QuartoJaExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    @FXML
    protected void preencherComboBox(){
        
        ArrayList<TipoQuartoEnum> tipoQuarto = new ArrayList<>();
        tipoQuarto.add(TipoQuartoEnum.QuartoCasal);
        tipoQuarto.add(TipoQuartoEnum.QuartoSolteiro);
        tipoQuarto.add(TipoQuartoEnum.QuartoDuploSolteiro);
        tipoQuarto.add(TipoQuartoEnum.QuartoFamilia);
        
        ObservableList<TipoQuartoEnum> itens = FXCollections.observableArrayList(tipoQuarto);
        comboBox.setItems(itens);
    }
    
    @FXML
    protected void ListarQuartos(){
        ArrayList<String> apresentacao = new ArrayList<>();
        ArrayList<Quarto> quartos = Hotel.getInstance().listaQuartos();
        
        for(Quarto q: quartos){
            apresentacao.add(q.toString());
        }
        
        ObservableList<String> itens = FXCollections.observableArrayList(apresentacao);
        listaQuarto.setItems(itens);
    }
    
    @FXML
    protected void bucarQuarto(){
        try {
            quarto = Hotel.getInstance().buscarQuarto(Integer.parseInt(txtNumeroQuarto.getText()));
            labelTipoQuarto.setText(quarto.getTipo().name());
        } catch (QuartoNaoExisteException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
}
