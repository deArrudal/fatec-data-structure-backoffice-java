package controller;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;

import javax.swing.*;

public class ManterClienteCPF {
    LinkedList<ClientePF> listaClientesPF;

    public ManterClienteCPF(LinkedList<ClientePF> listaClientesPF) {
        this.listaClientesPF = listaClientesPF;
    }

    public String consultaClientePF(String cpf) throws Exception {
        int tam = listaClientesPF.size();
        ClientePF aux = new ClientePF();
        for (int i = 0; i < tam; i++) {
            if (listaClientesPF.get(i).cpfClientePF.equals(cpf)) {
                aux = listaClientesPF.get(i);
                break;
            }
        }
        if (aux == null) {
            return "Cliente não encontrado!";
        } else {
            return aux.toString();
        }
    }

    public void excluirClientePF(String cpf) throws Exception {
        int tam = listaClientesPF.size();
        int aux = -1;
        for (int i = 0; i < tam; i++) {
            if (listaClientesPF.get(i).cpfClientePF.equals(cpf)) {
                aux = i;
                break;
            }
        }
        if (aux == -1) {
            JOptionPane.showMessageDialog(null,"Cliente não encontrado para exclusão");
        } else {
            listaClientesPF.remove(aux);
        }
    }

    public void inserirClientePF(String cpfClientePF, String nomeClientePF, String enderecoClientePF, String cepClientePF, String telefoneClientePF) throws Exception {
        ClientePF aux = new ClientePF(cpfClientePF,nomeClientePF,enderecoClientePF,cepClientePF,telefoneClientePF);
        if (listaClientesPF.isEmpty()) {
            listaClientesPF.addFirst(aux);
        }else {
            listaClientesPF.addLast(aux);
        }
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }
    
}
