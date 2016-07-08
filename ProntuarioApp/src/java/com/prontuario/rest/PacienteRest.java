/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rest;

import com.google.gson.Gson;
import com.prontuario.bean.Medicacao;
import com.prontuario.bean.Paciente;
import com.prontuario.crud.CrudGenericoRest;
import com.prontuario.crud.ErroRest;
import com.prontuario.crud.RNException;
import com.prontuario.rn.PacienteRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author scard
 */
@Path("/pacientes")
public class PacienteRest extends CrudGenericoRest<Paciente>{

    private final PacienteRN pacienteRN;

    public PacienteRest() {
        this.pacienteRN = new PacienteRN();
    }
       
    @Override
    public Response consultarPK(String pk) {
        try {
            Paciente p = pacienteRN.consultar(new Paciente(Integer.parseInt(pk)));
            return Response.ok(p).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response pesquisar(String q) {
        try {
            List<Paciente> ret = pacienteRN.pesquisar(q);
            
            for (Paciente p : ret) {
                for (Medicacao m : p.getMedicacaoList()) {
                    m.setCodigoPaciente(null);
                }
            }
            
            
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
    public Response salvar(String obj) {
        try {
            Paciente p = pacienteRN.salvar(new Gson().fromJson(obj, Paciente.class));
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getCodigo())).build();
            return Response.created(uri).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    public Response alterar(String obj) {
        try {
            Paciente p = pacienteRN.alterar(new Gson().fromJson(obj, Paciente.class));
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getCodigo())).build();
            return Response.created(uri).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }

    @Override
    protected Response gerarResponseParaCollection(List<Paciente> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(toJSON(new ErroRest("Nenhum registro disponível; lista vazia")))
                .build();
        }

        return Response.ok(new Gson().toJson(obj)).build();
    }

}
