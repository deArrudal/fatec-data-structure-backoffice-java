package view.telascrud.telasatualizar;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaAtualizarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Quantidade;
	private JTextField nomeProduto;
	private JTextField valorProduto;
	private JTextField idProduto;
	private JComboBox<String> cbCategoriaPro;
	private JTextArea txtDescricaoPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarProduto frame = new TelaAtualizarProduto(null, null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAtualizarProduto(Produto retorno, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterProduto manterProduto = new ManterProduto(listaProdutos);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Produto");
		titulo.setBounds(147, 10, 141, 13);
		InserirClienteCNPJ.add(titulo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(203, 232, 85, 21);
		InserirClienteCNPJ.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(296, 232, 96, 21);
		InserirClienteCNPJ.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					manterProduto.excluirProduto(retorno.nomeProduto);
					Produto p = new Produto();
					p.idProduto = Integer.parseInt(idProduto.getText());
					p.idProdutoCategoria = Integer.parseInt(cbCategoriaPro.getSelectedItem().toString());
					p.nomeProduto = nomeProduto.getText();
					p.descricaoProduto = txtDescricaoPro.getText();
					p.qtdProduto = Integer.parseInt(Quantidade.getText());
					p.valorProduto = Double.parseDouble(valorProduto.getText());
					manterProduto.inserirProduto(p);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};
		btnConfirmar.addActionListener(confirmar);

		JLabel label1 = new JLabel("Nome do Produto: ");
		label1.setBounds(10, 52, 141, 13);
		InserirClienteCNPJ.add(label1);

		Quantidade = new JTextField();
		Quantidade.setBounds(147, 70, 85, 21);
		InserirClienteCNPJ.add(Quantidade);
		Quantidade.setColumns(10);
		Quantidade.setText(String.valueOf(retorno.qtdProduto));

		JLabel idC = new JLabel("Quantidade:");
		idC.setBounds(147, 52, 122, 13);
		InserirClienteCNPJ.add(idC);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(10, 70, 122, 21);
		InserirClienteCNPJ.add(nomeProduto);
		nomeProduto.setText(retorno.nomeProduto);

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
		valorProduto.setText(String.valueOf(retorno.valorProduto));

		JLabel lblNIdentificador = new JLabel("N° Identificador:");
		lblNIdentificador.setBounds(10, 101, 141, 13);
		InserirClienteCNPJ.add(lblNIdentificador);

		idProduto = new JTextField();
		idProduto.setColumns(10);
		idProduto.setBounds(10, 116, 85, 21);
		InserirClienteCNPJ.add(idProduto);
		idProduto.setText(String.valueOf(retorno.idProduto));

		JLabel lblBreveDescrioDo = new JLabel("Breve descrição do produto:");
		lblBreveDescrioDo.setBounds(10, 147, 290, 13);
		InserirClienteCNPJ.add(lblBreveDescrioDo);

		txtDescricaoPro = new JTextArea();
		txtDescricaoPro.setBounds(20, 169, 386, 53);
		InserirClienteCNPJ.add(txtDescricaoPro);
		txtDescricaoPro.setText(retorno.descricaoProduto);

		JLabel lblNIdentificadorDa = new JLabel("ID da Categoria do Produto");
		lblNIdentificadorDa.setBounds(147, 101, 192, 13);
		InserirClienteCNPJ.add(lblNIdentificadorDa);

		cbCategoriaPro = new JComboBox<String>();
		cbCategoriaPro.setBounds(146, 116, 131, 21);
		cbCategoriaPro.addItem(String.valueOf(retorno.idProdutoCategoria));
		InserirClienteCNPJ.add(cbCategoriaPro);

	}
}