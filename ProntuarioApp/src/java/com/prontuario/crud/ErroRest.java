package com.prontuario.crud;

/**
 *
 * @author lossurdo
 */
public class ErroRest {

    private String mensagem;
    private String detalhamento;

    public ErroRest(String mensagem, String detalhamento) {
        this.mensagem = mensagem;
        this.detalhamento = detalhamento;
    }

    public ErroRest(String mensagem) {
        this.mensagem = mensagem;
    }

    public ErroRest() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    @Override
    public String toString() {
        return "ErroRest{" + "mensagem=" + mensagem + ", detalhamento=" + detalhamento + '}';
    }
    
}
