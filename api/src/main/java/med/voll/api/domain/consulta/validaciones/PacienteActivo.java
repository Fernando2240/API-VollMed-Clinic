package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class PacienteActivo {

    private PacienteRepository pacienteRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        Long idPaciente = datosAgendarConsulta.idPaciente();
        if (idPaciente == null){
            return;
        }

        Boolean pacienteActivo = pacienteRepository.findActivoById(idPaciente);

        if (!pacienteActivo){
            throw new ValidationException("No se permite agendar consultas cn pacientes inactivos en el sistemas");
        }
    }
}
