package med.voll.api.validacoes.agendamento;

import med.voll.api.ValidacaoException;
import med.voll.api.dtos.DtoCriacaoConsulta;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamento {

    @Autowired
    private MedicoRepository repository;

    public void validar(DtoCriacaoConsulta dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }

}
