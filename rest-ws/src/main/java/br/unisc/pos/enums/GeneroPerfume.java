package br.unisc.pos.enums;

import java.util.HashMap;
import java.util.Map;

public enum GeneroPerfume {

    FEMININO, MASCULINO;

    private static Map<GeneroPerfume, String> map;

    static {
        map = new HashMap<>();
        map.put(FEMININO, "Feminino");
        map.put(MASCULINO, "Masculino");
    }

    public String getGenero() {
        return map.get(this);
    }

    public static GeneroPerfume getEnum(String genero) {
        for (GeneroPerfume obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
