package br.metodista.ads.dao;

import br.metodista.ads.modelos.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            if (livro.getId() == null) {
                String consultarID = "SELECT LIVRO_SEQ.NEXTVAL AS PROXIMO_ID"
                        + " FROM DUAL";
                pstm = conn.prepareStatement(consultarID);
                rs = pstm.executeQuery();

                if (rs.next()) {

                    livro.setId(rs.getLong("PROXIMO_ID"));
                    String inserir = "INSERT INTO LIVRO (id, titulo, autor, isbn,"
                            + " paginas, edicao"
                            + ") VALUES (?,?,?,?,?,?)";

                    pstm = conn.prepareStatement(inserir);
                    pstm.setLong(1, livro.getId());
                    pstm.setString(2, livro.getTitulo());
                    pstm.setString(3, livro.getAutor());
                    pstm.setString(4, livro.getIsbn());
                    pstm.setInt(5, livro.getPaginas());
                    pstm.setInt(6, livro.getEdicao());
                    pstm.execute();

                }
            } else {

                String atualizar = "UPDATE Livro SET titulo = ?, autor = ?,"
                        + " isbn = ?, paginas = ?, edicao = ?"
                        + " WHERE id = ?";

                pstm = conn.prepareStatement(atualizar);
                pstm.setString(1, livro.getTitulo());
                pstm.setString(2, livro.getAutor());
                pstm.setString(3, livro.getIsbn());
                pstm.setInt(4, livro.getPaginas());
                pstm.setInt(5, livro.getEdicao());
                pstm.setLong(6, livro.getId());
                pstm.executeUpdate();

            }

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

    public List<Livro> consultar() throws Exception {

        List<Livro> livro = new ArrayList<>();
        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            String consulta = "SELECT * FROM Livro";
            pstm = conn.prepareStatement(consulta);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Livro liv = new Livro(rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getInt("paginas"),
                        rs.getInt("edicao"));

                livro.add(liv);

            }

        } catch (SQLException ex) {

            System.out.println("Erro Consultar DAO: " + ex.getMessage());
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

        return livro;
    }

    public int remover(Livro livro) throws Exception {

        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        int retorno = 0;

        try {

            String delete = "DELETE FROM livro where id = ?";

            pstm = conn.prepareStatement(delete);
            pstm.setLong(1, livro.getId());
            retorno = pstm.executeUpdate();
            System.out.println(retorno);

        } catch (SQLException ex) {

            System.out.println("Erro Remover DAO: " + ex.getMessage());
            System.out.println("Código Erro: " + ex.getErrorCode());
            ex.printStackTrace();

        } finally {

            if (pstm != null) {

                pstm.close();

            }

            sqlConexao.desconectar(conn);
        }

        return retorno;
    }

}
