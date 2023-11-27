package view.telascompra;

import java.awt.Color;
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
import view.telasmenu.TelaCliente;

public class TelaClienteCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;

	public TelaClienteCarrinho(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, String nomeUsuario, ManterCarrinho novoCarrinho) {

		setTitle("Backoffice - Carrinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Carrinho");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 16));
		lblNewLabel.setBounds(280, 20, 100, 13);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(35, 70, 615, 420);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id", "Produto", "Descricao", "Estoque", "Preco"},
			},
			new String[] {
				"Id", "Produto", "Descricao", "Estoque", "Preco"
			}
		) {
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

		try {
			novoCarrinho.exibirCarrinho(table);

		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar carrinho",
					"BackOffice - Carrinho", JOptionPane.ERROR_MESSAGE);
		}

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(35, 520, 85, 23);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos, nomeUsuario, novoCarrinho);
				telaCliente.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnExcluirItem = new JButton("Excluir item");
		btnExcluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					novoCarrinho.removerItemCarrinho(
							(table.getModel().getValueAt(table.getSelectedRow(), 1).toString()));

					novoCarrinho.exibirCarrinho(table);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir item",
							"BackOffice - Carrinho", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnExcluirItem.setBackground(Color.RED);
		btnExcluirItem.setBounds(255, 520, 150, 23);
		contentPane.add(btnExcluirItem);

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(518, 520, 130, 23);
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCheckout telaCheckout = new TelaCheckout(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos, nomeUsuario, novoCarrinho);
				telaCheckout.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCheckout);
	}
}
