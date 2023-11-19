package controller;

import linkedlist.model.LinkedList;
import model.Produto;

public class ManterProduto {
    LinkedList<Produto>[] listaProdutos;

    public ManterProduto(LinkedList<Produto>[] listaProdutos ) {
        this.listaProdutos = listaProdutos;
    }

    public Produto consultaProduto(String nomeProduto) throws Exception{
        boolean isFound = false;
        Produto produto = new Produto();
        for (LinkedList<Produto> listaProduto : listaProdutos) {
            for (int y = 0; y < listaProduto.size(); y++) {
                if(listaProduto.get(y).nomeProduto.equals(nomeProduto)){
                    produto = listaProduto.get(y);
                    isFound = true;
                    break;
                }
            }
        }
        if(!isFound) {
            throw new Exception("Produto não encontrado");
        }
        return produto;
    }

    public void excluirProduto(String nomeProduto) throws Exception{
        boolean isFound = false;
        Produto produto = new Produto();
        int hash = 0;
        int pos = 0;
        for (LinkedList<Produto> listaProduto : listaProdutos) {
            for (int y = 0; y < listaProduto.size(); y++) {
                if(listaProduto.get(y).nomeProduto.equals(nomeProduto)){
                    hash = listaProduto.get(y).idProduto;
                    pos = y;
                    isFound = true;
                    break;
                }
            }
        }
        if(!isFound) {
            throw new Exception("Produto não encontrado");
        }
    }

    public void inserirProduto(Produto produto) throws Exception{
        int pos = produto.idProduto;
        listaProdutos[pos].addLast(produto);
    }


}
