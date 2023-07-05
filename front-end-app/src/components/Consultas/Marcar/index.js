import API from "../../../config/API";
import React from "react";
import "./index.css";

export default function MarcarConsulta() {
  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita o comportamento padrão de recarregar a página

    const idPaciente = event.target.idPaciente.value;
    const idMedico = event.target.idMedico.value;
    const data = event.target.dataHora.value;

    const formData = {
      idPaciente,
      idMedico,
      data,
    };

    
    try {
        const response = await API.post('/consultas', formData);
        alert("Consulta marcada com sucesso!");
    } catch (error) {
        alert("Erro ao marcar consulta!");
        console.log(formData); // Imprime o objeto formData no console
    }
  };

  return (
    <div className="marcar-consulta">
      <h1 className="titulo">Cadastro de Médicos</h1>
      <form onSubmit={handleSubmit}>
        <label className="pergunta" htmlFor="idPaciente">
          ID do Paciente:
        </label>
        <input type="text" id="idPaciente" name="idPaciente" required />

        <label className="pergunta" htmlFor="idMedico">
          ID do Médico:
        </label>
        <input type="text" id="idMedico" name="idMedico" required />

        <label className="pergunta" htmlFor="dataHora">
          Data/Hora da Consulta:
        </label>
        <input type="datetime-local" id="dataHora" name="dataHora" required />

        <input type="submit" value="Marcar Consulta" />
      </form>
    </div>
  );
}
