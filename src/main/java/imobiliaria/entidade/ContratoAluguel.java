package imobiliaria.entidade;

import java.time.LocalDateTime;

public class ContratoAluguel {

    private long id;
    private long imovelId;
    private long clienteId;
    private float valor;
    private boolean ativo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFinal;

    public ContratoAluguel(long id, long imovelId, long clienteId, float valor, boolean ativo, LocalDateTime dataInicio, LocalDateTime dataFinal) {
        this.id = id;
        this.imovelId = imovelId;
        this.clienteId = clienteId;
        this.valor = valor;
        this.ativo = ativo;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }
}
