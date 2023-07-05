import { useEffect, useState } from "react";
import API from "../../../config/API";
import "./index.css";
import 'react-toastify/dist/ReactToastify.css';
import { Link, useParams } from "react-router-dom";

export default function ListarMedicoPorId() {
  const [medico, setMedico] = useState(null);
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
    async function loadMedico() {
      try {
        const response = await API.get(`/medicos/${id}`);
        setMedico(response.data);
        setNome(response.data.nome);
        setTelefone(response.data.telefone);
        console.log(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    loadMedico();
  }, [id]);

  const handleDelete = async (id) => {
    try {
      await API.delete(`/medicos/${id}`);
      setMedico(null);
    } catch (error) {
      console.log(error);
    }
  };

  const handleUpdate = async () => {
    try {
      const updatedMedico = {
        ...medico,
        nome: nome,
        telefone: telefone,
        endereco: endereco
      };
      await API.put(`/medicos/${medico.id}`, updatedMedico);
      alert("Dados atualizados com sucesso!");
    } catch (error) {
      console.log(error);
    }
  };

  if (!medico) {
    return <div>Carregando...</div>;
  }

  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">NOME</th>
              <th scope="col">EMAIL</th>
              <th scope="col">CRM</th>
              <th scope="col">ESPECIALIDADE</th>
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
              <th scope="row">{medico.id}</th>
              <td>
                <input
                  type="text"
                  value={nome}
                  onChange={(e) => setNome(e.target.value)}
                />
              </td>
              <td>{medico.email}</td>
              <td>{medico.crm}</td>
              <td>{medico.especialidade}</td>
              <td>
                <input
                  type="text"
                  value={telefone}
                  onChange={(e) => setTelefone(e.target.value)}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.logradouro}
                  onChange={(e) => setEndereco({ ...endereco, logradouro: e.target.value })}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.numero}
                  onChange={(e) => setEndereco({ ...endereco, numero: e.target.value })}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.complemento}
                  onChange={(e) => setEndereco({ ...endereco, complemento: e.target.value })}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.bairro}
                  onChange={(e) => setEndereco({ ...endereco, bairro: e.target.value })}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.cidade}
                  onChange={(e) => setEndereco({ ...endereco, cidade: e.target.value })}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.uf}
                  onChange={(e) => setEndereco({ ...endereco, uf: e.target.value })}
                />
              </td>
              <td>
                <input
                  type="text"
                  value={endereco.cep}
                  onChange={(e) => setEndereco({ ...endereco, cep: e.target.value })}
                />
              </td>
              <td>
                <button className="btn btn-outline-primary mx-2" onClick={handleUpdate}>
                  Atualizar
                </button>
              </td>
              <td>
                <button
                  className="botaoApagar"
                  onClick={() => handleDelete(medico.id)}
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
