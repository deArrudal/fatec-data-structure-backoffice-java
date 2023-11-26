package controller.crud;

import linkedlist.model.LinkedList;
import model.ClientePF;
import javax.swing.JOptionPane;

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
    
    public ClientePF consultaClientePFNome(String nomeCliente) throws Exception {
        boolean isFound = false;
        ClientePF cliente = new ClientePF();
        for (int i = 0; i < listaClientesPF.size(); i++) {
            if (listaClientesPF.get(i).nomeClientePF.equals(nomeCliente)) {
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
    	boolean vali = validarCPF(cpf);
    	if (vali == true) {
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
        
    }

    private boolean validarCPF(String cpf) throws Exception {
        long cpfNovo = Long.parseLong(cpf);
        int qtdDigitos = validarDigitos(cpfNovo, 0);
        if (qtdDigitos != 11) {
        	return false;
           
        }
        return true;
    }

    //String cpfClientePF, String nomeClientePF, String enderecoClientePF, String cepClientePF,
    //String telefoneClientePF
    public void inserirClientePF(ClientePF cliente) throws Exception {
    	boolean vali = validarCPF(cliente.cpfClientePF);
    	if (vali == true) {
    		 listaClientesPF.addLast(cliente);
    	        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
    	}
       
    }

    public void atualizarClientePF(ClientePF antigoCliente, ClientePF novoCliente) throws Exception {
    	boolean vali = validarCPF(novoCliente.cpfClientePF);
    	if (vali == true) {
    	       int pos = encontrarPosicao(antigoCliente);
    	        listaClientesPF.remove(pos);
    	        listaClientesPF.add(novoCliente, pos);
    	} 
 
    }

    private int encontrarPosicao(ClientePF antigoCliente) throws Exception {
        int pos = -1;
        for (int i = 0; i < listaClientesPF.size(); i++) {
            if (listaClientesPF.get(i).cpfClientePF.equals(antigoCliente.cpfClientePF)) {
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

    private int validarDigitos(long num, int qtd) {
        if (num == 0) {
            return qtd;
        }
        qtd += 1;
        num /= 10;
        return validarDigitos(num, qtd);
    }

    /*
     * Notas: O Update ta seperado em 3 etapas:
     * 1- Primeiramente, será utilizado o consulta normal (que está fora do método "atualizaCliente") que ira retornar os dados do cliente
     * que será armazenado numa variável do tipo Cliente temporária, e enviar dados para a tela.
     * 2- Em seguida, após o backoffice atualizar todos os campos e confirmar a atualização irá chamar a função "atualizarCliente"
     * e irá passar como paramêtro os novos dados atualizados e os antigo que ainda estarão armazenados na variável temporária do tipo
     * Cliente
     * 3- Depois disso, dnetro da função "atualizarCliente" do tipo void, irá chamar uma função para encontrar a posição exata do cliente
     * que terá seus dados atualizados, após isso, ele remove o antigo e insere o novo na exata mesma posição da lista.
     */
}
