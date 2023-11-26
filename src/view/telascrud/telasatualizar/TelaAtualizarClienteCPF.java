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

import controller.crud.ManterClientePF;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaAtualizarClienteCPF extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField cpfClientePF;
	private JTextField telefoneClientePF;
	private JTextField nomeClientePF;
	private JTextField cepClientePF;
	private JTextField enderecoClientePF;

	public TelaAtualizarClienteCPF(ClientePF retorno, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePF manterClientePF = new ManterClientePF(listaClientesPF);

		setTitle("BackOffice - Atualizar Cliente PF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel AtualizarClientePF = new JPanel();
		AtualizarClientePF.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AtualizarClientePF);
		AtualizarClientePF.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Cliente - CPF");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 20, 300, 23);
		AtualizarClientePF.add(titulo);

		JLabel label1 = new JLabel("Nome:");
		label1.setBounds(20, 50, 141, 23);
		AtualizarClientePF.add(label1);

		nomeClientePF = new JTextField();
		nomeClientePF.setColumns(10);
		nomeClientePF.setBounds(20, 75, 187, 23);
		AtualizarClientePF.add(nomeClientePF);
		nomeClientePF.setText(retorno.nomeClientePF);

		JLabel cnpj = new JLabel("CPF:");
		cnpj.setBounds(220, 50, 85, 23);
		AtualizarClientePF.add(cnpj);

		cpfClientePF = new JTextField();
		cpfClientePF.setBounds(220, 75, 192, 23);
		AtualizarClientePF.add(cpfClientePF);
		cpfClientePF.setColumns(10);
		cpfClientePF.setText(retorno.cpfClientePF);

		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(20, 100, 141, 23);
		AtualizarClientePF.add(telefoneInserirPJ_1);

		telefoneClientePF = new JTextField();
		telefoneClientePF.setColumns(10);
		telefoneClientePF.setBounds(20, 125, 172, 23);
		AtualizarClientePF.add(telefoneClientePF);
		telefoneClientePF.setText(retorno.telefoneClientePF);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 152, 141, 23);
		AtualizarClientePF.add(lblCep);

		cepClientePF = new JTextField();
		cepClientePF.setColumns(10);
		cepClientePF.setBounds(20, 176, 115, 23);
		AtualizarClientePF.add(cepClientePF);
		cepClientePF.setText(retorno.cepClientePF);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(150, 152, 141, 23);
		AtualizarClientePF.add(lblEndereo);

		enderecoClientePF = new JTextField();
		enderecoClientePF.setColumns(10);
		enderecoClientePF.setBounds(150, 176, 255, 23);
		AtualizarClientePF.add(enderecoClientePF);
		enderecoClientePF.setText(retorno.enderecoClientePF);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(105, 220, 100, 23);
		AtualizarClientePF.add(btnVoltar);
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
		AtualizarClientePF.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClientePF pf = new ClientePF();

					boolean vali = manterClientePF.validarCPF(cpfClientePF.getText());
					if (vali == true) {
						pf.cpfClientePF = cpfClientePF.getText();
						pf.telefoneClientePF = telefoneClientePF.getText();
						pf.nomeClientePF = nomeClientePF.getText();
						pf.enderecoClientePF = enderecoClientePF.getText();
						pf.cepClientePF = cepClientePF.getText();
						manterClientePF.atualizarClientePF(retorno, pf);

						JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso",
								"BackOffice - Cadastro Cliente PF", JOptionPane.INFORMATION_MESSAGE);

						TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos,
								listaClientesPF, listaClientesPJ, listaPedidos);
						telaConsulta.setVisible(true);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Erro atualizar cliente",
								"BackOffice - Cadastro Cliente PF", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro atualizar cliente",
							"BackOffice - Atualizar Cliente PF", JOptionPane.ERROR_MESSAGE);
				}

			}
		};
		btnConfirmar.addActionListener(confirmar);
	}
}