package imobiliaria.dao;
import imobiliaria.Main;
import imobiliaria.entidade.ContratoAluguel;

import java.sql.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContratoAluguelDAO extends BaseDAO {

    public void cadastrarContrato(long imovelId, long clienteId, double valor, Date dataInicio, Date dataFinal){

        String query = "INSERT INTO ContratoAluguel (IDCliente, IDImovel, Valor, DataInicio, DataFinal) VALUES ( ?, ?, ?, ?, ?)";

        try (
                Connection conn = con();
                PreparedStatement pre = conn.prepareStatement(query);
        ){

            pre.setLong(1,clienteId);
            pre.setLong(2, imovelId);
            pre.setDouble(3,valor);
            pre.setDate(4,dataInicio);
            pre.setDate(5,dataFinal);

            pre.execute();

            System.out.println("Cadastro realizado com sucesso!\n");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("ID de Imóvel ou Cliente não cadastrado!");
            Main.cadastradorContrato();
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
                double Valor = consultaFeita.getDouble("Valor");
                boolean Ativo = consultaFeita.getBoolean("Ativo");
                Date DataInicio = consultaFeita.getDate("DataInicio");
                Date DataFinal = consultaFeita.getDate("DataFinal");

                LocalDate dataInicioLD = DataInicio.toLocalDate();
                LocalDate dataFinalLD = DataFinal.toLocalDate();

                ContratoAluguel contratoAluguel = new ContratoAluguel(id, IDImovel,IDCliente ,Valor, Ativo, dataInicioLD, dataFinalLD);

                listaContratos.add(contratoAluguel);

            }

            return listaContratos;

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return listaContratos;
        }
    }


}
