package model;

public class ClientePJ {
    public String cnpjClientePJ; // ex.: 11223344556677
    public String nomeClientePJ; // ex.: mirian doces s.a.
    public String enderecoClientePJ; // ex.: jardim das rosas, 45, bairro alegre, sp
    public String cepClientePJ; // ex.: 04875146
    public String telefoneClientePJ; // ex.: 11947528422
    public String emailClientePJ; // ex.: miriandoces@mail.com

    public ClientePJ(String cnpjClientePJ, String nomeClientePJ, String enderecoClientePJ,
                     String cepClientePJ, String telefoneClientePJ, String emailClientePJ) {
        this.cnpjClientePJ = cnpjClientePJ;
        this.nomeClientePJ = nomeClientePJ;
        this.enderecoClientePJ = enderecoClientePJ;
        this.cepClientePJ = cepClientePJ;
        this.telefoneClientePJ = telefoneClientePJ;
        this.emailClientePJ = emailClientePJ;
    }
    public ClientePJ() {
        super();
    }
    @Override
    public String toString() {
        return cnpjClientePJ + ";" + nomeClientePJ + ";" + enderecoClientePJ + ";" + cepClientePJ + ";" +
                telefoneClientePJ + ";" + emailClientePJ;
    }
}
