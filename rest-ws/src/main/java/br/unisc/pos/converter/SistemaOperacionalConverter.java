package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.produto.eletronico.Voltagem;

@Converter
public class SistemaOperacionalConverter implements AttributeConverter<Voltagem, String> {

    @Override
    public String convertToDatabaseColumn(Voltagem sistemaOperacional) {
        return sistemaOperacional.getGenero();
    }

    @Override
    public Voltagem convertToEntityAttribute(String sistemaOperacional) {
        return Voltagem.getEnum(sistemaOperacional);
    }
}
