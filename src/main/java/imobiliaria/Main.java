package imobiliaria;

import imobiliaria.dao.ClienteDAO;
import imobiliaria.dao.ImovelDAO;
import imobiliaria.entidade.Cliente;
import imobiliaria.dao.ContratoAluguelDAO;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



    }

    public static void cadastradorCliente(Scanner leitor){


        ClienteDAO clienteDao = new ClienteDAO();

        System.out.println("Insira os dados do cliente!");
        System.out.println("Digite o nome:");
        String nome = leitor.nextLine();

        System.out.println("Digite o e-mail:");
        String email = leitor.nextLine();

        System.out.println("Digite a idade:");
        int idade = leitor.nextInt();

        System.out.println("im sexy and i know it?");
        String sexo = leitor.nextLine();

        clienteDao.cadastrarCliente(nome, email, idade, sexo);

    }


    public static void cadastradorImovel(Scanner leitor){

        ImovelDAO imovelDAO = new ImovelDAO();


        System.out.println("Insira os dados do Imóvel!");
        System.out.println("Digite o tipo do Imóvel:");
        String tipo = leitor.nextLine();

        System.out.println("Digite o m² do imóvel:");
        float tamanho  = leitor.nextFloat();

        System.out.println("Digite o endereço do imóvel:");
        String endereco  = leitor.nextLine();

        imovelDAO.cadastrarImovel(tipo, tamanho, endereco);

    }

    public static void cadastradorContrato(Scanner leitor){

        ContratoAluguelDAO contratoDao = new ContratoAluguelDAO();

        System.out.println("Insira os dados do Contrato de Aluguel!");
        System.out.println("Digite o id do cliente:");
        long idCliente = leitor.nextLong();

        System.out.println("Digite o id do imóvel:");
        long idImovel = leitor.nextLong();

        System.out.println("Digite o valor do imóvel:");
        float valor = leitor.nextFloat();

        System.out.println("O contrato está ativo?");
        boolean ativo = true;

        // tem q ser em string e depois converter pra timestamp...safada
        System.out.println("Digite a data de inicio(DD/MM/YYYY):");
        String dataInicio = leitor.nextLine();

        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date convertDate = dataFormatada.parse(dataInicio);
            Timestamp dataConvertidaInicio = new Timestamp(convertDate.getTime());
        } catch (ParseException e) {
            System.out.println("Erro" + e);;
        }


        System.out.println("Digite a data de fim(DD/MM/YYYY:");
        String dataFinal = leitor.nextLine();

        SimpleDateFormat dataFormatadaFinal = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date convertDate = dataFormatada.parse(dataInicio);
            Timestamp dataConvertidaFinal = new Timestamp(convertDate.getTime());
        } catch (ParseException e) {
            System.out.println("Erro" + e);;
        }


        /*
     long id;
     long imovelId;
     long clienteId;
     float valor;
     boolean ativo;
     Timestamp dataInicio;
     Timestamp dataFinal;
    */
    }


}
