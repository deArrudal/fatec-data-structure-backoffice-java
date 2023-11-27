package view.telascrud.telasatualizar;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.crud.ManterClientePJ;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaAtualizarClienteCNPJ extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField cnpjClientePJ;
	private JTextField telefoneClientePJ;
	private JTextField nomeClientePJ;
	private JTextField cepClientePJ;
	private JTextField enderecoClientePJ;
	private JTextField emailPJ;

	public TelaAtualizarClienteCNPJ(ClientePJ retorno, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePJ manterClientePJ = new ManterClientePJ(listaClientesPJ);

		setTitle("BackOffice - Atualizar Cliente PJ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel AtualizarClientePJ = new JPanel();
		AtualizarClientePJ.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AtualizarClientePJ);
		AtualizarClientePJ.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Cliente - CNPJ");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 20, 300, 23);
		AtualizarClientePJ.add(titulo);

		JLabel label1 = new JLabel("Nome Fantasia:");
		label1.setBounds(20, 50, 141, 23);
		AtualizarClientePJ.add(label1);

		nomeClientePJ = new JTextField();
		nomeClientePJ.setColumns(10);
		nomeClientePJ.setBounds(20, 75, 187, 23);
		nomeClientePJ.setText(retorno.nomeClientePJ);
		AtualizarClientePJ.add(nomeClientePJ);

		JLabel cnpj = new JLabel("CNPJ:");
		cnpj.setBounds(220, 50, 85, 23);
		AtualizarClientePJ.add(cnpj);

		cnpjClientePJ = new JTextField();
		cnpjClientePJ.setBounds(220, 75, 192, 23);
		AtualizarClientePJ.add(cnpjClientePJ);
		cnpjClientePJ.setColumns(10);
		cnpjClientePJ.setText(retorno.cnpjClientePJ);

		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(20, 100, 141, 23);
		AtualizarClientePJ.add(telefoneInserirPJ_1);

		telefoneClientePJ = new JTextField();
		telefoneClientePJ.setColumns(10);
		telefoneClientePJ.setBounds(20, 125, 172, 23);
		telefoneClientePJ.setText(retorno.telefoneClientePJ);
		AtualizarClientePJ.add(telefoneClientePJ);

		JLabel telefoneInserirPJ = new JLabel("E-mail:");
		telefoneInserirPJ.setBounds(205, 100, 141, 23);
		AtualizarClientePJ.add(telefoneInserirPJ);

		emailPJ = new JTextField();
		emailPJ.setColumns(10);
		emailPJ.setBounds(205, 125, 202, 23);
		emailPJ.setText(retorno.emailClientePJ);
		AtualizarClientePJ.add(emailPJ);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 152, 141, 23);
		AtualizarClientePJ.add(lblCep);

		cepClientePJ = new JTextField();
		cepClientePJ.setColumns(10);
		cepClientePJ.setBounds(20, 176, 115, 23);
		cepClientePJ.setText(retorno.cepClientePJ);
		AtualizarClientePJ.add(cepClientePJ);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(150, 152, 141, 23);
		AtualizarClientePJ.add(lblEndereo);

		enderecoClientePJ = new JTextField();
		enderecoClientePJ.setColumns(10);
		enderecoClientePJ.setBounds(150, 176, 255, 23);
		enderecoClientePJ.setText(retorno.enderecoClientePJ);
		AtualizarClientePJ.add(enderecoClientePJ);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(105, 220, 100, 23);
		AtualizarClientePJ.add(btnVoltar);
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
		AtualizarClientePJ.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClientePJ pj = new ClientePJ();

					boolean vali = manterClientePJ.validarCNPJ(cnpjClientePJ.getText());
					if (vali == true) {

						pj.cnpjClientePJ = cnpjClientePJ.getText();
						pj.telefoneClientePJ = telefoneClientePJ.getText();
						pj.nomeClientePJ = nomeClientePJ.getText();
						pj.enderecoClientePJ = enderecoClientePJ.getText();
						pj.cepClientePJ = cepClientePJ.getText();
						pj.emailClientePJ = emailPJ.getText();
						manterClientePJ.atualizarClientePJ(retorno, pj);

						JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso",
								"BackOffice - Atualizar Cliente PJ", JOptionPane.INFORMATION_MESSAGE);

						TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
								listaClientesPJ, listaPedidos);
						telaConsulta.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Erro atualizar cliente",
								"BackOffice - Atualizar Cliente PJ", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro atualizar cliente",
							"BackOffice - Atualizar Cliente PJ", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		btnConfirmar.addActionListener(confirmar);
	}
}