/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.bd;

import com.prontuario.CRUD.CrudGenerico;
import com.prontuario.bean.Paciente;
import com.prontuario.fake.BancoDadosPaciente;
import java.util.List;

/**
 *
 * @author scard
 */
public class PacienteBD implements CrudGenerico<Paciente>{

    @Override
    public Paciente consultar(Paciente obj) {
        return BancoDadosPaciente.getInstance().consultar(obj);
    }

    @Override
    public boolean excluir(Paciente obj) {
        return BancoDadosPaciente.getInstance().excluir(obj);
    }

    @Override
    public List<Paciente> pesquisar(Paciente obj) {
        return BancoDadosPaciente.getInstance().pesquisar(obj);
    }

    @Override
    public Paciente salvar(Paciente obj) {
        return BancoDadosPaciente.getInstance().salvar(obj);
    }
}
