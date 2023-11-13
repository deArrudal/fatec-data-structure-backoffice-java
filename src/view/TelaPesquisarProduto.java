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

public class TelaPesquisarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisarProduto frame = new TelaPesquisarProduto();
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
	public TelaPesquisarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por CATEGORIAS");
		lblNewLabel.setBounds(101, 11, 317, 13);
		contentPane.add(lblNewLabel);
		
		nomeCategoria = new JTextField();
		nomeCategoria.setBounds(32, 53, 251, 19);
		contentPane.add(nomeCategoria);
		nomeCategoria.setColumns(10);
		
		JButton btnPesquisarCategoria = new JButton("Pesquisar");
		btnPesquisarCategoria.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarCategoria);
		
		JLabel lblInformeOCpf = new JLabel("Informe o NOME para buscá-la:");
		lblInformeOCpf.setBounds(22, 34, 317, 13);
		contentPane.add(lblInformeOCpf);
		
		JButton btnAtualizarCategoria = new JButton("Atualizar");
		btnAtualizarCategoria.setBackground(new Color(128, 255, 128));
		btnAtualizarCategoria.setForeground(new Color(0, 0, 0));
		btnAtualizarCategoria.setBounds(22, 232, 114, 21);
		contentPane.add(btnAtualizarCategoria);
		
		JButton btnExcluirCategoria = new JButton("Excluir");
		btnExcluirCategoria.setBackground(new Color(255, 0, 0));
		btnExcluirCategoria.setBounds(146, 232, 114, 21);
		contentPane.add(btnExcluirCategoria);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(312, 232, 114, 21);
		contentPane.add(btnVoltar);
	}

}
