package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MetodosCarregarBD {
    public String encontrarArquivo(String tipoOperacao) {
        // definir filtro de arquivos
        FileNameExtensionFilter filtroArquivo = new FileNameExtensionFilter(
                "Arquivos de valores separados por virgula (.csv)", "csv");

        // definir diretorio padrao
        String diretorioPadrao = System.getProperty("user.home") + "/Desktop";
        File diretorioArquivo = new File(diretorioPadrao);

        // definir propriedades do explorador de arquivos
        JFileChooser exploradorArquivo = new JFileChooser();
        exploradorArquivo.setDialogTitle("Explorador de Arquivos - " + tipoOperacao);
        exploradorArquivo.setCurrentDirectory(diretorioArquivo);
        exploradorArquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        exploradorArquivo.setAcceptAllFileFilterUsed(false);
        exploradorArquivo.addChoosableFileFilter(filtroArquivo);

        String caminhoArquivo = "";
        int flagCaminho = exploradorArquivo.showOpenDialog(null);

        if (flagCaminho == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo = exploradorArquivo.getSelectedFile().getAbsolutePath();

        } else {
            JOptionPane.showMessageDialog(null, "Arquivo invalido",
                    "Explorador de Arquivos - " + tipoOperacao, JOptionPane.ERROR_MESSAGE);
        }

        return caminhoArquivo;
    }

    public void carregarArquivo(String caminhoArquivo, String  tipoOperacao) {
        if (caminhoArquivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Arquivo invalido",
                    "Explorador de Arquivos - " + tipoOperacao, JOptionPane.ERROR_MESSAGE);
        }

        try {
            String cmdExe = "cmd /c start cmd.exe /C\"" + caminhoArquivo + "\"";
            Runtime.getRuntime().exec(cmdExe);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arquivo invalido",
                    "Explorador de Arquivos - " + tipoOperacao, JOptionPane.ERROR_MESSAGE);
        }
    }
}
