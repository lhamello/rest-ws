package br.unisc.pos.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.unisc.pos.produto.livro.GeneroLivro;

@Converter
public class GeneroLivroConverter implements AttributeConverter<GeneroLivro, String> {

    @Override
    public String convertToDatabaseColumn(GeneroLivro genero) {
        return genero.getGenero();
    }

    @Override
    public GeneroLivro convertToEntityAttribute(String genero) {
        return GeneroLivro.getEnum(genero);
    }
}
