/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rest;

import com.google.gson.Gson;
import com.prontuario.bean.Paciente;
import com.prontuario.crud.CrudGenericoRest;
import com.prontuario.rn.PacienteRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author scard
 */
@Path("/pacientes")
public class PacienteRest extends CrudGenericoRest<Paciente>{

    private  PacienteRN pacientern;

    public PacienteRest() {
        pacientern = new PacienteRN();
    }

    @Override
    public Response consultarPK(String pk) {
        Paciente p = pacientern.consultar(new Paciente(Integer.parseInt(pk)));
        return Response.ok(p).build();
    }

    @Override
    public Response pesquisar(String json) {
        Gson g = new Gson();
        Paciente p = g.fromJson(json, Paciente.class);
        List<Paciente> ret = pacientern.listar(p);
        return gerarResponseParaCollection(ret);        
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        List<Paciente> ret = pacientern.listar(null);
        return gerarResponseParaCollection(ret);       
    }

    @Override
    public Response excluirPK(String pk) {
        pacientern.excluir(new Paciente(Integer.parseInt(pk)));
        return Response.ok().build();        
    }

    @Override
    public Response salvar(Paciente paciente) {
        Paciente p = pacientern.salvar(new Gson().fromJson(paciente, Paciente.class));
        URI uri = uriInfo.getAbsolutePathBuilder().path(p.getCodigo().toString()).build();
        return Response.created(uri).build();        
    }

    @Override
    protected Response gerarResponseParaCollection(List<Paciente> obj) {
        if (obj == null || obj.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        GenericEntity<List<Paciente>> lista = new GenericEntity<List<Paciente>>(obj) {
        };
        return Response.ok(lista).build();        
    }           
}
