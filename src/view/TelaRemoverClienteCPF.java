package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaRemoverClienteCPF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverClienteCPF frame = new TelaRemoverClienteCPF();
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
	public TelaRemoverClienteCPF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemover = new JLabel("Remover Cliente CPF");
		lblRemover.setBounds(10, 11, 129, 14);
		contentPane.add(lblRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(232, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro.main(null);
				setVisible(false);
			}
		};
		
		btnVoltar.addActionListener(voltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(331, 227, 89, 23);
		contentPane.add(btnConfirmar);
	}
}
