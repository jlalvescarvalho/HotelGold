package gui.controller;

import fachada.Hotel;
import java.net.URL;
import java.time.LocalDate;
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
import negocio.entidade.Quarto;
import negocio.entidade.Reserva;
import negocio.entidade.TipoQuartoEnum;
import negocio.entidade.TipoReservaEnum;
import negocio.execao.hospede.HospedeNaoExisteException;
import negocio.execao.quarto.QuartoNaoExisteException;
import negocio.execao.quarto.QuartoOcupadoException;
import negocio.execao.reserva.ReservaJaExisteException;

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
    private ComboBox<Quarto> quartoCadastrar = new ComboBox<>();
    @FXML
    private ComboBox<Quarto> quartoAlterar = new ComboBox<>();
    @FXML
    private ComboBox<TipoReservaEnum> tipoReservaCadastrar = new ComboBox<>();
    @FXML
    private ComboBox<TipoReservaEnum> tipoReservaAlterar = new ComboBox<>();
    @FXML
    private DatePicker dataSaidaCadastrar;
    @FXML
    private DatePicker dataEntradaCadastrar;
    @FXML
    private DatePicker dataSaidaAlterar;
    
    @FXML
    protected void cadastrarReserva(){
        try{
            Quarto q = quartoCadastrar.getValue();
            LocalDate d1 = dataEntradaCadastrar.getValue();
            LocalDate d2 = dataSaidaCadastrar.getValue();
            Reserva reserva = new Reserva(q,d1,d2,hospede, tipoReservaCadastrar.getValue());
            Hotel.getInstance().adicionarReserva(reserva);
        }catch(ReservaJaExisteException re){
            JOptionPane.showMessageDialog(null, re.getMessage());
        }catch(HospedeNaoExisteException hne){
            JOptionPane.showMessageDialog(null, hne.getMessage());
        }catch(QuartoOcupadoException qo){
            JOptionPane.showMessageDialog(null, qo.getMessage());
        }catch(QuartoNaoExisteException qne){
            JOptionPane.showMessageDialog(null, qne.getMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    @FXML
    protected void preencherTipoQuarto(){
        preencherTipoReserva();
        ArrayList<Quarto> tipoQuarto = Hotel.getInstance().quartosVagos();
        
        ObservableList<Quarto> itens = FXCollections.observableArrayList(tipoQuarto);
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
    protected void preencherTipoReserva(){
        ArrayList<TipoReservaEnum> tipoReserva = Hotel.getInstance().tiposReservas();
        
        ObservableList<TipoReservaEnum> itens = FXCollections.observableArrayList(tipoReserva);
        tipoReservaCadastrar.setItems(itens);
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }     
}
