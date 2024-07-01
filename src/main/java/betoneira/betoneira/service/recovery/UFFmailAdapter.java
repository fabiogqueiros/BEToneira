package betoneira.betoneira.service.recovery;

public class UFFmailAdapter implements EmailSender{

    private UFFmail service;

    public UFFmailAdapter() {
        this.service = new UFFmail();
    }

    @Override
    public void enviaEmail(String email, String msg){

        String nome = email.split("_")[0];
        String sufixo = email.split("@")[1];

        service.sendUFFmail(nome, sufixo, msg);
    }
}