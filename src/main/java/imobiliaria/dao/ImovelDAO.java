package imobiliaria.dao;



import imobiliaria.entidade.Imovel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO extends BaseDAO {

    public void cadastrarImovel(String tipo, float tamanho, String endereco){

        String query = "INSERT INTO imovel (Tipo, Tamanho, Endereco) VALUES (?, ?, ?)";

        try (
                Connection conn = con();
                PreparedStatement comando = conn.prepareStatement(query);
                ){

            comando.setString(1, tipo);
            comando.setFloat(2, tamanho);
            comando.setString(3, endereco);

            comando.execute();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }



    public List<Imovel> obterTodos(){

        String query = "SELECT * FROM imovel";
        List<Imovel> listaImoveis = new ArrayList<Imovel>();

        try (
                Connection conn = con();
                PreparedStatement comando = conn.prepareStatement(query);
                ){

            ResultSet consultaFeita = comando.executeQuery();

            while (consultaFeita.next()){

                long id = consultaFeita.getLong("IDImovel");
                String tipo = consultaFeita.getString("Tipo");
                float tamanho = consultaFeita.getFloat("Tamanho");
                String endereco = consultaFeita.getString("Endereco");

                Imovel imovel = new Imovel(id, tipo, tamanho, endereco);

                listaImoveis.add(imovel);

            }

            return listaImoveis;

        }catch (Exception e) {
            System.out.println("Erro: " + e);
            return listaImoveis;
        }

    }




}
