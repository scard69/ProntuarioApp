package com.prontuario.fake;

import com.prontuario.bean.Medicacao;
import com.prontuario.crud.CrudGenerico;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BancoDadosMedicacao implements CrudGenerico<Medicacao> {

    private TreeSet<Medicacao> listagem;

    private BancoDadosMedicacao() {
        listagem = new TreeSet<>();
        
              listagem = new TreeSet<>();
        
               listagem.add(new Medicacao(1, 100, "Paracetamol", "02/06/2016", "principio ativo", "dor de cabeça", "700mg", "1x8", "observacao")

        );
    }

    public static BancoDadosMedicacao getInstance() {
        return BancoDadosHolder.INSTANCE;
    }

    @Override
    public List<Medicacao> pesquisar(Medicacao obj) {
        if(obj==null) {
            return new ArrayList<>(listagem);
        }
        TreeSet<Medicacao> lista = new TreeSet<>();
        for (Medicacao p : listagem) {
                lista.add(p);
        }
        return new ArrayList<>(lista);
    }

    private static class BancoDadosHolder {

        private static final BancoDadosMedicacao INSTANCE = new BancoDadosMedicacao();
    }

    @Override
    public Medicacao consultar(Medicacao obj) {
        for (Medicacao p : listagem) {
            if (p.equals(obj)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean excluir(Medicacao obj) {
        return listagem.remove(obj);
    }

    @Override
    public Medicacao salvar(Medicacao obj) {
        listagem.remove(obj);
        listagem.add(obj);
        return obj;
    }
}
