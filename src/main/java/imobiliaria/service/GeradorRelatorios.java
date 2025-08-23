package imobiliaria.service;
import imobiliaria.dao.ClienteDAO;
import imobiliaria.dao.ContratoAluguelDAO;
import imobiliaria.dao.ImovelDAO;
import imobiliaria.entidade.Cliente;
import imobiliaria.entidade.ContratoAluguel;
import imobiliaria.entidade.Imovel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeradorRelatorios {

    public static List<ContratoAluguel> listarContratosAtivos(){

        ContratoAluguelDAO contratoDao = new ContratoAluguelDAO();
        List<ContratoAluguel> todosContratos = contratoDao.obterTodos();

        List<ContratoAluguel> contratosAtivos = new ArrayList<>();

        for(ContratoAluguel contrato : todosContratos){
            if (contrato.isAtivo()){
                contratosAtivos.add(contrato);
            }
        }

        return contratosAtivos;
    }




    public static List<Imovel> listarImoveisDisponiveis(){

        ImovelDAO imovelDao = new ImovelDAO();
        ContratoAluguelDAO contratoDao = new ContratoAluguelDAO();
        List<ContratoAluguel> todosContratos = contratoDao.obterTodos();
        List<Imovel> todosImoveis = imovelDao.obterTodos();

        List<Imovel> imoveisDisponiveis = new ArrayList<>();

        Boolean possuiContratoAtivo = false;

        for(Imovel imovel : todosImoveis){

            for (ContratoAluguel contrato : todosContratos){


               if(imovel.getId() == contrato.getImovelId()) {


                    if(contrato.isAtivo()){
                        possuiContratoAtivo = true;
                    }
                }
            }

            if(! possuiContratoAtivo){
                imoveisDisponiveis.add(imovel);
            }
            possuiContratoAtivo = false;

        }
        return imoveisDisponiveis;

    }


    public static Cliente listarClientesMaisContratos(){

        ClienteDAO clienteDao = new ClienteDAO();
        ContratoAluguelDAO contratoDao = new ContratoAluguelDAO();
        List<ContratoAluguel> todosContratos = contratoDao.obterTodos();
        List<Cliente> todosClientes = clienteDao.obterTodos();

        Cliente clienteMax = todosClientes.get(0);

        int maxContratos = 0;

        for(Cliente cliente : todosClientes){
            int quantContratos = 0;
            for(ContratoAluguel contrato : todosContratos){
                if( cliente.getId() == contrato.getClienteId()){
                    quantContratos ++;
                }
            }
            if(quantContratos > maxContratos){
                clienteMax = cliente;
                maxContratos = quantContratos;
            }
            quantContratos = 0;
        }
        return clienteMax;

    }


    public static List<ContratoAluguel> listarContratosExpirando(){

        ContratoAluguelDAO contratoDao = new ContratoAluguelDAO();
        List<ContratoAluguel> todosContratos = contratoDao.obterTodos();

        List<ContratoAluguel> contratosExpir = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataMaxima = dataAtual.plusDays(31);

        for(ContratoAluguel contrato : todosContratos){
            if ( contrato.isAtivo() && contrato.getDataFinal().isBefore(dataMaxima)){
                contratosExpir.add(contrato);
            }
        }

        return contratosExpir;

    }


}