/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.mb;

import com.prontuario.bean.Medicacao;
import com.prontuario.rn.MedicacaoRN;
import java.util.List;

/**
 *
 * @author scard
 */
public class MedicacaoMB {
    private MedicacaoRN medicacaorn;

    public MedicacaoMB() {
        medicacaorn = new MedicacaoRN();
    }
    public List<Medicacao> getListaMedicacaos(){
        return medicacaorn.listar(null);
    }
}
