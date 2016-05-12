/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rest;

import com.google.gson.Gson;
import com.prontuario.CRUD.CrudGenericoRest;
import com.prontuario.bean.Paciente;
import com.prontuario.infra.RNException;
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
@Path("/paciente")
public class PacienteRest extends CrudGenericoRest<Paciente>{
    
    private final PacienteRN pacienteRN;
    
    public PacienteRest() {
        this.pacienteRN = new PacienteRN();
    }

    @Override
    public Response consultarPK(String pk) {
        try {
            Paciente m = pacienteRN.consultar(new Paciente(Integer.parseInt(pk)));
            return Response.ok(m).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Paciente m = g.fromJson(json, Paciente.class);

            List<Paciente> ret = pacienteRN.pesquisar(m);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }        
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Paciente> ret = pacienteRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response excluirPK(String pk) {
        try {
            pacienteRN.excluir(new Paciente(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response salvar(Paciente obj) {
        try {
            Paciente p = pacienteRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getCodigo())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }        
    }

    @Override
    protected Response gerarResponseParaCollection(List<Paciente> obj) {
                if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Paciente>> lista = new GenericEntity<List<Paciente>>(obj) {
        };
        return Response.ok(lista).build();  
    }
    
}
