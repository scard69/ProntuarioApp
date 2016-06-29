/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rest;

import com.prontuario.bean.Medicacao;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.ws.rs.Path;

/**
 *
 * @author scard
 */
@Path("/medicacoes")
public class MedicacaoRest implements CrudGenerico<Medicacao>{

    @Override
    public void salvar(Medicacao bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Medicacao bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicacao> listar(Medicacao bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medicacao consultar(Medicacao bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
