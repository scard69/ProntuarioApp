/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.mb;

import com.prontuario.bean.Paciente;
import com.prontuario.rn.PacienteRN;
import java.util.List;

/**
 *
 * @author scard
 */
public class PacienteMB {
    private PacienteRN pacientern;

    public PacienteMB() {
        pacientern = new PacienteRN();
    }
    
    public List<Paciente> getListaPaciente(){
        return pacientern.listar(null);
    }   
}
