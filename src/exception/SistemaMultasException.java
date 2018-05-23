package exception;

public final class SistemaMultasException extends Exception{

    public SistemaMultasException() {
        super("Ocorreu um erro desconhecido!");
    }
    public SistemaMultasException(String msg) {
        super(msg);
    }
}
