package br.unisc.pos.produto.jogoeletronico;

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
import br.unisc.pos.produto.Produto;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "JOGO_ELETRONICO")
public class JogoEletronico extends Produto {

    private static final long serialVersionUID = 1L;

    @Column(name = "PLATAFORMA", nullable = false)
    @Convert(converter = PlataformaJogoEletronicoConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private PlataformaJogoEletronico plataforma;

    @Column(name = "GENERO", nullable = false)
    @Convert(converter = GeneroJogoEletronicoConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private GeneroJogoEletronico genero;

    public PlataformaJogoEletronico getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(PlataformaJogoEletronico plataforma) {
        this.plataforma = plataforma;
    }

    public GeneroJogoEletronico getGenero() {
        return genero;
    }

    public void setGenero(GeneroJogoEletronico genero) {
        this.genero = genero;
    }
}
