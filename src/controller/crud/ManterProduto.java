package controller.crud;

import linkedlist.model.LinkedList;
import model.Produto;

import javax.swing.*;

public class ManterProduto {
    LinkedList<Produto>[] listaProdutos;

    public ManterProduto(LinkedList<Produto>[] listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Produto consultaProduto(String nomeProduto) throws Exception{
        boolean isFound = false;
        Produto produto = new Produto();
        for (LinkedList<Produto> listaProduto : listaProdutos) {
            for (int y = 0; y < listaProduto.size(); y++) {
                if(listaProduto.get(y).nomeProduto.equals(nomeProduto.toLowerCase())){
                    produto = listaProduto.get(y);
                    isFound = true;
                    break;
                }
            }
            if(isFound) { //Finaliza o for each
                break;
            }
        }
        if(!isFound) {
            throw new Exception("Produto não encontrado");
        }
        return produto;
    }

    public void excluirProduto(String nomeProduto) throws Exception{
        boolean isFound = false;
        int hash = 0;
        int pos = 0;
        for (LinkedList<Produto> listaProduto : listaProdutos) {
            for (int i = 0; i < listaProduto.size(); i++) {
                if(listaProduto.get(i).nomeProduto.equals(nomeProduto.toLowerCase())){
                    hash = listaProduto.get(i).idProdutoCategoria;
                    pos = i;
                    isFound = true;
                    break; //Finaliza o segundo for
                }
            }
            if(isFound) { //Finaliza o for each
                break;
            }
        }
        if(!isFound) {
            throw new Exception("Produto não encontrado");
        }
        listaProdutos[hash].remove(pos);
    }

    public void inserirProduto(Produto produto) throws Exception{
        int hash = produto.idProdutoCategoria;
        listaProdutos[hash].addLast(produto);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }

    public void atualizarProduto(Produto antigoProduto, Produto novoProduto) throws Exception {
        int pos = encontrarPosicao(antigoProduto);
        int hash = antigoProduto.idProdutoCategoria;
        listaProdutos[hash].remove(pos);
        listaProdutos[hash].add(novoProduto, pos);
    }

    private int encontrarPosicao(Produto antigoProduto) throws Exception {
        boolean isFound = false;
        int pos = -1;
        for (LinkedList<Produto> listaProduto : listaProdutos) {
            for (int y = 0; y < listaProduto.size(); y++) {
                if(listaProduto.get(y).nomeProduto.equals(antigoProduto.nomeProduto.toLowerCase())){
                    pos = y;
                    isFound = true;
                    break;
                }
            }
            if(isFound) { //Finaliza o for each
                break;
            }
        }
        return pos;
    }

}
