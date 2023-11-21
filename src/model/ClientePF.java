package model;

public class ClientePF {

    String cpfClientePF; // ex.: 12345678900
    String nomeClientePF; // ex.: jose da silva
    String enderecoClientePF; // ex.: rua da liberdade, 68, liberdade, sp
    String cepClientePF; // ex.: 01234567
    String telefoneClientePF; // ex.: 11012345678

    public ClientePF(String cpfClientePF, String nomeClientePF,
            String enderecoClientePF, String cepClientePF, String telefoneClientePF) {
                
        this.cpfClientePF = cpfClientePF;
        this.nomeClientePF = nomeClientePF;
        this.enderecoClientePF = enderecoClientePF;
        this.cepClientePF = cepClientePF;
        this.telefoneClientePF = telefoneClientePF;
    }
}
