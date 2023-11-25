package view.telascrud.telasremover;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;

import controller.crud.ManterCategoria;
import controller.crud.ManterClientePF;
import controller.crud.ManterClientePJ;
import controller.crud.ManterProduto;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telascrud.telasconsulta.TelaConsulta;

public class TelaRemoverRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverRegistro frame = new TelaRemoverRegistro(null, null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaRemoverRegistro(String conteudo, String valorCampo, String categoria,
			LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos) {

		ManterClientePF manterClientePF = new ManterClientePF(listaClientesPF);
		ManterClientePJ manterClientePJ = new ManterClientePJ(listaClientesPJ);
		ManterCategoria manterCategoria = new ManterCategoria(listaCategorias);
		ManterProduto manterProduto = new ManterProduto(listaProdutos);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Pessoa Física (CPF)\r\n\r\n");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRemover = new JLabel("Removendo Registro");
		lblRemover.setForeground(new Color(253, 66, 66));
		lblRemover.setBounds(152, 10, 163, 13);
		contentPane.add(lblRemover);

		JLabel lblVocEstPrestes = new JLabel("Você está prestes a excluir o seguinte registro:");
		lblVocEstPrestes.setForeground(new Color(253, 66, 66));
		lblVocEstPrestes.setBounds(53, 51, 299, 13);
		contentPane.add(lblVocEstPrestes);

		JLabel lblEstaAo = new JLabel("Esta ação é irreversível, deseja prosseguir?");
		lblEstaAo.setForeground(new Color(0, 0, 0));
		lblEstaAo.setBounds(99, 143, 299, 13);
		contentPane.add(lblEstaAo);

		JLabel registroRemovido = new JLabel("");
		registroRemovido.setBounds(53, 84, 45, 13);
		contentPane.add(registroRemovido);

		registroRemovido.setText(conteudo);

		// Evento clique voltar
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setPreferredSize(new Dimension(100, 25));
		btnVoltar.setBounds(88, 166, 100, 23);
		contentPane.add(btnVoltar);
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsulta t = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);

		JButton btnConfirmarExcluir = new JButton("Prosseguir");
		btnConfirmarExcluir.setPreferredSize(new Dimension(100, 25));
		btnConfirmarExcluir.setBounds(211, 166, 104, 23);
		contentPane.add(btnConfirmarExcluir);
		ActionListener excluir = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (categoria) {
					case "CLIENTE CPF":
						try {
							manterClientePF.excluirClientePF(valorCampo);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					case "CLIENTE CNPJ":
						try {
							manterClientePJ.excluirClientePJ(valorCampo);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;

					case "PRODUTO":
						try {
							manterProduto.excluirProduto(valorCampo);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;

					case "CATEGORIA":
						try {
							manterCategoria.excluirCategoria(valorCampo);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
				}
				JOptionPane.showMessageDialog(btnConfirmarExcluir, "Registro Excluido");

				TelaConsulta t = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);

				t.setVisible(true);
				dispose();
			}

		};
		btnConfirmarExcluir.addActionListener(excluir);
	}
}
