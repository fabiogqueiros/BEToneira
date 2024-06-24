package betoneira.model;

public abstract class Jogos {
    private Integer seed;
    private Conquista.Aposta apostas[];
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
