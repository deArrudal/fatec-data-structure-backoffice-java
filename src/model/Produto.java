package model;

public class Produto {
    int idProduto; // ex.: 01
    int idProdutoCategoria; // ex.: 01
    String nomeProduto; // ex.: grampeador
    String descricaoProduto; // ex.: 400g, 13x5x6 cm, azul
    int qtdProduto; // ex.: 12
    double valorProduto; // ex.: 19.99

    public Produto(int idProduto, int idProdutoCategoria, String nomeProduto, String descricaoProduto, int qtdProduto,
                   double valorProduto) {
        this.idProduto = idProduto;
        this.idProdutoCategoria = idProdutoCategoria;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.qtdProduto = qtdProduto;
        this.valorProduto = valorProduto;
    }

    @Override
    public String toString() {
        return idProduto + ";" + idProdutoCategoria + ";" + nomeProduto  + ";" + descricaoProduto  + ";" +
                qtdProduto  + ";" + valorProduto  + ";";
    }
}
