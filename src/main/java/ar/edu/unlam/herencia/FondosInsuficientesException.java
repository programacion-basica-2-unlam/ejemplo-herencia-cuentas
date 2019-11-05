package ar.edu.unlam.herencia;

public class FondosInsuficientesException extends RuntimeException {

    public FondosInsuficientesException() {
    }

    public FondosInsuficientesException(String message) {
        super(message);
    }
}
