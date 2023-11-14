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
        int tam = listaClientesPF.size();
        ClientePF aux = new ClientePF();
        for (int i = 0; i < tam; i++) {
            if (listaClientesPF.get(i).cpfClientePF.equals(cpf)) {
                aux = listaClientesPF.get(i);
                break;
            }
        }
        if (aux == null) {
            throw new Exception("Cliente não encontrado");
        } else {
            return aux;
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

    public void inserirClientePF(String cpfClientePF, String nomeClientePF, String enderecoClientePF, String cepClientePF,
                                 String telefoneClientePF) throws Exception {
        ClientePF aux = new ClientePF(cpfClientePF,nomeClientePF,enderecoClientePF,cepClientePF,telefoneClientePF);
        if (listaClientesPF.isEmpty()) {
            listaClientesPF.addFirst(aux);
        }else {
            listaClientesPF.addLast(aux);
        }
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    }

    public void atualizarClientePF(String cpf) throws Exception {
        ClientePF novoCliente = consultaClientePF(cpf); //Retorna para o front de alguma forma

    }

}
