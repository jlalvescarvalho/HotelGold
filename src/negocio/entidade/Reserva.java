package negocio.entidade;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private long id;
    private Quarto quarto;
    private Date dataEntrada;
    private Date dataSaida;
    private Hospede hospede;
    private TipoReservaEnum tipoReserva;
    private boolean reservaFinalizada;

    private static int contadorId = 1;

    public Reserva(Quarto quarto, Date dataEntrada, Date dataSaida, Hospede hospede, TipoReservaEnum tipoReserva) {
        this.id = contadorId++;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospede = hospede;
        this.hospede.incrementarFrequencia();
        this.tipoReserva = tipoReserva;
    }

    public boolean getReservaFinalizada() {
        return reservaFinalizada;
    }

    public void setReservaFinalizada(boolean reservaFinalizada) {
        this.reservaFinalizada = reservaFinalizada;
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    
    public double checkOut(){
        double total = this.calcularConta() + this.hospede.getCartaoConsumo().calcularConsumo() + this.tipoReserva.getPreco();
        this.quarto.setOcupado(false);
        this.reservaFinalizada = true;
        return total;
    }

    @Override
    public String toString() {
        return "Id: " +this.id+" | Hospede: "+this.hospede.getNome() + " | Quarto: "+this.quarto.getTipo().name()+" | Data Entrada: "+this.dataEntrada+" | Data Saida: "+
                this.dataSaida+" | Tipo Reserva: "+this.tipoReserva.name();
    }
    
    
}
