package br.metodista.ads.dao;

import br.metodista.ads.modelos.Emprestimo;
import br.metodista.ads.modelos.Livro;
import br.metodista.ads.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz Fernando de Souza ADS - EAD Sorocaba Matricula: 225272
 */
public class EmprestimoDAO {
    
    BancoSQL sqlConexao = new BancoSQL();
    
    public List<Emprestimo> consultar() throws Exception {
        
        List<Emprestimo> emprestimos = new ArrayList<>();
        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            
            String consultar = "select  liv.id, liv.titulo, liv.autor, liv.isbn,"
                    + " liv.paginas, liv.edicao,us.ID, us.LOGIN, liv.emprestado"
                    + "  from livro liv"
                    + "  left outer join emprestimo emp"
                    + "  on (liv.ID = emp.IDLIVRO)"
                    + "  left outer join usuario us"
                    + "  on (emp.IDUSUARIO = us.id and emp.DATADEVOLUCAO is null)"
                    + "  order by liv.TITULO";
            
            pstm = conn.prepareStatement(consultar);
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                
                Livro livr = new Livro(rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getInt("paginas"),
                        rs.getInt("edicao"),
                        rs.getInt("emprestado"));
                
                Usuario usuario = new Usuario(rs.getLong("id"), rs.getString("login"));
                Emprestimo e = new Emprestimo(livr, usuario);
                
                emprestimos.add(e);
            }
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            if (pstm != null) {
                
                pstm.close();
                
            }
            
            if (rs != null) {
                
                rs.close();
                
            }
            
        }
        
        return emprestimos;
    }
    
    public Emprestimo emprestar(Emprestimo emprestimo) throws Exception {
        
        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            
            String consultarID = "SELECT EMPRESTIMO_SEQ.NEXTVAL AS PROXIMO_ID"
                    + " FROM DUAL";
            
            pstm = conn.prepareStatement(consultarID);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                
                emprestimo.setId(rs.getLong("PROXIMO_ID"));
                
                String inserir = "INSERT INTO EMPRESTIMO "
                        + "(id, idusuario, idlivro, dataemprestimo, datadevolucao)"
                        + " VALUES (?,?,?,?,?)";
                
                pstm = conn.prepareStatement(inserir);
                
                pstm.setLong(1, emprestimo.getId());
                pstm.setLong(2, emprestimo.getUsuario().getId());
                pstm.setLong(3, emprestimo.getLivro().getId());
                pstm.setTimestamp(4, new java.sql.Timestamp(emprestimo.getDataEmprestimo().getTime()));
                pstm.setDate(5, null);
                pstm.execute();
                
                String atualizarLivro = "UPDATE Livro SET emprestado = ?"
                        + " WHERE id = ?";
                
                pstm = conn.prepareStatement(atualizarLivro);
                pstm.setInt(1, 1);
                pstm.setLong(2, emprestimo.getLivro().getId());
                pstm.executeUpdate();
                
            }
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            if (pstm != null) {
                
                pstm.close();
                
            }
            
            if (rs != null) {
                
                rs.close();
                
            }
            
            sqlConexao.desconectar(conn);
        }
        
        return emprestimo;
    }
    
    public Emprestimo devolver(Emprestimo emprestimo) throws Exception {
        
        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String devolver = "Update Emprestimo SET datadevolucao = ?"
                    + " WHERE idLivro = ? and dataDevolucao is null";
            
            pstm = conn.prepareStatement(devolver);
            pstm.setTimestamp(1, new java.sql.Timestamp(emprestimo.getDataDevolucao().getTime()));
            pstm.setLong(2, emprestimo.getLivro().getId());
            pstm.executeUpdate();
            
            String atualizarLivro = "UPDATE Livro SET emprestado = ?"
                    + " WHERE id = ?";
            
            pstm = conn.prepareStatement(atualizarLivro);
            pstm.setInt(1, 0);
            pstm.setLong(2, emprestimo.getLivro().getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            
        } finally {
            
            if (pstm != null) {
                
                pstm.close();
                
            }
            
            sqlConexao.desconectar(conn);
            
        }
        return emprestimo;
        
    }
}
