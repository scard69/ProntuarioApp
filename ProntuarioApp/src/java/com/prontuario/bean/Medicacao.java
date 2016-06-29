/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scard
 */
@Entity
@Table(name = "medicacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicacao.findAll", query = "SELECT m FROM Medicacao m"),
    @NamedQuery(name = "Medicacao.findById", query = "SELECT m FROM Medicacao m WHERE m.id = :id"),
    @NamedQuery(name = "Medicacao.findByData", query = "SELECT m FROM Medicacao m WHERE m.data = :data"),
    @NamedQuery(name = "Medicacao.findByNomeComercial", query = "SELECT m FROM Medicacao m WHERE m.nomeComercial = :nomeComercial"),
    @NamedQuery(name = "Medicacao.findByPrincipioAtivo", query = "SELECT m FROM Medicacao m WHERE m.principioAtivo = :principioAtivo"),
    @NamedQuery(name = "Medicacao.findByIndicacoes", query = "SELECT m FROM Medicacao m WHERE m.indicacoes = :indicacoes"),
    @NamedQuery(name = "Medicacao.findByDose", query = "SELECT m FROM Medicacao m WHERE m.dose = :dose"),
    @NamedQuery(name = "Medicacao.findByFrequencia", query = "SELECT m FROM Medicacao m WHERE m.frequencia = :frequencia")})
public class Medicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "nomeComercial")
    private String nomeComercial;
    @Basic(optional = false)
    @Column(name = "principioAtivo")
    private String principioAtivo;
    @Basic(optional = false)
    @Column(name = "indicacoes")
    private String indicacoes;
    @Basic(optional = false)
    @Column(name = "dose")
    private String dose;
    @Basic(optional = false)
    @Column(name = "frequencia")
    private String frequencia;
    @Basic(optional = false)
    @Lob
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "codigoPaciente", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Paciente codigoPaciente;

    public Medicacao() {
    }

    public Medicacao(Integer id) {
        this.id = id;
    }

    public Medicacao(Integer id, Date data, String nomeComercial, String principioAtivo, String indicacoes, String dose, String frequencia, String observacoes) {
        this.id = id;
        this.data = data;
        this.nomeComercial = nomeComercial;
        this.principioAtivo = principioAtivo;
        this.indicacoes = indicacoes;
        this.dose = dose;
        this.frequencia = frequencia;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
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

    public Paciente getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Paciente codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicacao)) {
            return false;
        }
        Medicacao other = (Medicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prontuario.bean.Medicacao[ id=" + id + " ]";
    }
    
}
