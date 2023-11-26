package view.telascrud.telasatualizar;

import java.awt.Dimension;
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

import controller.crud.ManterProduto;
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

	public TelaAtualizarProduto(Produto retorno, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterProduto manterProduto = new ManterProduto(listaProdutos);

		setTitle("BackOffice - Atualizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel AtualizarProduto = new JPanel();
		AtualizarProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AtualizarProduto);
		AtualizarProduto.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Produto");
		titulo.setBounds(147, 10, 141, 13);
		AtualizarProduto.add(titulo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(203, 232, 85, 21);
		AtualizarProduto.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ,
						listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(296, 232, 96, 21);
		AtualizarProduto.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					Produto p = new Produto();

					int qntProduto = Integer.parseInt(Quantidade.getText());
					Double valor = Double.parseDouble(valorProduto.getText());


					if (valor <= 0) {
						JOptionPane.showMessageDialog(null, "Valor não pode ser menor ou igual a 0", "Atenção",
								JOptionPane.ERROR_MESSAGE);
					} else if (qntProduto < 0) {
						JOptionPane.showMessageDialog(null, "Quantidade não pode ser menos que 0", "Atenção",
								JOptionPane.ERROR_MESSAGE);
					} else {
						p.idProduto = Integer.parseInt(idProduto.getText());
						p.idProdutoCategoria = Integer.parseInt(cbCategoriaPro.getSelectedItem().toString());
						p.nomeProduto = nomeProduto.getText();
						p.descricaoProduto = txtDescricaoPro.getText();
						p.qtdProduto = Integer.parseInt(Quantidade.getText());
						p.valorProduto = Double.parseDouble(valorProduto.getText());

						manterProduto.excluirProduto(retorno.nomeProduto);
						manterProduto.inserirProduto(p);
						TelaConsulta tc = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
								listaClientesPJ, listaPedidos);
						tc.setVisible(true);
						dispose();
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};
		btnConfirmar.addActionListener(confirmar);

		JLabel label1 = new JLabel("Nome do Produto: ");
		label1.setBounds(10, 52, 141, 13);
		AtualizarProduto.add(label1);

		Quantidade = new JTextField();
		Quantidade.setBounds(147, 70, 85, 21);
		AtualizarProduto.add(Quantidade);
		Quantidade.setColumns(10);
		Quantidade.setText(String.valueOf(retorno.qtdProduto));

		JLabel idC = new JLabel("Quantidade:");
		idC.setBounds(147, 52, 122, 13);
		AtualizarProduto.add(idC);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(10, 70, 122, 21);
		AtualizarProduto.add(nomeProduto);
		nomeProduto.setText(retorno.nomeProduto);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(284, 52, 122, 13);
		AtualizarProduto.add(lblValor);

		JLabel lblR = new JLabel("R$");
		lblR.setBounds(256, 74, 21, 13);
		AtualizarProduto.add(lblR);

		valorProduto = new JTextField();
		valorProduto.setColumns(10);
		valorProduto.setBounds(277, 70, 85, 21);
		AtualizarProduto.add(valorProduto);
		valorProduto.setText(String.valueOf(retorno.valorProduto));

		JLabel lblNIdentificador = new JLabel("N° Identificador:");
		lblNIdentificador.setBounds(10, 101, 141, 13);
		AtualizarProduto.add(lblNIdentificador);

		idProduto = new JTextField();
		idProduto.setColumns(10);
		idProduto.setBounds(10, 116, 85, 21);
		AtualizarProduto.add(idProduto);
		idProduto.setText(String.valueOf(retorno.idProduto));

		JLabel lblBreveDescrioDo = new JLabel("Breve descrição do produto:");
		lblBreveDescrioDo.setBounds(10, 147, 290, 13);
		AtualizarProduto.add(lblBreveDescrioDo);

		txtDescricaoPro = new JTextArea();
		txtDescricaoPro.setBounds(20, 169, 386, 53);
		AtualizarProduto.add(txtDescricaoPro);
		txtDescricaoPro.setText(retorno.descricaoProduto);

		JLabel lblNIdentificadorDa = new JLabel("ID da Categoria do Produto");
		lblNIdentificadorDa.setBounds(147, 101, 192, 13);
		AtualizarProduto.add(lblNIdentificadorDa);

		cbCategoriaPro = new JComboBox<String>();
		cbCategoriaPro.setBounds(146, 116, 131, 21);
		cbCategoriaPro.addItem(String.valueOf(retorno.idProdutoCategoria));
		AtualizarProduto.add(cbCategoriaPro);

	}
}
