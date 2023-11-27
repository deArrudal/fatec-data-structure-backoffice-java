package view.telascrud.telasconsulta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import controller.crud.ManterCategoria;
import controller.crud.ManterClientePF;
import controller.crud.ManterClientePJ;
import controller.crud.ManterProduto;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.telasatualizar.TelaAtualizarCategoria;
import view.telascrud.telasatualizar.TelaAtualizarClienteCNPJ;
import view.telascrud.telasatualizar.TelaAtualizarClienteCPF;
import view.telascrud.telasatualizar.TelaAtualizarProduto;
import view.telascrud.telasremover.TelaRemoverRegistro;
import view.telasmenu.TelaHome;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaConsulta extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField campoPesquisa;
	private JComboBox<String> cbCategoria;

	public String valorCampo;
	public String categoria;
	public String pesquisaRetorno;
	public Categoria rCategoria;
	public Produto rProduto;
	public ClientePF rClientePF;
	public ClientePJ rClientePJ;
	private JTable table;

	public TelaConsulta(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterCategoria manterCategoria = new ManterCategoria(listaCategorias);
		ManterProduto manterProduto = new ManterProduto(listaProdutos);
		ManterClientePF manterClientePF = new ManterClientePF(listaClientesPF);
		ManterClientePJ manterClientePJ = new ManterClientePJ(listaClientesPJ);

		setTitle("Backoffice - Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Consulta", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 16));
		lblTitulo.setBounds(150, 20, 340, 23);
		contentPane.add(lblTitulo);

		// Definir tipo de pesquisa
		JLabel lblNewLabel = new JLabel("Você esta pesquisando por:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(35, 90, 160, 23);
		contentPane.add(lblNewLabel);

		// Definir comboBox para selecao de consulta
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(310, 55, 250, 23);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("Cliente CPF");
		cbCategoria.addItem("Cliente CNPJ");
		cbCategoria.addItem("Produto");
		cbCategoria.addItem("Categoria");
		cbCategoria.addItem("Pedido");

		// Definir campo de pesquisa
		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(205, 90, 250, 23);
		contentPane.add(campoPesquisa);
		campoPesquisa.setColumns(10);

		// Definir barra de rolagem
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 123, 615, 385);
		contentPane.add(scrollPane);

		// Definir tabela
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"", "", "", "", "", ""
				}));

		// Evento clique botão pesquisar
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBounds(465, 90, 114, 23);
		contentPane.add(btnPesquisarProduto);
		ActionListener pesquisar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorCampo = campoPesquisa.getText();
				if (valorCampo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo vazio",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);

				} else {
					// Metodo de pesquisa
					pesquisar(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				}
			}
		};
		btnPesquisarProduto.addActionListener(pesquisar);

		// Evento clique botão atualiza
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(35, 520, 85, 23);
		btnAtualizar.setBackground(new Color(128, 255, 128));
		btnAtualizar.setForeground(new Color(0, 0, 0));
		contentPane.add(btnAtualizar);
		ActionListener atualizar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ver = table.getSelectedRow();
				if (ver < 1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);

				} else {
					switch (categoria) {
						case "Cliente CPF":
							try {
								ClientePF rClientePF = manterClientePF
										.consultaClientePF(table.getModel().getValueAt(ver, 0).toString());

								TelaAtualizarClienteCPF CPF = new TelaAtualizarClienteCPF(rClientePF, valorCampo,
										categoria,
										listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
								CPF.setVisible(true);
								dispose();

							} catch (Exception exception) {
								JOptionPane.showMessageDialog(null, "Erro consulta",
										"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
							}
							break;

						case "Cliente CNPJ":
							try {
								ClientePJ rClientePJ = manterClientePJ
										.consultaClientePJ(table.getModel().getValueAt(ver, 0).toString());

								TelaAtualizarClienteCNPJ CNPJ = new TelaAtualizarClienteCNPJ(rClientePJ, valorCampo,
										categoria,
										listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
								CNPJ.setVisible(true);
								dispose();

							} catch (Exception exception) {
								JOptionPane.showMessageDialog(null, "Erro consulta",
										"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
							}
							break;

						case "Produto":
							try {
								Produto rProduto = manterProduto
										.consultaProduto(table.getModel().getValueAt(ver, 2).toString());

								TelaAtualizarProduto Produto = new TelaAtualizarProduto(rProduto, valorCampo, categoria,
										listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
								Produto.setVisible(true);
								dispose();

							} catch (Exception exception) {
								JOptionPane.showMessageDialog(null, "Erro consulta",
										"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
							}
							break;

						case "Categoria":
							try {
								Categoria rCategoria = manterCategoria
										.consultaCategoria(table.getModel().getValueAt(ver, 1).toString());

								TelaAtualizarCategoria Categoria = new TelaAtualizarCategoria(rCategoria, valorCampo,
										categoria,
										listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
								Categoria.setVisible(true);
								dispose();

							} catch (Exception exception) {
								JOptionPane.showMessageDialog(null, "Erro consulta",
										"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
							}
							break;
					}
				}
			}
		};
		btnAtualizar.addActionListener(atualizar);

		// Evento clique botão Excluir
		JButton btnExcluirProduto = new JButton("Excluir");
		btnExcluirProduto.setBounds(135, 520, 85, 23);
		btnExcluirProduto.setBackground(new Color(255, 0, 0));
		contentPane.add(btnExcluirProduto);
		ActionListener excluir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ver = table.getSelectedRow();
				if (ver < 1) {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);

				} else {
					String pesquisaRetorno = "";

					switch (categoria) {
						case "ClienteCPF":
							pesquisaRetorno = table.getModel().getValueAt(ver, 0).toString();
							break;
						case "ClienteCNPJ":
							pesquisaRetorno = table.getModel().getValueAt(ver, 0).toString();
							break;
						case "Produto":
							pesquisaRetorno = table.getModel().getValueAt(ver, 2).toString();
							break;
						case "Categoria":
							pesquisaRetorno = table.getModel().getValueAt(ver, 1).toString();
							break;
					}

					TelaRemoverRegistro t = new TelaRemoverRegistro(pesquisaRetorno, valorCampo, categoria,
							listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
					t.setVisible(true);
					dispose();
				}
			}
		};
		btnExcluirProduto.addActionListener(excluir);

		// Definir campo informe
		JLabel lblInforme = new JLabel();
		categoria = cbCategoria.getSelectedItem().toString();
		formatarTabela(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
		switch (categoria) {
			case "Cliente CPF":
				lblInforme.setText("Informe o CPF para busca-lo:");
				break;

			case "Cliente CNPJ":
				lblInforme.setText("Informe o CNPJ para busca-lo:");
				break;

			case "Produto":
				lblInforme.setText("Informe o NOME DO PRODUTO para busca-lo:");
				break;

			case "Categoria":
				lblInforme.setText("Informe o NOME DA CATEGORIA para busca-lo:");
				break;

			case "Pedido":
				lblInforme.setText("Informe o ID DO PEDIDO para busca-lo:");
				break;
		}
		lblInforme.setBounds(35, 55, 280, 23);
		contentPane.add(lblInforme);

		// Atualiza a tela cadavez que um item for selecionado no comboBox cbCategoria
		PopupMenuListener p = new PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				formatarTabela(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				switch (cbCategoria.getSelectedItem().toString()) {
					case "Cliente CPF":
						lblInforme.setText("Informe o CPF para busca-lo:");
						btnAtualizar.setVisible(true);
						btnExcluirProduto.setVisible(true);
						break;

					case "Cliente CNPJ":
						lblInforme.setText("Informe o CNPJ para busca-lo:");
						btnAtualizar.setVisible(true);
						btnExcluirProduto.setVisible(true);
						break;

					case "Produto":
						lblInforme.setText("Informe o NOME DO PRODUTO para busca-lo:");
						btnAtualizar.setVisible(true);
						btnExcluirProduto.setVisible(true);
						break;

					case "Categoria":
						lblInforme.setText("Informe o NOME DA CATEGORIA para busca-lo:");
						btnAtualizar.setVisible(true);
						btnExcluirProduto.setVisible(true);
						break;

					case "Pedido":
						lblInforme.setText("Informe o ID DO PEDIDO para busca-lo:");
						btnAtualizar.setVisible(false);
						btnExcluirProduto.setVisible(false);
						break;
				}
			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
		};
		cbCategoria.addPopupMenuListener(p);

		// Evento clique botão voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(570, 520, 80, 23);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ,
						listaPedidos);
				telaHome.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnProdCat = new JButton("Categoria");
		btnProdCat.setBounds(455, 520, 100, 23);
		btnProdCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaProdCat t = new TelaConsultaProdCat(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnProdCat);
	}

	private void formatarTabela(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		if (model.getRowCount() > 0) {
			int tamanho = model.getRowCount() - 1;
			for (int i = tamanho; i >= 0; i--) {
				model.removeRow(i);
			}
		}

		String categoria = cbCategoria.getSelectedItem().toString();

		switch (categoria) {
			case "Cliente CPF":
				model.addRow(new Object[] { "CPF", "Nome", "Endereco", "CEP", "Telefone" });

				LinkedList<ClientePF> cpf = listaClientesPF;
				int tamanhoListaCPF = cpf.size();

				for (int j = 0; j < tamanhoListaCPF; j++) {
					try {
						ClientePF p = cpf.get(j);

						model.addRow(new Object[] { p.cpfClientePF, p.nomeClientePF, p.enderecoClientePF,
								p.cepClientePF, p.telefoneClientePF });

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro formatacao tabela",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;

			case "Cliente CNPJ":
				model.addRow(new Object[] { "CNPJ", "Nome", "Endereco", "CEP", "Telefone", "E-mail" });

				LinkedList<ClientePJ> cnpj = listaClientesPJ;
				int tamanhoListaCNPJ = cnpj.size();

				for (int j = 0; j < tamanhoListaCNPJ; j++) {
					try {
						ClientePJ p = cnpj.get(j);

						model.addRow(new Object[] { p.cnpjClientePJ, p.nomeClientePJ, p.enderecoClientePJ,
								p.cepClientePJ, p.telefoneClientePJ });

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro formatacao tabela",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;

			case "Produto":
				model.addRow(new Object[] { "Id Produto", "Id Categoria", "Nome", "Descricao", "Estoque", "Valor" });

				int tamanhoTabela = listaProdutos.length;

				for (int i = 0; i < tamanhoTabela; i++) {
					LinkedList<Produto> prod = listaProdutos[i];
					int tamanhoListaProd = prod.size();

					for (int j = 0; j < tamanhoListaProd; j++) {
						try {
							Produto p = prod.get(j);

							model.addRow(new Object[] { p.idProduto, p.idProdutoCategoria, p.nomeProduto,
									p.descricaoProduto, p.qtdProduto, p.valorProduto });

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Erro formatacao tabela",
									"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				break;

			case "Categoria":
				model.addRow(new Object[] { "Id", "Nome" });
				LinkedList<Categoria> cat = listaCategorias;
				int tamanhoListaCat = cat.size();

				for (int j = 0; j < tamanhoListaCat; j++) {
					try {
						Categoria p = cat.get(j);
						model.addRow(new Object[] { p.idCategoria, p.nomeCategoria });

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro formatacao tabela",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;

			case "Pedido":
				model.addRow(new Object[] { "Id", "Nome Cliente", "Itens Pedido" });
				LinkedList<Pedido> ped = listaPedidos;
				int tamanhoListaPed = ped.size();

				for (int j = 0; j < tamanhoListaPed; j++) {
					try {
						Pedido p = ped.get(j);
						model.addRow(new Object[] { p.idPedido, p.nomeCliente, p.itensPedido });

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro formatacao tabela",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}
				break;
		}
	}

	private void pesquisar(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		if (model.getRowCount() > 0) {
			int tamanho = model.getRowCount() - 1;
			for (int i = tamanho; i >= 0; i--) {
				model.removeRow(i);
			}
		}

		String categoria = cbCategoria.getSelectedItem().toString();
		boolean isFound = false;

		valorCampo = campoPesquisa.getText();

		switch (categoria) {
			case "Cliente CPF":
				model.addRow(new Object[] { "CPF", "Nome", "Endereço", "CEP", "Telefone" });

				LinkedList<ClientePF> cpf = listaClientesPF;
				int tamanhoListaCPF = cpf.size();

				for (int j = 0; j < tamanhoListaCPF; j++) {
					try {
						ClientePF p = cpf.get(j);

						if (p.cpfClientePF.equals(valorCampo)) {
							model.addRow(new Object[] { p.cpfClientePF, p.nomeClientePF, p.enderecoClientePF,
									p.cepClientePF, p.telefoneClientePF });
							isFound = true;
						}

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro registro",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}

				if (!isFound) {
					JOptionPane.showMessageDialog(null, "Registro nao encontrado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Cliente CNPJ":
				model.addRow(new Object[] { "CNPJ", "Nome", "Endereço", "CEP", "Telefone", "E-mail" });

				LinkedList<ClientePJ> cnpj = listaClientesPJ;
				int tamanhoListaCNPJ = cnpj.size();

				for (int j = 0; j < tamanhoListaCNPJ; j++) {
					try {
						ClientePJ p = cnpj.get(j);

						if (p.cnpjClientePJ.equals(valorCampo)) {
							model.addRow(new Object[] { p.cnpjClientePJ, p.nomeClientePJ, p.enderecoClientePJ,
									p.cepClientePJ, p.telefoneClientePJ });
							isFound = true;
						}

					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "Erro registro",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}

				if (!isFound) {
					JOptionPane.showMessageDialog(null, "Registro não encontrado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Produto":
				model.addRow(new Object[] { "Id Produto", "Id Categoria", "Nome", "Descricao", "Estoque", "Valor" });

				int tamanhoTabela = listaProdutos.length;

				for (int i = 0; i < tamanhoTabela; i++) {

					LinkedList<Produto> prod = listaProdutos[i];
					int tamanhoListaProd = prod.size();

					for (int j = 0; j < tamanhoListaProd; j++) {
						try {
							Produto p = prod.get(j);

							if (p.nomeProduto.equals(valorCampo)) {
								model.addRow(new Object[] { p.idProduto, p.idProdutoCategoria, p.nomeProduto,
										p.descricaoProduto, p.qtdProduto, p.valorProduto });
								isFound = true;
							}

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Erro registro",
									"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
						}
					}
				}

				if (!isFound) {
					JOptionPane.showMessageDialog(null, "Registro não encontrado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Categoria":
				model.addRow(new Object[] { "Id", "Nome" });

				LinkedList<Categoria> cat = listaCategorias;
				int tamanhoListaCat = cat.size();

				for (int j = 0; j < tamanhoListaCat; j++) {
					try {
						Categoria p = cat.get(j);

						if (p.nomeCategoria.equals(valorCampo)) {
							model.addRow(new Object[] { p.idCategoria, p.nomeCategoria });
							isFound = true;
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro registro",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}

				if (!isFound) {
					JOptionPane.showMessageDialog(null, "Registro não encontrado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
				}
				break;

			case "Pedido":
				model.addRow(new Object[] { "Id", "Nome Cliente", "Itens Pedido" });

				LinkedList<Pedido> ped = listaPedidos;
				int tamanhoListaPed = ped.size();

				for (int j = 0; j < tamanhoListaPed; j++) {
					try {
						Pedido p = ped.get(j);

						if (String.valueOf(p.idPedido).equals(valorCampo)) {
							model.addRow(new Object[] { p.idPedido, p.nomeCliente, p.itensPedido });
							isFound = true;
						}

					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro registro",
								"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
					}
				}
				if (!isFound) {
					JOptionPane.showMessageDialog(null, "Registro nao encontrado",
							"BackOffice - Consulta", JOptionPane.ERROR_MESSAGE);
				}
				break;
		}
	}
}