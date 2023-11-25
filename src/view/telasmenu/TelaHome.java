package view.telasmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;
import view.telascrud.TelaSelecaoCadastro;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() {
	 * public void run() {
	 * try {
	 * TelaHome frame = new TelaHome(null, null, null, null);
	 * frame.setVisible(true);
	 * 
	 * } catch (Exception e) {
	 * e.printStackTrace();
	 * }
	 * }
	 * });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public TelaHome(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ,
			LinkedList<Produto>[] tabelaProduto, LinkedList<Categoria> listaCategoria) {

		/*
		 * int tamanhoP = 15; //valor provisório, tabela hash não inicializando
		 * for (int i = 0; i<tamanhoP;i++) {
		 * tabelaProduto[i] = new LinkedList<Produto>();
		 * }
		 */

		setTitle("Backoffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Evento clique botão carregar
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.setBounds(321, 23, 89, 23);
		contentPane.add(btnCarregar);

		ActionListener carregar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TelaSelecaoConsultar t = new TelaSelecaoConsultar();
				// t.setVisible(true);
				// setVisible(false);
			}
		};
		btnCarregar.addActionListener(carregar);

		// Evento clique botão consulta
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(321, 83, 89, 23);
		contentPane.add(btnConsulta);

		ActionListener consulta = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria);
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
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaClientePF, listaCLientePJ, tabelaProduto,
						listaCategoria);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnCadastro.addActionListener(cadastro);

		// Evento clique botão compra
		JButton btnCompra = new JButton("Compra");
		btnCompra.setBounds(321, 203, 89, 23);
		contentPane.add(btnCompra);
		ActionListener compra = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TelaSelecaoCadastro t = new TelaSelecaoCadastro();
				// t.setVisible(true);
				// setVisible(false);
			}
		};
		btnCadastro.addActionListener(compra);
	}
}
