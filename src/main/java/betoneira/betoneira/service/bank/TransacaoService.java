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

    public List<Transacao> getTransacoesByNome(String nome) {
        List<Transacao> todasTransacoes = repository.findAll();
        Iterator<Transacao> iterador = todasTransacoes.iterator();
        List<Transacao> transacoesUsuario = new ArrayList<Transacao>();
        while (iterador.hasNext()) {
            Transacao transacaoAtual = iterador.next();
            if (transacaoAtual.getNome() != null) {
                if (transacaoAtual.getNome().equals(nome)) {
                    transacoesUsuario.add(transacaoAtual);
                }
            }
        }
        return transacoesUsuario;
    }


    public Transacao getTransacaoById(int id) {
        return repository.findById(id);
    }


    public Transacao createTransacao(Transacao transacao) {
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

    public String getTransacaoByNomeWithFilter(String nome, int tipo, String inicio, String fim){
        LocalDate dataInicio = LocalDate.parse(inicio);
        LocalDate dataFim = LocalDate.parse(fim);
        List<Transacao> listaTransacao = new ArrayList<>();
        List<Transacao> todasTransacoes = this.getTransacoesByNome(nome);
        Iterator<Transacao> iterador = todasTransacoes.iterator();
        String tipoTransacao = "";
        String listaFinal = "";
        if(tipo == 1){
            tipoTransacao = "Saque";
        } else if (tipo == 2) {
            tipoTransacao = "Deposito";
        }
        while (iterador.hasNext()){
            Transacao transacao = iterador.next();
            if(tipo == 1 || tipo == 2){
                if(transacao.getDataTransacao() != null && transacao.getTipo().equals(tipoTransacao)){
                    if(!dataInicio.isAfter(transacao.getDataTransacao()) && !dataFim.isBefore(transacao.getDataTransacao())){
                        listaTransacao.add(transacao);
                    }
                }
            }
            else{
                if(transacao.getDataTransacao() != null){
                    if(!dataInicio.isAfter(transacao.getDataTransacao()) && !dataFim.isBefore(transacao.getDataTransacao())){
                        listaTransacao.add(transacao);
                    }
                }
            }
        }
        Iterator<Transacao> iteradorFinal = listaTransacao.iterator();
        while(iteradorFinal.hasNext()){
            Transacao transacaoPrint = iteradorFinal.next();
            listaFinal = listaFinal + "Tipo: " + transacaoPrint.getTipo() + "\nQuantia: " + String.valueOf(transacaoPrint.getQuantia()) + "\nData da Transacao: " + transacaoPrint.getDataTransacao().toString() + "\n\n";
        }

        return listaFinal;
    }

}
