package com.senac.util;

import java.util.List;

public interface CrudGenerico<T> {
    
    public void salvar(T bean);
    public void excluir(T bean);
    public List<T> listar(T bean);
    public T consultar(T bean);
    
}
