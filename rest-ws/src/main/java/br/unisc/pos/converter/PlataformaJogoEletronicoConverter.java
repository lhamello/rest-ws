package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.produto.jogoeletronico.PlataformaJogoEletronico;

@Converter
public class PlataformaJogoEletronicoConverter implements AttributeConverter<PlataformaJogoEletronico, String> {

    @Override
    public String convertToDatabaseColumn(PlataformaJogoEletronico genero) {
        return genero.getPlataforma();
    }

    @Override
    public PlataformaJogoEletronico convertToEntityAttribute(String genero) {
        return PlataformaJogoEletronico.getEnum(genero);
    }
}
