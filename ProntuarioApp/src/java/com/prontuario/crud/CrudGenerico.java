package com.prontuario.crud;

import java.util.List;

public interface CrudGenerico<T> {

    T consultar(T bean);

    boolean excluir(T bean);
    
    T salvar(T bean);    

    T alterar(T bean);    
    
    // métodos válidos para as pesquisas REST
    List<T> pesquisar(T bean);    
    List<T> pesquisar(String valor);
    
}
