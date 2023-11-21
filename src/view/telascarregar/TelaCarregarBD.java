package view.telascarregar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaCarregarBD extends JFrame {
    
    JLabel textoOpcao;
    JButton carregarCategorias;
    JButton carregarProdutos;
    JButton carregarClientesPF;
    JButton carregarClientesPJ;
    JButton cancelarOperacao;

    public TelaCarregarBD(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos) {

        // definir e configurar elementos de tela
        textoOpcao = new JLabel("Selecione a opção de carregamento", SwingConstants.CENTER);
        textoOpcao.setBounds(100, 20, 250, 23);

        carregarCategorias = new JButton();
        carregarCategorias.setBounds(130, 58, 190, 23);
        carregarCategorias.setText("Categorias de Produtos");
        carregarCategorias.setHorizontalAlignment(SwingConstants.CENTER);
        carregarCategorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaDefinirArquivo(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos, "Carregar", "categorias");
            }
        });

        carregarProdutos = new JButton();
        carregarProdutos.setBounds(130, 96, 190, 23);
        carregarProdutos.setText("Produtos");
        carregarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
        carregarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaDefinirArquivo(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos, "Carregar", "produtos");
            }
        });

        carregarClientesPF = new JButton();
        carregarClientesPF.setBounds(130, 134, 190, 23);
        carregarClientesPF.setText("Clientes - Pessoa Fisica");
        carregarClientesPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaDefinirArquivo(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos, "Carregar", "clientesPF");
            }
        });

        carregarClientesPJ = new JButton();
        carregarClientesPJ.setBounds(130, 172, 190, 23);
        carregarClientesPJ.setText("Clientes - Pessoa Juridica");
        carregarClientesPJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaDefinirArquivo(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos, "Carregar", "clientesPJ");
            }
        });

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(175, 220, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // definir propriedades do frame
        this.setTitle("Backoffice - Carregar Banco de Dados");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // adicionar elementos ao frame
        this.add(textoOpcao);
        this.add(carregarCategorias);
        this.add(carregarProdutos);
        this.add(carregarClientesPF);
        this.add(carregarClientesPJ);
        this.add(cancelarOperacao);
    }
}
