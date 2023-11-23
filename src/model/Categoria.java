package model;

public class Categoria {

    public int idCategoria; // ex.: 01
    public String nomeCategoria; // ex.: bens de consumo

    public Categoria() {
        super();
    }

    public Categoria(int idCategoria, String nomeCategoria) {

        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public String toString() {
        return idCategoria + ";" + nomeCategoria;
    }
}