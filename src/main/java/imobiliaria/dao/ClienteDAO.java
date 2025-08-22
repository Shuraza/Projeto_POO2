package imobiliaria.dao;

import imobiliaria.entidade.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ClienteDAO extends BaseDAO {

    public void cadastrarCliente(String nome, String email, int idade, String sexo) {

        String query = "INSERT INTO cliente (Nome, Email, Idade, Sexo) VALUES (?,?,?,?)";

        try (
                Connection conn = con();
                PreparedStatement pre = conn.prepareStatement(query);
        ) {


            pre.setString(1, nome);
            pre.setString(2, email);
            pre.setInt(3, idade);
            pre.setString(4, sexo);

            pre.execute();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }


    public List<Cliente> obterTodos(){

    }



}