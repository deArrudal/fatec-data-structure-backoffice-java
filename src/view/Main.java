package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import controller.ManterClientePF;
import controller.ManterClientePJ;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;
import view.telasmenu.TelaCliente;
import view.telasmenu.TelaHome;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public LinkedList<ClientePF> listaClientePF = new LinkedList<>();
	public LinkedList<ClientePJ> listaCLientePJ = new LinkedList<>();
	public LinkedList<Categoria> listaCategoria = new LinkedList<>();
	public LinkedList<Produto>[] tabelaProduto;

	ManterClientePF pf = new ManterClientePF(listaClientePF);
	ManterClientePJ pj = new ManterClientePJ(listaCLientePJ);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Eu sou:");
		lblNewLabel.setBounds(190, 52, 95, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sistema de Compras");
		lblNewLabel_1.setBounds(162, 10, 163, 13);
		contentPane.add(lblNewLabel_1);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(162, 108, 123, 21);
		contentPane.add(btnCliente);
		ActionListener cliente = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ClientePF PF = null;
				ClientePJ PJ = null;

				String res;
				do {
					res = JOptionPane.showInputDialog("Informe seu CPF ou CNPJ (Pessoa jurídica)");
					try {
						PF = pf.consultaClientePF(res);
						PJ = pj.consultaClientePJ(res);
					} catch (Exception e2) {
						e2.getStackTrace();
					}

					if (PF == null & PJ == null) {
						JOptionPane.showMessageDialog(btnCliente,
								"Cliente não localizado, solicite seu cadastro a um de nossos funcionários");
						break;
					}
				} while (PF == null & PJ == null);

				if (PF != null || PJ != null) {
					TelaCliente t = new TelaCliente(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, PF,
							PJ);
					t.setVisible(true);
					setVisible(false);
				}

			}
		};
		btnCliente.addActionListener(cliente);

		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setBounds(162, 160, 123, 21);
		contentPane.add(btnFuncionario);
		ActionListener funcionario = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String r = "0";
				do {
					r = JOptionPane.showInputDialog("Digite sua senha para seguir: ");

					if (!r.equals("0000")) {
						JOptionPane.showMessageDialog(btnFuncionario, "Senha incorreta");
						break;
					}
				} while (!r.equals("0000"));

				if (r.equals("0000")) {
					TelaHome t = new TelaHome(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria);
					t.setVisible(true);
					setVisible(false);
				}

			}
		};
		btnFuncionario.addActionListener(funcionario);
	}
}
