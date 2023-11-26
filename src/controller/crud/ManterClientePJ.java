package controller.crud;

import linkedlist.model.LinkedList;
import model.ClientePJ;

import javax.swing.*;

public class ManterClientePJ {

    LinkedList<ClientePJ> listaClientesPJ;

    public ManterClientePJ(LinkedList<ClientePJ> listaClientesPJ) {
        this.listaClientesPJ = listaClientesPJ;
    }

    public ClientePJ consultaClientePJ(String cnpj) throws Exception {
        boolean isFound = false;
        ClientePJ cliente = new ClientePJ();
        for (int i = 0; i < listaClientesPJ.size(); i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(cnpj)) {
                cliente = listaClientesPJ.get(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            return cliente = null;
        }
        return cliente;
    }

    public ClientePJ consultaClientePJNome(String nomeCliente) throws Exception {
        boolean isFound = false;
        ClientePJ cliente = new ClientePJ();
        for (int i = 0; i < listaClientesPJ.size(); i++) {
            if (listaClientesPJ.get(i).nomeClientePJ.equals(nomeCliente)) {
                cliente = listaClientesPJ.get(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            return cliente = null;
        }
        return cliente;
    }

    public void excluirClientePJ(String cnpj) throws Exception {
        boolean vali = validarCNPJ(cnpj);
        if (vali == true) {
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

    }

    public boolean validarCNPJ(String cnpj) throws Exception {
        long cnpjNovo = Long.parseLong(cnpj);
        int qtd = validarDigitos(cnpjNovo, 0);
        if (qtd != 14) {
            return false;
        }
        return true;
    }

    private int validarDigitos(long num, int qtd) {
        if (num == 0) {
            return qtd;
        }
        qtd += 1;
        num /= 10;
        return validarDigitos(num, qtd);
    }

    public void inserirClientePJ(ClientePJ cliente) throws Exception {
        boolean vali = validarCNPJ(cliente.cnpjClientePJ);
        if (vali == true) {
            listaClientesPJ.addLast(cliente);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
        }

    }

    public void atualizarClientePJ(ClientePJ antigoCliente, ClientePJ novoCliente) throws Exception {
        boolean vali = validarCNPJ(novoCliente.cnpjClientePJ);
        if (vali == true) {
            int pos = encontrarPosicao(antigoCliente);
            listaClientesPJ.remove(pos);
            listaClientesPJ.add(novoCliente, pos);
        }

    }

    private int encontrarPosicao(ClientePJ antigoCliente) throws Exception {
        int pos = -1;
        for (int i = 0; i < listaClientesPJ.size(); i++) {
            if (listaClientesPJ.get(i).cnpjClientePJ.equals(antigoCliente.cnpjClientePJ)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public void validarCEP(String cep) throws Exception {
        long cepNovo = Long.parseLong(cep);
        int qtdDigitos = validarDigitos(cepNovo, 0);
        if (qtdDigitos != 8) {
            throw new Exception("CEP inválido!");
        }
    }
}
