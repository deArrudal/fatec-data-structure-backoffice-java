package view.telascrud.telasatualizar;

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

		setTitle("BackOffice - Atualizar Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel AtualizarProduto = new JPanel();
		AtualizarProduto.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AtualizarProduto);
		AtualizarProduto.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Produto");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 20, 300, 23);
		AtualizarProduto.add(titulo);

		JLabel label1 = new JLabel("Nome do Produto: ");
		label1.setBounds(20, 50, 141, 23);
		AtualizarProduto.add(label1);

		nomeProduto = new JTextField();
		nomeProduto.setColumns(10);
		nomeProduto.setBounds(20, 75, 150, 23);
		AtualizarProduto.add(nomeProduto);
		nomeProduto.setText(retorno.nomeProduto);

		JLabel idC = new JLabel("Quantidade:");
		idC.setBounds(190, 50, 122, 23);
		AtualizarProduto.add(idC);

		Quantidade = new JTextField();
		Quantidade.setBounds(190, 75, 85, 23);
		AtualizarProduto.add(Quantidade);
		Quantidade.setColumns(10);
		Quantidade.setText(String.valueOf(retorno.qtdProduto));

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(315, 50, 122, 23);
		AtualizarProduto.add(lblValor);

		JLabel lblR = new JLabel("R$");
		lblR.setBounds(295, 75, 21, 23);
		AtualizarProduto.add(lblR);

		valorProduto = new JTextField();
		valorProduto.setColumns(10);
		valorProduto.setBounds(315, 75, 85, 23);
		AtualizarProduto.add(valorProduto);
		valorProduto.setText(String.valueOf(retorno.valorProduto));

		JLabel lblNIdentificador = new JLabel("N° Identificador:");
		lblNIdentificador.setBounds(20, 100, 141, 23);
		AtualizarProduto.add(lblNIdentificador);

		idProduto = new JTextField();
		idProduto.setColumns(10);
		idProduto.setBounds(20, 125, 85, 23);
		AtualizarProduto.add(idProduto);
		idProduto.setText(String.valueOf(retorno.idProduto));

		JLabel lblNIdentificadorDa = new JLabel("ID da Categoria do Produto");
		lblNIdentificadorDa.setBounds(125, 100, 192, 23);
		AtualizarProduto.add(lblNIdentificadorDa);

		cbCategoriaPro = new JComboBox<String>();
		cbCategoriaPro.setBounds(125, 125, 131, 23);
		cbCategoriaPro.addItem(String.valueOf(retorno.idProdutoCategoria));
		AtualizarProduto.add(cbCategoriaPro);

		JLabel lblBreveDescrioDo = new JLabel("Descriçao do produto:");
		lblBreveDescrioDo.setBounds(20, 152, 290, 23);
		AtualizarProduto.add(lblBreveDescrioDo);

		txtDescricaoPro = new JTextArea();
		txtDescricaoPro.setBounds(20, 176, 386, 23);
		AtualizarProduto.add(txtDescricaoPro);
		txtDescricaoPro.setText(retorno.descricaoProduto);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(105, 220, 100, 23);
		AtualizarProduto.add(btnVoltar);
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

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(245, 220, 100, 23);
		AtualizarProduto.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Produto p = new Produto();

					int qntProduto = Integer.parseInt(Quantidade.getText());
					Double valor = Double.parseDouble(valorProduto.getText());

					if (valor <= 0) {
						JOptionPane.showMessageDialog(null, "Valor nao pode ser menor ou igual a 0",
								"BackOffice - Atualizar Produto", JOptionPane.ERROR_MESSAGE);

					} else if (qntProduto < 0) {
						JOptionPane.showMessageDialog(null, "Quantidade não pode ser menos que 0",
								"BackOffice - Atualizar Produto", JOptionPane.ERROR_MESSAGE);

					} else {
						p.idProduto = Integer.parseInt(idProduto.getText());
						p.idProdutoCategoria = Integer.parseInt(cbCategoriaPro.getSelectedItem().toString());
						p.nomeProduto = nomeProduto.getText();
						p.descricaoProduto = txtDescricaoPro.getText();
						p.qtdProduto = Integer.parseInt(Quantidade.getText());
						p.valorProduto = Double.parseDouble(valorProduto.getText());

						manterProduto.excluirProduto(retorno.nomeProduto);
						manterProduto.inserirProduto(p);

						JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso",
								"BackOffice - Atualizar Produto", JOptionPane.INFORMATION_MESSAGE);

						TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
								listaClientesPJ, listaPedidos);
						telaConsulta.setVisible(true);
						dispose();
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro atualizar produto",
							"BackOffice - Atualizar Produto", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		btnConfirmar.addActionListener(confirmar);
	}
}
