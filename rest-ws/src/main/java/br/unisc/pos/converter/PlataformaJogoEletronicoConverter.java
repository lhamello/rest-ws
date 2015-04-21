package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.enums.PlataformaGame;

@Converter
public class PlataformaJogoEletronicoConverter implements AttributeConverter<PlataformaGame, String> {

    @Override
    public String convertToDatabaseColumn(PlataformaGame genero) {
        return genero.getPlataforma();
    }

    @Override
    public PlataformaGame convertToEntityAttribute(String genero) {
        return PlataformaGame.getEnum(genero);
    }
}
