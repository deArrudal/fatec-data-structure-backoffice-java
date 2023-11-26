package view.telascrud.telasconsulta;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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

	public TelaConsulta(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterCategoria manterCategoria = new ManterCategoria(listaCategorias);
		ManterProduto manterProduto = new ManterProduto(listaProdutos);
		ManterClientePF manterClientePF = new ManterClientePF(listaClientesPF);
		ManterClientePJ manterClientePJ = new ManterClientePJ(listaClientesPJ);

		setTitle("Backoffice - Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Definir tipo de pesquisa
		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(32, 11, 178, 13);
		contentPane.add(lblNewLabel);

		// Definir comboBox para selecao de consulta
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(220, 6, 175, 22);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("Cliente CPF");
		cbCategoria.addItem("Cliente CNPJ");
		cbCategoria.addItem("Produto");
		cbCategoria.addItem("Categoria");

		// Definir campo de pesquisa
		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(19, 53, 251, 19);
		contentPane.add(campoPesquisa);
		campoPesquisa.setColumns(10);

		// Definir barra de rolagem
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(32, 83, 363, 127);
		contentPane.add(scrollPane);

		// Definir area de retorno da pesquisa
		JTextArea resultadoPesquisa = new JTextArea();
		scrollPane.setViewportView(resultadoPesquisa);

		// Evento clique botão pesquisar
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarProduto);
		ActionListener pesquisar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorCampo = campoPesquisa.getText();
				if (valorCampo.isEmpty()) {
					resultadoPesquisa.setText("Campo vazio!");

				} else {
					// Metodo de pesquisa
					categoria = cbCategoria.getSelectedItem().toString();
					switch (categoria) {
						case "Cliente CPF":
							try {
								rClientePF = manterClientePF.consultaClientePF(valorCampo);
								valorCampo = rClientePF.cpfClientePF;
								pesquisaRetorno = rClientePF.nomeClientePF;

							} catch (Exception e1) {
								e1.printStackTrace();
							}
							break;

						case "Cliente CNPJ":
							try {
								rClientePJ = manterClientePJ.consultaClientePJ(valorCampo);
								valorCampo = rClientePJ.cnpjClientePJ;
								pesquisaRetorno = rClientePJ.nomeClientePJ;

							} catch (Exception e1) {
								e1.printStackTrace();
							}
							break;

						case "Produto":
							try {
								rProduto = manterProduto.consultaProduto(valorCampo);
								valorCampo = rProduto.nomeProduto;
								pesquisaRetorno = rProduto.nomeProduto;

							} catch (Exception e1) {
								e1.printStackTrace();
							}
							break;

						case "Categoria":
							try {
								rCategoria = manterCategoria.consultaCategoria(valorCampo);
								valorCampo = rCategoria.nomeCategoria;
								pesquisaRetorno = rCategoria.nomeCategoria;

							} catch (Exception e1) {
								e1.printStackTrace();
							}

							break;
					}

					resultadoPesquisa.setText(pesquisaRetorno);
				}
			}
		};
		btnPesquisarProduto.addActionListener(pesquisar);

		// Definir campo informe
		JLabel lblInforme = new JLabel();
		categoria = cbCategoria.getSelectedItem().toString();
		switch (categoria) {
			case "Cliente CPF":
				lblInforme.setText("Informe o CPF para buscá-lo:");
				break;

			case "Cliente CNPJ":
				lblInforme.setText("Informe o CNPJ para buscá-lo:");
				break;

			case "Produto":
				lblInforme.setText("Informe o NOME DO PRODUTO para buscá-lo:");
				break;

			case "Categoria":
				lblInforme.setText("Informe o NOME DA CATEGORIA para buscá-lo:");
				break;
		}
		lblInforme.setBounds(22, 34, 317, 13);
		contentPane.add(lblInforme);
		PopupMenuListener p = new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				switch (cbCategoria.getSelectedItem().toString()) {
					case "Cliente CPF":
						lblInforme.setText("Informe o CPF para buscá-lo:");
						break;

					case "Cliente CNPJ":
						lblInforme.setText("Informe o CNPJ para buscá-lo:");
						break;

					case "Produto":
						lblInforme.setText("Informe o NOME DO PRODUTO para buscá-lo:");
						break;

					case "Categoria":
						lblInforme.setText("Informe o NOME DA CATEGORIA para buscá-lo:");
						break;
				}

			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub
			}
		};
		cbCategoria.addPopupMenuListener(p);

		// Evento clique botão atualiza
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(22, 232, 114, 21);
		btnAtualizar.setBackground(new Color(128, 255, 128));
		btnAtualizar.setForeground(new Color(0, 0, 0));
		contentPane.add(btnAtualizar);
		ActionListener atualizar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pesquisaRetorno == null) {
					resultadoPesquisa.setText("Registro não localizado, impossível atualizar!");
				} else {
					switch (categoria) {
						case "Cliente CPF":
							TelaAtualizarClienteCPF CPF = new TelaAtualizarClienteCPF(rClientePF, valorCampo, categoria,
									 listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
							CPF.setVisible(true);
							setVisible(false);
							break;

						case "Cliente CNPJ":
							TelaAtualizarClienteCNPJ CNPJ = new TelaAtualizarClienteCNPJ(rClientePJ, valorCampo,
									categoria, listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
							CNPJ.setVisible(true);
							setVisible(false);
							break;

						case "Produto":
							TelaAtualizarProduto Produto = new TelaAtualizarProduto(rProduto, valorCampo, categoria,
									listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
							Produto.setVisible(true);
							setVisible(false);
							break;

						case "Categoria":
							TelaAtualizarCategoria Categoria = new TelaAtualizarCategoria(rCategoria, valorCampo,
									categoria, listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
							Categoria.setVisible(true);
							setVisible(false);
							break;

					}

					resultadoPesquisa.setText(pesquisaRetorno);
				}
			}
		};
		btnAtualizar.addActionListener(atualizar);

		// Evento clique botão Excluir
		JButton btnExcluirProduto = new JButton("Excluir");
		btnExcluirProduto.setBounds(146, 232, 114, 21);
		btnExcluirProduto.setBackground(new Color(255, 0, 0));
		contentPane.add(btnExcluirProduto);
		ActionListener excluir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pesquisaRetorno == null) {
					resultadoPesquisa.setText("Registro não localizado, impossível excluir!");
				} else {
					TelaRemoverRegistro t = new TelaRemoverRegistro(pesquisaRetorno, valorCampo, categoria,
							listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
					t.setVisible(true);
					setVisible(false);
				}
			}
		};
		btnExcluirProduto.addActionListener(excluir);

		// Evento clique botão voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(312, 232, 114, 21);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaHome.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);
	}
}
