package view.telascompra;

import javax.swing.JOptionPane;

import controller.crud.ManterCarrinho;
import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;
import view.telasmenu.TelaHome;

public class TelaCheckoutConfirma {

	public TelaCheckoutConfirma(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
			LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
			LinkedList<Pedido> listaPedidos, String novoUsuario, ManterCarrinho novoCarrinho) {

		if (JOptionPane.showConfirmDialog(null, "Finalizar a compra?", "BackOffice - Checkout",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			// Caso sim
			try {
				novoCarrinho.CheckoutFim(listaProdutos, listaPedidos);

				JOptionPane.showMessageDialog(null, "Pedido confirmado",
						"BackOffice - Checkout", JOptionPane.INFORMATION_MESSAGE);

				TelaCheckout telaCheckout = new TelaCheckout(listaCategorias, listaProdutos, listaClientesPF,
						listaClientesPJ,
						listaPedidos, novoUsuario, novoCarrinho);
				telaCheckout.dispose();

				TelaHome telaHome = new TelaHome(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ,
						listaPedidos);
				telaHome.setVisible(true);

			} catch (Exception Exception) {
				JOptionPane.showMessageDialog(null, "Erro na confirmacao do pedido",
						"BackOffice - Checkout", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			// Caso nao
			TelaCheckout telaCheckout = new TelaCheckout(listaCategorias, listaProdutos,
					listaClientesPF, listaClientesPJ, listaPedidos, novoUsuario, novoCarrinho);
			telaCheckout.setVisible(true);
		}
	}
}
