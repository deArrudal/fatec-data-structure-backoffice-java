package view.telasmenu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascarregar.TelaCarregarBD;
import view.telascrud.TelaSelecaoCadastro;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaHome extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public TelaHome(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		setTitle("Backoffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*
		JLabel iconLabel = new JLabel();
		Image iconBackOffice = new ImageIcon(this.getClass().getResource("/image.jpeg")).getImage();
		iconLabel.setIcon(new ImageIcon(iconBackOffice));
		iconLabel.setBounds(25, 25, 100, 100);
		contentPane.add(iconLabel);
		*/

		// Evento clique botão carregar
		JButton btnCarregar = new JButton("Carregar dados");
		btnCarregar.setBounds(321, 23, 89, 23);
		contentPane.add(btnCarregar);

		ActionListener carregar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCarregarBD t = new TelaCarregarBD(listaCategorias, listaProdutos, listaClientesPF,
						listaClientesPJ, listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		};

		btnCarregar.addActionListener(carregar);

		// Evento clique botão consulta
		JButton btnConsulta = new JButton("Consultas");
		btnConsulta.setBounds(321, 83, 89, 23);
		contentPane.add(btnConsulta);

		ActionListener consulta = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaClientesPF, listaClientesPJ, listaProdutos, listaCategorias);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnConsulta.addActionListener(consulta);

		// Evento clique botão cadastro
		JButton btnCadastro = new JButton("Cadastros");
		btnCadastro.setBounds(321, 143, 89, 23);
		contentPane.add(btnCadastro);
		ActionListener cadastro = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecaoCadastro t = new TelaSelecaoCadastro(listaClientesPF, listaClientesPJ, listaProdutos,
						listaCategorias);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnCadastro.addActionListener(cadastro);

		// Evento clique botão compra
		JButton btnCompra = new JButton("Realizar compra");
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
