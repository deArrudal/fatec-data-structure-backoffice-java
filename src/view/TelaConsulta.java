package view;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
		cbCategoria.addItem("CLIENTE CPF");
		cbCategoria.addItem("CLIENTE CNPJ");
		cbCategoria.addItem("PRODUTO");
		cbCategoria.addItem("CATEGORIA");
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(32, 11, 178, 13);
		contentPane.add(lblNewLabel);
		
		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(32, 53, 251, 19);
		contentPane.add(campoPesquisa);
		campoPesquisa.setColumns(10);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.setBounds(280, 52, 114, 21);
		contentPane.add(btnPesquisarProduto);
		
		
		
		JLabel lblInforme = new JLabel();
		switch (cbCategoria.getSelectedItem().toString()){
		case "CLIENTE CPF":
			lblInforme.setText("Informe o CPF para buscá-lo:");
			break;
		case "CLIENTE CNPJ":
			lblInforme.setText("Informe o CNPJ para buscá-lo:");
			break;
		case "PRODUTO":
			lblInforme.setText("Informe o NOME DO PRODUTO para buscá-lo:");
			break;
		case "CATEGORIA":
			lblInforme.setText("Informe o NOME DA CATEGORIA para buscá-lo:");
			break;
		}
		lblInforme.setBounds(22, 34, 317, 13);
		contentPane.add(lblInforme);
		PopupMenuListener p = new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				switch (cbCategoria.getSelectedItem().toString()){
				case "CLIENTE CPF":
					lblInforme.setText("Informe o CPF para buscá-lo:");
					break;
				case "CLIENTE CNPJ":
					lblInforme.setText("Informe o CNPJ para buscá-lo:");
					break;
				case "PRODUTO":
					lblInforme.setText("Informe o NOME DO PRODUTO para buscá-lo:");
					break;
				case "CATEGORIA":
					lblInforme.setText("Informe o NOME DA CATEGORIA para buscá-lo:");
					break;
				}
				
			}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		cbCategoria.addPopupMenuListener(p);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(32, 83, 363, 127);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
	}
}
