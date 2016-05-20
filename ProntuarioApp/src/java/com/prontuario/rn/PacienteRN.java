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
import javax.jws.WebService;

/**
 *
 * @author scard
 */
@WebService
public class PacienteRN extends CrudGenericoRN<Paciente>{
    
    private final PacienteBD pacienteBD;
    
    public PacienteRN() {
        this.pacienteBD = new PacienteBD();
    }

    @Override
    public Paciente consultar(Paciente obj) {
        avaliarConsultar(pacienteBD, obj);
        return pacienteBD.consultar(obj);
    }

    @Override
    public boolean excluir(Paciente obj) {
        avaliarExcluir(pacienteBD, obj);
        return pacienteBD.excluir(obj);
    }

    @Override
    public List<Paciente> pesquisar(Paciente obj) {
        avaliarPesquisar(pacienteBD, obj);
        return pacienteBD.pesquisar(obj);
    }

    @Override
    public Paciente salvar(Paciente obj) {
        avaliarSalvar(pacienteBD, obj);
        return pacienteBD.salvar(obj);
    } 
}
