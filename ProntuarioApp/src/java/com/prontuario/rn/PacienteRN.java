/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rn;

import com.prontuario.BD.PacienteBD;
import com.prontuario.bean.Paciente;
import com.prontuario.crud.CrudGenericoRN;
import com.prontuario.crud.RNException;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author scard
 */
public class PacienteRN extends CrudGenericoRN<Paciente>{
    
    private final PacienteBD pacienteBD;

    public PacienteRN() {
        pacienteBD = new PacienteBD();
    }
       
    @Override
    public Paciente consultar(Paciente bean) {
        avaliarConsultar(pacienteBD, bean);
        return pacienteBD.consultar(bean);
    }

    @Override
    public boolean excluir(Paciente bean) {
        avaliarExcluir(pacienteBD, bean);
        return pacienteBD.excluir(bean);
    }

    @Override
    public Paciente salvar(Paciente bean) {
        avaliarSalvar(pacienteBD, bean);
        if(StringUtils.isBlank(bean.getNome())) {
            throw new RNException(RNException.Tipo.CAMPOS_OBRIGATORIOS_VIOLADOS);
        }        
        return pacienteBD.salvar(bean);   
    }

    @Override
    public Paciente alterar(Paciente bean) {
        avaliarAlterar(pacienteBD, bean);
        if(StringUtils.isBlank(bean.getNome())) {
            throw new RNException(RNException.Tipo.CAMPOS_OBRIGATORIOS_VIOLADOS);
        }
        return pacienteBD.alterar(bean);        
    }

    @Override
    public List<Paciente> pesquisar(Paciente bean) {
        return pacienteBD.pesquisar(bean);
    }

    @Override
    public List<Paciente> pesquisar(String valor) {
        valor = avaliarPesquisar(valor);
        return pacienteBD.pesquisar(valor);
    }
}
