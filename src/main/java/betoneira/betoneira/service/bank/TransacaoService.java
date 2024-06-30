package betoneira.betoneira.service.bank;

import betoneira.betoneira.model.bank.Transacao;
import betoneira.betoneira.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;


    public List<Transacao> getTransacoes() {
        return repository.findAll();
    }


    public Transacao getTransacaoById(int id) {
        return repository.findById(id);
    }


    public Transacao createTransacao( Transacao transacao) {
        transacao.setDataTransacao(LocalDate.now());
        return repository.save(transacao);
    }


    public Transacao updateTransacao(Transacao transacao) {
        return repository.save(transacao);
    }


    public Transacao deleteTransacaoById(int id) {
        Transacao transacao = repository.findById(id);
        if (transacao == null) {
            return null;
        } else {
            repository.delete(transacao);
            return transacao;
        }
    }


    public List<Transacao> getTransacaoWithFilter(String inicio, String fim){
        LocalDate dataInicio = LocalDate.parse(inicio);
        LocalDate dataFim = LocalDate.parse(fim);
        List<Transacao> listaTransacao = new ArrayList<>();
        List<Transacao> todasTransacoes = this.getTransacoes();
        Iterator<Transacao> iterador = todasTransacoes.iterator();
        while (iterador.hasNext()){
            Transacao transacao = iterador.next();
            if(transacao.getDataTransacao() != null){
                if(!dataInicio.isAfter(transacao.getDataTransacao()) && !dataFim.isBefore(transacao.getDataTransacao())){
                    listaTransacao.add(transacao);
                }
            }
        }
        return listaTransacao;
    }

}
