package com.prontuario.bean;

public class Medicacao {

    private int id;
    private int pacienteId;
    private String nomeComercial;
    private String data;
    private String principioAtivo;
    private String indicacoes;
    private String dose;
    private String frequencia;
    private String observacoes;

    public Medicacao(int id) {
        this.id = id;
    }

    public Medicacao(int id, int pacienteId, String nomeComercial, String data, String principioAtivo, String indicacoes, String dose, String frequencia, String observacoes) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.nomeComercial = nomeComercial;
        this.data = data;
        this.principioAtivo = principioAtivo;
        this.indicacoes = indicacoes;
        this.dose = dose;
        this.frequencia = frequencia;
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medicacao other = (Medicacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medicacao{" + "id=" + id 
                + ", pacienteId=" + pacienteId 
                + ", nomeComercial=" + nomeComercial 
                + ", data=" + data 
                + ", principioAtivo=" + principioAtivo 
                + ", indicacoes=" + indicacoes 
                + ", dose=" + dose 
                + ", frequencia=" + frequencia 
                + ", observacoes=" + observacoes + '}';
    }
}
