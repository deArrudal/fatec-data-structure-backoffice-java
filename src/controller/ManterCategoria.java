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
        int tam = listaCategorias.size();
        Categoria aux = new Categoria();
        for(int i = 0; i < tam; i++) {
            if(listaCategorias.get(i).nomeCategoria.equals(categoria)) {
                aux = listaCategorias.get(i);
            }
        }
        if(aux == null) {
            return "Categoria não encontrada!";
        }else {
            return aux.toString();
        }
    }

    public void excluirCategoria(String categoria) throws Exception {
        int tam = listaCategorias.size();
        int aux = -1;
        for (int i = 0; i < tam; i++) {
            if (listaCategorias.get(i).nomeCategoria.equals(categoria)) {
                aux = i;
                break;
            }
        }
        if (aux == -1) {
            JOptionPane.showMessageDialog(null,"Cliente não encontrado para exclusão");
        } else {
            listaCategorias.remove(aux);
        }
    }

    public void inserirCategoria(int idCategoria, String nomeCategoria) throws Exception {
        Categoria aux = new Categoria(idCategoria, nomeCategoria);
        if (listaCategorias.isEmpty()) {
            listaCategorias.addFirst(aux);
        }else {
            listaCategorias.addLast(aux);
        }
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
        //git
    }
}
