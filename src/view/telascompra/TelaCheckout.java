package view.telascompra;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controller.crud.ManterCarrinho;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaCheckout extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;

	public TelaCheckout(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, String novoUsuario, ManterCarrinho novoCarrinho) {

		setTitle("Backoffice - Checkout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCheckout = new JLabel("Checkout");
		lblCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckout.setFont(new Font("Serif", Font.BOLD, 16));
		lblCheckout.setBounds(280, 20, 100, 23);
		contentPane.add(lblCheckout);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setToolTipText("");
		scrollPane.setBounds(35, 70, 615, 420);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Id", "Produto", "Descri\u00E7\u00E3o", "Estoque", "Pre\u00E7o" }) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setColumnHeaderView(table);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCarrinho telaClienteCarrinho = new TelaClienteCarrinho(listaCategorias,
						listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, novoUsuario, novoCarrinho);
				telaClienteCarrinho.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(35, 520, 85, 23);
		contentPane.add(btnVoltar);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(518, 520, 130, 23);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCheckoutConfirma(listaCategorias,
						listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, novoUsuario, novoCarrinho);
				dispose();
			}
		});
		contentPane.add(btnFinalizar);

		JLabel lblValorTotal = new JLabel("");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setBounds(145, 520, 400, 23);
		contentPane.add(lblValorTotal);

		try {
			novoCarrinho.CheckoutInicio(table, lblValorTotal);

		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "Erro checkout",
					"BackOffice - Carrinho", JOptionPane.ERROR_MESSAGE);
		}
	}
}
