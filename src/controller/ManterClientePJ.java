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
        int tam = listaClientesPJ.size();
        ClientePJ aux = new ClientePJ();
        for (int i = 0; i < tam; i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(cnpj)) {
                aux = listaClientesPJ.get(i);
                break;
            }
        }
        if (aux == null) {
            return "Cliente não encontrado!";
        } else {
            return aux.toString();
        }
    }

    public void excluirClientePJ(String cnpj) throws Exception {
        int tam = listaClientesPJ.size();
        int aux = -1;
        for (int i = 0; i < tam; i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(cnpj)) {
                aux = i;
                break;
            }
        }
        if (aux == -1) {
            JOptionPane.showMessageDialog(null,"Cliente não encontrado para exclusão");
        } else {
            listaClientesPJ.remove(aux);
        }
    }

    public void inserirClientePJ(String cnpjClientePJ, String nomeClientePJ, String enderecoClientePJ,
                                 String cepClientePJ, String telefoneClientePJ, String emailClientePJ) throws Exception {
        ClientePJ aux = new ClientePJ(cnpjClientePJ, nomeClientePJ, enderecoClientePJ, cepClientePJ, telefoneClientePJ, emailClientePJ);
        if (listaClientesPJ.isEmpty()) {
            listaClientesPJ.addFirst(aux);
        }else {
            listaClientesPJ.addLast(aux);
        }
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }
}
