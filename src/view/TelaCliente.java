package view.telasmenu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;
import view.telascompra.TelaClienteCarrinho;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField campoPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente(null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCliente(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ,
			LinkedList<Produto>[] tabelaProduto, LinkedList<Categoria> listaCategoria, ClientePF PF, ClientePJ PJ) {
		String nomeCliente;
		if (PF == null) {
			nomeCliente = PJ.nomeClientePJ;
		} else {
			nomeCliente = PF.nomeClientePF;
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCliente = new JLabel("New label");
		lblCliente.setBounds(88, 10, 304, 13);
		contentPane.add(lblCliente);
		// lblCliente.setText("Bem vinda(o) a área do cliente " + nomeCliente);

		JButton btnCarrinho = new JButton("Ver Carrinho");
		btnCarrinho.setBounds(306, 232, 120, 21);
		contentPane.add(btnCarrinho);
		ActionListener carrinho = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCarrinho t = new TelaClienteCarrinho(listaClientePF, listaCLientePJ, tabelaProduto,
						listaCategoria);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnCarrinho.addActionListener(carrinho);

		JButton btnAdicionarAoCarrinho = new JButton("Adicionar selecionados ao Carrinho");
		btnAdicionarAoCarrinho.setBackground(new Color(0, 128, 64));
		btnAdicionarAoCarrinho.setForeground(new Color(255, 255, 255));
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionarAoCarrinho.setBounds(20, 232, 276, 21);
		contentPane.add(btnAdicionarAoCarrinho);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(281, 55, 114, 21);
		contentPane.add(btnPesquisar);

		campoPesquisa = new JTextField();
		campoPesquisa.setColumns(10);
		campoPesquisa.setBounds(20, 56, 251, 19);
		contentPane.add(campoPesquisa);

		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 33, 178, 13);
		contentPane.add(lblNewLabel);

		JComboBox<String> cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(198, 28, 175, 22);
		contentPane.add(cbCategoria);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 85, 375, 137);
		contentPane.add(textArea);
		cbCategoria.addItem("PRODUTO");
		cbCategoria.addItem("CATEGORIA");

	}
}
