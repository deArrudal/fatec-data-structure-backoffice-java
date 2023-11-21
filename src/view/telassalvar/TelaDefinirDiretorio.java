package view.telassalvar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MetodosSalvarBD;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaDefinirDiretorio extends JFrame {

    JLabel textoCaminho;
    JTextField campoPasta;
    JButton procurarPasta;
    JButton cancelarOperacao;
    JButton confirmarOperacao;

    public TelaDefinirDiretorio(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos, String tipoOperacao, String modoOperacao) {

        MetodosSalvarBD metodos = new MetodosSalvarBD();

        // definir e configurar elementos de tela.
        textoCaminho = new JLabel("Inserir o caminho do diretorio:");
        textoCaminho.setBounds(30, 12, 200, 23);

        campoPasta = new JTextField();
        campoPasta.setBounds(30, 40, 320, 23);

        procurarPasta = new JButton();
        procurarPasta.setBounds(30, 72, 100, 23);
        procurarPasta.setText("Procurar");
        procurarPasta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoPasta.setText(metodos.encontrarDiretorio(tipoOperacao, modoOperacao));
            }
        });

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(140, 72, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                        campoPasta.getText());

                dispose();
            }
        });

        // definir propriedades do frame.
        this.setTitle("Backoffice - " + tipoOperacao + " " + modoOperacao);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // adicionar elementos ao frame.
        this.add(textoCaminho);
        this.add(campoPasta);
        this.add(procurarPasta);
        this.add(cancelarOperacao);
        this.add(confirmarOperacao);
    }
}
