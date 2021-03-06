package br.unisc.pos.business.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.unisc.pos.converter.GeneroPerfumeConverter;
import br.unisc.pos.enums.GeneroPerfume;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "PERFUME")
public class Perfume extends Produto {

    private static final long serialVersionUID = 1L;

    @Column(name = "PRECO", nullable = false)
    @Convert(converter = GeneroPerfumeConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private GeneroPerfume genero;

    public GeneroPerfume getGenero() {
        return genero;
    }

    public void setGenero(GeneroPerfume genero) {
        this.genero = genero;
    }
}
