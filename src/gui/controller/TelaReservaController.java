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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.entidade.Hospede;
import negocio.entidade.Quarto;
import negocio.entidade.Reserva;
import negocio.entidade.TipoReservaEnum;
import negocio.execao.hospede.HospedeNaoExisteException;
import negocio.execao.quarto.QuartoNaoExisteException;
import negocio.execao.quarto.QuartoOcupadoException;
import negocio.execao.reserva.ReservaJaExisteException;
import negocio.execao.reserva.ReservaNaoExisteException;

public class TelaReservaController implements Initializable {

    private Hospede hospede;
    private Reserva reserva;
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
    private ListView<String> listaReservas = new ListView<>();

    @FXML
    protected void cadastrarReserva() {
        try {
            Quarto q = quartoCadastrar.getValue();
            LocalDate d1 = dataEntradaCadastrar.getValue();
            LocalDate d2 = dataSaidaCadastrar.getValue();
            Reserva reserva = new Reserva(q, d1, d2, hospede, tipoReservaCadastrar.getValue());
            Hotel.getInstance().adicionarReserva(reserva);
        } catch (ReservaJaExisteException re) {
            JOptionPane.showMessageDialog(null, re.getMessage());
        } catch (HospedeNaoExisteException hne) {
            JOptionPane.showMessageDialog(null, hne.getMessage());
        } catch (QuartoOcupadoException qo) {
            JOptionPane.showMessageDialog(null, qo.getMessage());
        } catch (QuartoNaoExisteException qne) {
            JOptionPane.showMessageDialog(null, qne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @FXML
    protected void preencherTipoQuarto() {
        preencherTipoReserva();
        ArrayList<Quarto> tipoQuarto = Hotel.getInstance().quartosVagos();

        ObservableList<Quarto> itens = FXCollections.observableArrayList(tipoQuarto);
        quartoCadastrar.setItems(itens);
        quartoAlterar.setItems(itens);

    }

    @FXML
    protected void buscarCadastrar() {
        try {
            hospede = Hotel.getInstance().buscarHospede(cpfCadastrar.getText());
            nomeCadastrar.setText(hospede.getNome());
        } catch (HospedeNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    protected void preencherTipoReserva() {
        ArrayList<TipoReservaEnum> tipoReserva = Hotel.getInstance().tiposReservas();

        ObservableList<TipoReservaEnum> itens = FXCollections.observableArrayList(tipoReserva);
        tipoReservaCadastrar.setItems(itens);
        tipoReservaAlterar.setItems(itens);
    }

    @FXML
    protected void listarReservas() {
        ArrayList<String> apresentacao = new ArrayList<>();
        ArrayList<Reserva> reservas = Hotel.getInstance().listarReservas();

        for (Reserva r : reservas) {
            apresentacao.add(r.toString());
        }

        ObservableList<String> itens = FXCollections.observableArrayList(apresentacao);
        listaReservas.setItems(itens);
    }

    @FXML
    protected void buscarAlterarReserva() {
        try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idAlterar.getText()));
            preencherTipoQuarto();
            tipoReservaAlterar.setValue(reserva.getTipoReserva());
            quartoAlterar.setValue(reserva.getQuarto());

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    protected void alterarReserva() {
        try {
            reserva.setDataSaida(dataSaidaAlterar.getValue());
            reserva.setQuarto(quartoAlterar.getValue());
            reserva.setTipoReserva(tipoReservaAlterar.getValue());

            Hotel.getInstance().alterarReserva(reserva);
        } catch (ReservaNaoExisteException hne) {
            JOptionPane.showMessageDialog(null, hne.getMessage());
        }
    }

    @FXML
    protected void buscarReserva() {
        try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idBuscar.getText()));
            nomeBuscar.setText(reserva.getHospede().getNome());
            cpfBuscar.setText(reserva.getHospede().getCpf());
            quartoBuscar.setText(reserva.getQuarto().getTipo().name());

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void buscarRemoverReserva() {
        try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idRemover.getText()));
            nomeRemover.setText(reserva.getHospede().getNome());
            cpfRemover.setText(reserva.getHospede().getCpf());
            quartoRemover.setText(reserva.getQuarto().getTipo().name());

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void removerReserva(){
        try{
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idRemover.getText()));
            Hotel.getInstance().removerReserva(reserva);
        }catch(ReservaNaoExisteException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
