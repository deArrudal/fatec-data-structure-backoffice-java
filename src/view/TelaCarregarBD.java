package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaCarregarBD extends JFrame implements ActionListener {
    JLabel textoOpcao;
    JButton carregarCategorias;
    JButton carregarProdutos;
    JButton carregarClientesPF;
    JButton carregarClientesPJ;
    JButton cancelarOperacao;

    // remover main apos depurar
    public static void main(String[] args) {
        new TelaCarregarBD();
    }

    public TelaCarregarBD() {
        // definir e configurar elementos de tela
        textoOpcao = new JLabel("Selecione a opção de carregamento", SwingConstants.CENTER);
        textoOpcao.setBounds(100, 20, 250, 23);

        carregarCategorias = new JButton();
        carregarCategorias.setBounds(130, 58, 190, 23);
        carregarCategorias.setText("Categorias de Produtos");
        carregarCategorias.setHorizontalAlignment(SwingConstants.CENTER);
        carregarCategorias.addActionListener(this);

        carregarProdutos = new JButton();
        carregarProdutos.setBounds(130, 96, 190, 23);
        carregarProdutos.setText("Produtos");
        carregarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
        carregarProdutos.addActionListener(this);

        carregarClientesPF = new JButton();
        carregarClientesPF.setBounds(130, 134, 190, 23);
        carregarClientesPF.setText("Clientes - Pessoa Fisica");
        carregarClientesPF.addActionListener(this);

        carregarClientesPJ = new JButton();
        carregarClientesPJ.setBounds(130, 172, 190, 23);
        carregarClientesPJ.setText("Clientes - Pessoa Juridica");
        carregarClientesPJ.addActionListener(this);

        cancelarOperacao = new JButton();
        cancelarOperacao.setBounds(175, 220, 100, 23);
        cancelarOperacao.setText("Cancelar");
        cancelarOperacao.addActionListener(this);

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

    // realizar operacoes/chamadas com base na interacao com os elementos
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == carregarCategorias) {
            new TelaDefinirPath("Carregar Categorias");
        }

        if (e.getSource() == carregarProdutos) {
            new TelaDefinirPath("Carregar Produtos");
        }

        if (e.getSource() == carregarClientesPF) {
            new TelaDefinirPath("Carregar Clientes PF");
        }

        if (e.getSource() == carregarClientesPJ) {
            new TelaDefinirPath("Carregar Clientes PJ");
        }

        if (e.getSource() == cancelarOperacao) {
            this.dispose();
        }
    }
}
