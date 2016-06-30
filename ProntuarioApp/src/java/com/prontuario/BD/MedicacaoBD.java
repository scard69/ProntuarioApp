/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.BD;

import com.prontuario.bean.Medicacao;
import com.senac.util.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author scard
 */
public class MedicacaoBD implements CrudGenerico<Medicacao>{
    
    private EntityManager em;

    public MedicacaoBD() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prontuario");
        em = emf.createEntityManager();
    }
        
    @Override
    public void salvar(Medicacao medicacao) {
        em.getTransaction().begin();
        em.merge(medicacao);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Medicacao medicacao) {
        em.getTransaction().begin();
        em.remove(em.find(Medicacao.class, medicacao.getId()));
        em.getTransaction().commit();        
    }

    @Override
    public List<Medicacao> listar(Medicacao medicacao) {
        StringBuilder sb = new StringBuilder("select c from medicacao c where 1=1");
        if(medicacao.getCodigoPaciente()!=null && medicacao.getId()!=0) {
            sb.append("and c.codigoPaciente=:c ");
        }        
        Query qry = em.createQuery(sb.toString());
        if(medicacao.getCodigoPaciente()!=null && medicacao.getId()!=0) {
            qry.setParameter("c", medicacao.getCodigoPaciente());
        }        
        return qry.getResultList();
        
    }

    @Override
    public Medicacao consultar(Medicacao medicacao) {
        return em.find(Medicacao.class, medicacao.getId());
    }  
}
