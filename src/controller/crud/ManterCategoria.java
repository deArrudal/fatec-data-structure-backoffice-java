package controller.crud;

import linkedlist.model.LinkedList;
import model.Categoria;

import javax.swing.*;

public class ManterCategoria {

    LinkedList<Categoria> listaCategorias;

    public ManterCategoria(LinkedList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Categoria consultaCategoria(String nomeCategoria) throws Exception {
        boolean isFound = false;
        Categoria categoria = new Categoria();
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).nomeCategoria.equals(nomeCategoria.toLowerCase())) {
                categoria = listaCategorias.get(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Categoria não encontrada!");
        }
        return categoria;
    }

    public void excluirCategoria(String nomeCategoria) throws Exception {
        boolean isFound = false;
        int pos = -1;
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).nomeCategoria.equals(nomeCategoria.toLowerCase())) {
                pos = i;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Categoria não encontrado para exclusão");
        }
        listaCategorias.remove(pos);
    }

    //int idCategoria, String nomeCategoria)
    public void inserirCategoria(Categoria categoria) throws Exception {
        //Tratamento de LowerCase antes de passar pelo parâmetro da função
        listaCategorias.addLast(categoria);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }

    public void atualizarCategoria(Categoria antigaCategoria, Categoria novaCategoria) throws Exception {
        int pos = encontrarPosicao(antigaCategoria);
        listaCategorias.remove(pos);
        listaCategorias.add(novaCategoria, pos);
    }

    private int encontrarPosicao(Categoria antigaCategoria) throws Exception {
        int pos = -1;
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).idCategoria == antigaCategoria.idCategoria) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
