package com.prontuario.crud;

public abstract class CrudGenericoRN<T> implements CrudGenerico<T> {

    protected void avaliarSalvar(CrudGenerico crudGenerico, Object object) {
        if (crudGenerico.consultar(object) != null) {
            throw new RNException(RNException.Tipo.REGISTRO_JA_EXISTE, "Registro já existe");
        }
    }

    protected void avaliarConsultar(CrudGenerico crudGenerico, Object object) {
        if (crudGenerico.consultar(object) == null) {
            throw new RNException(RNException.Tipo.REGISTRO_NAO_ENCONTRADO, "Registro não encontrado");
        }
    }

    protected void avaliarAlterar(CrudGenerico crudGenerico, Object object) {
        avaliarConsultar(crudGenerico, object);
    }

    protected void avaliarExcluir(CrudGenerico crudGenerico, Object object) {
        avaliarConsultar(crudGenerico, object);
    }

    protected String avaliarPesquisar(String valor) {
        return (valor == null || "null".equalsIgnoreCase(valor)) ? "" : valor;
    }
}
