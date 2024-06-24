package betoneira.model;

import betoneira.interfaces.InterfaceRecuperacao;
import betoneira.interfaces.InterfaceSorteio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Conquista {
    private String titulo;
    private String descricao;

    public static class AutenticacaoTrue extends StateAutenticacao {
        private ContextAutenticacao context;


        AutenticacaoTrue(ContextAutenticacao state){
            super(state);
            //state.
            //Implement Method
        }
        public void autenticaRequisicao(Requisicao req){
            //Implemnents Method
        }
        public void setContext(ContextAutenticacao context){
            this.context = context;
            //Implemnents Method
        };
    }

    public static class ContextAutenticacao {
        private StateAutenticacao state;
        private boolean autenticado;//Nao sei se e mais necessario com o uso do padrao GoF State!!!!!


        ContextAutenticacao(StateAutenticacao stateInitial){
            this.state = stateInitial;
            //Implemnents Method
        }

        public void autenticaRequisicao(Requisicao req){
            this.state.autenticaRequisicao(req);
        }
        public void changeState(StateAutenticacao state){
            this.state = state;
            this.state.setContext(this);
        }
    }

    public static class Recuperacao implements InterfaceRecuperacao {
        private String email;
        private Integer codigo;


        public void enviarEmail(){};
        public void gerarCodigo(){};
        public void confirmarCodigo(String codigo){};
    }

    public static class AutenticaoFalse extends StateAutenticacao{
        private betoneira.model.ContextAutenticacao context;


        AutenticaoFalse(betoneira.model.ContextAutenticacao state){
            super(state);
            //state.
            //Implement Method
        }
        @Override
        public void autenticaRequisicao(Requisicao req){
            //Implemnents Method
        }
        @Override
        public void setContext(betoneira.model.ContextAutenticacao context){
            //Implemnents Method
            this.context = context;
        };
    }

    public static class SorteioInteiro implements InterfaceSorteio {
        Random random;
        public SorteioInteiro(){
            this.random = new Random();
        }
        public Object sorteia(Object inicio, Object fim){
            Integer ini = (Integer) inicio;
            Integer fi = (Integer) fim;
            Integer numero = this.random.nextInt(fi - ini);
            return numero;
        };
    }

    public static class RecuperacaoDecoratorPhone implements InterfaceRecuperacao{
        private InterfaceRecuperacao recupera;
        private Integer codigo;
        private Integer phone;


        RecuperacaoDecoratorPhone(InterfaceRecuperacao recupera){//Exemplo de classe para estender novas funcionalidades para recuperar conta
            this.recupera = recupera;
        }

        @Override
        public void gerarCodigo(){
            recupera.gerarCodigo();
            //Implements method
        };
        @Override
        public void confirmarCodigo(String codigo){
            this.recupera.confirmarCodigo(codigo);
            //Implements method
        };
    }

    public abstract static class StateAutenticacao {
        private betoneira.model.ContextAutenticacao state;


        StateAutenticacao(betoneira.model.ContextAutenticacao state){
            this.state = state;
        }

        public abstract void setContext(betoneira.model.ContextAutenticacao context);
        public abstract void autenticaRequisicao(Requisicao req);

    }

    public static class Aposta {
        private float quantia;
        private Jogos jogo;
        private String tipoJogo;//E necessario?
        private Conta conta;
        private float salto;


        public void iniciarJogo(){
            this.jogo.iniciarJogo();
            //Implement Method
        }
        public void encerrarAposta(double d){//Mudei o tipo da variavel aqui, rever isso (somente para evitar erro no codigo)
            //Implemnents Method
        }
        private void calculaSaldo(float multiplicador){
            //Implemnents Method
        }
    }

    public static class Requisicao {
        String usuario;
        //Vai ter alguma funcao de especificar qual o tipo de requisicao que vamos fazer?
    }

    public static class Roleta extends Jogos{
        private String cores[];
        private Integer numeros[];
        private String corEscolhida;
        private Integer numeroEscolhido;


        //@Override
        public void iniciarJogo(){
            //Implement Method
        }
        public List<?> sorteia(){//Refazer a assinatura, somente definicao (Ha sentido retornar uma lista? Porque?)
            //Implements Method
            return new ArrayList<>();
        }
        public void encerrarJogo(){
            //Implements Method
        }
        public Integer calcularMultiplicador(){
            //Implements Method
            return 1;
        }
    }

    public static class Loteria extends Jogos{
        private Date inicio;
        private Date fim;
        private static betoneira.model.Loteria loteria;
        private Map<Integer, List<betoneira.model.Aposta>> bilhetes;//Nao defini ao certo a tipagem, mas deixar como lembrete de (Aposta, numero)
        private InterfaceSorteio sorteio;
        private Integer[] numerosValidos;//Atualizar o diagrama de classes


        public static betoneira.model.Loteria getCurrentLoteria(){
            if(loteria == null){
                loteria = new betoneira.model.Loteria();
            }
            return loteria;
        }
        //@Override
        public void iniciarJogo(){
            this.sorteio = new betoneira.model.SorteioInteiro();
            //Implement Method
        }
        public Integer sorteia(){//Acho que aqui vai virar uma funcao void, levado em conta o padrao GoF Observer (Correcao, fica a mesma coisa, observer ficou em encerrarJogo)
            Integer numero = (Integer) this.sorteio.sorteia(this.numerosValidos[0], this.numerosValidos[-1]);//Colocar aqui o range de numeros ou cores da aposta (Como retorna o ultimo numero?)
            return numero;
        }
        public void addBilhetes(betoneira.model.Aposta aposta, int numero){//Adicionando observadores aqui
            List<betoneira.model.Aposta> temp = this.bilhetes.get(numero);
            temp.add(aposta);
            this.bilhetes.put(numero, temp);//Fazer a logica ainda de escolher o numero
            //Implements Method
        }
        public Integer[] getNumerosValidos(){
            return this.numerosValidos;
        }
        public void encerrarJogo(){
            Integer numero = this.sorteia();
            this.bilhetes.forEach((key, value) -> {
                for (betoneira.model.Aposta apt : value) {
                    if(key == numero){//Fazer talvez um tratamento de voltar o multiplicador relativo a cada aposta (desacoplando aposta de Loteria)
                        apt.encerrarAposta(numero);
                    }
                    else apt.encerrarAposta(numero);
            };});
        }
        public Integer calcularMultiplicador(){
            //Implements Method
            return 1;
        }

    }

    public abstract static class Jogos {
        private Integer seed;
        private betoneira.model.Aposta apostas[];
        private String tipo;


        public abstract void iniciarJogo();/*{
            //Implement Method
        }*/
        public abstract void encerrarJogo();/*{
            //Implement Method
        };*/
        //public abstract void sorteia();
        public abstract Integer calcularMultiplicador();
        //public abstract Integer sorteia();
    }

    public static class Aviao extends betoneira.model.Jogos {
        private Integer tempo;
        private String estado;
        private float multiplicadorAtual;


        //@Override
        public void iniciarJogo(){
            //Implement Method
        }
        public void parar(){
            //Implemnents Method
        }
        private void aviaoSobe(){//No diagrama esta como publico, nao acho que deve ser isso
            //Implements Method
        }
        private void aviaoCrash(){
            //Implements Method
        }
        public void encerrarJogo(){
            //Implements Method
        }
        public Integer calcularMultiplicador(){
            //Implements Method
            return 1;
        }
    }

    public static class Transacao {
        private String tipo;
        private float quantia;
        private String modo;

    }

    public static class ContaBancaria {
        private float saldo;
        private betoneira.model.Transacao historico;


        public void fazerTransacaoInterna(float saldo){
            //Implemnents Method
        }
        public void fazerDeposito(int idConta, float quantia){
            //Implemnents Method
        }
        public void fazerSaque(){//O retorno nao deve ser um inteiro, no caso de outra classe que chamou ela (como confirmacao)
            //Implemnents Method
        }
        public float consultarExtrato(int idConta){
            //Implemnents Method
            return this.saldo;
        }
        private float checarSaldo(){
            //Implemnents Method
            return this.saldo;
        }
        public void salvarTransacao(betoneira.model.Transacao trsc){
            //Implemnents Method
        }
        private void adicionarSaldo(float quantia){
            //Implemnents Method
        }
        private void realizarPagamento(float quantia){
            //Implemnents Method
        }

    }
}
