package view.telascrud.telasinserir;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

import controller.ManterProduto;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param listaCategoria
	 * @param listaProduto
	 * @param listaCLientePJ
	 * @param listaClientePF
	 * @param listaPedidos 
	 */
	public TelaInserirProduto(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {
		ManterProduto m = new ManterProduto(listaProdutos);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);

		JLabel titulo = new JLabel("Cadastrar Produto");
		titulo.setBounds(147, 10, 141, 13);
		InserirClienteCNPJ.add(titulo);

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
		VoltarInserirPF.setBounds(203, 232, 85, 21);
		InserirClienteCNPJ.add(VoltarInserirPF);

		JButton ConfirmarInserirPF = new JButton("Confirmar");
		ConfirmarInserirPF.setBounds(296, 232, 96, 21);
		InserirClienteCNPJ.add(ConfirmarInserirPF);

		JLabel label1 = new JLabel("Nome do Produto: ");
		label1.setBounds(10, 52, 141, 13);
		InserirClienteCNPJ.add(label1);

		qtdProduto = new JTextField();
		qtdProduto.setBounds(147, 70, 85, 21);
		InserirClienteCNPJ.add(qtdProduto);
		qtdProduto.setColumns(10);

		JLabel idC = new JLabel("Quantidade:");
		idC.setBounds(147, 52, 122, 13);
		InserirClienteCNPJ.add(idC);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(10, 70, 122, 21);
		InserirClienteCNPJ.add(nomeProduto);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(284, 52, 122, 13);
		InserirClienteCNPJ.add(lblValor);

		JLabel lblR = new JLabel("R$");
		lblR.setBounds(256, 74, 21, 13);
		InserirClienteCNPJ.add(lblR);

		valorProduto = new JTextField();
		valorProduto.setColumns(10);
		valorProduto.setBounds(277, 70, 85, 21);
		InserirClienteCNPJ.add(valorProduto);

		JLabel lblNIdentificador = new JLabel("N° Identificador:");
		lblNIdentificador.setBounds(10, 101, 141, 13);
		InserirClienteCNPJ.add(lblNIdentificador);

		idProduto = new JTextField();
		idProduto.setColumns(10);
		idProduto.setBounds(10, 116, 85, 21);
		InserirClienteCNPJ.add(idProduto);

		JLabel lblBreveDescrioDo = new JLabel("Breve descrição do produto:");
		lblBreveDescrioDo.setBounds(10, 147, 290, 13);
		InserirClienteCNPJ.add(lblBreveDescrioDo);

		JTextArea descricaoProduto = new JTextArea();
		descricaoProduto.setBounds(20, 169, 386, 53);
		InserirClienteCNPJ.add(descricaoProduto);

		JLabel lblNIdentificadorDa = new JLabel("ID da Categoria do Produto");
		lblNIdentificadorDa.setBounds(147, 101, 192, 13);
		InserirClienteCNPJ.add(lblNIdentificadorDa);

		int tamanho = listaCategorias.size();
		JComboBox<Integer> idProdutoCategoria = new JComboBox<>();
		idProdutoCategoria.setBounds(146, 116, 131, 21);
		InserirClienteCNPJ.add(idProdutoCategoria);

		for (int i = 0; i < tamanho; i++) {
			Categoria l;
			try {
				l = listaCategorias.get(i);
				idProdutoCategoria.addItem(l.idCategoria);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

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
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		};

		ConfirmarInserirPF.addActionListener(confirmar);
	}
}
