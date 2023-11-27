package view.telascrud.telasconsulta;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import linkedlist.model.LinkedList;
import model.Categoria;
import model.ClientePF;
import model.ClientePJ;
import model.Pedido;
import model.Produto;

public class TelaConsultaProdCat extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public TelaConsultaProdCat(LinkedList<Categoria> listaCategorias, LinkedList<Produto>[] listaProdutos,
            LinkedList<ClientePF> listaClientesPF, LinkedList<ClientePJ> listaClientesPJ,
            LinkedList<Pedido> listaPedidos) {

        setTitle("BackOffice - Consulta Categorias/Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 600);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        int tamanho = listaCategorias.size();
        JComboBox<String> cbCategoria = new JComboBox<String>();
        cbCategoria.setBounds(110, 50, 217, 23);
        contentPane.add(cbCategoria);
        cbCategoria.addItem("Todos os Produtos");

        for (int i = 0; i < tamanho; i++) {
            Categoria l;
            try {
                l = listaCategorias.get(i);
                if (l.nomeCategoria != null) {
                    cbCategoria.addItem(String.valueOf(l.idCategoria) + " - " + l.nomeCategoria);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Erro consulta",
                        "BackOffice - Consulta Categorias/Produtos", JOptionPane.ERROR_MESSAGE);
            }
        }

        JLabel lblProdCat = new JLabel("Produtos por Categoria");
        lblProdCat.setHorizontalAlignment(SwingConstants.CENTER);
        lblProdCat.setFont(new Font("Serif", Font.BOLD, 16));
        lblProdCat.setBounds(10, 20, 664, 23);
        contentPane.add(lblProdCat);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(31, 50, 69, 23);
        contentPane.add(lblCategoria);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(561, 520, 89, 23);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaConsulta t = new TelaConsulta(listaCategorias, listaProdutos, listaClientesPF, listaClientesPJ,
                        listaPedidos);
                t.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVoltar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 85, 620, 421);
        contentPane.add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        formataTA(textArea, cbCategoria, listaCategorias, listaProdutos);

        // Quando um item do combobox é clicado, a area atualiza
        PopupMenuListener p = new PopupMenuListener() {
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                formataTA(textArea, cbCategoria, listaCategorias, listaProdutos);
            }

            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        };
        cbCategoria.addPopupMenuListener(p);

    }

    private void formataTA(JTextArea textArea, JComboBox<String> cbCategoria, LinkedList<Categoria> listaCategorias,
            LinkedList<Produto>[] listaProdutos) {
        if (textArea.getText() != "") {
            textArea.setText("");
        }
        String cbCat = cbCategoria.getSelectedItem().toString();

        // Mostra todos os produtos e as categorias
        if (cbCat.equals("Todos os Produtos")) {
            LinkedList<Categoria> lc = listaCategorias;
            int tamanhoC = lc.size();

            for (int i = 0; i < tamanhoC; i++) {
                Categoria c;
                try {
                    c = lc.get(i);

                    textArea.append(c.idCategoria + " - " + c.nomeCategoria + "\n");

                    LinkedList<Produto> lp = listaProdutos[c.idCategoria];
                    int tamanhoLista = lp.size();

                    for (int j = 0; j < tamanhoLista; j++) {
                        Produto p = lp.get(j);
                        textArea.append(p.idProduto + " - " + p.nomeProduto + "\n");

                    }
                    textArea.append("\n");

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Erro consulta",
                            "BackOffice - Consulta Categorias/Produtos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Mostra a categoria em específico
        else {
            String[] div = cbCat.split(" ");
            int cat = Integer.parseInt(div[0]) - 1;
            LinkedList<Categoria> lc = listaCategorias;
            try {
                Categoria c = lc.get(cat);

                textArea.append(c.idCategoria + " - " + c.nomeCategoria + "\n");

                LinkedList<Produto> l = listaProdutos[c.idCategoria];
                int tamanhoLista = l.size();
                for (int j = 0; j < tamanhoLista; j++) {
                    Produto p = l.get(j);
                    textArea.append(p.idProduto + " - " + p.nomeProduto + "\n");
                }

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Erro consulta",
                        "BackOffice - Consulta Categorias/Produtos", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}