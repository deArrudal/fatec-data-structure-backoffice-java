package controller;

import linkedlist.model.LinkedList;
import model.ClientePJ;

import javax.swing.*;

public class ManterClientePJ {

    LinkedList<ClientePJ> listaClientesPJ;

    public ManterClientePJ(LinkedList<ClientePJ> listaClientesPJ) {
        this.listaClientesPJ = listaClientesPJ;
    }

    public String consultaClientePJ(String cnpj) throws Exception {
        boolean isFound = false;
        ClientePJ aux = new ClientePJ();
        for (int i = 0; i < listaClientesPJ.size(); i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(cnpj)) {
                aux = listaClientesPJ.get(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Cliente não encontrado!");
        }
        return aux.toString();
    }

    public void excluirClientePJ(String cnpj) throws Exception {
        boolean isFound = false;
        int pos = -1;
        for (int i = 0; i < listaClientesPJ.size(); i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(cnpj)) {
                pos = i;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Cliente não encontrado para exclusão!");
        }
        listaClientesPJ.remove(pos);
    }

    //String cnpjClientePJ, String nomeClientePJ, String enderecoClientePJ,
    //                                 String cepClientePJ, String telefoneClientePJ, String emailClientePJ
    public void inserirClientePJ(ClientePJ cliente) throws Exception {
        listaClientesPJ.addLast(cliente);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }
}
