package view;

import linkedlist.model.LinkedList;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class Principal {
    public static void main(String[] args) {
        // declaração de variaveis.
        String[] listaCategorias;
        LinkedList<Produto>[] listaProdutos;
        LinkedList<ClientePF>[] listaClientesPF;
        LinkedList<ClientePJ>[] listaClientesPJ;
        LinkedList<Pedido> listaPedidos;

        new TelaCarregarBD();
    }
}
