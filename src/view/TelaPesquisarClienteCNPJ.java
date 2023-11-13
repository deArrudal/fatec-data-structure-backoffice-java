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

public class TelaPesquisarClienteCNPJ extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cpfClienteCNPJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisarClienteCNPJ frame = new TelaPesquisarClienteCNPJ();
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
	public TelaPesquisarClienteCNPJ() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por CLIENTES - PJ");
		lblNewLabel.setBounds(101, 11, 317, 13);
		contentPane.add(lblNewLabel);
		
		cpfClienteCNPJ = new JTextField();
		cpfClienteCNPJ.setBounds(32, 53, 251, 19);
		contentPane.add(cpfClienteCNPJ);
		cpfClienteCNPJ.setColumns(10);
		
		JButton btnPesquisarClienteCNPJ = new JButton("Pesquisar");
		btnPesquisarClienteCNPJ.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarClienteCNPJ);
		
		JLabel lblInformeOCpf = new JLabel("Informe o CNPJ para buscá-lo:");
		lblInformeOCpf.setBounds(22, 34, 317, 13);
		contentPane.add(lblInformeOCpf);
		
		JButton btnAtualizarClienteCNPJ = new JButton("Atualizar");
		btnAtualizarClienteCNPJ.setBackground(new Color(128, 255, 128));
		btnAtualizarClienteCNPJ.setForeground(new Color(0, 0, 0));
		btnAtualizarClienteCNPJ.setBounds(22, 232, 114, 21);
		contentPane.add(btnAtualizarClienteCNPJ);
		
		JButton btnExcluirClienteCNPJ = new JButton("Excluir");
		btnExcluirClienteCNPJ.setBackground(new Color(255, 0, 0));
		btnExcluirClienteCNPJ.setBounds(146, 232, 114, 21);
		contentPane.add(btnExcluirClienteCNPJ);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(312, 232, 114, 21);
		contentPane.add(btnVoltar);
	}

}
