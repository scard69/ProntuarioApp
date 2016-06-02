package com.prontuario.rest;

import com.google.gson.Gson;
import com.prontuario.CRUD.CrudGenericoRest;
import com.prontuario.bean.Medicacao;
import com.prontuario.infra.RNException;
import com.prontuario.rn.MedicacaoRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/medicacoes")
public class MedicacaoRest extends CrudGenericoRest<Medicacao>{
    
    private final MedicacaoRN medicacaoRN;
    
    public MedicacaoRest() {
        this.medicacaoRN = new MedicacaoRN();
    }
    
    @Override
    public Response consultarPK(String pk) {
        try {
            Medicacao m = medicacaoRN.consultar(new Medicacao(Integer.parseInt(pk)));
            return Response.ok(m).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }
    
    @Override
    public Response pesquisar(String json) {
        try {
            Gson g = new Gson();
            Medicacao m = g.fromJson(json, Medicacao.class);

            List<Medicacao> ret = medicacaoRN.pesquisar(m);

            return gerarResponseParaCollection(ret);    
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }        
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        try {
            List<Medicacao> ret = medicacaoRN.pesquisar(null);        
            return gerarResponseParaCollection(ret);
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }
    
    @Override
    public Response excluirPK(String pk) {
        try {
            medicacaoRN.excluir(new Medicacao(Integer.parseInt(pk)));
            return Response.ok().build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }
    }
    
    @Override
    public Response salvar(Medicacao obj) {
        try {
            Medicacao p = medicacaoRN.salvar(obj);
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(p.getId())).build();
            return Response.created(uri).build();      
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }        
    }

    @Override
    protected Response gerarResponseParaCollection(List<Medicacao> obj) {
                if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        GenericEntity<List<Medicacao>> lista = new GenericEntity<List<Medicacao>>(obj) {
        };
        return Response.ok(lista).build();  
    }
    
}

