package com.prontuario.auth;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * Esta classe é responsável por armazenar os tokens já
 * distribuídos nas autenticações e conferir se estão
 * válidos (expiração por data/hora).
 * 
 * @author lossurdo
 */
class TokenControl {

    private static final double DIFF_MILLIS = 1.8E6; // 30min
    private static HashMap<String, Long> listaToken;
    private static TreeSet<String> listaTokenExpirado;

    private TokenControl() {
        listaToken = new HashMap<>();
        listaTokenExpirado = new TreeSet<>();
    }

    public static TokenControl getInstance() {
        return TokenControlHolder.INSTANCE;
    }

    private static class TokenControlHolder {
        private static final TokenControl INSTANCE = new TokenControl();
    }

    public void revalidarToken(String token) throws Exception {
        expiraTokens(token);
        if (listaTokenExpirado.contains(token)) {
            throw new RuntimeException("Token expirado");
        }

        if (!listaToken.containsKey(token)) {
            throw new RuntimeException("Token nunca existiu");
        }

        addToken(token);
    }

    public void addToken(String token) {
        listaToken.put(token, Calendar.getInstance().getTimeInMillis());
    }
    
    private void expiraTokens(String token) {
        Set<String> tokens = listaToken.keySet();
        for (String tkn : tokens) {
            long now = Calendar.getInstance().getTimeInMillis();
            if (now - listaToken.get(tkn) > DIFF_MILLIS) {
                listaToken.remove(tkn);
                listaTokenExpirado.add(tkn);
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(listaToken);
    }

}
