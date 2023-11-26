package view.telasmenu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.login.MetodosLogin;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.Principal;

public class TelaIniciar extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel titulo;
    JTextArea nomeGrupo;
    JButton usuarioHome;
    JButton administradorHome;
    JButton sairOperacao;

    MetodosLogin login = new MetodosLogin();

    public TelaIniciar(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos) {

        // definir e configurar elementos de tela
        titulo = new JLabel("Sistema BackOffice 1.0", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 20));
        titulo.setBounds(75, 20, 300, 23);

        nomeGrupo = new JTextArea(
                "Um Projeto feito por Bianca Severiano, Gabriel C. Delfino, \n" +
                        "Lucas S. deArruda, Pedro H. B. Silva e Rafael B. dos Santos.");
        nomeGrupo.setFont(new Font("Serif", Font.BOLD, 12));
        nomeGrupo.setBounds(60, 80, 355, 46);
        nomeGrupo.setBackground(null);

        usuarioHome = new JButton();
        usuarioHome.setBounds(50, 150, 150, 23);
        usuarioHome.setText("Usuario");
        usuarioHome.setHorizontalAlignment(SwingConstants.CENTER);
        usuarioHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Principal.modoAdministrador = false; // desabilita modo administrador.

                TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos);
                telaHome.setVisible(true);
                setVisible(false);
            }
        });

        administradorHome = new JButton();
        administradorHome.setBounds(240, 150, 150, 23);
        administradorHome.setText("Administrador");
        administradorHome.setHorizontalAlignment(SwingConstants.CENTER);
        administradorHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    login.loginAdministrador();
                    Principal.modoAdministrador = true; // habilita modo administrador

                    TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos, listaClientesPF,
                            listaClientesPJ, listaPedidos);
                    telaHome.setVisible(true);
                    setVisible(false);

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Operacao invalida",
                            "BackOffice - Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sairOperacao = new JButton();
        sairOperacao.setBounds(175, 220, 100, 23);
        sairOperacao.setText("Sair");
        sairOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
        this.add(nomeGrupo);
        this.add(usuarioHome);
        this.add(administradorHome);
        this.add(sairOperacao);
    }
}
