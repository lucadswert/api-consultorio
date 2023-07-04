package med.voll.api.validacoes.agendamento;

import med.voll.api.repositories.ConsultaRepository;
import med.voll.api.dtos.DtoCriacaoConsulta;
import med.voll.api.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsultaNoMesmoHorario implements ValidadorAgendamento {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DtoCriacaoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }

}
