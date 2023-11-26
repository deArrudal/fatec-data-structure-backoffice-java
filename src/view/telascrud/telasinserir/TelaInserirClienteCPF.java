package view.telascrud.telasinserir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import view.telascrud.TelaSelecaoCadastro;

public class TelaInserirClienteCPF extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField cpfClientePF;
	private JTextField telefoneClientePF;
	private JTextField nomeClientePF;
	private JTextField cepClientePF;
	private JTextField enderecoClientePF;

	public TelaInserirClienteCPF(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePF m = new ManterClientePF(listaClientesPF);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});

		setTitle("BackOffice - Cadastro Cliente PF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel InserirClienteCPF = new JPanel();
		InserirClienteCPF.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InserirClienteCPF);
		InserirClienteCPF.setLayout(null);

		JLabel titulo = new JLabel("Cadastro de Cliente - Pessoa Fisica");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 20, 300, 23);
		InserirClienteCPF.add(titulo);

		JLabel label1 = new JLabel("Nome: ");
		label1.setBounds(20, 50, 141, 23);
		InserirClienteCPF.add(label1);

		nomeClientePF = new JTextField();
		nomeClientePF.setColumns(10);
		nomeClientePF.setBounds(20, 75, 192, 23);
		InserirClienteCPF.add(nomeClientePF);

		JLabel cpf = new JLabel("CPF:");
		cpf.setBounds(220, 50, 85, 23);
		InserirClienteCPF.add(cpf);

		cpfClientePF = new JTextField();
		cpfClientePF.setBounds(222, 75, 192, 23);
		InserirClienteCPF.add(cpfClientePF);
		cpfClientePF.setColumns(10);

		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(20, 100, 141, 23);
		InserirClienteCPF.add(telefoneInserirPJ_1);

		telefoneClientePF = new JTextField();
		telefoneClientePF.setColumns(10);
		telefoneClientePF.setBounds(20, 125, 192, 23);
		InserirClienteCPF.add(telefoneClientePF);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 152, 141, 23);
		InserirClienteCPF.add(lblCep);

		cepClientePF = new JTextField();
		cepClientePF.setColumns(10);
		cepClientePF.setBounds(20, 176, 115, 23);
		InserirClienteCPF.add(cepClientePF);

		JLabel lblEndereo = new JLabel("Endereco:");
		lblEndereo.setBounds(161, 152, 141, 23);
		InserirClienteCPF.add(lblEndereo);

		enderecoClientePF = new JTextField();
		enderecoClientePF.setColumns(10);
		enderecoClientePF.setBounds(159, 176, 255, 23);
		InserirClienteCPF.add(enderecoClientePF);

		JButton VoltarInserirPF = new JButton("Voltar");
		VoltarInserirPF.setPreferredSize(new Dimension(77, 21));
		VoltarInserirPF.setActionCommand("");
		VoltarInserirPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro telaSelecaoCadastro = new TelaSelecaoCadastro(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaSelecaoCadastro.setVisible(true);
				dispose();
			}
		});
		VoltarInserirPF.setBounds(105, 220, 100, 23);
		InserirClienteCPF.add(VoltarInserirPF);

		JButton ConfirmarInserirPF = new JButton("Confirmar");
		ConfirmarInserirPF.setBounds(245, 220, 100, 23);
		InserirClienteCPF.add(ConfirmarInserirPF);
		ActionListener confirmar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientePF cliente = new ClientePF();

				cliente.cpfClientePF = cpfClientePF.getText();
				cliente.nomeClientePF = nomeClientePF.getText();
				cliente.enderecoClientePF = enderecoClientePF.getText();
				cliente.cepClientePF = cepClientePF.getText();
				cliente.telefoneClientePF = telefoneClientePF.getText();

				try {
					m.inserirClientePF(cliente);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro inserir cliente",
							"BackOffice - Cadastro Cliente PF", JOptionPane.ERROR_MESSAGE);
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
