package view;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Produto;

public class Principal {
	public LinkedList<ClientePF> listaClientePF = new LinkedList<>();
	public LinkedList<ClientePJ> listaCLientePJ = new LinkedList<>();
	public LinkedList<Categoria> listaCategoria = new LinkedList<>();
	public LinkedList<Produto>[] tabelaProduto;
	
	public static void main(String[] args) {
		LinkedList<ClientePF> listaClientePF = new LinkedList<>();
		LinkedList<ClientePJ> listaCLientePJ = new LinkedList<>();
		LinkedList<Categoria> listaCategoria = new LinkedList<>();
		LinkedList<Produto>[] tabelaProduto = null;
		TelaHome t = new TelaHome(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria);
		t.setVisible(true);

	}

}
