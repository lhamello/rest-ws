package br.unisc.pos.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "TELEVISOR")
public class Televisor extends Eletronico {

    private static final long serialVersionUID = 1L;

    @Column(name = "POLEGADA", nullable = false)
    @NotNull
    private Short polegada;

    public Short getPolegada() {
        return polegada;
    }

    public void setPolegada(Short polegada) {
        this.polegada = polegada;
    }
}
