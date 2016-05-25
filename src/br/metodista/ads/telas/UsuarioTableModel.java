package br.metodista.ads.telas;

import br.metodista.ads.dao.UsuarioDAO;
import br.metodista.ads.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    UsuarioDAO dao = new UsuarioDAO();

    public UsuarioTableModel() {

        try {

            usuarios = dao.consultar();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {

        return usuarios.size();
    }

    @Override
    public int getColumnCount() {

        return 3;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Usuario user = usuarios.get(linha);

        switch (coluna) {

            case 0:

                return user.getId();

            case 1:

                return user.getNome();

            case 2:

                return user.getLogin();

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

                return "Nome";

            case 2:

                return "Login";

            default:

                return "";

        }
    }

    public boolean adicionar(Usuario u, int posicao) throws Exception {

        u = dao.salvar(u);

        if (u != null) {

            if (posicao == -1) {
                usuarios.add(u);
                fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
                
            } else {
                System.out.println(posicao);
                //usuarios.add(u);
                usuarios.set(posicao, u);
                fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
                fireTableDataChanged();
                //fireTableChanged(null);
            }
            

            return true;
        } else {

            return false;

        }
    }

    public boolean remover(Usuario u) throws Exception {

        boolean retorno = false;

        if (dao.remover(u) == 1) {

            usuarios.remove(u);
            fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);

            return retorno = true;

        } else {

            return false;

        }

    }

    public Usuario getUsuarios(int linha) {

        return usuarios.get(linha);

    }

}
