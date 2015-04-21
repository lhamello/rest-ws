package br.unisc.pos.enums;

import java.util.HashMap;
import java.util.Map;

public enum GeneroGame {

    ACAO, AVENTURA, CASUAL, CORRIDA, ESPORTE, ESTRATEGIA, PLATAFORMA, SIMULACAO;

    private static Map<GeneroGame, String> map;

    static {
        map = new HashMap<>();
        map.put(ACAO, "A��o");
        map.put(AVENTURA, "Aventura");
        map.put(CASUAL, "Casual");
        map.put(CORRIDA, "Corrida");
        map.put(ESPORTE, "Esporte");
        map.put(ESTRATEGIA, "Estrat�gia");
        map.put(PLATAFORMA, "Plataforma");
        map.put(SIMULACAO, "Simula��o");
    }

    public String getGenero() {
        return map.get(this);
    }

    public static GeneroGame getEnum(String genero) {
        for (GeneroGame obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
