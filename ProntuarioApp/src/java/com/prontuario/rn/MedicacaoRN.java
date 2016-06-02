package com.prontuario.rn;

import com.prontuario.CRUD.CrudGenericoRN;
import com.prontuario.bd.MedicacaoBD;
import com.prontuario.bean.Medicacao;
import java.util.List;
import javax.jws.WebService;


@WebService
public class MedicacaoRN extends CrudGenericoRN<Medicacao>{
    
    private final MedicacaoBD medicacaoBD;
    
    public MedicacaoRN() {
        this.medicacaoBD = new MedicacaoBD();
    }

    @Override
    public Medicacao consultar(Medicacao obj) {
        avaliarConsultar(medicacaoBD, obj);
        return medicacaoBD.consultar(obj);
    }

    @Override
    public boolean excluir(Medicacao obj) {
        avaliarExcluir(medicacaoBD, obj);
        return medicacaoBD.excluir(obj);
    }

    @Override
    public List<Medicacao> pesquisar(Medicacao obj) {
        avaliarPesquisar(medicacaoBD, obj);
        return medicacaoBD.pesquisar(obj);
    }

    @Override
    public Medicacao salvar(Medicacao obj) {
        avaliarSalvar(medicacaoBD, obj);
        return medicacaoBD.salvar(obj);
    } 
}

