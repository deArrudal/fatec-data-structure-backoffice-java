package model;

public class Produto {
    public int idProduto; // ex.: 01
    public int idProdutoCategoria; // ex.: 01
    public String nomeProduto; // ex.: grampeador
    public String descricaoProduto; // ex.: 400g, 13x5x6 cm, azul
    public int qtdProduto; // ex.: 12
    public double valorProduto; // ex.: 19.99

    public Produto(int idProduto, int idProdutoCategoria, String nomeProduto, String descricaoProduto, int qtdProduto,
                   double valorProduto) {
        this.idProduto = idProduto;
        this.idProdutoCategoria = idProdutoCategoria;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto;
    }

    public Produto() {
        super();
    }

    @Override
    public String toString() {
        return idProduto + ";" + idProdutoCategoria + ";" + nomeProduto + ";" + descricaoProduto + ";" +
                qtdProduto + ";" + valorProduto + ";";
    }
}
