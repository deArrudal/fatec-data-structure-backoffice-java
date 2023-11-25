package controller;

import java.rmi.server.ExportException;

import javax.swing.JOptionPane;

import linkedlist.model.LinkedList;
import model.ClientePF;
import model.ClientePJ;

public class MetodosLogin {

    String senhaAdministrador = "0000";

    public MetodosLogin() {
        super();
    }

    // realizar login modo Administrador
    public void loginAdministrador() throws Exception {
        String senha = JOptionPane.showInputDialog(null, "Insira senha de administrador:",
                "BackOffice - Login", JOptionPane.INFORMATION_MESSAGE);
        if (!senha.equals(senhaAdministrador)) {
            throw new ExportException("Senha invalida");
        }
    }

    // realizar login modo Usuario
    public String loginUsuario(LinkedList<ClientePF> listaClientesPF,
            LinkedList<ClientePJ> listaClientesPJ) throws Exception {

        // definir tipo de busca
        String[] tipoCliente = { "Pessoa Fisica", "Pessoa Juridica" };
        String tipo = (String) JOptionPane.showInputDialog(null, "Defina tipo de usuario",
                "BackOffice - Realizar Compras", JOptionPane.PLAIN_MESSAGE, null, tipoCliente,
                "Pessoa Fisica");

        switch (tipo) {
            case "Pessoa Fisica":
                // instacia metodo de consulta
                ManterClientePF consultaPF = new ManterClientePF(listaClientesPF);

                // ler cpf
                String CPF = JOptionPane.showInputDialog(null, "Insira CPF",
                        "BackOffice - Realizar Compras", JOptionPane.INFORMATION_MESSAGE);

                ClientePF clientePF = consultaPF.consultaClientePF(CPF);

                if (clientePF == null) {
                    throw new Exception("Usuario nao encontrado");
                }

                return clientePF.nomeClientePF;

            case "Pessoa Juridica":
                // instacia metodo de consulta
                ManterClientePJ consultaPJ = new ManterClientePJ(listaClientesPJ);

                // ler cnpj
                String CNPJ = JOptionPane.showInputDialog(null, "Insira CNPJ",
                        "BackOffice - Realizar Compras", JOptionPane.INFORMATION_MESSAGE);

                ClientePJ clientePJ = consultaPJ.consultaClientePJ(CNPJ);

                if (clientePJ == null) {
                    throw new Exception("Usuario nao encontrado");
                }

                return clientePJ.nomeClientePJ;
        }

        throw new ExportException("Usuario nao encontrado");
    }
}
