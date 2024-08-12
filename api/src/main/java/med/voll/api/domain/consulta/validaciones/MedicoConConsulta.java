package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.LocalDateTime;

public class MedicoConConsulta {

    private ConsultaRepository consultaRepository;

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {

        if(datosAgendarConsulta.idMedico() == null){
            return;
        }

        Boolean medicoConConsulta = consultaRepository.existsByMedicoIdAndDate(datosAgendarConsulta.fecha(), datosAgendarConsulta.fecha());

        if (medicoConConsulta) {
            throw new ValidationException("El medico ya tiene una consulta en ese horario");
        }
    }
}
