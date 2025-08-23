package imobiliaria;

import imobiliaria.dao.ClienteDAO;
import imobiliaria.entidade.Cliente;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDao = new ClienteDAO();

        //clienteDao.cadastrarCliente("Caio", "caiodesouza.cds@gmail.com", 19, "Masculino");


        List<Cliente> lista = clienteDao.obterTodos();

        for(Cliente cliente : lista){
            System.out.println(cliente.getId());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getSexo());
            System.out.println(cliente.getIdade());
        }

    }
}
