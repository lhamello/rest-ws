package br.unisc.pos.business.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.unisc.pos.converter.SistemaOperacionalConverter;
import br.unisc.pos.enums.SistemaOperacional;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "COMPUTADOR")
public class Computador extends Eletronico {

    private static final long serialVersionUID = 1L;

    @Column(name = "SISTEMA_OPERACIONAL", nullable = false)
    @Convert(converter = SistemaOperacionalConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private SistemaOperacional sistemaOperacional;

    public SistemaOperacional getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
}
