import React from "react";
import "./index.css";
import API from "../../../config/API";

export default function CadastroMedico() {
  const handleSubmit = async (event) => {
    event.preventDefault(); // Evita o envio padrão do formulário

    // Captura os valores dos campos do formulário
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const telefone = document.getElementById("telefone").value;
    const crm = document.getElementById("crm").value;
    const especialidade = document.getElementById("especialidade").value;
    const logradouro = document.getElementById("logradouro").value;
    const numero = document.getElementById("numero").value;
    const complemento = document.getElementById("complemento").value;
    const bairro = document.getElementById("bairro").value;
    const cidade = document.getElementById("cidade").value;
    const uf = document.getElementById("uf").value;
    const cep = document.getElementById("cep").value;

    // Cria um objeto JSON com os valores capturados
    const dadosMedico = {
      nome,
      email,
      telefone,
      crm,
      especialidade,
      endereco: {
        logradouro,
        numero,
        complemento,
        bairro,
        cidade,
        uf,
        cep
      }
    };

    try {
      // Envia os dados para o endpoint usando o Axios
      await API.post("/medicos", dadosMedico);

      // Limpa os campos do formulário após o envio bem-sucedido
      document.getElementById("nome").value = "";
      document.getElementById("email").value = "";
      document.getElementById("telefone").value = "";
      document.getElementById("crm").value = "";
      document.getElementById("especialidade").value = "";
      document.getElementById("logradouro").value = "";
      document.getElementById("numero").value = "";
      document.getElementById("complemento").value = "";
      document.getElementById("bairro").value = "";
      document.getElementById("cidade").value = "";
      document.getElementById("uf").value = "";
      document.getElementById("cep").value = "";

      // Exibe uma mensagem de sucesso ou redireciona para outra página, se necessário
      alert("Cadastro realizado com sucesso!");
    } catch (error) {
        alert("Erro ao cadastrar médico!");
      // Manipula erros de requisição, se houver
      console.error(error);
    }
  };

  return (
    <div className="cadastro-medico">
      <h1 className="titulo">Cadastro de Médicos</h1>
      <form onSubmit={handleSubmit}>
        <label className="pergunta" htmlFor="nome">
          Nome:
        </label>
        <input type="text" id="nome" name="nome" required />

        <label className="pergunta" htmlFor="email">
          E-mail:
        </label>
        <input type="email" id="email" name="email" required />

        <label className="pergunta" htmlFor="telefone">
          Telefone:
        </label>
        <input type="tel" id="telefone" name="telefone" required />

        <label className="pergunta" htmlFor="crm">
          CRM:
        </label>
        <input type="text" id="crm" name="crm" required />

        <label className="pergunta" htmlFor="especialidade">
          Especialidade:
        </label>
        <select id="especialidade" name="especialidade" required>
          <option value="ORTOPEDIA">ORTOPEDIA</option>
          <option value="CARDIOLOGIA">CARDIOLOGIA</option>
          <option value="GINECOLOGIA">GINECOLOGIA</option>
          <option value="DERMATOLOGIA">DERMATOLOGIA</option>
        </select>

        <h2>Endereço</h2>
        <label className="pergunta" htmlFor="logradouro">
          Logradouro:
        </label>
        <input type="text" id="logradouro" name="logradouro" required />

        <label className="pergunta" htmlFor="numero">
          Número:
        </label>
        <input type="text" id="numero" name="numero" />

        <label className="pergunta" htmlFor="complemento">
          Complemento:
        </label>
        <input type="text" id="complemento" name="complemento" />

        <label className="pergunta" htmlFor="bairro">
          Bairro:
        </label>
        <input type="text" id="bairro" name="bairro" required />

        <label className="pergunta" htmlFor="cidade">
          Cidade:
        </label>
        <input type="text" id="cidade" name="cidade" required />

        <label className="pergunta" htmlFor="uf">
          UF:
        </label>
        <input type="text" id="uf" name="uf" required />

        <label className="pergunta" htmlFor="cep">
          CEP:
        </label>
        <input type="text" id="cep" name="cep" required />

        <input type="submit" value="Cadastrar" />
      </form>
    </div>
  );
}
