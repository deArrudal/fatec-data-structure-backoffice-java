package view.telasmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

import controller.MetodosLogin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.Principal;
import view.telascarregar.TelaCarregarBD;
import view.telascrud.TelaSelecaoCadastro;
import view.telascrud.telasconsulta.TelaConsulta;
import view.telassalvar.TelaSalvarBD;

public class TelaHome extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	MetodosLogin login = new MetodosLogin();

	public TelaHome(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		setTitle("Backoffice - Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// label titulo
		JLabel lblTitulo = new JLabel("Menu principal", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
		lblTitulo.setBounds(75, 20, 300, 23);
		contentPane.add(lblTitulo);

		// texto aviso
		JTextArea txtAviso = new JTextArea("*Recomenda-se carregar os\n dados");
		txtAviso.setFont(new Font("Serif", Font.BOLD, 12));
		txtAviso.setBounds(50, 65, 150, 35);
		txtAviso.setBackground(null);
		txtAviso.setForeground(Color.RED);
		contentPane.add(txtAviso);

		// evento clique botão consulta
		JButton btnConsulta = new JButton("Consultas");
		btnConsulta.setBounds(240, 65, 150, 23);
		contentPane.add(btnConsulta);
		ActionListener consulta = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta telaConsulta = new TelaConsulta(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaConsulta.setVisible(true);
				setVisible(false);
			}
		};
		btnConsulta.addActionListener(consulta);

		// evento clique botão carregar
		JButton btnCarregar = new JButton("Carregar dados");
		btnCarregar.setBounds(50, 115, 150, 23);
		contentPane.add(btnCarregar);
		ActionListener carregar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarregarBD telaCarregarBD = new TelaCarregarBD(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaCarregarBD.setVisible(true);
				setVisible(false);
			}
		};
		btnCarregar.addActionListener(carregar);

		// evento clique botão cadastro
		JButton btnCadastro = new JButton("Cadastros");
		btnCadastro.setBounds(240, 115, 150, 23);
		contentPane.add(btnCadastro);
		ActionListener cadastro = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro telaSelecaoCadastro = new TelaSelecaoCadastro(listaCategorias,
						listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				telaSelecaoCadastro.setVisible(true);
				setVisible(false);
			}
		};
		btnCadastro.addActionListener(cadastro);

		// evento clique botão salvar
		JButton btnSalvar = new JButton("Salvar dados");
		btnSalvar.setBounds(50, 165, 150, 23);
		contentPane.add(btnSalvar);
		ActionListener salvar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSalvarBD telaSalvarBD = new TelaSalvarBD(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaSalvarBD.setVisible(true);
				setVisible(false);
			}
		};
		btnSalvar.addActionListener(salvar);

		// evento clique botão compra
		JButton btnCompra = new JButton("Realizar compra");
		btnCompra.setBounds(240, 165, 150, 23);
		contentPane.add(btnCompra);
		ActionListener compra = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nomeUsuario = login.loginUsuario(listaClientesPF, listaClientesPJ);
					JOptionPane.showMessageDialog(null, "Test: " + nomeUsuario);

				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Operacao invalida",
							"BackOffice - Login", JOptionPane.ERROR_MESSAGE);
				}

			}
		};
		btnCompra.addActionListener(compra);

		// label modo de usuario
		JLabel lblModoUsuario = new JLabel("Modo usuario", SwingConstants.CENTER);
		lblModoUsuario.setFont(new Font("Serif", Font.BOLD, 12));
		lblModoUsuario.setBounds(290, 220, 150, 23);
		lblModoUsuario.setForeground(Color.RED);
		contentPane.add(lblModoUsuario);
		lblModoUsuario.setVisible(false);

		// evento clique botão retornar
		JButton btnRetornar = new JButton("Cancelar");
		btnRetornar.setBounds(175, 220, 100, 23);
		contentPane.add(btnRetornar);
		ActionListener retornar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaIniciar telaIniciar = new TelaIniciar(listaCategorias, listaProdutos,
						listaClientesPF, listaClientesPJ, listaPedidos);
				telaIniciar.setVisible(true);
				setVisible(false);
			}
		};
		btnRetornar.addActionListener(retornar);

		// desabilita modo administrador.
		if (!Principal.modoAdministrador) {
			lblModoUsuario.setVisible(true);
			txtAviso.setVisible(false);
			btnConsulta.setVisible(false);
			btnCarregar.setVisible(false);
			btnCadastro.setVisible(false);
			btnSalvar.setVisible(false);
		}
	}
}
