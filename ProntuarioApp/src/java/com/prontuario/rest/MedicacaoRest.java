package com.prontuario.rest;

import com.google.gson.Gson;
import com.prontuario.bean.Medicacao;
import com.prontuario.crud.CrudGenericoRest;
import com.prontuario.crud.ErroRest;
import com.prontuario.crud.RNException;
import com.prontuario.rn.MedicacaoRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/medicacoes")
public class MedicacaoRest extends CrudGenericoRest<Medicacao>{

    private final MedicacaoRN medicacaoRN;

    public MedicacaoRest() {
        medicacaoRN = new MedicacaoRN();
    }
    
    @Override
    public Response consultarPK(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response pesquisar(String q) {
        try {
            List<Medicacao> ret = medicacaoRN.pesquisar(q);
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
    public Response salvar(String obj) {
        try {
            Medicacao m = medicacaoRN.salvar(new Gson().fromJson(obj, Medicacao.class));
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(m.getId())).build();
            return Response.created(uri).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }        
    }

    @Override
    public Response alterar(String obj) {
        try {
            Medicacao m = medicacaoRN.alterar(new Gson().fromJson(obj, Medicacao.class));
            URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(m.getId())).build();
            return Response.created(uri).build();
        } catch (RNException e) {
            return exceptionParaResponse(e);
        }       
    }

    @Override
    protected Response gerarResponseParaCollection(List<Medicacao> obj) {
        if (obj == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(toJSON(new ErroRest("Nenhum registro disponível; lista vazia")))
                .build();
        }

        return Response.ok(new Gson().toJson(obj)).build();
    }               
}
