package view.telasmenu;

import java.awt.EventQueue;
import java.awt.PopupMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import stack.model.Stack;
import view.telascompra.TelaClienteCarrinho;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;
import java.awt.event.ActionEvent;
import java.awt.Color;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.crud.ManterCarrinho;
import controller.crud.ManterClientePF;
import controller.crud.ManterClientePJ;
import controller.crud.ManterProduto;

import javax.swing.ScrollPaneConstants;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoPesquisa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente(null, null, null, null, null, null, null);
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
	public TelaCliente(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, String cliente, ManterCarrinho mc) {
		setTitle("Backoffice - Área do Cliente");
		ManterClientePJ mpj = new ManterClientePJ(listaClientesPJ);
		ManterClientePF mpf = new ManterClientePF(listaClientesPF);
		String[] split = cliente.split(";");
		String nomeCliente = "";
		if (split[1].equals("PJ")) {
			 ClientePJ CNPJ;
				try {
					CNPJ = mpj.consultaClientePJNome(split[0]);
					nomeCliente = CNPJ.nomeClientePJ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else {
			 ClientePF CPF;
				try {
					CPF = mpf.consultaClientePFNome(split[0]);
					nomeCliente = CPF.nomeClientePF;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		ManterProduto mp = new ManterProduto(listaProdutos);
		if (!mc.carrinhoDisponível) {
			 mc.iniciarCarrinho(nomeCliente, listaPedidos);
		}
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCliente = new JLabel("New label");
		lblCliente.setBounds(88, 10, 304, 13);
		contentPane.add(lblCliente);
		lblCliente.setText("Bem vinda(o) a área do cliente " + nomeCliente);
		
		JButton btnCarrinho = new JButton("Ver Carrinho");
		btnCarrinho.setBounds(554, 10, 120, 21);
		contentPane.add(btnCarrinho);
		ActionListener verCarrinho = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCarrinho t = new TelaClienteCarrinho(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, cliente, mc);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnCarrinho.addActionListener(verCarrinho);
		
		
		
		campoPesquisa = new JTextField();
		campoPesquisa.setColumns(10);
		campoPesquisa.setBounds(20, 56, 251, 19);
		contentPane.add(campoPesquisa);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 33, 178, 13);
		contentPane.add(lblNewLabel);
		
		int tamanho = listaCategorias.size();
		JComboBox<String> cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(198, 28, 175, 22);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("Todos os Produtos");
		
		for(int i = 0;i<tamanho;i++) {
			Categoria l;
			try {
				l = listaCategorias.get(i);
				if (l.nomeCategoria != null ) {
					cbCategoria.addItem(String.valueOf(l.idCategoria)+" - "+l.nomeCategoria);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		
		JButton btnVoltar = new JButton("<-");
		btnVoltar.setBounds(20, 5, 45, 23);
		contentPane.add(btnVoltar);
		
		ActionListener voltar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					mc.excluirCarrinho();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				TelaHome t = new TelaHome(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(35, 90, 600, 400);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Produto", "Descri\u00E7\u00E3o", "Estoque", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setColumnHeaderView(table);
		
		formatarTabela(cbCategoria, listaProdutos);
		PopupMenuListener p = new PopupMenuListener() {
			
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
			
			
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				formatarTabela(cbCategoria, listaProdutos);
			}
			
			public void popupMenuCanceled(PopupMenuEvent e) {				
			}
		};
		cbCategoria.addPopupMenuListener(p);
		
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar selecionado ao Carrinho");
		btnAdicionarAoCarrinho.setBackground(new Color(0, 128, 64));
		btnAdicionarAoCarrinho.setForeground(new Color(255, 255, 255));
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Pega o nome produto na linha selecionada
					//Preciso checar se o valr inserido é maior que o estoque
					Produto produto = mp.consultaProduto((table.getModel().getValueAt(table.getSelectedRow(),1).toString()));
					int qtd = produto.qtdProduto;
					produto.qtdProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantos itens vão ser adicionados ao carrinho?"));
					if (produto.qtdProduto>qtd) {
						while(produto.qtdProduto>qtd) {
							JOptionPane.showMessageDialog(null, "Valor maior que o estoque!");
							produto.qtdProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantos itens vão ser adicionados ao carrinho?"));
						}
					}
					mc.inserirCarrinho(produto);
					JOptionPane.showMessageDialog(null, "Produto adicionado ao Carrinho!");
					//Preciso excluir o valor inserido no carrinho no final do checkout
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAdicionarAoCarrinho.setBounds(20, 517, 276, 21);
		contentPane.add(btnAdicionarAoCarrinho);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(281, 55, 114, 21);
		btnPesquisar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				pesquisarProduto(campoPesquisa, cbCategoria, listaProdutos);
			}

			
		});
		contentPane.add(btnPesquisar);

	}

	private void formatarTabela(JComboBox<String> cbCategoria, LinkedList<Produto>[] tabelaProduto) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		if (model.getRowCount()>0) {
			int tamanho = model.getRowCount()-1;
			for (int i = tamanho;i>=0;i--) {
				model.removeRow(i);
			}
		}
		String cbCat = cbCategoria.getSelectedItem().toString();
		if (cbCat.equals("Todos os Produtos")) {
			int tamanhoTabela = tabelaProduto.length;
			for (int i = 0;i<tamanhoTabela;i++) {
				LinkedList<Produto> l = tabelaProduto[i];
				int tamanhoLista = l.size();
				for (int j = 0;j<tamanhoLista;j++) {
					try {
						Produto p = l.get(j);
						model.addRow(new Object [] {p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		else {
			String [] div = cbCat.split(" ");
			int cat = Integer.parseInt(div[0]);
			LinkedList<Produto> l = tabelaProduto[cat];
			int tamanhoLista = l.size();
			for (int j = 0;j<tamanhoLista;j++) {
				try {
					Produto p = l.get(j);
					model.addRow(new Object [] {p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void pesquisarProduto(JTextField campoPesquisa2, JComboBox<String> cbCategoria, LinkedList<Produto>[] tabelaProduto) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		if (model.getRowCount()>0) {
			int tamanho = model.getRowCount()-1;
			for (int i = tamanho;i>=0;i--) {
				model.removeRow(i);
			}
		}
		String cbCat = cbCategoria.getSelectedItem().toString();
		if (cbCat.equals("Todos os Produtos")) {
			int tamanhoTabela = tabelaProduto.length;
			for (int i = 0;i<tamanhoTabela;i++) {
				LinkedList<Produto> l = tabelaProduto[i];
				int tamanhoLista = l.size();
				for (int j = 0;j<tamanhoLista;j++) {
					try {
						Produto p = l.get(j);
						if (p.nomeProduto.equals(campoPesquisa2.getText())) {
							model.addRow(new Object [] {p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto});
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		else {
			String [] div = cbCat.split(" ");
			int cat = Integer.parseInt(div[0]);
			LinkedList<Produto> l = tabelaProduto[cat];
			int tamanhoLista = l.size();
			for (int j = 0;j<tamanhoLista;j++) {
				try {
					Produto p = l.get(j);
					if (p.nomeProduto.equals(campoPesquisa2.getText())) {
						model.addRow(new Object [] {p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
