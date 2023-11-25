package view;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class Principal {
	public LinkedList<ClientePF> listaClientePF = new LinkedList<>();
	public LinkedList<ClientePJ> listaCLientePJ = new LinkedList<>();
	public LinkedList<Categoria> listaCategoria = new LinkedList<>();
	public LinkedList<Produto>[] tabelaProduto;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//Cria as Listas e tabela vai para a tela da seleção de ambiente
		LinkedList<ClientePF> listaClientePF = new LinkedList<>();
		LinkedList<ClientePJ> listaCLientePJ = new LinkedList<>();
		LinkedList<Categoria> listaCategoria = new LinkedList<>();
		LinkedList<Produto>[] tabelaProduto = new LinkedList[50];
		LinkedList<Pedido> listaPedidos = new LinkedList<>();
		int tamanho = tabelaProduto.length;
		for (int i = 0; i<tamanho;i++) {
			tabelaProduto[i] = new LinkedList<Produto>();
		}
		TelaAmbiente t = new TelaAmbiente(listaClientePF, listaCLientePJ, tabelaProduto, listaCategoria, listaPedidos);
		t.setVisible(true);
		
	}

}
