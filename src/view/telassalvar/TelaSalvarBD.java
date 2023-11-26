package view.telassalvar;

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
import view.telasmenu.TelaHome;

public class TelaSalvarBD extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel textoOpcao;
    JButton salvarCategorias;
    JButton salvarProdutos;
    JButton salvarClientesPF;
    JButton salvarClientesPJ;
    JButton salvarPedidos;
    JButton cancelarOperacao;

    public TelaSalvarBD(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos) {

        // definir e configurar elementos de tela
        textoOpcao = new JLabel("Selecione o tipo de dados a ser salvo", SwingConstants.CENTER);
        textoOpcao.setBounds(100, 20, 250, 23);

        salvarCategorias = new JButton();
        salvarCategorias.setBounds(20, 65, 190, 23);
        salvarCategorias.setText("Categorias de Produtos");
        salvarCategorias.setHorizontalAlignment(SwingConstants.CENTER);
        salvarCategorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaDefinirDiretorio telaDefinirDiretorio = new TelaDefinirDiretorio(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos, "Salvar", "categorias");
                telaDefinirDiretorio.setVisible(true);
                dispose();
            }
        });

        salvarProdutos = new JButton();
        salvarProdutos.setBounds(225, 65, 190, 23);
        salvarProdutos.setText("Produtos");
        salvarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
        salvarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaDefinirDiretorio telaDefinirDiretorio = new TelaDefinirDiretorio(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos, "Salvar", "produtos");
                telaDefinirDiretorio.setVisible(true);
                dispose();
            }
        });

        salvarClientesPF = new JButton();
        salvarClientesPF.setBounds(20, 115, 190, 23);
        salvarClientesPF.setText("Clientes - Pessoa Fisica");
        salvarClientesPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaDefinirDiretorio telaDefinirDiretorio = new TelaDefinirDiretorio(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos, "Salvar", "clientesPF");
                telaDefinirDiretorio.setVisible(true);
                dispose();
            }
        });

        salvarClientesPJ = new JButton();
        salvarClientesPJ.setBounds(225, 115, 190, 23);
        salvarClientesPJ.setText("Clientes - Pessoa Juridica");
        salvarClientesPJ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaDefinirDiretorio telaDefinirDiretorio = new TelaDefinirDiretorio(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos, "Salvar", "clientesPJ");
                telaDefinirDiretorio.setVisible(true);
                dispose();
            }
        });

        salvarPedidos = new JButton();
        salvarPedidos.setBounds(175, 165, 100, 23);
        salvarPedidos.setText("Pedidos");
        salvarPedidos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaDefinirDiretorio telaDefinirDiretorio = new TelaDefinirDiretorio(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos, "Salvar", "pedidos");
                telaDefinirDiretorio.setVisible(true);
                dispose();
            }
        });

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(175, 220, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos);
                telaHome.setVisible(true);
                dispose();
            }
        });

        // definir propriedades do frame
        this.setTitle("Backoffice - Salvar Banco de Dados");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // adicionar elementos ao frame
        this.add(textoOpcao);
        this.add(salvarCategorias);
        this.add(salvarProdutos);
        this.add(salvarClientesPF);
        this.add(salvarClientesPJ);
        this.add(salvarPedidos);
        this.add(cancelarOperacao);
    }
}