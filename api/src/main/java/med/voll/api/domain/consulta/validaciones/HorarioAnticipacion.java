package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.infra.errores.ValidacionIntegridad;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class HorarioAnticipacion {

    public void validar(DatosAgendarConsulta datosAgendarConsulta){

        LocalDateTime horaConsulta = datosAgendarConsulta.fecha();
        LocalDateTime ahora = LocalDateTime.now();

        Boolean diferencia30Min = Duration.between(ahora, horaConsulta).toMinutes() < 30;

        if(diferencia30Min){
            throw new ValidationException("Las consultas deben tener al menos 30 minutos de anticipación");
        }
    }
}
