package br.metodista.ads.dao;

import br.metodista.ads.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

            if (usuario.getId() == null) {

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

            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        } finally {

            pstm.close();
            rs.close();
            sqlConexao.desconectar(conn);
        }

        return usuario;
    }

}
