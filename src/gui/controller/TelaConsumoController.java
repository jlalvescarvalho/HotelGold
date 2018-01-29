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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import negocio.entidade.BebidasEnum;
import negocio.entidade.RefeicaoEnum;
import negocio.entidade.Reserva;
import negocio.entidade.TipoReservaEnum;
import negocio.execao.reserva.ReservaNaoExisteException;

public class TelaConsumoController implements Initializable {

    private Reserva reserva;
    @FXML
    private TextField idAdicionar;
    @FXML
    private TextField idRemoverConsumo;
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
    
    @FXML
    protected void buscarAdicionar() {
        try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idAdicionar.getText()));
            nomeAdicionar.setText(reserva.getHospede().getNome());
            cpfAdicionar.setText(reserva.getHospede().getCpf());

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    @FXML
    protected void buscarRemover() {
        try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idRemoverConsumo.getText()));
            nomeRemover.setText(reserva.getHospede().getNome());
            cpfRemover.setText(reserva.getHospede().getCpf());

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void adicionarBebida(){
            try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idAdicionar.getText()));
            reserva.getHospede().getCartaoConsumo().consumir(listaBebidas.getValue());
            JOptionPane.showMessageDialog(null, "Bebida adicionada");

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    protected void adicionarRefeicao(){
            try {
            reserva = Hotel.getInstance().buscarReserva(Long.parseLong(idAdicionar.getText()));
            reserva.getHospede().getCartaoConsumo().consumir(listaRefeicoes.getValue());
            JOptionPane.showMessageDialog(null, "Refeição adicionada");

        } catch (ReservaNaoExisteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    protected void preencherTipoBebidas() {
        ArrayList<BebidasEnum> tipoBebida = new ArrayList<>();
        tipoBebida.add(BebidasEnum.Agua);
        tipoBebida.add(BebidasEnum.CocaCola);
        tipoBebida.add(BebidasEnum.Fanta);
        tipoBebida.add(BebidasEnum.Suco);
        tipoBebida.add(BebidasEnum.Whisky);

        ObservableList<BebidasEnum> itens = FXCollections.observableArrayList(tipoBebida);
        listaBebidas.setItems(itens);
        
    
    
    }   
    
    @FXML
    protected void preencherTipoRefeicao(){
        preencherTipoBebidas();
        
        ArrayList<RefeicaoEnum> tipoRefeicao = new ArrayList<>();
        tipoRefeicao.add(RefeicaoEnum.Almoco);
        tipoRefeicao.add(RefeicaoEnum.CafeDaManha);
        tipoRefeicao.add(RefeicaoEnum.Janta);
        
        ObservableList<RefeicaoEnum> itens = FXCollections.observableArrayList(tipoRefeicao);
        listaRefeicoes.setItems(itens);
        
    }
    
    @FXML
    protected void listarConsumo(){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
