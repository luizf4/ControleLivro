package br.metodista.ads.dao;

import br.metodista.ads.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class UsuarioDAO {

    BancoSQL sqlConexao = new BancoSQL();

    public Usuario salvar(Usuario usuario) throws Exception {

        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            String consultaLogin = "select login from usuario where login = ?";
            pstm = conn.prepareStatement(consultaLogin);
            pstm.setString(1, usuario.getLogin());
            rs = pstm.executeQuery();

            if (usuario.getId() == null) {

                if (rs.next() == false) {

                    String consultarID = "SELECT USUARIO_SEQ.NEXTVAL AS PROXIMO_ID"
                            + " FROM DUAL";
                    pstm = conn.prepareStatement(consultarID);
                    rs = pstm.executeQuery();

                    if (rs.next()) {

                        usuario.setId(rs.getLong("PROXIMO_ID"));
                        String inserir = "INSERT INTO USUARIO (id, nome, login, senha "
                                + ") VALUES (?,?,?,?)";

                        pstm = conn.prepareStatement(inserir);
                        pstm.setLong(1, usuario.getId());
                        pstm.setString(2, usuario.getNome());
                        pstm.setString(3, usuario.getLogin());
                        pstm.setString(4, usuario.getSenha());
                        pstm.execute();

                    }

                } else {
                    System.out.println("Já existe");

                    return usuario = null;

                }

            } else {

                String atualizar = "UPDATE Usuario SET nome = ?, senha = ?"
                        + " WHERE id = ?";

                pstm = conn.prepareStatement(atualizar);
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSenha());
                pstm.setLong(3, usuario.getId());
                pstm.executeUpdate();
            }

        } catch (SQLException ex) {

            throw new RuntimeException(ex);

//            System.out.println("Erro Salvar DAO: " + ex.getSQLState());
//            System.out.println("Código Erro: " + ex.getErrorCode());
//            ex.printStackTrace();
        } finally {

            if (pstm != null) {

                pstm.close();

            }

            if (rs != null) {

                rs.close();

            }
            sqlConexao.desconectar(conn);
        }

        return usuario;
    }

    public List<Usuario> consultar() throws Exception {

        List<Usuario> usuario = new ArrayList<>();
        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            String consultar = "SELECT * FROM Usuario";
            pstm = conn.prepareStatement(consultar);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Usuario user = new Usuario(rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("login"), rs.getString("senha"));
                usuario.add(user);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao Consultar DAO: " + ex.getMessage());
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

        return usuario;
    }

    public int remover(Usuario usuario) throws Exception {

        Connection conn = sqlConexao.conectar();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int retorno = 0;

        try {
            String delete = "DELETE FROM usuario where id = ?";
            pstm = conn.prepareStatement(delete);
            pstm.setLong(1, usuario.getId());
            retorno = pstm.executeUpdate();
            System.out.println(retorno);

        } catch (SQLException ex) {

            System.out.println("Erro Remover SQL: " + ex.getMessage());
            System.out.println("Código Erro: " + ex.getErrorCode());
            ex.printStackTrace();

        } finally {

            if (pstm != null) {

                pstm.close();

            }

            if (rs != null) {

                rs.close();

            }
        }

        return retorno;
    }

}
