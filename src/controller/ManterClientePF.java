package controller;

import linkedlist.model.LinkedList;
import model.ClientePF;

import javax.swing.*;

public class ManterClientePF {

    LinkedList<ClientePF> listaClientesPF;

    public ManterClientePF(LinkedList<ClientePF> listaClientesPF) {
        this.listaClientesPF = listaClientesPF;
    }

    public ClientePF consultaClientePF(String cpf) throws Exception {
        boolean isFound = false;
        ClientePF cliente = new ClientePF();
        for (int i = 0; i < listaClientesPF.size(); i++) {
            if (listaClientesPF.get(i).cpfClientePF.equals(cpf)) {
                cliente = listaClientesPF.get(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Cliente não encontrado");
        }
        return cliente;
    }

    public void excluirClientePF(String cpf) throws Exception {
        boolean isFound = false;
        int pos = -1;
        for (int i = 0; i < listaClientesPF.size(); i++) {
            if (listaClientesPF.get(i).cpfClientePF.equals(cpf)) {
                pos = i;
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new Exception("Cliente não encontrado para exclusão");
        }
        listaClientesPF.remove(pos);
        JOptionPane.showMessageDialog(null, "Exclusão Realizada com sucesso!");
    }

    //String cpfClientePF, String nomeClientePF, String enderecoClientePF, String cepClientePF,
    //                                 String telefoneClientePF
    public void inserirClientePF(ClientePF cliente) throws Exception {
        listaClientesPF.addLast(cliente);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }

    public void atualizarClientePF(String cpf) throws Exception {
        ClientePF novoCliente = consultaClientePF(cpf); //Retorna para o front de alguma forma
    }

}
