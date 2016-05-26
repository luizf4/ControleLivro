package br.metodista.ads.telas;

import br.metodista.ads.dao.LivroDAO;
import br.metodista.ads.modelos.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class LivroTableModel extends AbstractTableModel {

    private List<Livro> livros = new ArrayList<Livro>();
    LivroDAO dao = new LivroDAO();

    public LivroTableModel() {

        try {
            livros = dao.consultar();
        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    @Override
    public int getRowCount() {

        return livros.size();

    }

    @Override
    public int getColumnCount() {

        return 6;

    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Livro livr = livros.get(linha);

        switch (coluna) {

            case 0:
                return livr.getId();
            case 1:
                return livr.getTitulo();
            case 2:
                return livr.getAutor();
            case 3:
                return livr.getIsbn();
            case 4:
                return livr.getPaginas();
            case 5:
                return livr.getEdicao();
            default:

                return "";

        }

    }

    @Override
    public String getColumnName(int coluna) {

        switch (coluna) {

            case 0:
                return "ID";
            case 1:
                return "Título";
            case 2:
                return "Autor";
            case 3:
                return "ISBN";
            case 4:
                return "Páginas";
            case 5:
                return "Edição";
            default:

                return "";

        }

    }

    public Livro getLivros(int linha) {

        return livros.get(linha);

    }

    public boolean adicionar(Livro l, int posicao) throws Exception {

        l = dao.salvar(l);
        if (l != null) {
            if (posicao == -1) {

                livros.add(l);
                fireTableRowsInserted(livros.size() - 1, livros.size() - 1);

            } else {

                livros.set(posicao, l);
                fireTableRowsInserted(livros.size() - 1, livros.size() - 1);
                fireTableDataChanged();

            }

            return true;
            
        } else {
            
            return false;
            
        }

    }

    public boolean remover(Livro l) throws Exception {

        boolean retorno = false;

        if (dao.remover(l) == 1) {

            livros.remove(l);
            fireTableRowsInserted(livros.size() - 1, livros.size() - 1);

            return retorno = true;

        } else {

            return false;

        }

    }

}
