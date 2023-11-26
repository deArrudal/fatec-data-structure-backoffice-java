package model;

public class Pedido {

    public int idPedido; // ex.: 001
    public String nomeCliente; // ex.: cleiton sapatos
    public String itensPedido; // ex.: {"sabao,1.00,3";"arroz,15.42,1";"leite,4.89,2"}

    public Pedido() {
        super();
    }

    public Pedido(int idPedido, String nomeCliente, String itensPedido) {

        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return idPedido + ";" + nomeCliente + ";" + itensPedido;
    }
}
