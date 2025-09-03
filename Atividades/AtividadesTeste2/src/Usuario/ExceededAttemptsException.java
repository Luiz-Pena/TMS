package Usuario;

public class ExceededAttemptsException extends Exception {
    public ExceededAttemptsException(String mensagem) {
        super(mensagem);
    }
}
