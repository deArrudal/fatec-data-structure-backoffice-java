package view.telascompra;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import controller.crud.ManterCarrinho;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaClienteCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField qtdProduto1;

	public TelaClienteCarrinho(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, ManterCarrinho mc) {

		setTitle("Backoffice - Tela Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

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
