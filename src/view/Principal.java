package view;

import java.awt.EventQueue;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telasmenu.TelaIniciar;

public class Principal {
    public static void main(String[] args) {

        // declarar variaveis
        LinkedList<Categoria> listaCategorias = new LinkedList<>();
        LinkedList<Produto>[] listaProdutos = new LinkedList[100];
        LinkedList<ClientePF> listaClientesPF = new LinkedList<>();
        LinkedList<ClientePJ> listaClientesPJ = new LinkedList<>();
        LinkedList<Pedido> listaPedidos = new LinkedList<>();
        int size = listaProdutos.length;

        // inicializar listaProdutos
        for (int i = 0; i < size; i++) {
            listaProdutos[i] = new LinkedList<>();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // chamar tela inicial
                    TelaIniciar telaIniciar = new TelaIniciar(listaCategorias, listaProdutos, listaClientesPF,
                            listaClientesPJ, listaPedidos);
                    telaIniciar.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
