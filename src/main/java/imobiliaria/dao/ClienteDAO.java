package imobiliaria.dao;

import imobiliaria.entidade.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

        String query = "SELECT * FROM cliente";
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        try (
                Connection conn = con();
                PreparedStatement pre = conn.prepareStatement(query);
        ) {


            ResultSet consultaFeita = pre.executeQuery();

            while (consultaFeita.next()){

                int id = consultaFeita.getInt("IDCliente");
                String nome = consultaFeita.getString("Nome");
                String email = consultaFeita.getString("Email");
                int idade = consultaFeita.getInt("Idade");
                String sexo = consultaFeita.getString("Sexo");

                Cliente cliente = new Cliente(id, nome, email, idade, sexo);

                listaClientes.add(cliente);

            }

            return listaClientes;

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            return listaClientes;
        }

    }



}