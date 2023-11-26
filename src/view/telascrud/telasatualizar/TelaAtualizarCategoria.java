package view.telascrud.telasatualizar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.crud.ManterCategoria;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaAtualizarCategoria extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField idCategoria;
	private JTextField nomeCategoria;

	
	public TelaAtualizarCategoria(Categoria retorno, String valorCampo, String categoria, LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {
				
		ManterCategoria manterCategoria = new ManterCategoria(listaCategorias);
		
		setTitle("BackOffice - Atualizar Categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 205);
		setLocationRelativeTo(null);

		JPanel AtualizarCategoria = new JPanel();
		AtualizarCategoria.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AtualizarCategoria);
		AtualizarCategoria.setLayout(null);
		
		JLabel titulo = new JLabel("Atualizar Categoria");
		titulo.setBounds(147, 10, 141, 13);
		AtualizarCategoria.add(titulo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(111, 154, 85, 21);
		AtualizarCategoria.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(212, 154, 96, 21);
		AtualizarCategoria.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					manterCategoria.excluirCategoria(retorno.nomeCategoria);
					Categoria c = new Categoria();
					c.idCategoria = Integer.parseInt(idCategoria.getText());
					c.nomeCategoria = nomeCategoria.getText();
					manterCategoria.inserirCategoria(c);
                    TelaConsulta tc = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF,
                    listaClientesPJ, listaPedidos);
                    tc.setVisible(true);
                    dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		};
		btnConfirmar.addActionListener(confirmar);
		
		JLabel label1 = new JLabel("Nome da Categoria: ");
		label1.setBounds(10, 69, 141, 13);
		AtualizarCategoria.add(label1);
		idCategoria = new JTextField();
		idCategoria.setBounds(212, 92, 192, 21);
		AtualizarCategoria.add(idCategoria);
		idCategoria.setColumns(10);
		idCategoria.setText(String.valueOf(retorno.idCategoria));
		
		JLabel idC = new JLabel("N° identificador:");
		idC.setBounds(212, 69, 122, 13);
		AtualizarCategoria.add(idC);
		nomeCategoria = new JTextField();
		nomeCategoria.setColumns(10);
		nomeCategoria.setBounds(10, 92, 192, 21);
		AtualizarCategoria.add(nomeCategoria);
		nomeCategoria.setText(retorno.nomeCategoria);
	}
}
