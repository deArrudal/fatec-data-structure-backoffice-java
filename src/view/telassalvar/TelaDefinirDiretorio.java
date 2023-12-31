package view.telassalvar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.salvarecarregar.MetodosSalvarBD;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaDefinirDiretorio extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel textoCaminho;
    JTextField campoDiretorio;
    JButton procurarDiretorio;
    JButton cancelarOperacao;
    JButton confirmarOperacao;

    public TelaDefinirDiretorio(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos, String tipoOperacao, String modoOperacao) {

        MetodosSalvarBD metodos = new MetodosSalvarBD();

        // definir e configurar elementos de tela
        textoCaminho = new JLabel("Inserir o caminho do diretorio:");
        textoCaminho.setBounds(30, 12, 200, 23);

        campoDiretorio = new JTextField();
        campoDiretorio.setBounds(30, 40, 320, 23);

        procurarDiretorio = new JButton();
        procurarDiretorio.setBounds(30, 72, 100, 23);
        procurarDiretorio.setText("Procurar");
        procurarDiretorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoDiretorio.setText(metodos.encontrarDiretorio(tipoOperacao, modoOperacao));
            }
        });

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(140, 72, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaSalvarBD telaSalvarBD = new TelaSalvarBD(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos);
                telaSalvarBD.setVisible(true);
                dispose();
            }
        });

        confirmarOperacao = new JButton();
        confirmarOperacao.setBounds(250, 72, 100, 23);
        confirmarOperacao.setText("Confirmar");
        confirmarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodos.carregarDiretorio(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos, tipoOperacao, modoOperacao,
                        campoDiretorio.getText());

                TelaSalvarBD telaSalvarBD = new TelaSalvarBD(listaCategorias, listaProdutos,
                        listaClientesPF, listaClientesPJ, listaPedidos);
                telaSalvarBD.setVisible(true);
                dispose();
            }
        });

        // definir propriedades do frame
        this.setTitle("Backoffice - " + tipoOperacao + " " + modoOperacao);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // adicionar elementos ao frame
        this.add(textoCaminho);
        this.add(campoDiretorio);
        this.add(procurarDiretorio);
        this.add(cancelarOperacao);
        this.add(confirmarOperacao);
    }
}