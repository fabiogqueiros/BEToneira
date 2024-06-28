package betoneira.betoneira.service;

import betoneira.betoneira.model.Aposta;

public abstract class Jogos {
    private int seed;
    private Aposta apostas[];
    private String tipo;
    protected float multiplicador;

    
    public abstract void iniciarJogo();/*{
        //Implement Method
    }*/
    public abstract void encerrarJogo();/*{
        //Implement Method
    };*/
    //public abstract void sorteia();
    public abstract float calcularMultiplicador();
    //public abstract Integer sorteia();
}
