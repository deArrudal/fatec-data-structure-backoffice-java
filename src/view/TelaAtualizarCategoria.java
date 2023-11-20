package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ManterCategoria;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaAtualizarCategoria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField idCategoria;
	private JTextField nomeCategoria;
	//ManterCategoria manterCategoria = new ManterCategoria();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarCategoria frame = new TelaAtualizarCategoria(null, null, null, null, null, null, null);
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
	public TelaAtualizarCategoria(String retorno, String valorCampo, String categoria, LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ, LinkedList<Produto>[] tabelaProduto, LinkedList<Categoria> listaCategoria) {
		
		String campos[] = retorno.split(";");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel InserirClienteCNPJ = new JPanel();
		InserirClienteCNPJ.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(InserirClienteCNPJ);
		InserirClienteCNPJ.setLayout(null);
		
		JLabel titulo = new JLabel("Atualizar Categoria");
		titulo.setBounds(147, 10, 141, 13);
		InserirClienteCNPJ.add(titulo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(77, 21));
		btnVoltar.setActionCommand("");
		btnVoltar.setBounds(111, 154, 85, 21);
		InserirClienteCNPJ.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(212, 154, 96, 21);
		InserirClienteCNPJ.add(btnConfirmar);
		ActionListener confirmar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ManterCategoria.excluirCategoria(valorCampo);
				Categoria c = new Categoria();
				c.idCategoria = Integer.parseInt(idCategoria.getText());
				c.nomeCategoria = nomeCategoria.getText();
				//ManterCategoria.inserirCategoria(c);
				
			}
		};
		btnConfirmar.addActionListener(confirmar);
		
		JLabel label1 = new JLabel("Nome da Categoria: ");
		label1.setBounds(10, 69, 141, 13);
		InserirClienteCNPJ.add(label1);
		idCategoria = new JTextField();
		idCategoria.setBounds(212, 92, 192, 21);
		InserirClienteCNPJ.add(idCategoria);
		idCategoria.setColumns(10);
		idCategoria.setText(campos[0]);
		
		JLabel idC = new JLabel("N° identificador:");
		idC.setBounds(212, 69, 122, 13);
		InserirClienteCNPJ.add(idC);
		nomeCategoria = new JTextField();
		nomeCategoria.setColumns(10);
		nomeCategoria.setBounds(10, 92, 192, 21);
		InserirClienteCNPJ.add(nomeCategoria);
		nomeCategoria.setText(campos[1]);
	}
}
