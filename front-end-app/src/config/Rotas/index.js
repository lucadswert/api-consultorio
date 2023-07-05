import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "../../components/Home";
import Header from "../../components/Header";
import Listar from "../../components/Listar";
import Cadastros from "../../components/Cadastros";
import Consultas from "../../components/Consultas";
import { ToastContainer } from "react-toastify";
import CadastroPaciente from "../../components/Cadastros/Paciente";
import CadastroMedico from "../../components/Cadastros/Medico";
import MarcarConsulta from "../../components/Consultas/Marcar";
import CancelarConsulta from "../../components/Consultas/Desmarcar";
import ListarMedicos from "../../components/Listar/Medicos";
import ListarPacientes from "../../components/Listar/Pacientes";
import ListarMedicoPorId from "../../components/Editar/Medico";
import ListarPacientePorId from "../../components/Editar/Paciente";


export default function Rotas(){

    return(
        <BrowserRouter>
        <ToastContainer/>
            <Header/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/listar" element={<Listar/>}/>
                <Route path="/cadastros" element={<Cadastros/>}/>
                <Route path="/cadastrar-paciente" element={<CadastroPaciente/>}/>
                <Route path="/cadastrar-medico" element={<CadastroMedico/>}/>
                <Route path="/consultas" element={<Consultas/>}/>
                <Route path="/marcar-consulta" element={<MarcarConsulta/>}/>
                <Route path="/cancelar-consulta" element={<CancelarConsulta/>}/>
                <Route path="/listar-medicos" element={<ListarMedicos/>}/>
                <Route path="/listar-pacientes" element={<ListarPacientes/>}/>
                <Route path="/editar-medico/:id" element={<ListarMedicoPorId/>}/>
                <Route path="/editar-paciente/:id" element={<ListarPacientePorId/>}/>
            </Routes>
        </BrowserRouter>
    )

}