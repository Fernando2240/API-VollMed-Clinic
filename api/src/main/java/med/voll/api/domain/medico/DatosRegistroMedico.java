package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(String nombre, String email, String documento, String telefono, Especialidad especialidad, DatosDireccion direccion) {
}
