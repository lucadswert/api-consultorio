import { useEffect, useState } from "react";
import API from "../../../config/API";
import "./index.css";
import { useParams } from "react-router-dom";

export default function ListarPacientePorId() {
  const [paciente, setPaciente] = useState(null);
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [endereco, setEndereco] = useState({
    logradouro: "",
    numero: "",
    complemento: "",
    bairro: "",
    cidade: "",
    uf: "",
    cep: ""
  });
  const { id } = useParams();

  useEffect(() => {
    async function loadPaciente() {
      try {
        const response = await API.get(`/pacientes/${id}`);
        setPaciente(response.data);
        setNome(response.data.nome);
        setTelefone(response.data.telefone);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    loadPaciente();
  }, [id]);

  const handleDelete = async (id) => {
    try {
      await API.delete(`/pacientes/${id}`);
      setPaciente(null);
    } catch (error) {
      console.log(error);
    }
  };

  const handleUpdate = async () => {
    try {
      const updatedPaciente = {
        ...paciente,
        nome: nome,
        telefone: telefone,
        endereco: endereco
      };
      await API.put(`/pacientes/${paciente.id}`, updatedPaciente);
      alert("Dados atualizados com sucesso!");
    } catch (error) {
      console.log(error);
    }
  };

  if (!paciente) {
    return <div className="container">Carregando...</div>;
  }

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">NOME</th>
              <th scope="col">E-MAIL</th>
              <th scope="col">CPF</th>
              <th scope="col">TELEFONE</th>
              <th scope="col">LOGRADOURO</th>
              <th scope="col">NÚMERO</th>
              <th scope="col">COMPLEMENTO</th>
              <th scope="col">BAIRRO</th>
              <th scope="col">CIDADE</th>
              <th scope="col">UF</th>
              <th scope="col">CEP</th>
              <th scope="col">Editar</th>
              <th scope="col">Apagar</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">{paciente.id}</th>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={nome}
                  onChange={(e) => setNome(e.target.value)}
                />
              </td>
              <td>{paciente.email}</td>
              <td>{paciente.cpf}</td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={telefone}
                  onChange={(e) => setTelefone(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.logradouro}
                  onChange={(e) =>
                    setEndereco({ ...endereco, logradouro: e.target.value })
                  }
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.numero}
                  onChange={(e) =>
                    setEndereco({ ...endereco, numero: e.target.value })
                  }
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.complemento}
                  onChange={(e) =>
                    setEndereco({ ...endereco, complemento: e.target.value })
                  }
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.bairro}
                  onChange={(e) =>
                    setEndereco({ ...endereco, bairro: e.target.value })
                  }
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.cidade}
                  onChange={(e) =>
                    setEndereco({ ...endereco, cidade: e.target.value })
                  }
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.uf}
                  onChange={(e) =>
                    setEndereco({ ...endereco, uf: e.target.value })
                  }
                />
              </td>
              <td>
                <input
                  type="text"
                  className="form-control"
                  value={endereco.cep}
                  onChange={(e) =>
                    setEndereco({ ...endereco, cep: e.target.value })
                  }
                />
              </td>
              <td>
                <button
                  className="btn btn-outline-primary mx-2"
                  onClick={handleUpdate}
                >
                  Atualizar
                </button>
              </td>
              <td>
                <button
                  className="btn botaoApagar"
                  onClick={() => handleDelete(paciente.id)}
                >
                  Apagar
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}
