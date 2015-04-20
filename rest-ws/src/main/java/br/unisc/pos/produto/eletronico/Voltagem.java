package br.unisc.pos.produto.eletronico;

import java.util.HashMap;
import java.util.Map;

public enum Voltagem {

    V110, V220, V110_220;

    private static Map<Voltagem, String> map;

    static {
        map = new HashMap<>();
        map.put(V110, "110V");
        map.put(V220, "220V");
        map.put(V110_220, "V110/220");
    }

    public String getGenero() {
        return map.get(this);
    }

    public static Voltagem getEnum(String genero) {
        for (Voltagem obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
