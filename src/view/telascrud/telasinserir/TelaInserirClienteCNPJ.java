package view.telascrud.telasinserir;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.crud.ManterClientePJ;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.TelaSelecaoCadastro;

public class TelaInserirClienteCNPJ extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField cnpjClientePJ;
	private JTextField emailClientePJ;
	private JTextField telefoneClientePJ;
	private JTextField nomeClientePJ;
	private JTextField cepClientePJ;
	private JTextField enderecoClientePJ;

	public TelaInserirClienteCNPJ(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePJ m = new ManterClientePJ(listaClientesPJ);

		setTitle("BackOffice - Cadastro Cliente PJ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);

		JLabel titulo = new JLabel("Cadastro de Cliente - Pessoa Juridica");
		titulo.setFont(new Font("Serif", Font.BOLD, 14));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(75, 20, 300, 23);
		InserirClienteCNPJ.add(titulo);

		JLabel label1 = new JLabel("Nome fantasia: ");
		label1.setBounds(20, 50, 141, 23);
		InserirClienteCNPJ.add(label1);

		nomeClientePJ = new JTextField();
		nomeClientePJ.setColumns(10);
		nomeClientePJ.setBounds(20, 75, 187, 23);
		InserirClienteCNPJ.add(nomeClientePJ);

		JLabel cnpj = new JLabel("CNPJ:");
		cnpj.setBounds(220, 50, 85, 23);
		InserirClienteCNPJ.add(cnpj);

		cnpjClientePJ = new JTextField();
		cnpjClientePJ.setBounds(220, 75, 192, 23);
		InserirClienteCNPJ.add(cnpjClientePJ);
		cnpjClientePJ.setColumns(10);

		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(20, 100, 141, 23);
		InserirClienteCNPJ.add(telefoneInserirPJ_1);

		telefoneClientePJ = new JTextField();
		telefoneClientePJ.setColumns(10);
		telefoneClientePJ.setBounds(20, 125, 172, 23);
		InserirClienteCNPJ.add(telefoneClientePJ);

		JLabel NomeFantasiaInserirPJ_2 = new JLabel("E-mail:");
		NomeFantasiaInserirPJ_2.setBounds(205, 100, 141, 23);
		InserirClienteCNPJ.add(NomeFantasiaInserirPJ_2);

		emailClientePJ = new JTextField();
		emailClientePJ.setColumns(10);
		emailClientePJ.setBounds(205, 125, 202, 23);
		InserirClienteCNPJ.add(emailClientePJ);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 152, 141, 23);
		InserirClienteCNPJ.add(lblCep);

		cepClientePJ = new JTextField();
		cepClientePJ.setColumns(10);
		cepClientePJ.setBounds(20, 176, 115, 23);
		InserirClienteCNPJ.add(cepClientePJ);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(150, 152, 141, 23);
		InserirClienteCNPJ.add(lblEndereo);

		enderecoClientePJ = new JTextField();
		enderecoClientePJ.setColumns(10);
		enderecoClientePJ.setBounds(150, 176, 255, 23);
		InserirClienteCNPJ.add(enderecoClientePJ);

		JButton VoltarInserirPJ = new JButton("Voltar");
		VoltarInserirPJ.setPreferredSize(new Dimension(77, 21));
		VoltarInserirPJ.setActionCommand("");
		VoltarInserirPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro telaSelecaoCadastro = new TelaSelecaoCadastro(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaSelecaoCadastro.setVisible(true);
				dispose();
			}
		});
		VoltarInserirPJ.setBounds(105, 220, 100, 23);
		InserirClienteCNPJ.add(VoltarInserirPJ);

		JButton ConfirmarInserirPJ = new JButton("Confirmar");
		ConfirmarInserirPJ.setBounds(245, 220, 100, 23);
		InserirClienteCNPJ.add(ConfirmarInserirPJ);
		ActionListener confirmar = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientePJ cliente = new ClientePJ();
				
				cliente.cnpjClientePJ = cnpjClientePJ.getText();
				cliente.nomeClientePJ = nomeClientePJ.getText();
				cliente.enderecoClientePJ = enderecoClientePJ.getText();
				cliente.cepClientePJ = cepClientePJ.getText();
				cliente.telefoneClientePJ = telefoneClientePJ.getText();
				cliente.emailClientePJ = emailClientePJ.getText();
				
				try {
					m.inserirClientePJ(cliente);

					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso",
							"BackOffice - Cadastro Cliente PJ", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Erro inserir cliente",
							"BackOffice - Cadastro Cliente PJ", JOptionPane.ERROR_MESSAGE);
				}

				TelaSelecaoCadastro telaSelecaoCadastro = new TelaSelecaoCadastro(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaSelecaoCadastro.setVisible(true);
				dispose();
			}
		};
		ConfirmarInserirPJ.addActionListener(confirmar);
	}
}
