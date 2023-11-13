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

public class TelaPesquisarCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisarCategoria frame = new TelaPesquisarCategoria();
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
	public TelaPesquisarCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por PRODUTOS");
		lblNewLabel.setBounds(101, 11, 317, 13);
		contentPane.add(lblNewLabel);
		
		nomeProduto = new JTextField();
		nomeProduto.setBounds(32, 53, 251, 19);
		contentPane.add(nomeProduto);
		nomeProduto.setColumns(10);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarProduto);
		
		JLabel lblInformeOCpf = new JLabel("Informe o NOME para buscá-lo:");
		lblInformeOCpf.setBounds(22, 34, 317, 13);
		contentPane.add(lblInformeOCpf);
		
		JButton btnAtualizarProduto = new JButton("Atualizar");
		btnAtualizarProduto.setBackground(new Color(128, 255, 128));
		btnAtualizarProduto.setForeground(new Color(0, 0, 0));
		btnAtualizarProduto.setBounds(22, 232, 114, 21);
		contentPane.add(btnAtualizarProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir");
		btnExcluirProduto.setBackground(new Color(255, 0, 0));
		btnExcluirProduto.setBounds(146, 232, 114, 21);
		contentPane.add(btnExcluirProduto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(312, 232, 114, 21);
		contentPane.add(btnVoltar);
	}

}
