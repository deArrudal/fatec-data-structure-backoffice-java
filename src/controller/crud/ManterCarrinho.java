package controller.crud;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Pedido;
import model.Produto;
import queue.model.Queue;
import stack.model.Stack;

public class ManterCarrinho {
    static int cont = 0; //Ver com o Lucas
    Stack<Produto> carrinho;
    String nomeCliente;
    public boolean carrinhoDisponível;
    static double valorTotal;

    public ManterCarrinho() {
        carrinhoDisponível = false;
    }
    
    public void iniciarCarrinho(String nomeCliente) {
    	carrinhoDisponível = true;
    	carrinho = new Stack<Produto>();
        this.nomeCliente = nomeCliente;
    }

    public void inserirCarrinho(Produto produto){
        carrinho.push(produto);
    }

    public void exibirCarrinho(JTable table) throws Exception {
        Stack<Produto> aux = new Stack<>();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        if (model.getRowCount()>0) {
			int tamanho = model.getRowCount()-1;
			for (int i = tamanho;i>=0;i++) {
				model.removeRow(i);
			}
		}
        while(!carrinho.isEmpty()) {
            //System.out.println(carrinho.top());
        	Produto p = carrinho.top();
        	model.addRow(new Object [] {p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto});
            aux.push(carrinho.pop());
        }

        while(!aux.isEmpty()) {
            carrinho.push(aux.pop());
        }
    }

    public void removerItemCarrinho(String nomeProduto) throws Exception {
        boolean isFound = false;
        if(carrinho.isEmpty()) {
            throw new Exception("carrinho vazio");
        }

        //Percorre a pilha, procurando o item a ser removido
        Stack<Produto> aux = new Stack<>();
        while(!carrinho.isEmpty()) {
            if(nomeProduto.equals(carrinho.top().nomeProduto)) {
                carrinho.pop();
                isFound = true;
            }
            else {
            	aux.push(carrinho.pop());
            }
        }
        //Devolve pro carrinho
        while(!aux.isEmpty()) {
            carrinho.push(aux.pop());
        }

        if(!isFound) {
            throw new Exception("Item não encontrado!");
        }
    }

    public void excluirCarrinho() throws Exception {
    	if(carrinho.isEmpty()) {
    		while(!carrinho.isEmpty()) {
                carrinho.pop();
            }
            carrinhoDisponível = false;
    	}
    }

    public void Checkout() throws Exception {
        Queue<Produto> checkOut = new Queue<>();
        StringBuffer itensPedido = new StringBuffer();
        while(!carrinho.isEmpty()) {
            checkOut.insert(carrinho.pop());
        }
        while(!checkOut.isEmpty()) {
            Produto produto = checkOut.remove();
            itensPedido.append(produto.nomeProduto+",").append(produto.valorProduto+",").append(produto.qtdProduto+";");
            System.out.println(produto);
            valorTotal += produto.valorProduto;
        }
        System.out.println("Valor total = " + String.format("%.2f", valorTotal));
        cadastrarCompra(itensPedido);
        cont++;
        carrinhoDisponível = false;
    }

    public Pedido cadastrarCompra(StringBuffer itensPedido){
        Pedido pedido = new Pedido(cont, nomeCliente, itensPedido.toString());
        return pedido;
    }
}
