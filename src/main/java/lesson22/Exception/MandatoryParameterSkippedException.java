package lesson22.Exception;

public class MandatoryParameterSkippedException extends RuntimeException {

    public MandatoryParameterSkippedException(String message) {
        super(message);
    }
}

