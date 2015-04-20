package br.unisc.pos.produto.livro;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.unisc.pos.converter.GeneroLivroConverter;
import br.unisc.pos.produto.Produto;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "LIVRO")
public class Livro extends Produto {

    private static final long serialVersionUID = 1L;

    @Column(name = "AUTOR", length = 60, nullable = false)
    @Length(max = 60)
    @NotEmpty
    private String autor;
    
    @Column(name = "EDICAO", nullable = false)
    @NotNull
    private Short edicao;
    
    @Column(name = "GENERO", nullable = false)
    @Convert(converter = GeneroLivroConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private GeneroLivro genero;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Short getEdicao() {
        return edicao;
    }

    public void setEdicao(Short edicao) {
        this.edicao = edicao;
    }

    public GeneroLivro getGenero() {
        return genero;
    }

    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }
}
