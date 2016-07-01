/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.BD;

import com.prontuario.bean.Paciente;
import com.prontuario.crud.CrudGenerico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author scard
 */
public class PacienteBD implements CrudGenerico<Paciente>{

    private EntityManager em;

    public PacienteBD() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prontuario");
        em = emf.createEntityManager();
    }
       
    @Override
    public void salvar(Paciente paciente) {
        em.getTransaction().begin();
        em.merge(paciente);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Paciente paciente) {
        em.getTransaction().begin();
        em.remove(em.find(Paciente.class, paciente.getCodigo()));
        em.getTransaction().commit();
    }

    @Override
    public List<Paciente> listar(Paciente paciente) {
        StringBuilder sb = new StringBuilder("select c from paciente c where 1=1 ");

        if(paciente.getCodigo()!=null && paciente.getCodigo()!=0) {
            sb.append("and c.codigo=:c ");
        }
        if(paciente.getNome()!=null && !"".equals(paciente.getNome())) {
            sb.append("and c.nome like :n ");
        }
        if(paciente.getEmail()!=null && !"".equals(paciente.getEmail())) {
            sb.append("and c.email like :e ");
        }
        if(paciente.getContato()!=null && !"".equals(paciente.getContato())) {
            sb.append("and c.contato like :t ");
        }

        sb.append("order by c.nome");
        
        Query qry = em.createQuery(sb.toString());
        if(paciente.getCodigo()!=null && paciente.getCodigo()!=0) {
            qry.setParameter("c", paciente.getCodigo());
        }
        if(paciente.getNome()!=null && !"".equals(paciente.getNome())) {
            qry.setParameter("n", "%" + paciente.getNome() + "%");
        }
        if(paciente.getEmail()!=null && !"".equals(paciente.getEmail())) {
            qry.setParameter("e", "%" + paciente.getEmail() + "%");
        }
        if(paciente.getContato()!=null && !"".equals(paciente.getContato())) {
            qry.setParameter("t", "%" + paciente.getContato() + "%");
        }
        
        return qry.getResultList();        
    }

    @Override
    public Paciente consultar(Paciente paciente) {
        return em.find(Paciente.class, paciente.getCodigo());       
    }
    
}
