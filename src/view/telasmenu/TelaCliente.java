package view.telasmenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import controller.crud.ManterCarrinho;
import controller.crud.ManterProduto;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascompra.TelaClienteCarrinho;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField campoPesquisa;
	private JTable table;

	public TelaCliente(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, String nomeUsuario, ManterCarrinho novoCarrinho) {

		ManterProduto manterProduto = new ManterProduto(listaProdutos);

		// verificar se carrinho está em uso.
		if (!novoCarrinho.carrinhoDisponivel) {
			novoCarrinho.iniciarCarrinho(nomeUsuario, listaPedidos);
		}

		setTitle("Backoffice - Area do Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCliente = new JLabel("Bem-vinda(o): " + nomeUsuario, SwingConstants.CENTER);
		lblCliente.setFont(new Font("Serif", Font.BOLD, 16));
		lblCliente.setBounds(150, 20, 340, 23);
		contentPane.add(lblCliente);

		JLabel lblCategoria = new JLabel("Selecionar categoria:");
		lblCategoria.setBounds(35, 55, 135, 23);
		contentPane.add(lblCategoria);

		int tamanho = listaCategorias.size();
		JComboBox<String> cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(170, 55, 250, 23);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("Todos os Produtos");

		for (int i = 0; i < tamanho; i++) {
			Categoria categoria;

			try {
				categoria = listaCategorias.get(i);
				if (categoria.nomeCategoria != null) {
					cbCategoria.addItem(
							String.valueOf(categoria.idCategoria) + " - " + categoria.nomeCategoria);
				}

			} catch (Exception exception) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar lista",
						"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
			}
		}

		JLabel lblNewLabel = new JLabel("Voce esta pesquisando por:");
		lblNewLabel.setBounds(35, 90, 160, 23);
		contentPane.add(lblNewLabel);

		campoPesquisa = new JTextField();
		campoPesquisa.setColumns(10);
		campoPesquisa.setBounds(205, 90, 250, 23);
		contentPane.add(campoPesquisa);

		// Evento pesquisar
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(465, 90, 114, 23);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProduto(campoPesquisa, cbCategoria, listaProdutos);
			}
		});
		contentPane.add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(35, 123, 615, 385);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {},
						new String[] { "Id", "Produto", "Descricao", "Estoque", "Preco" }) {
					boolean[] columnEditables = new boolean[] {
							false, false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});

		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setColumnHeaderView(table);

		formatarTabela(cbCategoria, listaProdutos);
		PopupMenuListener p = new PopupMenuListener() {
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				formatarTabela(cbCategoria, listaProdutos);
			}

			public void popupMenuCanceled(PopupMenuEvent e) {
			}
		};
		cbCategoria.addPopupMenuListener(p);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(35, 520, 85, 23);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					novoCarrinho.excluirCarrinho();

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir carrinho",
							"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
				}

				TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos, listaClientesPF,
						listaClientesPJ, listaPedidos);
				telaHome.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);

		// Evento adicionar ao carrinho
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar item selecionado ao carrinho");
		btnAdicionarAoCarrinho.setBackground(new Color(0, 128, 64));
		btnAdicionarAoCarrinho.setForeground(new Color(255, 255, 255));
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto produto = manterProduto
							.consultaProduto((table.getModel().getValueAt(table.getSelectedRow(), 1).toString()));

					int qtd = produto.qtdProduto;

					do {
						produto.qtdProduto = Integer.parseInt(
								JOptionPane.showInputDialog(null, "Quantidade desejada:",
										"BackOffice - Area do Cliente", JOptionPane.INFORMATION_MESSAGE));

						if (produto.qtdProduto > qtd) {
							JOptionPane.showMessageDialog(null, "Estoque insuficiente",
									"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
						}
					} while (produto.qtdProduto > qtd);

					novoCarrinho.inserirCarrinho(produto);

					JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho",
							"BackOffice - Area do Cliente", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro ao adicionar produto",
							"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAdicionarAoCarrinho.setBounds(185, 520, 280, 23);
		contentPane.add(btnAdicionarAoCarrinho);

		JButton btnCarrinho = new JButton("Ver Carrinho");
		btnCarrinho.setBounds(518, 520, 130, 23);
		contentPane.add(btnCarrinho);
		ActionListener verCarrinho = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCarrinho telaClienteCarrinho = new TelaClienteCarrinho(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos, nomeUsuario, novoCarrinho);
				telaClienteCarrinho.setVisible(true);
				dispose();
			}
		};
		btnCarrinho.addActionListener(verCarrinho);
	}

	private void formatarTabela(JComboBox<String> cbCategoria, LinkedList<Produto>[] tabelaProduto) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (model.getRowCount() > 0) {
			int tamanho = model.getRowCount() - 1;
			for (int i = tamanho; i >= 0; i--) {
				model.removeRow(i);
			}
		}

		String cbCat = cbCategoria.getSelectedItem().toString();
		if (cbCat.equals("Todos os Produtos")) {

			int tamanhoTabela = tabelaProduto.length;
			for (int i = 0; i < tamanhoTabela; i++) {
				LinkedList<Produto> categoria = tabelaProduto[i];

				int tamanhoLista = categoria.size();
				for (int j = 0; j < tamanhoLista; j++) {
					try {
						Produto p = categoria.get(j);
						model.addRow(new Object[] { p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto,
								p.valorProduto });

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro ao formatar tabela",
								"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		} else {
			String[] div = cbCat.split(" ");
			int cat = Integer.parseInt(div[0]);

			LinkedList<Produto> categoria = tabelaProduto[cat];

			int tamanhoLista = categoria.size();
			for (int j = 0; j < tamanhoLista; j++) {
				try {
					Produto p = categoria.get(j);
					model.addRow(new Object[] { p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto,
							p.valorProduto });

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro ao formatar tabela",
							"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void pesquisarProduto(JTextField campoPesquisa2, JComboBox<String> cbCategoria,
			LinkedList<Produto>[] tabelaProduto) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (model.getRowCount() > 0) {
			int tamanho = model.getRowCount() - 1;
			for (int i = tamanho; i >= 0; i--) {
				model.removeRow(i);
			}
		}

		String cbCat = cbCategoria.getSelectedItem().toString();
		if (cbCat.equals("Todos os Produtos")) {
			int tamanhoTabela = tabelaProduto.length;
			for (int i = 0; i < tamanhoTabela; i++) {
				LinkedList<Produto> categoria = tabelaProduto[i];

				int tamanhoLista = categoria.size();
				for (int j = 0; j < tamanhoLista; j++) {
					try {
						Produto p = categoria.get(j);
						if (p.nomeProduto.equals(campoPesquisa2.getText())) {
							model.addRow(new Object[] { p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto,
									p.valorProduto });
						}

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro pesquisar produto",
								"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		} else {
			String[] div = cbCat.split(" ");
			int cat = Integer.parseInt(div[0]);

			LinkedList<Produto> categoria = tabelaProduto[cat];

			int tamanhoLista = categoria.size();
			for (int j = 0; j < tamanhoLista; j++) {
				try {
					Produto p = categoria.get(j);
					if (p.nomeProduto.equals(campoPesquisa2.getText())) {
						model.addRow(new Object[] { p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto,
								p.valorProduto });
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro ao formatar tabela",
							"BackOffice - Area do Cliente", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
