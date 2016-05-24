package br.metodista.ads.telas;


import br.metodista.ads.dao.UsuarioDAO;
import br.metodista.ads.modelos.Usuario;


/**
 *
 * @author Luiz
 */
public class TesteConexao {

    public static void main(String[] args) throws Exception {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        usuario.setNome("Gilce");
        usuario.setLogin("gilcinha");
        usuario.setSenha("000000");
        
        dao.salvar(usuario);

    }

}
