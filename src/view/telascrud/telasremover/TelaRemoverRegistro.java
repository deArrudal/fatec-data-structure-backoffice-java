package view.telascrud.telasremover;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaRemoverRegistro extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public TelaRemoverRegistro(String conteudo, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePF manterClientePF = new ManterClientePF(listaClientesPF);
		ManterClientePJ manterClientePJ = new ManterClientePJ(listaClientesPJ);
		ManterCategoria manterCategoria = new ManterCategoria(listaCategorias);
		ManterProduto manterProduto = new ManterProduto(listaProdutos);

		setTitle("Backoffice - Remover Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setToolTipText("Pessoa Física (CPF)\r\n\r\n");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemover = new JLabel("Removendo Registro", SwingConstants.CENTER);
		lblRemover.setFont(new Font("Serif", Font.BOLD, 14));
		lblRemover.setForeground(Color.RED);
		lblRemover.setBounds(70, 20, 300, 23);
		contentPane.add(lblRemover);

		JLabel lblVocEstPrestes = new JLabel("Você esta prestes a excluir o seguinte registro:",
				SwingConstants.CENTER);
		lblVocEstPrestes.setForeground(Color.RED);
		lblVocEstPrestes.setBounds(70, 50, 300, 23);
		contentPane.add(lblVocEstPrestes);

		JLabel registroRemovido = new JLabel("");
		registroRemovido.setBounds(45, 75, 350, 23);
		contentPane.add(registroRemovido);
		registroRemovido.setText(conteudo);
		registroRemovido.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEstaAo = new JLabel("Esta acao e irreversivel, deseja prosseguir?");
		lblEstaAo.setBounds(99, 100, 299, 13);
		contentPane.add(lblEstaAo);

		// Evento clique voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(100, 25));
		btnVoltar.setBounds(105, 125, 100, 23);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
						listaClientesPJ,
						listaPedidos);
				telaConsulta.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnConfirmarExcluir = new JButton("Prosseguir");
		btnConfirmarExcluir.setPreferredSize(new Dimension(100, 25));
		btnConfirmarExcluir.setBounds(245, 125, 100, 23);
		contentPane.add(btnConfirmarExcluir);
		ActionListener excluir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (categoria) {
					case "Cliente CPF":
						try {
							manterClientePF.excluirClientePF(valorCampo);

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Erro ao remover cadastro",
									"BackOffice - Remover Cadastro", JOptionPane.ERROR_MESSAGE);
						}
						break;

					case "Cliente CNPJ":
						try {
							manterClientePJ.excluirClientePJ(valorCampo);

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Erro ao remover cadastro",
									"BackOffice - Remover Cadastro", JOptionPane.ERROR_MESSAGE);
						}
						break;

					case "Produto":
						try {
							manterProduto.excluirProduto(valorCampo);

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Erro ao remover cadastro",
									"BackOffice - Remover Cadastro", JOptionPane.ERROR_MESSAGE);
						}
						break;

					case "Categoria":
						try {
							manterCategoria.excluirCategoria(valorCampo);

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Erro ao remover cadastro",
									"BackOffice - Remover Cadastro", JOptionPane.ERROR_MESSAGE);
						}
						break;
				}

				TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
						listaClientesPJ,
						listaPedidos);

				telaConsulta.setVisible(true);
				dispose();
			}

		};
		btnConfirmarExcluir.addActionListener(excluir);
	}
}
