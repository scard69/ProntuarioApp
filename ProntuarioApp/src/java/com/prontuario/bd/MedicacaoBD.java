package com.prontuario.bd;

import com.prontuario.CRUD.CrudGenerico;
import com.prontuario.bean.Medicacao;
import com.prontuario.fake.BancoDadosMedicacao;
import java.util.List;


public class MedicacaoBD implements CrudGenerico<Medicacao>{

    @Override
    public Medicacao consultar(Medicacao obj) {
        return BancoDadosMedicacao.getInstance().consultar(obj);
    }

    @Override
    public boolean excluir(Medicacao obj) {
        return BancoDadosMedicacao.getInstance().excluir(obj);
    }

    @Override
    public List<Medicacao> pesquisar(Medicacao obj) {
        return BancoDadosMedicacao.getInstance().pesquisar(obj);
    }

    @Override
    public Medicacao salvar(Medicacao obj) {
        return BancoDadosMedicacao.getInstance().salvar(obj);
    }
}

