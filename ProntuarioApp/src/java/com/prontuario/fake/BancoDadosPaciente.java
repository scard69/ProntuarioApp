package com.prontuario.fake;

import com.prontuario.bean.Paciente;
import com.prontuario.CRUD.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BancoDadosPaciente implements CrudGenerico<Paciente> {

    private TreeSet<Paciente> listagem;

    private BancoDadosPaciente() {
        listagem = new TreeSet<>();
        
               listagem.add(new Paciente(
                100, 
                "Antonio", 
                "antonios@gmail.com",
                "07/09/1989",
                "51-91123456",
                "M",
                "",
                "",
                "",
                ""
        ));
    }

    public static BancoDadosPaciente getInstance() {
        return BancoDadosHolder.INSTANCE;
    }

    @Override
    public List<Paciente> pesquisar(Paciente obj) {
        if(obj==null) {
            return new ArrayList<>(listagem);
        }
        TreeSet<Paciente> lista = new TreeSet<>();
        for (Paciente p : listagem) {
                lista.add(p);
        }
        return new ArrayList<>(lista);
    }

    private static class BancoDadosHolder {

        private static final BancoDadosPaciente INSTANCE = new BancoDadosPaciente();
    }

    @Override
    public Paciente consultar(Paciente obj) {
        for (Paciente p : listagem) {
            if (p.equals(obj)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Paciente obj) {
        return listagem.remove(obj);
    }

    @Override
    public Paciente salvar(Paciente obj) {
        listagem.remove(obj);
        listagem.add(obj);
        return obj;
    }

}
