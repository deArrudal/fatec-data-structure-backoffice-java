package controller;

import linkedlist.model.LinkedList;
import model.Produto;

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
        int pos = produto.idProduto;
        listaProdutos[pos].addLast(produto);
    }

}
