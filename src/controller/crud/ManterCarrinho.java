package controller.crud;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import linkedlist.model.LinkedList;
import model.Pedido;
import model.Produto;
import queue.model.Queue;
import stack.model.Stack;

public class ManterCarrinho {

    // declarar variaveis
    LinkedList<Pedido> listaPedidos;
    Stack<Produto> carrinho;

    public boolean carrinhoDisponivel;
    String nomeCliente;
    double valorTotal;

    public ManterCarrinho() {
        carrinhoDisponivel = false;
    }

    public void iniciarCarrinho(String nomeCliente, LinkedList<Pedido> listaPedidos) {
        carrinhoDisponivel = true;
        carrinho = new Stack<Produto>();

        this.nomeCliente = nomeCliente;
        this.listaPedidos = listaPedidos;
    }

    public void inserirCarrinho(Produto produto) {
        carrinho.push(produto);
    }

    public void exibirCarrinho(JTable table) throws Exception {
        Stack<Produto> aux = new Stack<>();

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() > 1) {
            int tamanho = model.getRowCount() - 1;

            for (int i = tamanho; i > 0; i--) {
                model.removeRow(i);
            }
        }

        while (!carrinho.isEmpty()) {
            Produto p = carrinho.top();

            model.addRow(new Object[] { p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto });

            aux.push(carrinho.pop());
        }

        while (!aux.isEmpty()) {
            carrinho.push(aux.pop());
        }
    }

    public void removerItemCarrinho(String nomeProduto) throws Exception {
        boolean isFound = false;

        if (carrinho.isEmpty()) {
            throw new Exception("Carrinho vazio");
        }

        // Percorre a pilha, procurando o item a ser removido
        Stack<Produto> aux = new Stack<>();

        while (!carrinho.isEmpty()) {
            if (nomeProduto.equals(carrinho.top().nomeProduto)) {
                carrinho.pop();
                isFound = true;

            } else {
                aux.push(carrinho.pop());
            }
        }

        // Devolve pro carrinho
        while (!aux.isEmpty()) {
            carrinho.push(aux.pop());
        }

        if (!isFound) {
            throw new Exception("Item nao encontrado");
        }
    }

    public void excluirCarrinho() throws Exception {
        if (carrinho.isEmpty()) {
            while (!carrinho.isEmpty()) {
                carrinho.pop();
            }

            carrinhoDisponivel = false;
        }
    }

    public void CheckoutInicio(JTable table, JLabel lblValorTotal) throws Exception {
        valorTotal = 0;
        Queue<Produto> checkOut = new Queue<>();
        Stack<Produto> aux = new Stack<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        while (!carrinho.isEmpty()) {
            checkOut.insert(carrinho.pop());
        }
        while (!checkOut.isEmpty()) {
            Produto p = checkOut.remove();
            model.addRow(new Object[] { p.idProduto, p.nomeProduto, p.descricaoProduto, p.qtdProduto, p.valorProduto });
            valorTotal += p.valorProduto * p.qtdProduto;
            aux.push(p);
        }

        while (!aux.isEmpty()) {
            carrinho.push(aux.pop());
        }
        lblValorTotal.setText("Valor total = " + String.format("%.2f", valorTotal));
    }

    public void CheckoutFim(LinkedList<Produto>[] listaProdutos, LinkedList<Pedido> listaPedidos) throws Exception {
        Stack<Produto> aux = new Stack<>();
        StringBuffer itensPedido = new StringBuffer();
        ManterProduto mp = new ManterProduto(listaProdutos);
        while (!carrinho.isEmpty()) {
            aux.push(carrinho.pop());
        }
        while (!aux.isEmpty()) {
            Produto p = aux.pop();
            itensPedido.append(p.nomeProduto + ",").append(p.valorProduto + ",").append(p.qtdProduto + ";");
            Produto q = mp.consultaProduto(p.nomeProduto);
            Produto r = q;
            r.qtdProduto = q.qtdProduto - p.qtdProduto;
            mp.atualizarProduto(q, r);
        }
        cadastrarCompra(itensPedido);
        carrinhoDisponivel = false;
    }

    public Pedido cadastrarCompra(StringBuffer itensPedido) throws Exception {
        Pedido pedido = new Pedido(listaPedidos.size() + 1, nomeCliente, itensPedido.toString());
        listaPedidos.addLast(pedido);

        return pedido;
    }
}
