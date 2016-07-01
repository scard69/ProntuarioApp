package com.prontuario.crud;

import java.util.List;

public interface CrudGenerico<T> {
    
    public T salvar(T bean);
    public boolean excluir(T bean);
    public List<T> listar(T bean);
    public T consultar(T bean);
    
}
