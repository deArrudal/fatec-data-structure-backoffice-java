package view;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telassalvar.TelaSalvarBD;

public class Principal {
    public static void main(String[] args) {

        // declaração de variaveis.
        LinkedList<Categoria> listaCategorias = new LinkedList<>();
        LinkedList<Produto>[] listaProdutos = new LinkedList[50];
        LinkedList<ClientePF> listaClientesPF = new LinkedList<>();
        LinkedList<ClientePJ> listaClientesPJ = new LinkedList<>();
        LinkedList<Pedido> listaPedidos = new LinkedList<>();
        int size = listaProdutos.length;

        // inicialização de listaProdutos.
        for (int i = 0; i < size; i++) {
            listaProdutos[i] = new LinkedList<>();
        }

        /*
         * new TelaIniciar(listaCategorias, listaProdutos, listaClientesPF,
         * listaClientesPJ, listaPedidos);
         */

        new TelaSalvarBD(listaCategorias, listaProdutos, listaClientesPF,
                listaClientesPJ, listaPedidos);
    }
}
