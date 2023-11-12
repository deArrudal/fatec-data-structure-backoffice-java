package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHome frame = new TelaHome();
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
	public TelaHome() {
		setTitle("Backoffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(321, 23, 89, 23);
		contentPane.add(btnCarregar);
		
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(321, 83, 89, 23);
		contentPane.add(btnConsulta);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(321, 143, 89, 23);
		contentPane.add(btnCadastro);
		
		JButton btnCompra = new JButton("Compra");
		btnCompra.setBounds(321, 203, 89, 23);
		contentPane.add(btnCompra);
	}
}
