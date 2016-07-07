/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.BD;

import com.prontuario.bean.Paciente;
import com.prontuario.crud.CrudGenericoBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author scard
 */
public class PacienteBD extends CrudGenericoBD<Paciente>{

    @Override
    public List<Paciente> pesquisar(Paciente bean) {
        return pesquisar(bean.getNome());
    }

    @Override
    public List<Paciente> pesquisar(String valor) {
        EntityManager em = createEntityManager();       
        try {
            Query query = em.createNamedQuery("Paciente.findByPaciente");
            query.setParameter("paciente", "%" + valor + "%");
            return query.getResultList();
        } finally {
            em.close();        
        }        
    }      
}
