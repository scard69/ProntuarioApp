/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rn;

import com.prontuario.CRUD.CrudGenericoRN;
import com.prontuario.bd.PacienteBD;
import com.prontuario.bean.Paciente;
import java.util.List;

/**
 *
 * @author scard
 */
public class PacienteRN extends CrudGenericoRN<Paciente>{
    
    private final PacienteBD pacienteBD;
    
    public PacienteRN() {
        this.pacienteBD = new PacienteBD();
    }

    @Override
    public Paciente consultar(Paciente obj) {
        return pacienteBD.consultar(obj);
    }

    @Override
    public boolean excluir(Paciente obj) {
        return pacienteBD.excluir(obj);
    }

    @Override
    public List<Paciente> pesquisar(Paciente obj) {
        return pacienteBD.pesquisar(obj);
    }

    @Override
    public Paciente salvar(Paciente obj) {
        return pacienteBD.salvar(obj);
    } 
}
