package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class TelaConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoPesquisa;
	private JComboBox<String> cbCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsulta frame = new TelaConsulta();
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
	public TelaConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(220, 6, 175, 22);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("PRODUTO");

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setBounds(82, 11, 140, 13);
		contentPane.add(lblNewLabel);
		
		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(32, 53, 251, 19);
		contentPane.add(campoPesquisa);
		campoPesquisa.setColumns(10);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarProduto);
		
		JLabel lblInformeOCpf = new JLabel("Informe o NOME para buscá-lo:");
		lblInformeOCpf.setBounds(22, 34, 317, 13);
		contentPane.add(lblInformeOCpf);
		
		JButton btnAtualizarProduto = new JButton("Atualizar");
		btnAtualizarProduto.setBounds(22, 232, 114, 21);
		btnAtualizarProduto.setBackground(new Color(128, 255, 128));
		btnAtualizarProduto.setForeground(new Color(0, 0, 0));
		contentPane.add(btnAtualizarProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir");
		btnExcluirProduto.setBounds(146, 232, 114, 21);
		btnExcluirProduto.setBackground(new Color(255, 0, 0));
		contentPane.add(btnExcluirProduto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(312, 232, 114, 21);
		contentPane.add(btnVoltar);
		
		
	}
}
