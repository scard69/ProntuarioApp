/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prontuario.rest;

import com.google.gson.Gson;
import com.prontuario.bean.Medicacao;
import com.prontuario.crud.CrudGenericoRest;
import com.prontuario.rn.MedicacaoRN;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author scard
 */
@Path("/medicacoes")
public class MedicacaoRest extends CrudGenericoRest<Medicacao>{
    
    private MedicacaoRN medicacaorn;

    public MedicacaoRest() {
        this.medicacaorn = new MedicacaoRN();
    }
    
    @Override
    public Response consultarPK(String pk) {
        Medicacao m = medicacaorn.consultar(new Medicacao(Integer.parseInt(pk)));
        return Response.ok(m).build();
    }

    @Override
    public Response pesquisar(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response listar(Integer offset, Integer limit) {
        List<Medicacao> ret = medicacaorn.listar(null);
        return gerarResponseParaCollection(ret);
    }

    @Override
    public Response excluirPK(String pk) {
        medicacaorn.excluir(new Medicacao(Integer.parseInt(pk)));
        return Response.ok().build();
    }

    @Override
    public Response salvar(String medicacao) {
       medicacaorn.salvar(new Gson().fromJson(medicacao, Medicacao.class));

        URI uri = uriInfo.getAbsolutePathBuilder().path(medicacao.getId().toString()).build();
        return Response.created(uri).build();        
    }

    @Override
    protected Response gerarResponseParaCollection(List<Medicacao> obj) {
        if (obj == null || obj.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        GenericEntity<List<Medicacao>> lista = new GenericEntity<List<Medicacao>>(obj) {
        };
        return Response.ok(lista).build();        
    }    
}
