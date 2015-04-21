package br.unisc.pos.business.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.unisc.pos.converter.GeneroJogoEletronicoConverter;
import br.unisc.pos.converter.PlataformaJogoEletronicoConverter;
import br.unisc.pos.enums.GeneroGame;
import br.unisc.pos.enums.PlataformaGame;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "GAME")
public class Game extends Produto {

    private static final long serialVersionUID = 1L;

    @Column(name = "PLATAFORMA", nullable = false)
    @Convert(converter = PlataformaJogoEletronicoConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private PlataformaGame plataforma;

    @Column(name = "GENERO", nullable = false)
    @Convert(converter = GeneroJogoEletronicoConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private GeneroGame genero;

    public PlataformaGame getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(PlataformaGame plataforma) {
        this.plataforma = plataforma;
    }

    public GeneroGame getGenero() {
        return genero;
    }

    public void setGenero(GeneroGame genero) {
        this.genero = genero;
    }
}
