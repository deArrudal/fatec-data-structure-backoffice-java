package controller.salvarecarregar;

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

public class MetodosCarregarBD {

    public MetodosCarregarBD() {
        super();
    }

    public String encontrarArquivo(String tipoOperacao, String modoOperacao) {

        // definir filtro de arquivos
        FileNameExtensionFilter filtroArquivo = new FileNameExtensionFilter(
                "Arquivos de valores separados por virgula (.csv)", "csv");

        // definir diretorio padrao
        String diretorioPadrao = System.getProperty("user.home") + "/Desktop";
        File diretorioArquivo = new File(diretorioPadrao);

        // definir propriedades do explorador de arquivos
        JFileChooser exploradorArquivo = new JFileChooser();
        exploradorArquivo.setDialogTitle("Explorador de Arquivos - " + tipoOperacao + " " + modoOperacao);
        exploradorArquivo.setCurrentDirectory(diretorioArquivo);
        exploradorArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        exploradorArquivo.setAcceptAllFileFilterUsed(false);
        exploradorArquivo.addChoosableFileFilter(filtroArquivo);

        String caminhoArquivo = "";
        int flagCaminho = exploradorArquivo.showOpenDialog(null);

        // verificar se retorno e valido
        if (flagCaminho == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo = exploradorArquivo.getSelectedFile().getAbsolutePath();

        } else {
            JOptionPane.showMessageDialog(null, "Arquivo invalido",
                    "Explorador de Arquivos - " + tipoOperacao + " " + modoOperacao, JOptionPane.ERROR_MESSAGE);
        }

        return caminhoArquivo;
    }

    public void carregarArquivo(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos, String tipoOperacao, String modoOperacao,
            String caminhoArquivo) {

        MetodosLerArquivo metodos = new MetodosLerArquivo();

        // caso caminho arquivo retorne vazio, imprimir mensagem de erro
        if (caminhoArquivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Arquivo invalido",
                    "Explorador de Arquivos - " + tipoOperacao + " " + modoOperacao, JOptionPane.ERROR_MESSAGE);
                    return;
        }

        try {
            // realizar chamada do metodo de leitura do arquivo
            switch (modoOperacao) {
                case "categorias":
                    metodos.lerCategoria(listaCategorias, caminhoArquivo);
                    break;
                case "produtos":
                    metodos.lerProduto(listaCategorias, listaProdutos, caminhoArquivo);
                    break;
                case "clientesPF":
                    metodos.lerClientePF(listaClientesPF, caminhoArquivo);
                    break;
                case "clientesPJ":
                    metodos.lerClientePJ(listaClientesPJ, caminhoArquivo);
                    break;
            }

            JOptionPane.showMessageDialog(null, "Carregamento bem-sucedido",
                    tipoOperacao + " " + modoOperacao, JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Operacao invalida",
                    "Explorador de Arquivos - " + tipoOperacao + " " + modoOperacao, JOptionPane.ERROR_MESSAGE);
        }
    }
}
