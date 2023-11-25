package view.telascarregar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MetodosCarregarBD;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaDefinirArquivo extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel textoCaminho;
    JLabel textoAviso;
    JTextField campoArquivo;
    JButton procurarArquivo;
    JButton cancelarOperacao;
    JButton confirmarOperacao;

    public TelaDefinirArquivo(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos, String tipoOperacao, String modoOperacao) {

        MetodosCarregarBD metodos = new MetodosCarregarBD();

        // definir e configurar elementos de tela
        textoCaminho = new JLabel("Inserir o caminho do arquivo:");
        textoCaminho.setBounds(30, 12, 200, 23);

        textoAviso = new JLabel("*Somente arquivos .csv");
        textoAviso.setBounds(215, 12, 150, 23);
        textoAviso.setForeground(Color.RED);

        campoArquivo = new JTextField();
        campoArquivo.setBounds(30, 40, 320, 23);

        procurarArquivo = new JButton();
        procurarArquivo.setBounds(30, 72, 100, 23);
        procurarArquivo.setText("Procurar");
        procurarArquivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoArquivo.setText(metodos.encontrarArquivo(tipoOperacao, modoOperacao));
            }
        });

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(140, 72, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCarregarBD telaCarregarBD = new TelaCarregarBD(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos);
                telaCarregarBD.setVisible(true);
                setVisible(false);
            }
        });

        confirmarOperacao = new JButton();
        confirmarOperacao.setBounds(250, 72, 100, 23);
        confirmarOperacao.setText("Confirmar");
        confirmarOperacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodos.carregarArquivo(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos, tipoOperacao, modoOperacao,
                        campoArquivo.getText());

                TelaCarregarBD telaCarregarBD = new TelaCarregarBD(listaCategorias, listaProdutos, listaClientesPF,
                        listaClientesPJ, listaPedidos);
                telaCarregarBD.setVisible(true);
                setVisible(false);
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
        this.add(textoAviso);
        this.add(campoArquivo);
        this.add(procurarArquivo);
        this.add(cancelarOperacao);
        this.add(confirmarOperacao);
    }
}