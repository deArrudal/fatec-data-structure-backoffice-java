package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManterCategoria;
import controller.ManterClientePF;
import controller.ManterClientePJ;
import controller.ManterProduto;

import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;

public class TelaRemoverRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	//ManterClientePF manterClienteCPF = new ManterClientePF();
	//ManterClientePJ manterClientePJ = new ManterClientePJ();
	//ManterCategoria manterCategoria = new ManterCategoria();
	//ManterProduto manterProduto = new ManterProduto();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverRegistro frame = new TelaRemoverRegistro(null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaRemoverRegistro(String conteudo, String valorCampo, String categoria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Pessoa Física (CPF)\r\n\r\n");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemover = new JLabel("Removendo Registro");
		lblRemover.setForeground(new Color(253, 66, 66));
		lblRemover.setBounds(152, 10, 163, 13);
		contentPane.add(lblRemover);

		
		JLabel lblVocEstPrestes = new JLabel("Você está prestes a excluir o seguinte registro:");
		lblVocEstPrestes.setForeground(new Color(253, 66, 66));
		lblVocEstPrestes.setBounds(53, 51, 299, 13);
		contentPane.add(lblVocEstPrestes);
		
		JLabel lblEstaAo = new JLabel("Esta ação é irreversível, deseja prosseguir?");
		lblEstaAo.setForeground(new Color(0, 0, 0));
		lblEstaAo.setBounds(99, 143, 299, 13);
		contentPane.add(lblEstaAo);
		
		JLabel registroRemovido = new JLabel("");
		registroRemovido.setBounds(53, 84, 45, 13);
		contentPane.add(registroRemovido);
		
		registroRemovido.setText(conteudo);

		
		// Evento clique voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(100, 25));
		btnVoltar.setBounds(88, 166, 100, 23);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta();
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JButton btnConfirmarExcluir = new JButton("Prosseguir");
		btnConfirmarExcluir.setPreferredSize(new Dimension(100, 25));
		btnConfirmarExcluir.setBounds(211, 166, 104, 23);
		contentPane.add(btnConfirmarExcluir);
		ActionListener excluir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (categoria) {
				case "CLIENTE CPF":
					//ManterClientePF.excluirClientePF(valorCampo);
					break;
				case "CLIENTE CNPJ":
					//ManterClientePJ.excluirClientePJ(valorCampo);
					break;

				case "PRODUTO":
					//ManterProduto.excluirProduto(valorCampo);
					break;

				case "CATEGORIA":
					//ManterCategoria.excluirCategoria(valorCampo);
					break;
				}
				JOptionPane.showMessageDialog(btnConfirmarExcluir, "Registro Excluido");
				TelaConsulta t = new TelaConsulta(null, null, null, null);
				t.setVisible(true);
				setVisible(false);
			}	
			
		};
		btnConfirmarExcluir.addActionListener(excluir);
	}
}
