package br.unisc.pos.produto.livro;

import java.util.HashMap;
import java.util.Map;

public enum GeneroLivro {

    BIOGRAFIA, CONTOS, CRONICA, FANTASIA, FICCAO, POESIA, POLICIAL, ROMANCE, TERROR;

    private static Map<GeneroLivro, String> map;

    static {
        map = new HashMap<>();
        map.put(BIOGRAFIA, "Biografia");
        map.put(CONTOS, "Contos");
        map.put(CRONICA, "Crônica");
        map.put(FANTASIA, "Fantasia");
        map.put(FICCAO, "Ficção Científica");
        map.put(POESIA, "Poesia");
        map.put(POLICIAL, "Policial");
        map.put(ROMANCE, "Romance");
        map.put(TERROR, "Terror");
    }

    public String getGenero() {
        return map.get(this);
    }

    public static GeneroLivro getEnum(String genero) {
        for (GeneroLivro obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
