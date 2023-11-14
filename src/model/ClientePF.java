package model;

public class ClientePF {
    public String cpfClientePF; // ex.: 12345678900
    public String nomeClientePF; // ex.: jose da silva
    public String enderecoClientePF; // ex.: rua da liberdade, 68, liberdade, sp
    public String cepClientePF; // ex.: 01234567
    public String telefoneClientePF; // ex.: 11012345678

    public ClientePF(String cpfClientePF, String nomeClientePF,
                     String enderecoClientePF, String cepClientePF, String telefoneClientePF) {
        this.cpfClientePF = cpfClientePF;
        this.nomeClientePF = nomeClientePF;
        this.enderecoClientePF = enderecoClientePF;
        this.cepClientePF = cepClientePF;
        this.telefoneClientePF = telefoneClientePF;
    }
    public ClientePF() {
        super();
    }
    @Override
    public String toString() {
        return cpfClientePF + ";" + nomeClientePF + ";" + enderecoClientePF + ";" + cepClientePF + ";" + telefoneClientePF;
    }
}
