package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class TelaPesquisarClienteCPF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpfClientePF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisarClienteCPF frame = new TelaPesquisarClienteCPF();
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
	public TelaPesquisarClienteCPF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por CLIENTES - PF");
		lblNewLabel.setBounds(101, 11, 317, 13);
		contentPane.add(lblNewLabel);
		
		cpfClientePF = new JTextField();
		cpfClientePF.setBounds(32, 53, 251, 19);
		contentPane.add(cpfClientePF);
		cpfClientePF.setColumns(10);
		
		JButton btnPesquisarClientePF = new JButton("Pesquisar");
		btnPesquisarClientePF.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarClientePF);
		
		JLabel lblInformeOCpf = new JLabel("Informe o CPF para buscá-lo:");
		lblInformeOCpf.setBounds(22, 34, 317, 13);
		contentPane.add(lblInformeOCpf);
		
		JButton btnAtualizarClientePF = new JButton("Atualizar");
		btnAtualizarClientePF.setBackground(new Color(128, 255, 128));
		btnAtualizarClientePF.setForeground(new Color(0, 0, 0));
		btnAtualizarClientePF.setBounds(22, 232, 114, 21);
		contentPane.add(btnAtualizarClientePF);
		
		JButton btnExcluirClientePF = new JButton("Excluir");
		btnExcluirClientePF.setBackground(new Color(255, 0, 0));
		btnExcluirClientePF.setBounds(146, 232, 114, 21);
		contentPane.add(btnExcluirClientePF);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(312, 232, 114, 21);
		contentPane.add(btnVoltar);
	}

}
