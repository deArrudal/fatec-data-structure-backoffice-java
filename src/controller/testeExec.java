package controller;

import linkedlist.model.LinkedList;
import model.ClientePF;

import javax.swing.*;


public class testeExec extends JFrame {
    public static void main(String[] args) {
        LinkedList<ClientePF> listaClientesPF = new LinkedList<>();
        ClientePF teste = new ClientePF("12345678901", "cleyton",
                "rua linda", "088988", "9999999");

        try {
            listaClientesPF.addFirst(teste);
            System.out.println(listaClientesPF.get(0));
            ManterClientePF PF = new ManterClientePF(listaClientesPF);
            //Atulizar

            ClientePF velhoCliente = PF.consultaClientePF("12345678901");
            PF.validarCEP("1234567");
            //Consulta e apresenta os dados

            ClientePF novoCliente = new ClientePF("12345678901", "cleyton dos santos",
                    "rua linda de mais", "088988", "9999999");
            PF.atualizarClientePF(velhoCliente, novoCliente);
            System.out.println(listaClientesPF.get(0));

        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
