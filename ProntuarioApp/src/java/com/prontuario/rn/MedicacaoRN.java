/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rn;

import com.prontuario.BD.MedicacaoBD;
import com.prontuario.bean.Medicacao;
import com.prontuario.crud.CrudGenericoRN;
import java.util.List;


/**
 *
 * @author scard
 */
public class MedicacaoRN extends CrudGenericoRN<Medicacao>{
    
    private final MedicacaoBD medicacaoBD;

    public MedicacaoRN() {
        medicacaoBD = new MedicacaoBD();
    }        

    @Override
    public Medicacao consultar(Medicacao bean) {
        avaliarConsultar(medicacaoBD, bean);
        return medicacaoBD.consultar(bean);
    }

    @Override
    public boolean excluir(Medicacao bean) {
        avaliarExcluir(medicacaoBD, bean);
        return medicacaoBD.excluir(bean);
    }

    @Override
    public Medicacao salvar(Medicacao bean) {
        avaliarSalvar(medicacaoBD, bean);        
        return medicacaoBD.salvar(bean);        
    }

    @Override
    public Medicacao alterar(Medicacao bean) {
        avaliarAlterar(medicacaoBD, bean);
        return medicacaoBD.alterar(bean);
    }

    @Override
    public List<Medicacao> pesquisar(Medicacao bean) {
        return medicacaoBD.pesquisar(bean);
    }

    @Override
    public List<Medicacao> pesquisar(String valor) {
        valor = avaliarPesquisar(valor);
        return medicacaoBD.pesquisar(valor);
    }  
}
