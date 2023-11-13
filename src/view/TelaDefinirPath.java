package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MetodosCarregarBD;

public class TelaDefinirPath extends JFrame implements ActionListener {

    JLabel textoCaminho;
    JLabel textoAviso;
    JTextField campoArquivo;
    JButton procurarArquivo;
    JButton cancelarOperacao;
    JButton confirmarOperacao;

    String tipoOperacao;

    public TelaDefinirPath(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;

        // definir e configurar elementos de tela.
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
        procurarArquivo.addActionListener(this);

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(140, 72, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(this);

        confirmarOperacao = new JButton();
        confirmarOperacao.setBounds(250, 72, 100, 23);
        confirmarOperacao.setText("Confirmar");
        confirmarOperacao.addActionListener(this);

        // definir propriedades do frame.
        this.setTitle("Backoffice - " + tipoOperacao);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // adicionar elementos ao frame.
        this.add(textoCaminho);
        this.add(textoAviso);
        this.add(campoArquivo);
        this.add(procurarArquivo);
        this.add(cancelarOperacao);
        this.add(confirmarOperacao);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MetodosCarregarBD metodo = new MetodosCarregarBD();

        if (e.getSource() == procurarArquivo) {
            campoArquivo.setText(metodo.encontrarArquivo(tipoOperacao));
        }

        if (e.getSource() == cancelarOperacao) {
            this.dispose();
        }

        if (e.getSource() == confirmarOperacao) {
            metodo.carregarArquivo(campoArquivo.getText(), tipoOperacao);
            this.dispose();
        }
    }
}
