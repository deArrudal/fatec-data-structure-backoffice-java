package model;

public class ClientePJ {

    String cnpjClientePJ; // ex.: 11223344556677
    String nomeClientePJ; // ex.: mirian doces s.a.
    String enderecoClientePJ; // ex.: jardim das rosas, 45, bairro alegre, sp
    String cepClientePJ; // ex.: 04875146
    String telefoneClientePJ; // ex.: 11947528422
    String emailClientePJ; // ex.: miriandoces@mail.com

    public ClientePJ(String cnpjClientePJ, String nomeClientePJ, String enderecoClientePJ,
            String cepClientePJ, String telefoneClientePJ, String emailClientePJ) {
                
        this.cnpjClientePJ = cnpjClientePJ;
        this.nomeClientePJ = nomeClientePJ;
        this.enderecoClientePJ = enderecoClientePJ;
        this.cepClientePJ = cepClientePJ;
        this.telefoneClientePJ = telefoneClientePJ;
        this.emailClientePJ = emailClientePJ;
    }
}
