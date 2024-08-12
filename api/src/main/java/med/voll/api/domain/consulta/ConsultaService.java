package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DatosAgendarConsulta datos) {

        Optional<Paciente> paciente = pacienteRepository.findById(datos.idPaciente());

        if (!paciente.isPresent()){
            throw new ValidacionIntegridad("El paciente no fue encontrado");
        }

        if(datos.idMedico() != null){
            Optional<Medico> medico = medicoRepository.findById(datos.idMedico());
            if(medico.isEmpty()) {
                throw new ValidacionIntegridad("El medico no fue encontrado");
            }
            Consulta consulta = new Consulta(null, medico.get(), paciente.get(), datos.fecha());
        }

        Consulta c = new Consulta(null, medicoRepository.seleccionarMedicoConEspecialidadEnFecha(datos.especialidad(), datos.fecha()), paciente.get(), datos.fecha());

    }

    private Medico seleccionarMedico(Medico medico, DatosAgendarConsulta datos){
        if (datos.especialidad() != null){
            throw new ValidacionIntegridad("Debe indicar una especialidad para el medico");
        }

        return medicoRepository.seleccionarMedicoConEspecialidadEnFecha(datos.especialidad(), datos.fecha());
    }
}
