
package com.prontuario.bean;

public class Paciente {
    
    private int codigo;
    private String nome;
    private String email;
    private String dataNascimento;
    private String sexo;
    private String escolaridade;
    private String profissao;
    private String ocupacao;
    private String logadouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public Paciente(int codigo) {
        this.codigo = codigo;
    }

    public Paciente(int codigo, String nome, String dataNascimento, String sexo, String logadouro, String numero, String bairro, String cidade, String cep, String estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.logadouro = logadouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
/** 
 ensina para o java o que são dois objetos iguais
 **/
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "codigo=" + codigo + ","
                + " nome=" + nome + ","
                + " email=" + email + ", "
                + "dataNascimento=" + dataNascimento + ", "
                + "sexo=" + sexo + ", "
                + "escolaridade=" + escolaridade + ","
                + " profissao=" + profissao + ", "
                + "ocupacao=" + ocupacao + ", "
                + "logadouro=" + logadouro + ", "
                + "numero=" + numero + ","
                + " bairro=" + bairro + ","
                + " cidade=" + cidade + ", "
                + "cep=" + cep + ","
                + " estado=" + estado + '}';
    } 
}
