package controller;

import linkedlist.model.LinkedList;
import model.ClientePF;
import model.ClientePJ;

public class ManterClienteCNPJ {
    LinkedList<ClientePJ> listaClientesPJ;
    public ManterClienteCNPJ(LinkedList<ClientePJ> listaClientesPJ) {
        this.listaClientesPJ = listaClientesPJ;
    }
    public String consultaClientePJ(String cnpj) throws Exception {
        int tam = listaClientesPJ.size();
        ClientePJ aux = new ClientePJ();
        for (int i = 0; i < tam; i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(cnpj)) {
                aux = listaClientesPJ.get(i);
            }
        }
        if (aux == null) {
            return "Cliente não encontrado!";
        } else {
            return aux.toString();
        }
    }
}
