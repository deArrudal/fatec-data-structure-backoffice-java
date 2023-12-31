package controller.salvarecarregar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class MetodosEscreverArquivo {

    public MetodosEscreverArquivo() {
        super();
    }

    public void EscreverCategorias(LinkedList<Categoria> listaCategorias, String caminhoDiretorio) throws Exception {

        // verificar se o diretorio e valido
        File diretorio = new File(caminhoDiretorio);
        if (!diretorio.isDirectory()) {
            throw new IOException("Diretorio invalido");
        }

        // verificar se o arquivo ja existe e deletar
        String caminhoArquivo = caminhoDiretorio + "/categorias.csv";
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo.createNewFile();

        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));

        // Imprimir cabecalho
        printWriter.println("idCategoria;nomeCategoria");

        int size = listaCategorias.size();
        for (int i = 0; i < size; i++) {
            printWriter.println(listaCategorias.get(i).toString());
        }

        printWriter.close();
    }

    public void EscreverProdutos(LinkedList<Produto>[] listaProdutos, String caminhoDiretorio) throws Exception {

        // verificar se o diretorio e valido
        File diretorio = new File(caminhoDiretorio);
        if (!diretorio.isDirectory()) {
            throw new IOException("Diretorio invalido");
        }

        // verificar se o arquivo ja existe e deletar
        String caminhoArquivo = caminhoDiretorio + "/produtos.csv";
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo.createNewFile();

        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));

        // Imprimir cabecalho
        printWriter.println("idProduto;idProdutoCategoria;nomeProduto;descricaoProduto;qtdProduto;valorProduto");

        int iSize = listaProdutos.length; // definir tamanho vetor
        int jSize;

        for (int i = 0; i < iSize; i++) {
            jSize = listaProdutos[i].size(); // definir tamanho lista

            for (int j = 0; j < jSize; j++) {
                printWriter.println(listaProdutos[i].get(j).toString());
            }
        }

        printWriter.close();
    }

    public void EscreverClientesPF(LinkedList<ClientePF> listaClientesPF, String caminhoDiretorio) throws Exception {

        File diretorio = new File(caminhoDiretorio);

        // verificar se o diretorio e valido
        if (!diretorio.isDirectory()) {
            throw new IOException("Diretorio invalido");
        }

        String caminhoArquivo = caminhoDiretorio + "/clientesPF.csv";
        File arquivo = new File(caminhoArquivo);

        // verificar se o arquivo ja existe e deletar
        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo.createNewFile();

        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));

        // Imprimir cabecalho
        printWriter.println("cpfClientePF;nomeClientePF;enderecoClientePF;cepClientePF;telefoneClientePF");

        int size = listaClientesPF.size();
        for (int i = 0; i < size; i++) {
            printWriter.println(listaClientesPF.get(i).toString());
        }

        printWriter.close();
    }

    public void EscreverClientesPJ(LinkedList<ClientePJ> listaClientesPJ, String caminhoDiretorio) throws Exception {

        File diretorio = new File(caminhoDiretorio);

        // verificar se o diretorio e valido
        if (!diretorio.isDirectory()) {
            throw new IOException("Diretorio invalido");
        }

        String caminhoArquivo = caminhoDiretorio + "/clientesPJ.csv";
        File arquivo = new File(caminhoArquivo);

        // verificar se o arquivo ja existe e deletar
        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo.createNewFile();

        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));

        // Imprimir cabecalho
        printWriter
                .println("cnpjClientePJ;nomeClientePJ;enderecoClientePJ;cepClientePJ;telefoneClientePJ;emailClientePJ");

        int size = listaClientesPJ.size();
        for (int i = 0; i < size; i++) {
            printWriter.println(listaClientesPJ.get(i).toString());
        }

        printWriter.close();
    }

    public void EscreverPedidos(LinkedList<Pedido> listaPedidos, String caminhoDiretorio) throws Exception {

        File diretorio = new File(caminhoDiretorio);

        // verificar se o diretorio e valido
        if (!diretorio.isDirectory()) {
            throw new IOException("Diretorio invalido");
        }

        String caminhoArquivo = caminhoDiretorio + "/pedidos.csv";
        File arquivo = new File(caminhoArquivo);

        // verificar se o arquivo ja existe e deletar
        if (arquivo.exists()) {
            arquivo.delete();
        }

        arquivo.createNewFile();

        PrintWriter printWriter = new PrintWriter(new FileWriter(arquivo, true));

        // Imprimir cabecalho
        printWriter.println("idPedido;nomeCliente;itensPedido");

        int size = listaPedidos.size();
        for (int i = 0; i < size; i++) {
            printWriter.println(listaPedidos.get(i).toString());
        }

        printWriter.close();
    }
}