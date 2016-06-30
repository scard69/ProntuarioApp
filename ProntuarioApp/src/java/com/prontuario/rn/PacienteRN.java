/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rn;

import com.prontuario.BD.PacienteBD;
import com.prontuario.bean.Paciente;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author scard
 */
@WebService
public class PacienteRN implements CrudGenerico<Paciente>{
    
    private PacienteBD pacientebd;

    public PacienteRN() {
        pacientebd = new PacienteBD();
    }       
    
    @Override
    public void salvar(@WebParam(name = "paciente")Paciente paciente) {
        if(paciente.getEmail()==null || "".equals(paciente.getEmail())) {
            throw new RuntimeException("Campo Email obrigatório");
        }
        if(paciente.getNome()==null || "".equals(paciente.getNome())) {
            throw new RuntimeException("Campo Nome obrigatório");
        }
        if(paciente.getContato()==null || "".equals(paciente.getContato())) {
            throw new RuntimeException("Campo Contato obrigatório");
        } 
        pacientebd.salvar(paciente);
    }

    @Override
    public void excluir(@WebParam(name = "paciente")Paciente paciente) {
        pacientebd.excluir(paciente);
    }

    @Override
    public List<Paciente> listar(@WebParam(name = "paciente")Paciente paciente) {
        return pacientebd.listar(paciente);
    }

    @Override
    public Paciente consultar(Paciente paciente) {
        return pacientebd.consultar(paciente);
    }
    
}
