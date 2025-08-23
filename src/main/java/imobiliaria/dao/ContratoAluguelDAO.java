package imobiliaria.dao;
import imobiliaria.entidade.ContratoAluguel;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ContratoAluguelDAO extends BaseDAO {

    public void cadastrarContrato(long imovelId, long clienteId, float valor, boolean ativo, Timestamp dataInicio, Timestamp dataFinal){

        String query = "INSERT INTO ContratoAluguel (IDCliente, IDImovel, Valor, Ativo, DataInicio, DataFinal) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = con();
                PreparedStatement pre = conn.prepareStatement(query);
                ){

            pre.setLong(1,clienteId);
            pre.setLong(2, imovelId);
            pre.setFloat(3,valor);
            pre.setBoolean(4,ativo);
            pre.setTimestamp(5,dataInicio);
            pre.setTimestamp(6,dataFinal);


        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }


    public List<ContratoAluguel> obterTodos(){

        String query = "SELECT *, CASE WHEN DataFinal >= CURDATE() THEN 1 ELSE 0 END AS Ativo FROM ContratoAluguel";
        List<ContratoAluguel> listaContratos = new ArrayList<ContratoAluguel>();

        try (
                Connection conn = con();
                PreparedStatement pre = conn.prepareStatement(query);
        ){
            ResultSet consultaFeita = pre.executeQuery();
            while (consultaFeita.next()){
                long id = consultaFeita.getLong("IDContrato");
                long IDCliente = consultaFeita.getLong("IDCliente");
                long IDImovel = consultaFeita.getLong("IDImovel");
                float Valor = consultaFeita.getFloat("Valor");
                boolean Ativo = consultaFeita.getBoolean("Ativo");
                Timestamp DataInicio = consultaFeita.getTimestamp("DataInicio");
                Timestamp DataFinal = consultaFeita.getTimestamp("DataFinal");

                ContratoAluguel contratoAluguel = new ContratoAluguel(id, IDCliente, IDImovel, Valor, Ativo, DataInicio, DataFinal);

                listaContratos.add(contratoAluguel);

            }

            return listaContratos;

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return listaContratos;
        }
    }


}
