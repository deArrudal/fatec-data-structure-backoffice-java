package view.telascompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.crud.ManterCarrinho;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import stack.model.Stack;
import view.telasmenu.TelaCliente;
import view.telasmenu.TelaIniciar;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class TelaClienteCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaClienteCarrinho frame = new TelaClienteCarrinho(null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param mc 
	 */
	public TelaClienteCarrinho(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, String cliente,  ManterCarrinho mc) {
		setTitle("Backoffice - Carrinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Carrinho");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 664, 13);
		contentPane.add(lblNewLabel);
		
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
				TelaCliente t = new TelaCliente(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, cliente, mc);
				t.setVisible(true);
				dispose();
			}
		};
		btnVoltar.addActionListener(voltar);
		
		JButton btnExcluirItem = new JButton("Excluir Item");
		btnExcluirItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mc.removerItemCarrinho((table.getModel().getValueAt(table.getSelectedRow(),1).toString()));
					mc.exibirCarrinho(table);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluirItem.setBounds(10, 529, 105, 21);
		contentPane.add(btnExcluirItem);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(558, 529, 116, 21);
		contentPane.add(btnCheckout);
		
		JButton btnSalvarQtdes = new JButton("Salvar ");
		btnSalvarQtdes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvarQtdes.setBounds(140, 529, 105, 21);
		contentPane.add(btnSalvarQtdes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 38, 640, 480);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Descri\u00E7\u00E3o", "Quantidade", "Pre\u00E7o"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setColumnHeaderView(table);
		
		try {
			mc.exibirCarrinho(table);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
