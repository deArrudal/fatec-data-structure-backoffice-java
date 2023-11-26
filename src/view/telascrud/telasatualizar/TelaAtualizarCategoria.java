package view.telascrud.telasatualizar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.crud.ManterCategoria;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaAtualizarCategoria extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField idCategoria;
	private JTextField nomeCategoria;

	public TelaAtualizarCategoria(Categoria retorno, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterCategoria manterCategoria = new ManterCategoria(listaCategorias);

		setTitle("BackOffice - Atualizar Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		setLocationRelativeTo(null);

		JPanel AtualizarCategoria = new JPanel();
		AtualizarCategoria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AtualizarCategoria);
		AtualizarCategoria.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Categoria");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(70, 20, 300, 23);
		AtualizarCategoria.add(titulo);

		JLabel idC = new JLabel("N° identificador:");
		idC.setBounds(50, 55, 130, 23);
		AtualizarCategoria.add(idC);

		idCategoria = new JTextField();
		idCategoria.setBounds(50, 82, 100, 23);
		AtualizarCategoria.add(idCategoria);
		idCategoria.setColumns(10);
		idCategoria.setText(String.valueOf(retorno.idCategoria));

		JLabel label1 = new JLabel("Nome da Categoria:");
		label1.setBounds(170, 55, 141, 23);
		AtualizarCategoria.add(label1);

		nomeCategoria = new JTextField();
		nomeCategoria.setColumns(10);
		nomeCategoria.setBounds(170, 82, 220, 23);
		AtualizarCategoria.add(nomeCategoria);
		nomeCategoria.setText(retorno.nomeCategoria);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(105, 125, 100, 23);
		AtualizarCategoria.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaConsulta.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(245, 125, 100, 23);
		AtualizarCategoria.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					manterCategoria.excluirCategoria(retorno.nomeCategoria);

					Categoria c = new Categoria();

					c.idCategoria = Integer.parseInt(idCategoria.getText());
					c.nomeCategoria = nomeCategoria.getText();
					manterCategoria.inserirCategoria(c);

					JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso",
							"BackOffice - Atualizar Categoria", JOptionPane.INFORMATION_MESSAGE);

					TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
							listaClientesPJ, listaPedidos);
					telaConsulta.setVisible(true);
					dispose();

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro atualizar categoria",
							"BackOffice - Atualizar Categoria", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		btnConfirmar.addActionListener(confirmar);
	}
}
