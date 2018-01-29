package negocio.entidade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private long id;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Hospede hospede;
    private TipoReservaEnum tipoReserva;

    private static int contadorId = 1;

    public Reserva(Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida, Hospede hospede, TipoReservaEnum tipoReserva) {
        this.id = contadorId++;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospede = hospede;
        this.hospede.incrementarFrequencia();
        this.tipoReserva = tipoReserva;
    }

    public TipoReservaEnum getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReservaEnum tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double calcularConta(){
        int quantDias = this.calcularDias();

        if (this.hospede.getFrequencia() == 9){
            this.hospede.zerarFrequencia();
            return (this.quarto.getTipo().getPreco() * quantDias)*0.5;
        }
        else {
            return (this.quarto.getTipo().getPreco() * quantDias);
        }
    }

    private int calcularDias(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String data1 = simpleDateFormat.format(this.dataSaida);
        String data2 = simpleDateFormat.format(this.dataEntrada);

        int quantDias, diaEntrada, diaSaida;

        diaSaida = Integer.parseInt((data1.split("/"))[0]);
        diaEntrada = Integer.parseInt((data2.split("/"))[0]);
        if ((diaSaida - diaEntrada)<0){
           return quantDias = (diaSaida - diaEntrada) + 31;
        }else{
            return quantDias = (diaSaida - diaEntrada) + 1;
        }
    }

    public long getId() {
        return id;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    
    public void checkOut(){
        double total = this.calcularConta() + this.hospede.getCartaoConsumo().calcularConsumo();
        this.quarto.setOcupado(false);
    }

    @Override
    public String toString() {
        return "Id: " +this.id+" | Hospede: "+this.hospede.getNome() + " | Quarto: "+this.quarto.getTipo().name()+" | Data Entrada: "+this.dataEntrada+" | Data Saida: "+
                this.dataSaida+" | Tipo Reserva: "+this.tipoReserva.name();
    }
    
    
}
