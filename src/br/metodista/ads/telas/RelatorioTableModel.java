/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.metodista.ads.telas;

import br.metodista.ads.dao.EmprestimoDAO;
import br.metodista.ads.modelos.Emprestimo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class RelatorioTableModel extends AbstractTableModel {

    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    EmprestimoDAO dao = new EmprestimoDAO();
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public RelatorioTableModel(){

        try {
            emprestimos = dao.consultarDevolvidos();
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

        return 5;

    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        Emprestimo e = emprestimos.get(linha);

        switch (coluna) {

            case 0:

                return e.getId();

            case 1:

                return e.getLivro().getTitulo();

            case 2:

                return e.getUsuario().getLogin();

            case 3:

                return  df.format(e.getDataEmprestimo());

            case 4:

                return df.format(e.getDataDevolucao());

            default:

                return "";

        }

    }

    @Override
    public String getColumnName(int coluna) {

        switch (coluna) {

            case 0:

                return "IDEmprestimo";

            case 1:

                return "Título";

            case 2:

                return "Login";

            case 3:

                return "Data Empréstimo";

            case 4:

                return "Data Devolução";

            default:

                return "";

        }
    }

    public Emprestimo getEmprestimos(int linha) {

        return emprestimos.get(linha);

    }
    
    public void atualizar(){
        
        try {
            emprestimos = dao.consultarDevolvidos();
            fireTableRowsInserted(emprestimos.size() - 1, emprestimos.size() - 1);
            fireTableDataChanged();
            
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        
    }

}
