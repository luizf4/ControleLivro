
package br.metodista.ads.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Luiz
 */
public class BancoSQL {
    
            private final static String url = "jdbc:oracle:thin:@localhost:1521:XE";
            private final static String usuario = "system";
            private final static String senha = "Gil@@3442";
    
    public Connection conectar() throws Exception {

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            

            conn = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com o Banco de Dados!!!");

        } catch (Exception ex) {

            ex.printStackTrace();
            throw new Exception("Erro ao conectar no BD.");
        }

        return conn;
    }

    public void desconectar(Connection conn) throws Exception {

        try {

            if (conn != null) {

                conn.close();
                System.out.println("Desconectado do Banco de Dados!!!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            throw new Exception("Não conseguiu fechar a conexão!");

        }

    }    
    
}
