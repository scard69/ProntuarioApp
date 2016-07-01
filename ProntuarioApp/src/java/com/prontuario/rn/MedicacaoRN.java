/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rn;

import com.prontuario.BD.MedicacaoBD;
import com.prontuario.bean.Medicacao;
import com.prontuario.crud.CrudGenerico;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author scard
 */
public class MedicacaoRN implements CrudGenerico<Medicacao>{

    private MedicacaoBD medicacaobd;

    public MedicacaoRN() {
        medicacaobd = new MedicacaoBD();
    }
    
    
    @Override
    public void salvar(@WebParam(name = "medicacao") Medicacao medicacao) {
        if(medicacao.getCodigoPaciente() == null || "".equals(medicacao.getCodigoPaciente())){
            throw new RuntimeException("Campo codigoPaciente obrigatório");
        }
        medicacaobd.salvar(medicacao);
    }

    @Override
    public void excluir(@WebParam(name = "medicacao")Medicacao medicacao) {
        medicacaobd.excluir(medicacao);
    }

    @Override
    public List<Medicacao> listar(@WebParam(name = "medicacao")Medicacao medicacao) {
        return medicacaobd.listar(medicacao);
    }

    @Override
    public Medicacao consultar(Medicacao medicacao) {
        return medicacaobd.consultar(medicacao);
    }
    
}
