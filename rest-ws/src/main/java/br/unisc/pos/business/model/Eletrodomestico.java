package br.unisc.pos.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "ELETRODOMESTICO")
public class Eletrodomestico extends Eletronico {

    private static final long serialVersionUID = 1L;

    @Column(name = "COR", length = 30, nullable = false)
    @Length(min = 1, max = 30)
    @NotEmpty
    private String cor;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
