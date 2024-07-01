package betoneira.betoneira.service.recovery;

//Representa um serviço externo. Não faz parte do sistema

public class UFFmail {

    public UFFmail(){
    }

    public void sendUFFmail(String nome, String sufixo, String msg){
        System.out.printf("Uau! Enviamos um email pelo iduff para %s_%s com a mensagem %s !!", nome, sufixo, msg);
    }
}
