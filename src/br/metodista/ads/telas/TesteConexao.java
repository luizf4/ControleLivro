package br.metodista.ads.telas;

import br.metodista.ads.dao.UsuarioDAO;
import br.metodista.ads.modelos.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class TesteConexao {

    public static void main(String[] args) throws Exception {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        List<Usuario> lista = dao.consultar();

//        usuario.setNome("Gilce");
//        usuario.setLogin("gilcinha");
//        usuario.setSenha("000000");
//        
//        dao.salvar(usuario);
        // System.out.println(lista);
        //usuario.setId(12L);
//         usuario.setNome("Angelo Moreno");
//         usuario.setLogin("angelo");
//         usuario.setSenha("");
        //dao.salvar(usuario);
        usuario.setId(24L);

        if (dao.remover(usuario) == 1) {

            System.out.println("Excluido");
        } else {

            System.out.println("Não excluiu");
        }

        for (Usuario l : lista) {

            System.out.println(l);
        }
    }

}
