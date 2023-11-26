package view.telascrud.telasinserir;

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
import view.telascrud.TelaSelecaoCadastro;

public class TelaInserirCategoria extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField idCategoria;
	private JTextField nomeCategoria;

	public TelaInserirCategoria(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterCategoria m = new ManterCategoria(listaCategorias);

		setTitle("BackOffice - Cadastro Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		setLocationRelativeTo(null);

		JPanel InserirCategoria = new JPanel();
		InserirCategoria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InserirCategoria);
		InserirCategoria.setLayout(null);

		JLabel titulo = new JLabel("Cadastrar Categoria");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(70, 20, 300, 23);
		InserirCategoria.add(titulo);

		JLabel idC = new JLabel("N° identificador:");
		idC.setBounds(50, 55, 130, 23);
		InserirCategoria.add(idC);

		idCategoria = new JTextField();
		idCategoria.setBounds(50, 82, 100, 23);
		idCategoria.setColumns(10);
		InserirCategoria.add(idCategoria);

		JLabel label1 = new JLabel("Nome:");
		label1.setBounds(170, 55, 141, 23);
		InserirCategoria.add(label1);

		nomeCategoria = new JTextField();
		nomeCategoria.setColumns(10);
		nomeCategoria.setBounds(170, 82, 220, 23);
		InserirCategoria.add(nomeCategoria);

		JButton VoltarInserirPF = new JButton("Voltar");
		VoltarInserirPF.setPreferredSize(new Dimension(77, 21));
		VoltarInserirPF.setActionCommand("");
		VoltarInserirPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		});
		VoltarInserirPF.setBounds(105, 125, 100, 23);
		InserirCategoria.add(VoltarInserirPF);

		JButton ConfirmarInserirPF = new JButton("Confirmar");
		ConfirmarInserirPF.setBounds(245, 125, 100, 23);
		InserirCategoria.add(ConfirmarInserirPF);

		ActionListener confirmar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Categoria categoria = new Categoria();
				
				categoria.idCategoria = Integer.parseInt(idCategoria.getText());
				categoria.nomeCategoria = nomeCategoria.getText();

				try {
					m.inserirCategoria(categoria);

					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso",
							"BackOffice - Cadastro Categoria", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro inserir cliente",
							"BackOffice - Cadastro Categoria", JOptionPane.ERROR_MESSAGE);
				}

				TelaSelecaoCadastro telaSelecaoCadastro = new TelaSelecaoCadastro(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaSelecaoCadastro.setVisible(true);
				dispose();
			}
		};
		ConfirmarInserirPF.addActionListener(confirmar);
	}
}
