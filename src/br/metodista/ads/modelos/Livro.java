package br.metodista.ads.modelos;

/**
 *
 * @author Luiz Fernando de Souza ADS - EAD Sorocaba Matricula: 225272
 */
public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private int paginas;
    private int edicao;
    private Emprestimo emprestimo;

    private Livro() {

    }
    //Construtor Completo
    public Livro(Long id, String titulo, String autor, String isbn,
            int paginas, int edicao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.edicao = edicao;
    }
    //Construtor para o método salvar do DAO
    public Livro(String titulo, String autor, String isbn, int paginas, int edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.edicao = edicao;        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object[] carregarGrid() {

        String temEmprestimo = emprestimo == null ? "Disponível"
                : emprestimo.getUsuario().getNome();

        return new Object[]{titulo, autor, isbn, paginas, edicao,
            temEmprestimo};
    }
}
