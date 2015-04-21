package br.unisc.pos.enums;

import java.util.HashMap;
import java.util.Map;

public enum GeneroLivro {

    BIOGRAFIA, CONTOS, CRONICA, FANTASIA, FICCAO, POESIA, POLICIAL, ROMANCE, TERROR;

    private static Map<GeneroLivro, String> map;

    static {
        map = new HashMap<>();
        map.put(BIOGRAFIA, "Biografia");
        map.put(CONTOS, "Contos");
        map.put(CRONICA, "Cr�nica");
        map.put(FANTASIA, "Fantasia");
        map.put(FICCAO, "Fic��o Cient�fica");
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
