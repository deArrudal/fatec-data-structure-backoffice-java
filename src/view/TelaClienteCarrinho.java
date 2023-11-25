package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaClienteCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField qtdProduto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCarrinho frame = new TelaClienteCarrinho(null, null, null, null);
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
	public TelaClienteCarrinho(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ, LinkedList<Produto>[] tabelaProduto, LinkedList<Categoria> listaCategoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho");
		lblNewLabel.setBounds(186, 10, 130, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnExcluirItem = new JButton("Excluir Item");
		btnExcluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluirItem.setBounds(10, 232, 105, 21);
		contentPane.add(btnExcluirItem);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(310, 232, 116, 21);
		contentPane.add(btnCheckout);
		
		JButton btnSalvarQtdes = new JButton("Salvar ");
		btnSalvarQtdes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvarQtdes.setBounds(142, 232, 105, 21);
		contentPane.add(btnSalvarQtdes);
		
		JRadioButton ProdutoSelecionavel1 = new JRadioButton("New radio button");
		ProdutoSelecionavel1.setBounds(27, 44, 103, 21);
		contentPane.add(ProdutoSelecionavel1);
		
		qtdProduto1 = new JTextField();
		qtdProduto1.setBounds(157, 45, 7, 19);
		contentPane.add(qtdProduto1);
		qtdProduto1.setColumns(10);
	}
}