package model;

public class Pedidos {
    int idPedido; // ex.: 001
    String nomeCliente; // ex.: cleiton sapatos
    String itensPedido; // ex.: {"sabao,1.00,3";"arroz,15.42,1";"leite,4.89,2"}

    public Pedidos(int idPedido, String nomeCliente, String itensPedido) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.itensPedido = itensPedido;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return idPedido + ";" + nomeCliente + ";" + itensPedido;
    }
}
