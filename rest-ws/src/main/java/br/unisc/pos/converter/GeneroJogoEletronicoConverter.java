package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.enums.GeneroGame;
 
@Converter
public class GeneroJogoEletronicoConverter implements AttributeConverter<GeneroGame, String> {

    @Override
    public String convertToDatabaseColumn(GeneroGame genero) {
        return genero.getGenero();
    }

    @Override
    public GeneroGame convertToEntityAttribute(String genero) {
        return GeneroGame.getEnum(genero);
    }
}
