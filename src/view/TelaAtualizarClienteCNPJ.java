package view;

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
import java.awt.Color;

public class TelaAtualizarClienteCNPJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField cnpjClientePJ;
	private JTextField telefoneClientePJ;
	private JTextField nomeClientePJ;
	private JTextField cepClientePJ;
	private JTextField enderecoClientePJ;
	private JTextField telClientePJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarClienteCNPJ frame = new TelaAtualizarClienteCNPJ();
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
	public TelaAtualizarClienteCNPJ() {
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
				TelaConsulta t = new TelaConsulta(null, null, null, null);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JButton ConfirmarInserirPF = new JButton("Confirmar");
		ConfirmarInserirPF.setBounds(295, 232, 96, 21);
		InserirClienteCNPJ.add(ConfirmarInserirPF);
		
		JLabel label1 = new JLabel("Nome Fantasia: ");
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
		
		telefoneClientePJ = new JTextField();
		telefoneClientePJ.setColumns(10);
		telefoneClientePJ.setBounds(10, 104, 186, 21);
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
		
		JLabel telefoneInserirPJ = new JLabel("Telefone:");
		telefoneInserirPJ.setBounds(222, 87, 141, 13);
		InserirClienteCNPJ.add(telefoneInserirPJ);
		
		telClientePJ = new JTextField();
		telClientePJ.setColumns(10);
		telClientePJ.setBounds(222, 105, 186, 21);
		InserirClienteCNPJ.add(telClientePJ);
	}
}