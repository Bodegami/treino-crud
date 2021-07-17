package br.com.renato.crud.livro;

import java.io.Serializable;
import java.math.BigDecimal;

public class LivroResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String autor;

    private String isbn;

    private BigDecimal preco;

    @Deprecated
    public LivroResponse() { }

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.autor = livro.getAutor();
        this.isbn = livro.getIsbn();
        this.preco = livro.getPreco();
    }

    public Long getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}
