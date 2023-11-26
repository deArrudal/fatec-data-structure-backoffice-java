package view.telascompra;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import view.telasmenu.TelaHome;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaCheckoutConfirma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckoutConfirma frame = new TelaCheckoutConfirma(null, null, null, null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCheckoutConfirma(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos, LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ, LinkedList<Pedido> listaPedidos, String cliente, ManterCarrinho mc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeseja = new JLabel("Deseja finalizar a compra?");
		lblDeseja.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeseja.setBounds(10, 41, 414, 14);
		contentPane.add(lblDeseja);
		
		JButton btnNo = new JButton("Não");
		btnNo.setBounds(108, 139, 89, 23);
		btnNo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				TelaCheckout t = new TelaCheckout(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, cliente, mc);
				t.setVisible(true);;
				dispose();
			}
		});
		contentPane.add(btnNo);
		
		JButton btnSim = new JButton("Sim");
		btnSim.setBounds(225, 139, 89, 23);
		btnSim.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					mc.CheckoutFim(listaProdutos, listaPedidos);
					JOptionPane.showMessageDialog(null, "Pedido Confirmado!");
					TelaCheckout t = new TelaCheckout(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos, cliente, mc);
					t.dispose();
					TelaHome h = new TelaHome(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ, listaPedidos);
					h.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnSim);
		
	}

}
