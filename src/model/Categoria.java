package model;

public class Categoria {
    int idCategoria; // ex.: 01
    String nomeCategoria; // ex.: bens de consumo

    public Categoria(int idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return idCategoria + ";" + nomeCategoria;
    }
}