package com.prontuario.crud;

public class RNException extends RuntimeException {
    private Tipo tipo;

    public RNException(Tipo tipo) {
        super(tipo.toString());
        this.tipo = tipo;
    }
    public RNException(Tipo tipo, String message) {
        super(message);
        this.tipo = tipo;
    }

    public RNException(Tipo tipo, String message, Throwable cause) {
        super(message, cause);
        this.tipo = tipo;
    }

    public RNException(Tipo tipo, Throwable cause) {
        super(cause);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Enum auxiliar para controle do tipo de erro
     * relacionado às regras de negócio.
     */
    public enum Tipo {
        REGISTRO_JA_EXISTE("Registro já existente"), 
        REGISTRO_NAO_ENCONTRADO("Registro não encontrado"),
        CAMPOS_OBRIGATORIOS_VIOLADOS("Campos obrigatórios não foram informados")
        ;
        
        private String value;
        
        private Tipo(String mensagem) {
            this.value = mensagem;
        }
        
        @Override        
        public String toString() {
            return this.value;
        }
    }
}
