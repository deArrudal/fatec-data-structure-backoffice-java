package view.telascrud.telasatualizar;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ManterClientePJ;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarClienteCNPJ frame = new TelaAtualizarClienteCNPJ(null, null, null, null, null, null,
							null, null);
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
	public TelaAtualizarClienteCNPJ(ClientePJ retorno, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePJ manterClientePJ = new ManterClientePJ(listaClientesPJ);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Cliente - CNPJ");
		titulo.setBounds(144, 10, 141, 13);
		InserirClienteCNPJ.add(titulo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(207, 232, 85, 21);
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
		btnConfirmar.setBounds(295, 232, 96, 21);
		InserirClienteCNPJ.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					manterClientePJ.excluirClientePJ(retorno.nomeClientePJ);
					ClientePJ pj = new ClientePJ();
					pj.cnpjClientePJ = cnpjClientePJ.getText();
					pj.telefoneClientePJ = telefoneClientePJ.getText();
					pj.nomeClientePJ = nomeClientePJ.getText();
					pj.enderecoClientePJ = enderecoClientePJ.getText();
					pj.cepClientePJ = cepClientePJ.getText();
					pj.emailClientePJ = emailPJ.getText();
					manterClientePJ.inserirClientePJ(pj);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};
		btnConfirmar.addActionListener(confirmar);

		JLabel label1 = new JLabel("Nome Fantasia: ");
		label1.setBounds(10, 33, 141, 13);
		InserirClienteCNPJ.add(label1);

		cnpjClientePJ = new JTextField();
		cnpjClientePJ.setBounds(222, 51, 192, 21);
		InserirClienteCNPJ.add(cnpjClientePJ);
		cnpjClientePJ.setColumns(10);
		cnpjClientePJ.setText(retorno.cnpjClientePJ);

		JLabel cnpj = new JLabel("CNPJ");
		cnpj.setBounds(220, 33, 85, 13);
		InserirClienteCNPJ.add(cnpj);

		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(10, 87, 141, 13);
		InserirClienteCNPJ.add(telefoneInserirPJ_1);

		telefoneClientePJ = new JTextField();
		telefoneClientePJ.setColumns(10);
		telefoneClientePJ.setBounds(10, 104, 186, 21);
		telefoneClientePJ.setText(retorno.telefoneClientePJ);
		InserirClienteCNPJ.add(telefoneClientePJ);

		nomeClientePJ = new JTextField();
		nomeClientePJ.setColumns(10);
		nomeClientePJ.setBounds(10, 52, 192, 21);
		nomeClientePJ.setText(retorno.nomeClientePJ);
		InserirClienteCNPJ.add(nomeClientePJ);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 135, 141, 13);
		InserirClienteCNPJ.add(lblCep);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(164, 135, 141, 13);
		InserirClienteCNPJ.add(lblEndereo);

		cepClientePJ = new JTextField();
		cepClientePJ.setColumns(10);
		cepClientePJ.setBounds(10, 157, 115, 21);
		cepClientePJ.setText(retorno.cepClientePJ);
		InserirClienteCNPJ.add(cepClientePJ);

		enderecoClientePJ = new JTextField();
		enderecoClientePJ.setColumns(10);
		enderecoClientePJ.setBounds(159, 158, 255, 20);
		enderecoClientePJ.setText(retorno.enderecoClientePJ);
		InserirClienteCNPJ.add(enderecoClientePJ);

		JLabel telefoneInserirPJ = new JLabel("E-mail");
		telefoneInserirPJ.setBounds(222, 87, 141, 13);
		InserirClienteCNPJ.add(telefoneInserirPJ);

		emailPJ = new JTextField();
		emailPJ.setColumns(10);
		emailPJ.setBounds(207, 104, 186, 21);
		emailPJ.setText(retorno.emailClientePJ);
		InserirClienteCNPJ.add(emailPJ);
	}
}