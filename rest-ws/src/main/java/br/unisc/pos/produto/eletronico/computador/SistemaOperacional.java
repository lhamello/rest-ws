package br.unisc.pos.produto.eletronico.computador;

import java.util.HashMap;
import java.util.Map;

public enum SistemaOperacional {

    LINUX, MAC_OS, SOLARIS, WINDOWS;

    private static Map<SistemaOperacional, String> map;

    static {
        map = new HashMap<>();
        map.put(LINUX, "Linux");
        map.put(MAC_OS, "Mac OS");
        map.put(SOLARIS, "Solaris");
        map.put(WINDOWS, "Windows");
    }

    public String getSistemaOperacional() {
        return map.get(this);
    }

    public static SistemaOperacional getEnum(String genero) {
        for (SistemaOperacional obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
