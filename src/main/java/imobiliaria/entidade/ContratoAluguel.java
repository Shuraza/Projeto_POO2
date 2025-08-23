package imobiliaria.entidade;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ContratoAluguel {

    private long id;
    private long imovelId;
    private long clienteId;
    private double valor;
    private boolean ativo;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    public ContratoAluguel(long id, long imovelId, long clienteId, double valor, boolean ativo, LocalDate dataInicio, LocalDate dataFinal) {
        this.id = id;
        this.imovelId = imovelId;
        this.clienteId = clienteId;
        this.ativo = ativo;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getImovelId() {
        return imovelId;
    }

    public void setImovelId(long imovelId) {
        this.imovelId = imovelId;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
}
