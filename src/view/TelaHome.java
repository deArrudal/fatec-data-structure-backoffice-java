package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class TelaHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHome frame = new TelaHome(null, null, null, null);
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
	public TelaHome(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ, LinkedList<Produto>[] tabelaProduto, 
			LinkedList<Categoria> listaCategoria, LinkedList<Pedido> listaPedidos) {
		
		/*int tamanhoP = 15; //valor provisório, tabela hash não inicializando
		for (int i = 0; i<tamanhoP;i++) {
			tabelaProduto[i] = new LinkedList<Produto>();
		}*/
		
		setTitle("Backoffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Evento clique botão consulta
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(321, 83, 89, 23);
		contentPane.add(btnConsulta);

		ActionListener consulta = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnConsulta.addActionListener(consulta);

		
		// Evento clique botão cadastro
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(321, 143, 89, 23);
		contentPane.add(btnCadastro);
		ActionListener cadastro = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnCadastro.addActionListener(cadastro);

		// Evento clique botão compra
		JButton btnCompra = new JButton("Compra");
		btnCompra.setBounds(321, 203, 89, 23);
		contentPane.add(btnCompra);
		ActionListener compra = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TelaSelecaoCadastro t = new TelaSelecaoCadastro();
				//t.setVisible(true);
				//setVisible(false);
			}
		};
		btnCadastro.addActionListener(compra);
		
		JButton btnVoltar = new JButton("<-");
		btnVoltar.setBounds(20, 5, 45, 23);
		contentPane.add(btnVoltar);
		
		ActionListener voltar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaAmbiente t = new TelaAmbiente(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);
	}
}
