package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.produto.jogoeletronico.GeneroJogoEletronico;

@Converter
public class GeneroJogoEletronicoConverter implements AttributeConverter<GeneroJogoEletronico, String> {

    @Override
    public String convertToDatabaseColumn(GeneroJogoEletronico genero) {
        return genero.getGenero();
    }

    @Override
    public GeneroJogoEletronico convertToEntityAttribute(String genero) {
        return GeneroJogoEletronico.getEnum(genero);
    }
}
