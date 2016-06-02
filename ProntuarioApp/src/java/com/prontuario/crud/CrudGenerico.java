package com.prontuario.crud;

import java.util.List;

public interface CrudGenerico<T> {

    T consultar(T obj);

    boolean excluir(T obj);
    
    List<T> pesquisar(T obj);

    T salvar(T obj);    
    
}
