package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;

public class TelaRemoverRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverRegistro frame = new TelaRemoverRegistro();
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
	public TelaRemoverRegistro() {
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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(100, 25));
		btnVoltar.setBounds(88, 166, 100, 23);
		contentPane.add(btnVoltar);
		
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro.main(null);
				setVisible(false);
			}
		};
		
		btnVoltar.addActionListener(voltar);
		
		JButton btnConfirmarExcluirCNPJ = new JButton("Prosseguir");
		btnConfirmarExcluirCNPJ.setPreferredSize(new Dimension(100, 25));
		btnConfirmarExcluirCNPJ.setBounds(211, 166, 104, 23);
		contentPane.add(btnConfirmarExcluirCNPJ);
		
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
	}
}
