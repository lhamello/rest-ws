package br.unisc.pos.business.model;

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

import br.unisc.pos.converter.VoltagemConverter;
import br.unisc.pos.enums.Voltagem;

@Entity
@PrimaryKeyJoinColumn(name = "ID")
@Table(name = "ELETRONICO")
public class Eletronico extends Produto {

    private static final long serialVersionUID = 1L;

    @Column(name = "MARCA", length = 60, nullable = false)
    @Length(max = 60)
    @NotEmpty
    private String marca;

    @Column(name = "VOLTAGEM", nullable = false)
    @Convert(converter = VoltagemConverter.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Voltagem voltagem;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Voltagem getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(Voltagem voltagem) {
        this.voltagem = voltagem;
    }
}
