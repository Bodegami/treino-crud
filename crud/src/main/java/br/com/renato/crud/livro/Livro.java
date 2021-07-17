package br.com.renato.crud.livro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String autor;

    private String isbn;

    private BigDecimal preco = BigDecimal.ZERO;

    private LocalDate cadastradoEm;

    @Deprecated
    public Livro() { }

    public Livro(String nome, String autor, String isbn, BigDecimal preco) {
        this.nome = nome;
        this.autor = autor;
        this.isbn = isbn;
        this.preco = preco;
        this.cadastradoEm = LocalDate.now();
    }

    public Long getId() {
        return id;
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

    public LocalDate getCadastradoEm() {
        return cadastradoEm;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(getId(), livro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
