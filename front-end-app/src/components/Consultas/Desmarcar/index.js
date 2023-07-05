import API from "../../../config/API";
import React from "react";
import "./index.css";

export default function DesmarcarConsulta() {
  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita o comportamento padrão de recarregar a página

    const idConsulta = event.target.idConsulta.value;
    const motivo = event.target.motivo.value;

    const formData = {
      idConsulta,
      motivo,
    };

    try {
      const response = await API.delete(`/consultas/${idConsulta}`, { data: formData });
      alert("Consulta desmarcada com sucesso!");
    } catch (error) {
      alert("Erro ao desmarcar consulta!");
      console.log(formData); // Imprime o objeto formData no console
    }
  };

  return (
    <div className="Cancelar-consulta">
      <h1 className="titulo">Cancelar Consulta</h1>
      <form onSubmit={handleSubmit}>
        <label className="pergunta" htmlFor="idConsulta">
          ID da Consulta:
        </label>
        <input type="text" id="idConsulta" name="idConsulta" required />

        <label className="pergunta" htmlFor="motivo">
          Motivo do Cancelamento:
        </label>
        <select id="motivo" name="motivo" required>
          <option value="">Selecione o motivo</option>
          <option value="PACIENTE_DESISTIU">Paciente desistiu</option>
          <option value="MEDICO_CANCELOU">Médico cancelou</option>
          <option value="OUTROS">Outros</option>
        </select>

        <input type="submit" value="Cancelar Consulta" />
      </form>
    </div>
  );
}
