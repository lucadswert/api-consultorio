package med.voll.api.validacoes.cancelamento;

import med.voll.api.dtos.DtoCancelarConsulta;
import med.voll.api.entidades.Consulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(Consulta dados);

}
