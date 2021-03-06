package br.unisc.pos.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.unisc.pos.infra.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PRODUTO")
public class Produto extends BaseEntity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Produto_SEQ")
    @SequenceGenerator(name = "Produto_SEQ", sequenceName = "ID_PRODUTO_SEQ", allocationSize = 1)
    protected Long id;

    @Column(name = "DESCRICAO", length = 100, nullable = false)
    @Length(min = 1, max = 100)
    @NotBlank
    private String descricao;

    @Column(name = "PRECO", nullable = false)
    @NotNull
    private Double preco;

    @Column(name = "OBSERVACAO", length = 4000, nullable = true)
    @Length(min = 1, max = 4000)
    private String observacao;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
