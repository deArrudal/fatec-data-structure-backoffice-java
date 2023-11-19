package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaSelecaoCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecaoCadastro frame = new TelaSelecaoCadastro();
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
	public TelaSelecaoCadastro() {
		setTitle("Backoffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbCategoria = new JComboBox<>();
		cbCategoria.setBounds(101, 97, 276, 22);
		contentPane.add(cbCategoria);
		
		cbCategoria.addItem("ClienteCPF");
		cbCategoria.addItem("ClienteCNPJ");
		cbCategoria.addItem("Produto");
		cbCategoria.addItem("Categoria");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(26, 101, 68, 14);
		contentPane.add(lblCategoria);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(199, 215, 89, 23);
		contentPane.add(btnVoltar);
		
		ActionListener voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaHome.main(null);
				setVisible(false);
			}
		};
		
		btnVoltar.addActionListener(voltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(298, 215, 99, 23);
		contentPane.add(btnConfirmar);
		
		ActionListener confirmar = confirmar();
		
		btnConfirmar.addActionListener(confirmar);
		
		JLabel lblNewLabel = new JLabel("Selecione a categoria do registro que deseja gerenciar");
		lblNewLabel.setBounds(57, 55, 333, 13);
		contentPane.add(lblNewLabel);
				
	
	}

	private ActionListener confirmar() {
		ActionListener confirmar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				switch((String)cbCategoria.getSelectedItem()) {
				case "ClienteCPF":
					TelaInserirClienteCPF cpf = new TelaInserirClienteCPF();
					cpf.setVisible(true);
					break;
				case "ClienteCNPJ":
					TelaInserirClienteCNPJ cnpj = new TelaInserirClienteCNPJ();
					cnpj.setVisible(true);
					break;
				case "Produto":
					TelaInserirProduto prod = new TelaInserirProduto();
					prod.setVisible(true);
					break;
				case "Categoria":
					TelaInserirCategoria cat = new TelaInserirCategoria();
					cat.setVisible(true);
					break;
				}
				setVisible(false);
			}
		};		return confirmar;
	}
}



