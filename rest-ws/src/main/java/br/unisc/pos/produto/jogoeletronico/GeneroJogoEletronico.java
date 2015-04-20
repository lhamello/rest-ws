package br.unisc.pos.produto.jogoeletronico;

import java.util.HashMap;
import java.util.Map;

public enum GeneroJogoEletronico {

    ACAO, AVENTURA, CASUAL, CORRIDA, ESPORTE, ESTRATEGIA, PLATAFORMA, SIMULACAO;

    private static Map<GeneroJogoEletronico, String> map;

    static {
        map = new HashMap<>();
        map.put(ACAO, "Ação");
        map.put(AVENTURA, "Aventura");
        map.put(CASUAL, "Casual");
        map.put(CORRIDA, "Corrida");
        map.put(ESPORTE, "Esporte");
        map.put(ESTRATEGIA, "Estratégia");
        map.put(PLATAFORMA, "Plataforma");
        map.put(SIMULACAO, "Simulação");
    }

    public String getGenero() {
        return map.get(this);
    }

    public static GeneroJogoEletronico getEnum(String genero) {
        for (GeneroJogoEletronico obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
