package controller;

import linkedlist.model.LinkedList;
import model.Categoria;

import javax.swing.*;

public class ManterCategoria {

    LinkedList<Categoria> listaCategorias;

    public ManterCategoria(LinkedList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public String consultaCategoria(String categoria) throws Exception {
        boolean isFound = false;
        Categoria aux = new Categoria();
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).nomeCategoria.equals(categoria)) {
                aux = listaCategorias.get(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            return "Categoria não encontrada!";
        } else {
            return aux.toString();
        }
    }

    public void excluirCategoria(String categoria) throws Exception {
        boolean isFound = false;
        int pos = -1;
        for (int i = 0; i < listaCategorias.size(); i++) {
            if (listaCategorias.get(i).nomeCategoria.equals(categoria)) {
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
        listaCategorias.addLast(categoria);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }
}
