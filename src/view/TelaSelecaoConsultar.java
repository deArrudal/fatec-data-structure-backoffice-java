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

public class TelaSelecaoConsultar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbCategoria;
	private JComboBox<String> cbOperacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecaoConsultar frame = new TelaSelecaoConsultar();
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
	public TelaSelecaoConsultar() {
		setTitle("Backoffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbCategoria = new JComboBox<>();
		cbCategoria.setBounds(137, 62, 276, 22);
		contentPane.add(cbCategoria);
		
		cbCategoria.addItem("ClienteCPF");
		cbCategoria.addItem("ClienteCNPJ");
		cbCategoria.addItem("Produto");
		cbCategoria.addItem("Cadastro");
		
		cbOperacao = new JComboBox<>();
		cbOperacao.setBounds(137, 125, 276, 22);
		contentPane.add(cbOperacao);
		
		cbOperacao.addItem("Inserir");
		cbOperacao.addItem("Remover");
		cbOperacao.addItem("Atualizar");
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(26, 66, 68, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblOperacao = new JLabel("Opera\u00E7\u00E3o:");
		lblOperacao.setLabelFor(cbOperacao);
		lblOperacao.setBounds(26, 129, 68, 14);
		contentPane.add(lblOperacao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(225, 215, 89, 23);
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
		btnConfirmar.setBounds(324, 215, 89, 23);
		contentPane.add(btnConfirmar);
				
		ActionListener confirmar = confirmar();
		
		btnConfirmar.addActionListener(confirmar);
	}

	private ActionListener confirmar() {
		ActionListener confirmar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				switch((String)cbCategoria.getSelectedItem()) {
				case "ClienteCPF":
					switch((String)cbOperacao.getSelectedItem()) {
					case "Inserir":
						TelaInserirClienteCPF.main(null);
						break;
					case "Remover":
						
						break;
					case "Atualizar":
						TelaAtualizarClienteCPF.main(null);
						break;
					}
					break;
				case "ClienteCNPJ":
					switch((String)cbOperacao.getSelectedItem()) {
					case "Inserir":
						
						break;
					case "Remover":
						
						break;
					case "Atualizar":
						
						break;
					}
					break;
				case "Produto":
					switch((String)cbOperacao.getSelectedItem()) {
					case "Inserir":
						
						break;
					case "Remover":
						
						break;
					case "Atualizar":
						
						break;
					}
					break;
				case "Categoria":
					switch((String)cbOperacao.getSelectedItem()) {
					case "Inserir":
						
						break;
					case "Remover":
						
						break;
					case "Atualizar":
						
						break;
					}
					break;
				}
				setVisible(false);
			}
		};		return confirmar;
	}
}
