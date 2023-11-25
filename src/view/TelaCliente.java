package view;

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

import controller.ManterCarrinho;
import controller.ManterProduto;

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
	public TelaCliente(LinkedList<ClientePF> listaClientePF, LinkedList<ClientePJ> listaCLientePJ,
			LinkedList<Produto>[] tabelaProduto, LinkedList<Categoria> listaCategoria, LinkedList<Pedido> listaPedidos,ClientePF PF, ClientePJ PJ) {
		String nomeCliente;
		if (listaPedidos == null) {
			 nomeCliente = PJ.nomeClientePJ;
		} else {
			 nomeCliente = PF.nomeClientePF;
		}
		ManterProduto mp = new ManterProduto(tabelaProduto);
		ManterCarrinho mc = new ManterCarrinho(nomeCliente);
		

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
		ActionListener carrinho = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 TelaClienteCarrinho t = new TelaClienteCarrinho(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, mc);
				t.setVisible(true);
				setVisible(false);
			}
		};
		btnCarrinho.addActionListener(carrinho);
		
		
		
		campoPesquisa = new JTextField();
		campoPesquisa.setColumns(10);
		campoPesquisa.setBounds(20, 56, 251, 19);
		contentPane.add(campoPesquisa);
		
		JLabel lblNewLabel = new JLabel("Você está pesquisando por ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 33, 178, 13);
		contentPane.add(lblNewLabel);
		
		int tamanho = listaCategoria.size();
		JComboBox<String> cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(198, 28, 175, 22);
		contentPane.add(cbCategoria);
		cbCategoria.addItem("Todos os Produtos");
		
		for(int i = 0;i<tamanho;i++) {
			Categoria l;
			try {
				l = listaCategoria.get(i);
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
				TelaAmbiente t = new TelaAmbiente(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos);
				t.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JScrollPane scrollPane = new JScrollPane();
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
		scrollPane.setColumnHeaderView(table);
		
		formatarTabela(cbCategoria, tabelaProduto);
		PopupMenuListener p = new PopupMenuListener() {
			
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
			
			
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				formatarTabela(cbCategoria, tabelaProduto);
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
					Produto produto = mp.consultaProduto((table.getModel().getValueAt(table.getSelectedRow(),1).toString()));
					produto.qtdProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantos itens vão ser adicionados ao carrinho?"));
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
				pesquisarProduto(campoPesquisa, cbCategoria, tabelaProduto);
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
