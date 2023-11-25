package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;

public class MetodosLerArquivo {

    public MetodosLerArquivo() {
        super();
    }

    public void lerCategoria(LinkedList<Categoria> listaCategorias, String caminhoArquivo) throws Exception {

        // verificar se o diretorio e valido
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.isFile()) {
            throw new IOException("Arquivo invalido");
        }

        Categoria categoria;

        String linha;
        String[] sublinha = new String[2];

        Scanner scan = new Scanner(arquivo);

        scan.nextLine(); // pular cabecalho
        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            sublinha = linha.split(";"); // quebrar conteudo baseado no ";"

            categoria = new Categoria(Integer.parseInt(sublinha[0]), sublinha[1]);

            listaCategorias.addLast(categoria);
        }

        scan.close();
    }

    public void lerProduto(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            String caminhoArquivo) throws Exception {

        // verificar se lista categorias ja foi alocada
        if (listaCategorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Categorias nao inicializada",
                    "Carregamento produtos", JOptionPane.ERROR_MESSAGE);

            throw new IOException("Operacao invalida");
        }

        // verificar se o diretorio e valido
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.isFile()) {
            throw new IOException("Arquivo invalido");
        }

        Produto produto;
        int index;

        String linha;
        String[] sublinha = new String[6];

        Scanner scan = new Scanner(arquivo);

        scan.nextLine(); // pular cabecalho
        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            sublinha = linha.split(";"); // quebrar conteudo baseado no ";"

            index = Integer.parseInt(sublinha[1]); // definir indice

            produto = new Produto(Integer.parseInt(sublinha[0]), index,
                    sublinha[2], sublinha[3], Integer.parseInt(sublinha[4]),
                    Double.parseDouble(sublinha[5]));

            listaProdutos[index].addLast(produto);
        }

        scan.close();
    }

    public void lerClientePF(LinkedList<ClientePF> listaClientesPF, String caminhoArquivo) throws Exception {

        // verificar se lista categorias ja foi alocada
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.isFile()) {
            throw new IOException("Arquivo invalido");
        }

        ClientePF clientePF;

        String linha;
        String[] sublinha = new String[5];

        Scanner scan = new Scanner(arquivo);

        scan.nextLine(); // pular cabecalho
        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            sublinha = linha.split(";"); // quebrar conteudo baseado no ";"

            clientePF = new ClientePF(sublinha[0], sublinha[1], sublinha[2], sublinha[3], sublinha[4]);

            listaClientesPF.addLast(clientePF);
        }

        scan.close();
    }

    public void lerClientePJ(LinkedList<ClientePJ> listaClientesPJ, String caminhoArquivo) throws Exception {

        // verificar se lista categorias ja foi alocada
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.isFile()) {
            throw new IOException("Arquivo invalido");
        }

        ClientePJ clientePJ;

        String linha;
        String[] sublinha = new String[6];

        Scanner scan = new Scanner(arquivo);

        scan.nextLine(); // pular cabecalho
        while (scan.hasNextLine()) {
            linha = scan.nextLine();
            sublinha = linha.split(";"); // quebrar conteudo baseado no ";"

            clientePJ = new ClientePJ(sublinha[0], sublinha[1], sublinha[2], sublinha[3], sublinha[4], sublinha[5]);

            listaClientesPJ.addLast(clientePJ);
        }

        scan.close();
    }
}