package imobiliaria;
import imobiliaria.dao.ClienteDAO;
import imobiliaria.dao.ImovelDAO;
import imobiliaria.dao.ContratoAluguelDAO;
import imobiliaria.entidade.Cliente;
import imobiliaria.entidade.ContratoAluguel;
import imobiliaria.entidade.Imovel;
import imobiliaria.service.GeradorRelatorios;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        Boolean loop = true;

        System.out.println("-------SISTEMA DE IMOBILIÁRIA-------");
        System.out.println("Seja bem vindo(a)!");

        while (loop){

            System.out.println("\nEscolha umas das opções abaixo:");
            System.out.println("1. Cadastrar\n2. Gerar relatório\n3. Encerrar");
            System.out.println("\nDigite o número corresponde a ação desejada:\n");

            int acaoDesejada = leitor.nextInt();

            if (acaoDesejada == 1){


                boolean cadastroPermitido = false;

                while (!cadastroPermitido){

                    System.out.println("O que deseja cadastrar?");
                    System.out.println("1. Cliente\n2. Imóvel\n3. Contrato de Aluguel");
                    int opcaoCadastro = leitor.nextInt();

                    if(opcaoCadastro == 1){
                        cadastroPermitido = true;

                        cadastradorCliente();


                    } else if (opcaoCadastro == 2) {
                        cadastroPermitido = true;

                        cadastradorImovel();




                    } else if (opcaoCadastro == 3) {
                        cadastroPermitido = true;

                        cadastradorContrato();


                    }else{
                        System.out.println("Opção inválida");
                    }


                }

            } else if (acaoDesejada == 2) {

                System.out.println("Qual relatório deseja criar?");
                System.out.println("1. Listar os imóveis disponíveis para aluguel.\n2. Listar contratos ativos.\n3. Clientes com mais contratos.\n4. Contratos expirando nos próximos 30 dias.");
                int opcaoRelatorio = leitor.nextInt();

                if(opcaoRelatorio == 1) {

                    List<Imovel> imoveisDisponiveis = GeradorRelatorios.listarImoveisDisponiveis();

                    if(imoveisDisponiveis.isEmpty()){
                        System.out.println("\nNão há imóveis disponíveis!");
                    }else{
                        System.out.println("\nImóveis disponíveis:");
                        for(Imovel imovel : imoveisDisponiveis){

                            System.out.println("\nID Imovel: " + imovel.getId() + " Endereço: " + imovel.getEndereco() + " Tipo: " +
                                    imovel.getTipo() + " Tamanho: " + imovel.getTamanho() + "m²");
                        }
                    }


                } else if(opcaoRelatorio == 2){

                    List<ContratoAluguel> contratosAtivos = GeradorRelatorios.listarContratosAtivos();

                    if(contratosAtivos.isEmpty()){
                        System.out.println("\nNão há contratos ativos!");
                    }else{
                        for (ContratoAluguel contrato : contratosAtivos){

                            System.out.println(String.format("\n-----------------------\nIDContrato:%d \nIDCliente:%d \nIDImovel:%d \nValor: R$ %.2f \nData Inicial: %td/%<tm/%<tY \nData Final: %td/%<tm/%<tY\n", contrato.getId(),
                                    contrato.getClienteId(), contrato.getImovelId(), contrato.getValor(), contrato.getDataInicio(), contrato.getDataFinal())
                            );
                        }
                    }


                } else if(opcaoRelatorio == 3){

                    Cliente maisContratos = GeradorRelatorios.listarClientesMaisContratos();

                    System.out.println("\nO cliente com mais contratos é: " + maisContratos.getNome());


                }else if(opcaoRelatorio == 4) {

                    List<ContratoAluguel> contratosExpirarao = GeradorRelatorios.listarContratosExpirando();

                    if(contratosExpirarao.isEmpty()){
                        System.out.println("\nNão há contratos que irão expirar nos próximos 30 dias!");
                    }else{
                        System.out.println("\nLista de contratos que vão expirar nos próximos 30 dias:");
                        for(ContratoAluguel contrato : contratosExpirarao){
                            System.out.println(String.format("\n-----------------------\nIDContrato:%d \nIDCliente:%d \nIDImovel:%d \nValor: R$ %.2f \nData Inicial: %td/%<tm/%<tY \nData Final: %td/%<tm/%<tY \n", contrato.getId(),
                                    contrato.getClienteId(), contrato.getImovelId(), contrato.getValor(), contrato.getDataInicio(), contrato.getDataFinal())
                            );
                        }
                    }


                }else{

                    System.out.println("Opção inválida");

                }

            } else if (acaoDesejada == 3){

                System.out.println("Encerrando Programa...");
                loop = false;

            }
            else{
                System.out.println("Opção Invalida!");
            }

        }


    }

    public static void cadastradorCliente(){

        Scanner leitor = new Scanner(System.in);

        ClienteDAO clienteDao = new ClienteDAO();

        System.out.println("\nInsira os dados do cliente!");
        System.out.println("Digite o nome:");
        String nome = leitor.nextLine();
        System.out.println("Digite o e-mail:");
        String email = leitor.nextLine();
        System.out.println("Digite a idade:");
        int idade = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Digite o sexo:");
        String sexo = leitor.nextLine();

        clienteDao.cadastrarCliente(nome, email, idade, sexo);

    }


    public static void cadastradorImovel(){

        Scanner leitor = new Scanner(System.in);

        ImovelDAO imovelDAO = new ImovelDAO();

        System.out.println("\nInsira os dados do Imóvel!");
        System.out.println("Digite o tipo do Imóvel:");
        String tipo = leitor.nextLine();

        System.out.println("Digite o m² do imóvel:");
        double tamanho = leitor.nextDouble();
        leitor.nextLine();

        System.out.println("Digite o endereço do imóvel:");
        String endereco  = leitor.nextLine();

        imovelDAO.cadastrarImovel(tipo, tamanho, endereco);

    }

    public static void cadastradorContrato(){

        Scanner leitor = new Scanner(System.in);

        ContratoAluguelDAO contratoDao = new ContratoAluguelDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        ImovelDAO imovelDao = new ImovelDAO();

        List<Cliente> todosClientes = clienteDao.obterTodos();
        List<Imovel> todosImoveis = imovelDao.obterTodos();


        System.out.println("\nInsira os dados do Contrato de Aluguel!\n");

        System.out.println("--------Clientes----------");
        System.out.printf("%-6s%-10s%-11s\n", "", "ID", "NOME");
        System.out.println("--------------------------");
        for(Cliente cliente : todosClientes){
            long IDCliente = cliente.getId();
            String nomeCliente = cliente.getNome();
            System.out.println(String.format("%-6s%-10d%-11s","", IDCliente, nomeCliente));
        }
        System.out.println("--------------------------\n");
        System.out.println("Digite o id do cliente:");
        long idCliente = leitor.nextLong();



        System.out.println("--------Imóveis-----------");
        System.out.printf("%-6s%-10s%-11s\n", "", "ID", "TIPO");
        System.out.println("--------------------------");
        for(Imovel imovel : todosImoveis){
            long IDImovel = imovel.getId();
            String Tipo = imovel.getTipo();
            System.out.println(String.format("%-6s%-10d%-11s","", IDImovel, Tipo));
        }
        System.out.println("--------------------------\n");

        System.out.println("Digite o id do imóvel:");
        long idImovel = leitor.nextLong();

        System.out.println("Digite o valor do imóvel:");
        double valor = leitor.nextDouble();
        leitor.nextLine();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite a data de inicio(DD/MM/YYYY):");
        String dataInicio = leitor.nextLine();

        LocalDate dataInicioLD = LocalDate.parse(dataInicio, formato);
        Date inicioDate = Date.valueOf(dataInicioLD);

        System.out.println("Digite a data de fim(DD/MM/YYYY):");
        String dataFinal = leitor.nextLine();

        LocalDate dataFinalLD = LocalDate.parse(dataFinal, formato);
        Date finalDate = Date.valueOf(dataFinalLD);

        contratoDao.cadastrarContrato(idImovel, idCliente, valor, inicioDate, finalDate);

    }


}
