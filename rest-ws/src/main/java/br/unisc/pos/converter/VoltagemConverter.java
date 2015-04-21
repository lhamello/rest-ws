package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.enums.Voltagem;

@Converter
public class VoltagemConverter implements AttributeConverter<Voltagem, String> {

    @Override
    public String convertToDatabaseColumn(Voltagem genero) {
        return genero.getGenero();
    }

    @Override
    public Voltagem convertToEntityAttribute(String genero) {
        return Voltagem.getEnum(genero);
    }
}
