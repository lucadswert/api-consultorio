import { useEffect, useState } from "react";
import API from "../../../config/API";
import "./index.css";
import 'react-toastify/dist/ReactToastify.css';
import { Link, useParams } from "react-router-dom";

export default function ListarPacientes() {
    const[pacientes, setPacientes]=useState([])

    useEffect(()=>{
        async function loadPacientes(){
            const response = await API.get("/pacientes")
            setPacientes(response.data)
            console.log(response.data)
        }
        
        loadPacientes();
    },[])

    const handleDelete = async (id) => {
        try {
            await API.delete(`/pacientes/${id}`);
            setPacientes(pacientes.filter(paciente => paciente.id !== id));
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
                    <th scope="col">CPF</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Apagar</th>
                    </tr>
                </thead>
                <tbody>
                    {pacientes.map((pacientes, index) => (
                    <tr>
                        <th scope="row" key={index}>
                        {index + 1}
                        </th>
                        <td>{pacientes.nome}</td>
                        <td>{pacientes.email}</td>
                        <td>{pacientes.cpf}</td>
                        <td>
                        <Link
                            className="btn btn-outline-primary mx-2"
                            to={`/editar-paciente/${pacientes.id}`}
                        >
                            Editar
                        </Link>
                        </td>
                        <td>
                            <button
                                className="botaoApagar"
                                onClick={() => handleDelete(pacientes.id)}
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