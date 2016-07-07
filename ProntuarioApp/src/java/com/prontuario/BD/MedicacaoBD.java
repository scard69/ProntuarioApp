/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.BD;

import com.prontuario.bean.Medicacao;
import com.prontuario.crud.CrudGenerico;
import com.prontuario.crud.CrudGenericoBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author scard
 */
public class MedicacaoBD extends CrudGenericoBD<Medicacao>{

    @Override
    public List<Medicacao> pesquisar(Medicacao bean) {
        return pesquisar(bean.getNomeComercial());
    }

    @Override
    public List<Medicacao> pesquisar(String valor) {
        EntityManager em = createEntityManager();        
        try {
            Query query = em.createNamedQuery("Medicacao.findByMedicacao");
            query.setParameter("medicacao", "%" + valor + "%");
            return query.getResultList();
        } finally {
            em.close();        
        } 
    }
        
 
}
