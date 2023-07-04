package med.voll.api.validacoes.agendamento;

import med.voll.api.repositories.ConsultaRepository;
import med.voll.api.dtos.DtoCriacaoConsulta;
import med.voll.api.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPresencaDeOutraConsultaNoDia implements ValidadorAgendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DtoCriacaoConsulta dados) {
        var primeiroHorarioDoDia = dados.data().withHour(7);
        var ultimoHorarioDoDia = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorarioDoDia, ultimoHorarioDoDia);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("Já existe uma consulta agendada para o paciente nesse dia");
        }
    }


}
