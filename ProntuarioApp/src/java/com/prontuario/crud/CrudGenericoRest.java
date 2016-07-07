package com.prontuario.crud;

import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * Utilizado para expor os serviços REST com base nas RNs do projeto.
 *
 * @see http://www.restapitutorial.com/lessons/httpmethods.html
 * http://gc.blog.br/2007/07/02/post-vs-put-quem-insere-e-quem-altera/
 * @author lossurdo
 * @param <T>
 */
public abstract class CrudGenericoRest<T> {

    @Context
    protected UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;
    
    @GET
    @Path("{pk}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract Response consultarPK(@PathParam(value = "pk") String pk);

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public abstract Response pesquisar(@QueryParam(value = "q") String q);

    @DELETE
    @Path("{pk}")
    public abstract Response excluirPK(@PathParam(value = "pk") String pk);

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public abstract Response salvar(String obj);

    @PUT
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public abstract Response alterar(String obj);

    /**
     * Pela característica da conversão das coleções
     * do Java em JSON, este método não permite
     * implementação genérica; deve ser implementado
     * nas classes filhas.
     * 
     * Exemplo:
     * GenericEntity<List<Teste>> genericEntity = new GenericEntity<List<Teste>>(LISTA) {};
     * 
     * @param obj
     * @return 
     */
    protected abstract Response gerarResponseParaCollection(List<T> obj);

    /**
     * Converte uma RNException para o Response necessário
     * conforme tipo de erro de regra de negócio.
     * 
     * @see http://www.restapitutorial.com/lessons/httpmethods.html
     * @param exception
     * @return 
     */
    protected Response exceptionParaResponse(RNException exception) {
        if (exception.getTipo().equals(RNException.Tipo.REGISTRO_JA_EXISTE)) {
            return Response.status(Response.Status.CONFLICT)
                .entity(toJSON(new ErroRest(exception.getTipo().toString())))
                .build();
        } else if (exception.getTipo().equals(RNException.Tipo.REGISTRO_NAO_ENCONTRADO)) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity(toJSON(new ErroRest(exception.getTipo().toString())))
                .build();
        }

        return Response.serverError()
            .entity(toJSON(new ErroRest(exception.getMessage())))
            .build();                
    }

    /**
     * Converte um objeto qualquer em formato JSON
     * 
     * @param object
     * @return 
     */
    protected String toJSON(Object object) {
        return new Gson().toJson(object);
    }
}
