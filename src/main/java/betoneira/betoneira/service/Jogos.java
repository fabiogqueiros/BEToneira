package betoneira.betoneira.service;

import betoneira.betoneira.model.Aposta;

public abstract class Jogos {
    private int seed;//Nao ha sentido serem privados, ja que esta classe nao usa ela
    private Aposta apostas[];
    private String tipo;
    protected float multiplicador;

    
    public abstract void iniciarJogo();
    
    public abstract void encerrarJogo();

    //public abstract int sorteia();

    public abstract float calcularMultiplicador();
}
