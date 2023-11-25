package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ManterClientePF;
import controller.ManterClientePJ;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class TelaAmbiente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 * @param listaPedidos 
	 */
	
	
	
	public TelaAmbiente(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ, LinkedList<Produto>[] tabelaProduto, LinkedList<Categoria> listaCategoria, LinkedList<Pedido> listaPedidos) {
		ManterClientePF pf = new ManterClientePF(listaClientePF);
		ManterClientePJ pj = new ManterClientePJ(listaCLientePJ);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
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
				//Pesquisa na lista de Clientes pelo CPF ou CNPJ, caso não ache, dispara um aviso
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
						JOptionPane.showMessageDialog(btnCliente, "Cliente não localizado, solicite seu cadastro a um de nossos funcionários");
						break;
					}
				} while (PF == null & PJ == null);
				
				if (PF != null || PJ != null) {
					TelaCliente t = new TelaCliente(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos, PF, PJ);
					t.setVisible(true);
					dispose();
				}

			}
		};
		btnCliente.addActionListener(cliente);

		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setBounds(162, 152, 123, 21);
		contentPane.add(btnFuncionario);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(162, 197, 123, 23);
		contentPane.add(btnCarregar);
		
		ActionListener carregar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaCarregarBD t = new TelaCarregarBD(listaCategoria, tabelaProduto, listaClientePF, listaCLientePJ, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnCarregar.addActionListener(carregar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(162, 231, 123, 23);
		contentPane.add(btnSalvar);
		
		ActionListener salvar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaSalvarBD t = new TelaSalvarBD(listaCategoria, tabelaProduto, listaClientePF, listaCLientePJ, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnSalvar.addActionListener(salvar);
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
					TelaHome t = new TelaHome(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos);
					t.setVisible(true);
					dispose();
				}

			}
		};
		btnFuncionario.addActionListener(funcionario);
	}
	
}
