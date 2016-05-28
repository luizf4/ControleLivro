package br.metodista.ads.telas;

import br.metodista.ads.dao.EmprestimoDAO;
import br.metodista.ads.modelos.Emprestimo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class EmprestimoTableModel extends AbstractTableModel {

    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    EmprestimoDAO dao = new EmprestimoDAO();

    public EmprestimoTableModel() {

        try {

            emprestimos = dao.consultar();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {

        return emprestimos.size();
    }

    @Override
    public int getColumnCount() {

        return 7;

    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Emprestimo e = emprestimos.get(linha);

        switch (coluna) {

            case 0:

                return e.getLivro().getTitulo();

            case 1:

                return e.getLivro().getAutor();

            case 2:

                return e.getLivro().getIsbn();

            case 3:

                return e.getLivro().getPaginas();

            case 4:

                return e.getLivro().getEdicao();

            case 5:

                return e.getUsuario().getLogin();

            case 6:
                
                if(e.getLivro().getEmprestado() == 0){
                    
                    return "Não";
                }else{
                    
                    return "Sim";
                    
                }
                
                //return e.getLivro().getEmprestado();

            default:

                return "";

        }

    }

    @Override
    public String getColumnName(int coluna) {

        switch (coluna) {

            case 0:

                return "Titulo";

            case 1:

                return "Autor";

            case 2:

                return "ISBN";

            case 3:

                return "Páginas";

            case 4:

                return "Edição";

            case 5:

                return "Login";

            case 6:

                return "Emprestado?";

            default:

                return "";

        }
    }

    public Emprestimo getEmprestimos(int linha) {

        return emprestimos.get(linha);

    }
    
    public void emprestar(Emprestimo e, int posicao) throws Exception{
        
        e = dao.emprestar(e);        
        //System.out.println(e);
        emprestimos = dao.consultar();        
        fireTableRowsInserted(emprestimos.size() - 1, emprestimos.size() - 1);
        fireTableDataChanged();
               
        
    }
    
    public void devolver(Emprestimo e) throws Exception{
        
        e = dao.devolver(e);
        emprestimos = dao.consultar();        
        fireTableRowsInserted(emprestimos.size() - 1, emprestimos.size() - 1);
        fireTableDataChanged();
        
        
    }

}
