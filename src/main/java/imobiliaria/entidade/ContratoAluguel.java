package imobiliaria.entidade;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class ContratoAluguel {

    private long id;
    private long imovelId;
    private long clienteId;
    private float valor;
    private boolean ativo;
    private Timestamp dataInicio;
    private Timestamp dataFinal;

    public ContratoAluguel(long id, long imovelId, long clienteId, float valor, boolean ativo, Timestamp dataInicio, Timestamp dataFinal) {
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

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }
}
