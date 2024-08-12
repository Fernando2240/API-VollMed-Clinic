package med.voll.api.infra.errores;

public class ValidacionIntegridad extends RuntimeException {

    public ValidacionIntegridad(String message) {
        super(message);
    }
}
