import { useEffect, useState } from "react";
import API from "../../../config/API";
import "./index.css";
import 'react-toastify/dist/ReactToastify.css';
import { Link, useParams } from "react-router-dom";

export default function ListarMedicos() {
    const [medicos, setMedicos] = useState([])

    useEffect(() => {
        async function loadMedicos() {
            const response = await API.get("/medicos")
            setMedicos(response.data)
            console.log(response.data)
        }
        loadMedicos();

    }, [])

    const handleDelete = async (id) => {
        try {
            await API.delete(`/medicos/${id}`);
            setMedicos(medicos.filter(medico => medico.id !== id));
        } catch (error) {
            console.log(error);
        }
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
                            <th scope="col">Editar</th>
                            <th scope="col">Apagar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {medicos.map((medico, index) => (
                            <tr key={index}>
                                <th scope="row">{index + 1}</th>
                                <td>{medico.nome}</td>
                                <td>{medico.email}</td>
                                <td>{medico.crm}</td>
                                <td>{medico.especialidade}</td>
                                <td>
                                    <Link
                                        className="btn btn-outline-primary mx-2"
                                        to={`/editar-medico/${medico.id}`}
                                    >
                                        Editar
                                    </Link>
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
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    )
}
