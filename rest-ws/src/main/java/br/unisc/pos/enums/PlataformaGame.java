package br.unisc.pos.enums;

import java.util.HashMap;
import java.util.Map;

public enum PlataformaGame {

    PC, PS_VITA, PSP, PS2, PS3, PS4, XBOX, XBOX_360, XBOX_ONE, WII, WII_U, N_3DS;

    private static Map<PlataformaGame, String> map;

    static {
        map = new HashMap<>();
        map.put(PC, "PC");
        map.put(PS_VITA, "PS VITA");
        map.put(PSP, "PSP");
        map.put(PS2, "PS2");
        map.put(PS3, "PS3");
        map.put(PS4, "PS4");
        map.put(XBOX, "XBOX");
        map.put(XBOX_360, "XBOX 360");
        map.put(XBOX_ONE, "XBOX ONE");
        map.put(WII, "Nintendo WII");
        map.put(WII_U, "Nintendo WII U");
        map.put(N_3DS, "Nintendo 3DS");
    }

    public String getPlataforma() {
        return map.get(this);
    }

    public static PlataformaGame getEnum(String genero) {
        for (PlataformaGame obj : map.keySet()) {
            String nome = map.get(obj);

            if (nome.equalsIgnoreCase(genero)) {
                return obj;
            }
        }

        return null;
    }
}
