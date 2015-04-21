package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.enums.GeneroPerfume;

@Converter
public class GeneroPerfumeConverter implements AttributeConverter<GeneroPerfume, String> {

    @Override
    public String convertToDatabaseColumn(GeneroPerfume genero) {
        return genero.getGenero();
    }

    @Override
    public GeneroPerfume convertToEntityAttribute(String genero) {
        return GeneroPerfume.getEnum(genero);
    }
}
