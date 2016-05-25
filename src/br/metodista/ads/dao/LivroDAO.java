package br.metodista.ads.dao;

import br.metodista.ads.modelos.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luiz
 */
public class LivroDAO {
    
    BancoSQL sqlConexao = new BancoSQL();
    
    public Livro salvar(Livro livro) throws SQLException, Exception {
        
        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            String consultarID = "SELECT LIVRO_SEQ.NEXTVAL AS PROXIMO_ID"
                    + " FROM DUAL";
            pstm = conn.prepareStatement(consultarID);
            rs = pstm.executeQuery();
            
            
            
        } catch (SQLException ex) {
            
            System.out.println("Erro Salvar DAO: " + ex.getMessage());
            throw new SQLException("Erro DAO");
        } finally {
            
            if (pstm != null) {
                
                pstm.close();
            }
            
            if (rs != null) {
                
                rs.close();
            }
            
            sqlConexao.desconectar(conn);
        }
        
        return livro;        
    }
    
}
