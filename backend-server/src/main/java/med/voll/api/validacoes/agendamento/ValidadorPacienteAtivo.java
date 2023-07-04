package med.voll.api.validacoes.agendamento;

import med.voll.api.dtos.DtoCriacaoConsulta;
import med.voll.api.ValidacaoException;
import med.voll.api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamento {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DtoCriacaoConsulta dados) {
        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Não é possível agendar consulta com um paciente excluído");
        }
    }

}
