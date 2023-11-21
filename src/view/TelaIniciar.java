package view;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class TelaIniciar extends JFrame {
    JLabel titulo;
    JButton carregarDB;
    JButton iniciarHome;
    JButton sairOperacao;

    public TelaIniciar(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos) {

        // definir e configurar elementos de tela
        titulo = new JLabel("Sistema BackOffice 1.0", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 28));
        titulo.setBounds(75, 50, 300, 23);

        carregarDB = new JButton();
        carregarDB.setBounds(55, 125, 160, 23);
        carregarDB.setText("Carregar dados");
        carregarDB.setHorizontalAlignment(SwingConstants.CENTER);
        carregarDB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCarregarBD(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos);
            }
        });

        iniciarHome = new JButton();
        iniciarHome.setBounds(235, 125, 160, 23);
        iniciarHome.setText("Iniciar");
        iniciarHome.setHorizontalAlignment(SwingConstants.CENTER);
        iniciarHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "test");
            }
        });

        sairOperacao = new JButton();
        sairOperacao.setBounds(175, 200, 100, 23);
        sairOperacao.setText("Sair");
        sairOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // definir propriedades do frame
        this.setTitle("Backoffice");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // adicionar elementos ao frame
        this.add(titulo);
        this.add(carregarDB);
        this.add(iniciarHome);
        this.add(sairOperacao);
    }
}
