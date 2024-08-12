package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;
import org.antlr.v4.runtime.misc.NotNull;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {
}
