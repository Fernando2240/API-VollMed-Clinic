package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class HorarioFuncionamiento {

    public void validar(DatosAgendarConsulta datosAgendarConsulta) {

        LocalDateTime fecha = datosAgendarConsulta.fecha();

        Boolean domingo = DayOfWeek.SUNDAY.equals(fecha.getDayOfWeek());

        Boolean antesApertura = fecha.getHour() < 7;
        Boolean despuesCierre = fecha.getHour() > 19;

        if(domingo || antesApertura || despuesCierre){
            throw new ValidationException("El horario de atención de la clinica es de lunes a sabado de 7:00 a 19:00 horas");
        }
    }
}
