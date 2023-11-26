package view.telascrud.telasinserir;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.crud.ManterProduto;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.TelaSelecaoCadastro;

public class TelaInserirProduto extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField qtdProduto;
	private JTextField nomeProduto;
	private JTextField valorProduto;
	private JTextField idProduto;

	public TelaInserirProduto(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterProduto m = new ManterProduto(listaProdutos);

		setTitle("BackOffice - Cadastro Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel InserirProduto = new JPanel();
		InserirProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InserirProduto);
		InserirProduto.setLayout(null);

		JLabel titulo = new JLabel("Cadastrar Produto");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 20, 300, 23);
		InserirProduto.add(titulo);

		JLabel label1 = new JLabel("Nome: ");
		label1.setBounds(20, 50, 141, 23);
		InserirProduto.add(label1);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(20, 75, 150, 23);
		InserirProduto.add(nomeProduto);

		JLabel idC = new JLabel("Quantidade:");
		idC.setBounds(190, 50, 122, 23);
		InserirProduto.add(idC);

		qtdProduto = new JTextField();
		qtdProduto.setBounds(190, 75, 85, 23);
		InserirProduto.add(qtdProduto);
		qtdProduto.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(315, 50, 122, 23);
		InserirProduto.add(lblValor);

		JLabel lblR = new JLabel("R$:");
		lblR.setBounds(295, 75, 21, 23);
		InserirProduto.add(lblR);

		valorProduto = new JTextField();
		valorProduto.setColumns(10);
		valorProduto.setBounds(315, 75, 85, 23);
		InserirProduto.add(valorProduto);

		JLabel lblNIdentificador = new JLabel("N° Identificador:");
		lblNIdentificador.setBounds(20, 100, 141, 23);
		InserirProduto.add(lblNIdentificador);

		idProduto = new JTextField();
		idProduto.setColumns(10);
		idProduto.setBounds(20, 125, 85, 23);
		InserirProduto.add(idProduto);

		JLabel lblNIdentificadorDa = new JLabel("ID da Categoria do Produto:");
		lblNIdentificadorDa.setBounds(125, 100, 192, 23);
		InserirProduto.add(lblNIdentificadorDa);

		int tamanho = listaCategorias.size();
		JComboBox<Integer> idProdutoCategoria = new JComboBox<>();
		idProdutoCategoria.setBounds(125, 125, 131, 23);
		InserirProduto.add(idProdutoCategoria);

		for (int i = 0; i < tamanho; i++) {
			Categoria l;
			try {
				l = listaCategorias.get(i);
				idProdutoCategoria.addItem(l.idCategoria);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

		JLabel lblBreveDescrioDo = new JLabel("Breve descrição do produto:");
		lblBreveDescrioDo.setBounds(20, 152, 290, 23);
		InserirProduto.add(lblBreveDescrioDo);

		JTextArea descricaoProduto = new JTextArea();
		descricaoProduto.setBounds(20, 176, 386, 23);
		InserirProduto.add(descricaoProduto);

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
		VoltarInserirPF.setBounds(105, 220, 100, 23);
		InserirProduto.add(VoltarInserirPF);

		JButton ConfirmarInserirPF = new JButton("Confirmar");
		ConfirmarInserirPF.setBounds(245, 220, 100, 23);
		InserirProduto.add(ConfirmarInserirPF);
		ActionListener confirmar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Produto produto = new Produto();

				produto.idProduto = Integer.parseInt(idProduto.getText());
				produto.idProdutoCategoria = Integer.parseInt(idProdutoCategoria.getSelectedItem().toString());
				produto.nomeProduto = nomeProduto.getText();
				produto.descricaoProduto = descricaoProduto.getText();
				produto.qtdProduto = Integer.parseInt(qtdProduto.getText());
				produto.valorProduto = Double.parseDouble(valorProduto.getText());

				try {
					m.inserirProduto(produto);

					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso",
							"BackOffice - Cadastro Produto", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro inserir cliente",
							"BackOffice - Cadastro Produto", JOptionPane.ERROR_MESSAGE);
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
