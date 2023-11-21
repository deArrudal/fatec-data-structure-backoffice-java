package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class MetodosSalvarBD {

    public MetodosSalvarBD() {
        super();
    }

    public String encontrarDiretorio(String tipoOperacao, String modoOperacao) {

        // definir diretorio padrao
        String diretorioPadrao = System.getProperty("user.home") + "/Desktop";
        File diretorioArquivo = new File(diretorioPadrao);

        // definir propriedades do explorador de arquivos
        JFileChooser exploradorArquivo = new JFileChooser();
        exploradorArquivo.setDialogTitle("Explorador de Pastas - " + tipoOperacao + " " + modoOperacao);
        exploradorArquivo.setCurrentDirectory(diretorioArquivo);
        exploradorArquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        exploradorArquivo.setAcceptAllFileFilterUsed(false);

        String caminhoArquivo = "";
        int flagCaminho = exploradorArquivo.showOpenDialog(null);

        if (flagCaminho == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo = exploradorArquivo.getSelectedFile().getAbsolutePath();

        } else {
            JOptionPane.showMessageDialog(null, "Arquivo invalido",
                    "Explorador de Arquivos - " + tipoOperacao + " " + modoOperacao, JOptionPane.ERROR_MESSAGE);
        }

        return caminhoArquivo;
    }

    public void carregarDiretorio(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos, String tipoOperacao, String modoOperacao, String text) {
    }  
}
