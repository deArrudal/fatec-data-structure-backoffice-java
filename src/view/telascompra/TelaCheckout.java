package view.telascompra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.crud.ManterCarrinho;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;

public class TelaCheckout extends JFrame {

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
					TelaCheckout frame = new TelaCheckout(null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCheckout(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos, LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ, LinkedList<Pedido> listaPedidos, String cliente, ManterCarrinho mc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Backoffice - Checkout");
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setToolTipText("");
		scrollPane.setBounds(20, 38, 640, 480);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id", "Produto", "Descri\u00E7\u00E3o", "Estoque", "Pre\u00E7o"},
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
		
		JLabel lblCheckout = new JLabel("Checkout");
		lblCheckout.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckout.setBounds(0, 11, 684, 14);
		contentPane.add(lblCheckout);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClienteCarrinho t = new TelaClienteCarrinho(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, cliente, mc);
				t.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(472, 529, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(571, 529, 89, 23);
		btnFinalizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCheckoutConfirma t = new TelaCheckoutConfirma(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, cliente, mc);
				t.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnFinalizar);
		
		JLabel lblValorTotal = new JLabel("");
		lblValorTotal.setBounds(20, 533, 442, 14);
		contentPane.add(lblValorTotal);
		
		try {
			mc.CheckoutInicio(table, lblValorTotal);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
