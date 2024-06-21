package betoneira.betoneira.games;

import betoneira.betoneira.Aposta;

public abstract class Jogos {
    private int seed;
    private Aposta apostas[];
    private String tipo;

    
    public abstract void iniciarJogo();/*{
        //Implement Method
    }*/
    public abstract void encerrarJogo();/*{
        //Implement Method
    };*/
    //public abstract void sorteia();
}
