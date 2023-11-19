package view;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controller.ManterCategoria;
import controller.ManterClientePF;
import controller.ManterClientePJ;
import controller.ManterProduto;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TelaConsulta extends JFrame {

	public String valorCampo;
	public String categoria;
	public String pesquisaRetorno;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoPesquisa;
	private JComboBox<String> cbCategoria;

	// ManterClientePF manterClienteCPF = new ManterClientePF();
	// ManterClientePJ manterClientePJ = new ManterClientePJ();
	// ManterCategoria manterCategoria = new ManterCategoria();
	// ManterProduto manterProduto = new ManterProduto();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(220, 6, 175, 22);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("CLIENTE CPF");
		cbCategoria.addItem("CLIENTE CNPJ");
		cbCategoria.addItem("PRODUTO");
		cbCategoria.addItem("CATEGORIA");

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(32, 11, 178, 13);
		contentPane.add(lblNewLabel);

		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(32, 53, 251, 19);
		contentPane.add(campoPesquisa);
		campoPesquisa.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(32, 83, 363, 127);
		contentPane.add(scrollPane);

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
					categoria = cbCategoria.getSelectedItem().toString();
					// METODO DE PESQUISA
					switch (categoria) {
					case "CLIENTE CPF":
						// pesquisaRetorno = ManterClientePF.consultaClientePF(valorCampo);
						break;
					case "CLIENTE CNPJ":
						// pesquisaRetorno = ManterClientePJ.consultaClientePJ(valorCampo);
						break;

					case "PRODUTO":
						// pesquisaRetorno = ManterProduto.consultaProduto(valorCampo);
						break;

					case "CATEGORIA":
						// pesquisaRetorno = ManterCategoria.consultaCategoria(valorCampo);
						break;

					}
					resultadoPesquisa.setText(pesquisaRetorno);
				}
			}

		};
		btnPesquisarProduto.addActionListener(pesquisar);

		JLabel lblInforme = new JLabel();
		categoria = cbCategoria.getSelectedItem().toString();
		switch (categoria) {
		case "CLIENTE CPF":
			lblInforme.setText("Informe o CPF para buscá-lo:");
			break;
		case "CLIENTE CNPJ":
			lblInforme.setText("Informe o CNPJ para buscá-lo:");
			break;
		case "PRODUTO":
			lblInforme.setText("Informe o NOME DO PRODUTO para buscá-lo:");
			break;
		case "CATEGORIA":
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
				case "CLIENTE CPF":
					lblInforme.setText("Informe o CPF para buscá-lo:");
					break;
				case "CLIENTE CNPJ":
					lblInforme.setText("Informe o CNPJ para buscá-lo:");
					break;
				case "PRODUTO":
					lblInforme.setText("Informe o NOME DO PRODUTO para buscá-lo:");
					break;
				case "CATEGORIA":
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
				
				categoria = cbCategoria.getSelectedItem().toString();
				valorCampo = campoPesquisa.getText();
				if (pesquisaRetorno == null) {
					resultadoPesquisa.setText("Registro não localizado, impossível excluir!");
				} else {
					TelaRemoverRegistro t = new TelaRemoverRegistro(pesquisaRetorno, valorCampo, categoria);
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
				TelaHome t = new TelaHome();
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);

	}
}
