package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManterClientePJ;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.JTextField;

public class TelaInserirClienteCNPJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField cnpjClientePJ;
	private JTextField emailClientePJ;
	private JTextField telefoneClientePJ;
	private JTextField nomeClientePJ;
	private JTextField cepClientePJ;
	private JTextField enderecoClientePJ;

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
	 * @param listaCategoria 
	 * @param listaProduto 
	 * @param listaCLientePJ 
	 * @param listaClientePF 
	 */
	public TelaInserirClienteCNPJ(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ, LinkedList<Produto> listaProduto, LinkedList<Categoria> listaCategoria) {
		ManterClientePJ m = new ManterClientePJ(listaCLientePJ);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);
		
		JLabel titulo = new JLabel("Cadastro de Cliente - PJ");
		titulo.setBounds(144, 10, 141, 13);
		InserirClienteCNPJ.add(titulo);
		
		JButton VoltarInserirPJ = new JButton("Voltar");
		VoltarInserirPJ.setPreferredSize(new Dimension(77, 21));
		VoltarInserirPJ.setActionCommand("");
		VoltarInserirPJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaClientePF, listaCLientePJ, listaProduto, listaCategoria);
				t.setVisible(true);
				setVisible(false);
			}
		});
		VoltarInserirPJ.setBounds(207, 232, 85, 21);
		InserirClienteCNPJ.add(VoltarInserirPJ);
		
		JButton ConfirmarInserirPJ = new JButton("Confirmar");
		ConfirmarInserirPJ.setBounds(295, 232, 96, 21);
		InserirClienteCNPJ.add(ConfirmarInserirPJ);
		
		JLabel label1 = new JLabel("Nome fantasia: ");
		label1.setBounds(10, 33, 141, 13);
		InserirClienteCNPJ.add(label1);
		
		cnpjClientePJ = new JTextField();
		cnpjClientePJ.setBounds(222, 51, 192, 21);
		InserirClienteCNPJ.add(cnpjClientePJ);
		cnpjClientePJ.setColumns(10);
		
		JLabel cnpj = new JLabel("CNPJ");
		cnpj.setBounds(220, 33, 85, 13);
		InserirClienteCNPJ.add(cnpj);
		
		JLabel telefoneInserirPJ_1 = new JLabel("Telefone:");
		telefoneInserirPJ_1.setBounds(10, 87, 141, 13);
		InserirClienteCNPJ.add(telefoneInserirPJ_1);
		
		JLabel NomeFantasiaInserirPJ_2 = new JLabel("E-mail:");
		NomeFantasiaInserirPJ_2.setBounds(224, 87, 141, 13);
		InserirClienteCNPJ.add(NomeFantasiaInserirPJ_2);
		
		emailClientePJ = new JTextField();
		emailClientePJ.setColumns(10);
		emailClientePJ.setBounds(222, 103, 192, 21);
		InserirClienteCNPJ.add(emailClientePJ);
		
		telefoneClientePJ = new JTextField();
		telefoneClientePJ.setColumns(10);
		telefoneClientePJ.setBounds(10, 104, 192, 21);
		InserirClienteCNPJ.add(telefoneClientePJ);
		
		nomeClientePJ = new JTextField();
		nomeClientePJ.setColumns(10);
		nomeClientePJ.setBounds(10, 52, 192, 21);
		InserirClienteCNPJ.add(nomeClientePJ);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(10, 148, 141, 13);
		InserirClienteCNPJ.add(lblCep);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setBounds(161, 148, 141, 13);
		InserirClienteCNPJ.add(lblEndereo);
		
		cepClientePJ = new JTextField();
		cepClientePJ.setColumns(10);
		cepClientePJ.setBounds(10, 162, 115, 21);
		InserirClienteCNPJ.add(cepClientePJ);
		
		enderecoClientePJ = new JTextField();
		enderecoClientePJ.setColumns(10);
		enderecoClientePJ.setBounds(159, 163, 255, 20);
		InserirClienteCNPJ.add(enderecoClientePJ);
		
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
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaClientePF, listaCLientePJ, listaProduto, listaCategoria);
				t.setVisible(true);
				setVisible(false);
			}
		};
		
		ConfirmarInserirPJ.addActionListener(confirmar);
	}
}
