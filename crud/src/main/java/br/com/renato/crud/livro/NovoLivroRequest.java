package br.com.renato.crud.livro;

import java.io.Serializable;
import java.math.BigDecimal;

public class NovoLivroRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;

    private String autor;

    private String isbn;

    private BigDecimal preco;

    @Deprecated
    public NovoLivroRequest() { }

    public NovoLivroRequest(String nome, String autor, String isbn, BigDecimal preco) {
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
        this.preco = preco;
    }

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

    public Livro toModel() {
        return new Livro(this.getNome(), this.getAutor(), this.getIsbn(), this.getPreco());
    }

}
