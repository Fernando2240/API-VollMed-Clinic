package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.LocalDateTime;

public class PacienteSinConsulta {

    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {

        LocalDateTime primerHorario = datosAgendarConsulta.fecha().withHour(7);
        LocalDateTime ultimoHorario = datosAgendarConsulta.fecha().withHour(18);

        Boolean pacienteConConsulta = consultaRepository.existsByPacienteIdAndDateBetween(datosAgendarConsulta.idPaciente(), primerHorario, ultimoHorario);

        if (pacienteConConsulta) {
            throw new ValidationException("No se permite programar mas de una consulta en el mismo dia");
        }
    }
}
