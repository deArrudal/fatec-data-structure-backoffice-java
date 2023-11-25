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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarClienteCPF frame = new TelaAtualizarClienteCPF(null, null, null, null, null, null,
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
	public TelaAtualizarClienteCPF(ClientePF retorno, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePF manterClientePF = new ManterClientePF(listaClientesPF);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);

		JLabel titulo = new JLabel("Atualizar Cliente - CPF");
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
					manterClientePF.excluirClientePF(retorno.nomeClientePF);
					ClientePF pf = new ClientePF();
					pf.cpfClientePF = cpfClientePF.getText();
					pf.telefoneClientePF = telefoneClientePF.getText();
					pf.nomeClientePF = nomeClientePF.getText();
					pf.enderecoClientePF = enderecoClientePF.getText();
					pf.cepClientePF = cepClientePF.getText();
					manterClientePF.inserirClientePF(pf);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		};
		btnConfirmar.addActionListener(confirmar);

		JLabel label1 = new JLabel("Nome: ");
		label1.setBounds(10, 33, 141, 13);
		InserirClienteCNPJ.add(label1);

		cpfClientePF = new JTextField();
		cpfClientePF.setBounds(222, 51, 192, 21);
		InserirClienteCNPJ.add(cpfClientePF);
		cpfClientePF.setColumns(10);
		cpfClientePF.setText(retorno.cpfClientePF);

		JLabel cnpj = new JLabel("CPF");
		cnpj.setBounds(220, 33, 85, 13);
		InserirClienteCNPJ.add(cnpj);

		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(10, 87, 141, 13);
		InserirClienteCNPJ.add(telefoneInserirPJ_1);

		telefoneClientePF = new JTextField();
		telefoneClientePF.setColumns(10);
		telefoneClientePF.setBounds(10, 104, 192, 21);
		InserirClienteCNPJ.add(telefoneClientePF);
		telefoneClientePF.setText(retorno.telefoneClientePF);

		nomeClientePF = new JTextField();
		nomeClientePF.setColumns(10);
		nomeClientePF.setBounds(10, 52, 192, 21);
		InserirClienteCNPJ.add(nomeClientePF);
		nomeClientePF.setText(retorno.nomeClientePF);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 148, 141, 13);
		InserirClienteCNPJ.add(lblCep);

		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(161, 148, 141, 13);
		InserirClienteCNPJ.add(lblEndereo);

		cepClientePF = new JTextField();
		cepClientePF.setColumns(10);
		cepClientePF.setBounds(10, 162, 115, 21);
		InserirClienteCNPJ.add(cepClientePF);
		cepClientePF.setText(retorno.cepClientePF);

		enderecoClientePF = new JTextField();
		enderecoClientePF.setColumns(10);
		enderecoClientePF.setBounds(159, 163, 255, 20);
		InserirClienteCNPJ.add(enderecoClientePF);
		enderecoClientePF.setText(retorno.enderecoClientePF);
	}
}