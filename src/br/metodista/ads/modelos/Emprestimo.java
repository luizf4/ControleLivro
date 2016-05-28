package br.metodista.ads.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luiz Fernando de Souza ADS - EAD Sorocaba Matricula: 225272
 */
public class Emprestimo {

    private Long id;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo() {

    }

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }    

    public Emprestimo(Long id, Date dataEmprestimo, Date dataDevolucao,
            Livro livro, Usuario usuario) {
        
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.livro = livro;
        this.usuario = usuario;
        
    }
    
    

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
//    
//    
//
//    public Object[] carregarGrid() {
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        return new Object[]{getUsuario().getNome(), livro.getTitulo(), df.format(getDataEmprestimo())};
//    }

    @Override
    public String toString() {
        return "\nEmprestimo\n" + "\nid: " + id + "\ndataEmprestimo=" + dataEmprestimo 
                + "\nDataDevolucao:" + dataDevolucao + "\nLivro" + livro.getAutor() +
                "Emprestado?: " + livro.getEmprestado()
                + "\nUsuario=" + usuario.getId();
    }

    
    
    

}
